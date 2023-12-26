package com.app.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Serializable>{

}
