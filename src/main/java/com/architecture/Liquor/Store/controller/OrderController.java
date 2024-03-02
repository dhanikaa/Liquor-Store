package com.architecture.Liquor.Store.controller;

import com.architecture.Liquor.Store.dto.OrderDto;
import com.architecture.Liquor.Store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1/order")
@CrossOrigin
public class OrderController  {

    @Autowired
    private OrderService orderService;
    @PostMapping("/saveOrder")
    public OrderDto saveOder(@RequestBody OrderDto oderDto) {

        return orderService.saveOrder(oderDto);
    }

    @GetMapping("/getOrder")
    public List<OrderDto> getOder() {
        return orderService.getAllOders();
    }


    @PutMapping("/updateOrder")
    public String updateOrders(@RequestBody OrderDto orderDto){
        orderService.updateOrders(orderDto);
        return "Order Updated";
    }

    @DeleteMapping("/deleteOrder")
    public String deleteOrders(@RequestBody OrderDto orderDto){
        orderService.deleteOrders(orderDto);
        return "deleted succesfully";
    }







}
