package com.ecommerceback.Repository.Orders;

import com.ecommerceback.Model.User.CheckoutRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRequestRepository extends JpaRepository<CheckoutRequest,Long> {

    @Query(value = "SELECT * FROM CHECKOUT_REQUEST WHERE USER_ID_ID_USER=:id ",nativeQuery = true)
    List<CheckoutRequest> findAllByUser(@Param("id")Long id);
}
