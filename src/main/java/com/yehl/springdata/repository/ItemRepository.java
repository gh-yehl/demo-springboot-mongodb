package com.yehl.springdata.repository;

import com.yehl.springdata.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
