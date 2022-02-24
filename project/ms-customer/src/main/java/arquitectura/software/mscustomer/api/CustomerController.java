package arquitectura.software.mscustomer.api;

import arquitectura.software.mscustomer.entity.Customer;
import arquitectura.software.mscustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Customer saveCustomer(@RequestBody Customer setCustomer){
        return customerRepository.save(setCustomer);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Customer> getAllCustomerList(){
        return customerRepository.findAll();
    }

    @RequestMapping(method= RequestMethod.GET)
    public Customer getCustomer(@RequestParam Integer customerId) throws Exception {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }
        else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found"
            );
        }
    }

}
