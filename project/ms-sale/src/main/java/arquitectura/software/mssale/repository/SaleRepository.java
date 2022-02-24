package arquitectura.software.mssale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import arquitectura.software.mssale.entity.Sale;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
    List<Sale> findByCustomerId(Integer customerId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Sale set status = false where customerId = :customerId")
    void deleteCustomerSell(@Param("customerId") Integer customerId);
}
