package com.example.VirtualBookStore.Service;

import com.example.VirtualBookStore.DTO.OrderDTO;
import com.example.VirtualBookStore.Entity.Order;
import com.example.VirtualBookStore.Entity.User;
import com.example.VirtualBookStore.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Oderservice {

    private final OrderRepository orderRepository;

    public Oderservice (OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public OrderDTO placeOrder(OrderDTO orderDTO, User user) {
        // Convert DTO to Entity
        Order order = new Order();
        order.setOrderDate(orderDTO.getOrderDate());
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setUser(user); // associate with user

        // Save entity
        Order savedOrder = orderRepository.save(order);

        // Convert back to DTO
        return new OrderDTO(
                savedOrder.getId(),
                savedOrder.getOrderDate(),
                savedOrder.getTotalAmount(),
                savedOrder.getUser() != null ? savedOrder.getUser().getId() : null
        );
    }

    public OrderDTO getOrder(Long id) {
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Order not found"));

            return new OrderDTO(
                    order.getId(),
                    order.getOrderDate(),
                    order.getTotalAmount(),
                    order.getUser().getId()
            );


    }

    public List<OrderDTO> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId)
                .stream()
                .map(order -> new OrderDTO(
                        order.getId(),
                        order.getOrderDate(),
                        order.getTotalAmount(),
                        order.getUser().getId()
                ))
                .collect(Collectors.toList());

    }

}
