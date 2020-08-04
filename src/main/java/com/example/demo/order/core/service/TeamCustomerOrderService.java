package com.example.demo.order.core.service;

import java.time.LocalDateTime;
import java.util.Date;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.demo.order.core.entity.Order;
import com.example.demo.order.core.port_infra.persistent.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class TeamCustomerOrderService {
	
	private final OrderRepository orderRepository;
	private final ModelMapper modelMapper;
	
	public List<Order> getOrderList(String teamid, LocalDateTime startdate, LocalDateTime enddate)
	{
		return orderRepository.findByTeamidAndOrderdateBetween(teamid, startdate, enddate);
		//return orderRepository.findAll();
	}
}
