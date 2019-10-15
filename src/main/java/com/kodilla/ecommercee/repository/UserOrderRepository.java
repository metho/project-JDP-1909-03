package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

    List<UserOrder> findByMailSentFalse();

    @Modifying(flushAutomatically = true)
    @Query(value = "update USER_ORDER set mail_sent=:value where order_id=:id", nativeQuery = true)
    void setMailSent(@Param("id") long id, @Param("value") boolean value);
}
