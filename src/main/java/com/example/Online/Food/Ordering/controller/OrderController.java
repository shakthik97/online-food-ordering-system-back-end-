package com.example.Online.Food.Ordering.controller;

import com.example.Online.Food.Ordering.model.CartItem;
import com.example.Online.Food.Ordering.model.Order;
import com.example.Online.Food.Ordering.model.User;
import com.example.Online.Food.Ordering.request.AddCartItemRequest;
import com.example.Online.Food.Ordering.request.OrderRequest;
import com.example.Online.Food.Ordering.service.OrderService;
import com.example.Online.Food.Ordering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest req,
                                                  @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Order order = orderService.createOrder(req, user);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Order> userOrders = orderService.getUserOrder(user.getId());
        return new ResponseEntity<>(userOrders, HttpStatus.CREATED);
    }



}
