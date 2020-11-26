package com.yehl.springdata.controller;

import com.yehl.springdata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/getOrderCount")
    public String getOrderCount() {
        int count = orderService.orderCount();
        return String.valueOf(count);
    }

    @RequestMapping("/getItemCount")
    public String getItemCount() {
        int count = orderService.itemCount();
        return String.valueOf(count);
    }

    @RequestMapping("/saveJpaItem")
    public String saveItem() {
        orderService.saveItem();
        int count = orderService.itemCount();
        return String.valueOf(count);
    }
}
