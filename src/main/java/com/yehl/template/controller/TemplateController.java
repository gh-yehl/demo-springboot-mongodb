package com.yehl.template.controller;

import com.yehl.template.service.UserTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemplateController {

    @Autowired
    UserTemplateService userTemplateService;

    @RequestMapping("/count")
    public String documentCount() {
        long count = userTemplateService.count("order");

        return String.valueOf(count);
    }

    @RequestMapping("/saveOrder")
    public String saveOrder() {
        userTemplateService.saveOrder();

        long count = userTemplateService.count("order");
        return String.valueOf(count);
    }

    @RequestMapping("/saveItem")
    public String saveItem() {
        userTemplateService.saveItem();

        long count = userTemplateService.count("item");
        return String.valueOf(count);
    }

    @RequestMapping("/findAll")
    public List findAll() {
        List list = userTemplateService.findAll();
        return list;
    }
}
