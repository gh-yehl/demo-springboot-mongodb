package com.yehl.springdata.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;

@Document
public class Order {

    @Id
    private String id;

    @Field("customer")
    private String customer;

    @Field("client")
    private String type;

    private Collection<Item> items = new LinkedHashSet<>();


}
