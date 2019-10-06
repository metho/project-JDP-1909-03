package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
