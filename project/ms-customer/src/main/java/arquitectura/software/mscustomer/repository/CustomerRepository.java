package arquitectura.software.mscustomer.repository;

import arquitectura.software.mscustomer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
