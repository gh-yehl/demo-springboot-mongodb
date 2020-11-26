package com.yehl.template.service;

import com.yehl.template.domain.Item;
import com.yehl.template.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@Service
public class UserTemplateService {

    @Autowired
    MongoTemplate mongoTemplate;
    public long count(String collection) {
        long count = mongoTemplate.getCollection(collection).count();
        return count;
    }

    public void saveOrder() {
        Order order = new Order();
        order.setCustomer("Chris");
        //order.setId("newId1");
        order.setType("manual");

        Collection<Item> items = new LinkedHashSet<>();
        for (int i = 0; i < 5; i++) {
            Item item = new Item();
            item.setId("item_id_" + String.valueOf(i));
            item.setPrice(100 + i);
            item.setQuantity(1000+i);
            items.add(item);
        }

        order.setItems(items);
        mongoTemplate.save(order, "order");
    }


    public void saveItem() {
        for (int i = 0; i < 5; i++) {
            Item item = new Item();
            if(i > 2) {
                item.setOrder_id("newId");
            }else {
                item.setOrder_id("newId1");
            }
            item.setId("item_id_"+String.valueOf(i));
            item.setPrice(100 + i);
            item.setQuantity(1000+i);

            mongoTemplate.save(item, "item");
        }

    }
    public List findAll() {
        List list = mongoTemplate.findAll(Order.class, "order");
        return list;
    }
}
