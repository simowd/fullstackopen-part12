package arquitectura.software.mssale.service;

import arquitectura.software.mssale.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
@FeignClient(name = "ms-customer")
public interface CustomerService {
    @RequestMapping(path = "/v1/api/customer/all", method = RequestMethod.GET)
    List<Customer> getAllCustomerList();
}
