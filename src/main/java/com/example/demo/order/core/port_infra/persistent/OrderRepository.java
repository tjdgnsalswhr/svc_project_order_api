package com.example.demo.order.core.port_infra.persistent;

import java.time.LocalDateTime;
import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.order.core.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> 
{
	//public List<Order> findByTeamidAndOrderdateBetween(String teamid, LocalDateTime startdate, LocalDateTime enddate);
	public List<Order> findByTeamidAndOrderdateBetween(String teamid, LocalDateTime startdate, LocalDateTime enddate);
	//public List<Order> findByStoreidAndOrderdateBetween(String storeid, LocalDateTime startdate, LocalDateTime enddate);
	public List<Order> findByStoreidAndOrderdateBetween(String storeid, LocalDateTime startdate, LocalDateTime enddate);
}
