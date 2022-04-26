package com.ecommerceback.Controller.Orders;

import com.ecommerceback.Model.User.Request.OrdersDtoRequest;
import com.ecommerceback.Service.Orders.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @PostMapping
    public ResponseEntity<?> saveOrders(@RequestBody OrdersDtoRequest request){
        return ordersService.saveOrders(request);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrdersByUser(@RequestParam Long request){
        return ordersService.getOrdersUser(request);
    }
    @GetMapping("/admin")
    public ResponseEntity<?> getOrders(){
        return ordersService.getOrders();
    }
}
