package com.example.VirtualBookStore.Controller;


import com.example.VirtualBookStore.DTO.OrderDTO;
import com.example.VirtualBookStore.Entity.Order;
import com.example.VirtualBookStore.Entity.User;
import com.example.VirtualBookStore.Repository.OrderRepository;
import com.example.VirtualBookStore.Service.Oderservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")

public class OrderController {

    private final Oderservice orderServ;

    public OrderController(Oderservice orderServ) {
        this.orderServ = orderServ;
    }

    @PostMapping
    public OrderDTO placeOrder(@RequestBody OrderDTO order, User user) {
        return orderServ.placeOrder(order,user);
    }

    @GetMapping("/{id}")
    public OrderDTO getOrder(@PathVariable Long id) {
        return orderServ.getOrder(id);
    }

    @GetMapping("/user/{userId}")
    public List<OrderDTO> getOrdersByUser(@PathVariable Long userId) {
        return orderServ.getOrdersByUser(userId);
    }




}
