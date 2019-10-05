package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToMany(mappedBy = "carts")
    private List<Product> products = new ArrayList<>();

    public void addProduct(final Product product) {
        products.add(product);
    }

    public void deleteProduct(final Product product) {
        products.remove(product);
    }
}