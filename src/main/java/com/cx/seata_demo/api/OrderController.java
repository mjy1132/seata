package com.cx.seata_demo.api;

import com.cx.seata_demo.entity.Order;
import com.cx.seata_demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author cx
 * @Date 2020-08-25
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping("/createOrder")
    public String createOrder(@RequestParam("id") Integer id,
                              @RequestParam("user_id") Integer userId,
                              @RequestParam("remarks")String remarks,
                              @RequestParam("amount")BigDecimal amount) throws Exception {
        Order order = new Order();
        order.setId(id);
        order.setUserId(userId);
        order.setAmount(amount);
        order.setRemarks(remarks);
        orderService.createOrder(order);
        return "ok";
    }
}
