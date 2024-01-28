package com.arthuracrani.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthuracrani.course.entities.OrderItem;
import com.arthuracrani.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}