package com.example.demo.order.core.service;

import java.util.List;

import java.util.Optional;


import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.common.error.exception.BusinessException;
import com.example.demo.order.core.application.object.command.OrderRequestDTO;
import com.example.demo.order.core.application.object.query.OrderResponseDTO;
import com.example.demo.order.core.entity.Order;
import com.example.demo.order.core.port_infra.persistent.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderInfoService {
	
	private final OrderRepository orderRepository;
	private final ModelMapper modelMapper;
	
	public List<Order> getAllOrderList()
	{
		return orderRepository.findAll();
	}
	
	public OrderResponseDTO getOneOrder(String id) //계속 주고 받는 것에 DTO를 쓰는 이유는 원래 객체를 망가뜨리지 않기 위해서 비슷한 것을 복제해 사용하는 것임
	{
		Optional<Order> optionalOrder = orderRepository.findById(id);
		if(optionalOrder.isPresent())
		{
			return modelMapper.map(optionalOrder.get(), OrderResponseDTO.class);
		}
		else
			return null;
	}
	
	public void insertOrder(OrderRequestDTO orderRequestDTO)
	{
		Order order = modelMapper.map(orderRequestDTO, Order.class);
		orderRepository.save(order);
	}
	
	public void updateOrder(OrderRequestDTO orderRequestDTO)	
	{
		Optional<Order> optionalOrder = orderRepository.findById(orderRequestDTO.getId());
		if(!optionalOrder.isPresent())
		{
			throw new BusinessException("0000","There is No Order");
		}
		Order order = optionalOrder.get();
		order.update(orderRequestDTO);
		orderRepository.save(order);
	}
	
	public void deleteOrder(String id)
	{
		Optional<Order> optionalOrder = orderRepository.findById(id);
		if(!optionalOrder.isPresent())
		{
			throw new BusinessException("0000","There is No Order");
		}
		orderRepository.delete(optionalOrder.get());
	}

}
