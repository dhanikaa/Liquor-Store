package com.architecture.Liquor.Store.service;

import com.architecture.Liquor.Store.dto.OrderDto;
import com.architecture.Liquor.Store.entity.Order;
import com.architecture.Liquor.Store.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;

    public OrderDto saveOrder(OrderDto orderDto) {
        orderRepository.save(modelMapper.map(orderDto, Order.class));
        return orderDto;

    }

    public List<OrderDto> getAllOders() {
        List<Order>orderList= orderRepository.findAll();
        return modelMapper.map(orderList,new TypeToken<List<OrderDto>>(){}.getType());
    }

    public OrderDto updateOrders(OrderDto orderDto) {
        orderRepository.save(modelMapper.map(orderDto, Order.class));
        return orderDto;
    }

    public boolean deleteOrders(OrderDto orderDto) {
        orderRepository.delete(modelMapper.map(orderDto, Order.class));
        return true;
    }

}
