package com.example.Online.Food.Ordering.repository;

import com.example.Online.Food.Ordering.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
