package com.miniapp.cardealer.entities;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "customers")
public class Customer {
    private long id;
    private String name;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "is_young_driver")
    private Boolean isYoungDriver;
    private Set<Sale> sales;

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public Boolean getIsYoungDriver() {
        return isYoungDriver;
    }

    public void setIsYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

   /* @OneToMany(mappedBy = "customer")
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }*/
}
