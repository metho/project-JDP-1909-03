package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
}
