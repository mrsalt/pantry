package com.pantry.data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity // This tells Hibernate to make a table out of this class
@IdClass(ProductLocation.MyId.class)
public class ProductLocation implements Serializable {
    public static class MyId implements Serializable
    {
        private Integer productId;
        private Integer locationId;

        public MyId() {}
        public MyId(Integer pId, Integer lId)
        {
            this.productId = pId;
            this.locationId = lId;
        }

        @Override
        public boolean equals(Object o) {

            if (o == this) {
                return true;
            }
            if (!(o instanceof ProductLocation)) {
                return false;
            }
            ProductLocation productLocation = (ProductLocation) o;
            return Objects.equals(locationId, productLocation.getLocationId()) &&
                    Objects.equals(productId, productLocation.getProductId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(locationId, productId);
        }
    }

    @Id
    private Integer productId;

    @Id
    private Integer locationId;

    private Integer quantity;

    private Date addedDate;

    private Integer size;

    @Enumerated(EnumType.STRING)
    private SizeUnit sizeUnit;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer id) {
        this.productId = id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer id) {
        this.locationId = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date date) {
        this.addedDate = date;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public SizeUnit getSizeUnit() {
        return this.sizeUnit;
    }

    public void setSizeUnit(SizeUnit su) {
        this.sizeUnit = su;
    }
}