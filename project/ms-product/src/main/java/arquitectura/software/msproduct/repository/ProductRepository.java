package arquitectura.software.msproduct.repository;

import arquitectura.software.msproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
