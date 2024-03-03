package com.architecture.Liquor.Store.controller;

import com.architecture.Liquor.Store.dto.OrderDto;
import com.architecture.Liquor.Store.entity.Order;
import com.architecture.Liquor.Store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{oid}")
    public ResponseEntity<Order> getOrderById(@PathVariable int oid) {
        Order order = orderService.getOrderById(oid);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) {
        Order createdOrder = orderService.createOrder(orderDto);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{oid}")
    public ResponseEntity<Order> updateOrder(@PathVariable int oid, @RequestBody OrderDto orderDto) {
        Order updatedOrder = orderService.updateOrder(oid, orderDto);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{oid}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int oid) {
        orderService.deleteOrder(oid);
        return ResponseEntity.noContent().build();
    }
}
