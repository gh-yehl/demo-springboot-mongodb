package com.yehl.springdata.repository;


import com.yehl.springdata.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface OrderRepository extends MongoRepository<Order, String> {

}
