package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
    List<UserOrder> findByMailSentFalse();

    @Modifying
    @Query("update UserOrder order set order.mailSent = :value where order.id = :id")
    void setMailSent(long id, boolean value);
}
