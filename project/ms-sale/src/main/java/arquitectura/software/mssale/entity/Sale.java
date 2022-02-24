package arquitectura.software.mssale.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer saleId;
    private Integer productId;
    private Integer customerId;
    private Integer quantity;
    private Boolean status;

    public Sale(){

    }

    public Sale(Integer saleId, Integer productId, Integer customerId, Integer quantity, Boolean status) {
        this.saleId = saleId;
        this.productId = productId;
        this.customerId = customerId;
        this.quantity = quantity;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(saleId, sale.saleId) && Objects.equals(productId, sale.productId) && Objects.equals(customerId, sale.customerId) && Objects.equals(quantity, sale.quantity) && Objects.equals(status, sale.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId, productId, customerId, quantity, status);
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
