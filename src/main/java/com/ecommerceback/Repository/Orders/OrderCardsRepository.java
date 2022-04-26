package com.ecommerceback.Repository.Orders;

import com.ecommerceback.Model.Card.CardOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCardsRepository extends JpaRepository<CardOrders,Long> {
}
