package com.fashion.server.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "order")
public class OrderModel  {

   @Id
   private String id;
   
   private BigDecimal totalMonney;
   
   private String status;
   
   private String note;
   
   private String reasonCancel;
   
   private BigDecimal shippingCost;
   
   private User user;
   
   private List<OrderDetail>orderDetails = new ArrayList<>();
   
   @Field(name = "create_date")
   private Date createDate;
   
   
}
