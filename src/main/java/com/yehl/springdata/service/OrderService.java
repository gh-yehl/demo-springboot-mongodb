package com.yehl.springdata.service;

import com.yehl.springdata.domain.Item;
import com.yehl.springdata.repository.ItemRepository;
import com.yehl.springdata.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;

    public int orderCount() {
        long count = orderRepository.count();
        return Integer.parseInt(String.valueOf(count));
    }

    public int itemCount() {
        long count = itemRepository.count();
        return Integer.parseInt(String.valueOf(count));
    }

    public void saveItem() {
        Item item = new Item();
        item.setOrder_id("newId");
        item.setPrice(1232.13);
        item.setQuantity(10);
        itemRepository.save(item);
    }
}
