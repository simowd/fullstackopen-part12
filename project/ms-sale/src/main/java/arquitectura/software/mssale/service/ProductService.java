package arquitectura.software.mssale.service;

import arquitectura.software.mssale.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
@FeignClient(name="ms-product")
public interface ProductService {
    @RequestMapping(path = "/v1/api/product/all", method = RequestMethod.GET)
    List<Product> getAllProducts();


}
