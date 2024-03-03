package com.architecture.Liquor.Store.service;

import com.architecture.Liquor.Store.dto.OrderDto;
import com.architecture.Liquor.Store.entity.Order;
import com.architecture.Liquor.Store.exception.OrderNotFoundException;
import com.architecture.Liquor.Store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(int oid) {
        return orderRepository.findById(oid)
                .orElseThrow(() -> new OrderNotFoundException("Order with id " + oid + " not found"));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(OrderDto orderDto) {
        Order order = new Order();
        mapDtoToEntity(orderDto, order);
        return orderRepository.save(order);
    }

    public Order updateOrder(int oid, OrderDto orderDto) {
        Order existingOrder = getOrderById(oid);
        mapDtoToEntity(orderDto, existingOrder);
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(int oid) {
        orderRepository.deleteById(oid);
    }

    private void mapDtoToEntity(OrderDto orderDto, Order order) {
        order.setPid(orderDto.getPid());
        order.setQuantity(orderDto.getQuantity());
        order.setPrice(orderDto.getPrice());
    }
}
