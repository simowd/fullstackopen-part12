package arquitectura.software.msproduct.api;

import arquitectura.software.msproduct.entity.Product;
import arquitectura.software.msproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/v1/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return  productRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Product changeProduct(@RequestBody Product product){
        if(product.getProductId() != null){
            return productRepository.save(product);
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Didn't send the id of the customer");
        }

    }
}
