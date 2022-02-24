package arquitectura.software.mssale.api;

import arquitectura.software.mssale.entity.Sale;
import arquitectura.software.mssale.model.Customer;
import arquitectura.software.mssale.model.Product;
import arquitectura.software.mssale.repository.SaleRepository;
import arquitectura.software.mssale.service.CustomerService;
import arquitectura.software.mssale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/sale")
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/sell", method = RequestMethod.POST)
    public Sale sellProduct(@RequestBody Sale currentSale){
        if(currentSale.getCustomerId() != null && currentSale.getProductId() != null){
            List<Customer> customers = customerService.getAllCustomerList();
            List<Product> products = productService.getAllProducts();
            Customer customer = customers.stream().filter(customer1 -> currentSale.getCustomerId().equals(customer1.getCustomerId())).findAny().orElse(null);
            Product product = products.stream().filter(product1 -> currentSale.getProductId().equals(product1.getProductId())).findAny().orElse(null);

            if(customer != null && product != null){
                currentSale.setStatus(true);
                return saleRepository.save(currentSale);
            }
            else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User or product does not exist");
            }
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body not complete");
        }
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getCustomerProducts(@RequestParam Integer customerId){
        List<Customer> customers = customerService.getAllCustomerList();
        List<Product> products = productService.getAllProducts();
        Customer customer = customers.stream().filter(customer1 -> customerId.equals(customer1.getCustomerId())).findAny().orElse(null);

        if(customer != null){
            List<Sale> sales = saleRepository.findByCustomerId(customer.getCustomerId());
            List <Product> productsPerCustomer = products.stream().filter(prod -> sales.stream().anyMatch(sale -> sale.getProductId().equals((prod.getProductId())))).collect(Collectors.toList());
            return productsPerCustomer;
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User does not exist");
        }
    }

    @RequestMapping(path = "/sell/all", method = RequestMethod.GET)
    public List<Sale> getSalePerCustomer(@RequestParam Integer customerId){
        List<Customer> customers = customerService.getAllCustomerList();
        List<Product> products = productService.getAllProducts();
        Customer customer = customers.stream().filter(customer1 -> customerId.equals(customer1.getCustomerId())).findAny().orElse(null);

        if(customer != null){
            return saleRepository.findByCustomerId(customer.getCustomerId());
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User does not exist");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public HttpStatus deleteSale(@RequestParam Integer customerId){
        try {
            saleRepository.deleteCustomerSell(customerId);
            return HttpStatus.OK;
        }
        catch (Exception e){
            return HttpStatus.NOT_FOUND;
        }
    }
}
