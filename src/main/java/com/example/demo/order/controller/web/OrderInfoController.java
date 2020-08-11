package com.example.demo.order.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.order.core.application.object.command.BalanceRequestDTO;
import com.example.demo.order.core.application.object.query.OrderResponseDTO;
import com.example.demo.order.core.application.object.query.ResponseDTO;
import com.example.demo.order.core.service.OrderInfoService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin("*")
@RestController
public class OrderInfoController {
	@Autowired
	OrderInfoService orderInfoService;
	
	@ApiOperation(value = "주문 정보 전체 조회", httpMethod="GET", notes="주문 정보 전체 조회 API.")
	@GetMapping(value="/order/info")
	public ResponseEntity<Object> getAllOrder()
	{
		return new ResponseEntity<>(orderInfoService.getAllOrderList(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "주문 정보 조회", httpMethod="GET", notes="주문 정보 조회 API.")
	@GetMapping(value="/order/info/{orderId}")
	public ResponseEntity<Object> getOneOrder(@PathVariable String orderId)
	{
		return new ResponseEntity<>(orderInfoService.getOneOrder(orderId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "주문 정보 추가", httpMethod="POST", notes="주문 정보 추가 API")
	@PostMapping(value="/order/info")
	public ResponseEntity<Object> addOrder(@RequestBody BalanceRequestDTO orderRequestDTO)
	{
		orderInfoService.insertOrder(orderRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "주문 정보 수정", httpMethod="PUT", notes="주문 정보 수정 API.")
	@PutMapping(value="/order/info")
	public ResponseEntity<Object> updateOrder(@RequestBody BalanceRequestDTO orderRequestDTO)
	{
		orderInfoService.updateOrder(orderRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "주문 정보 삭제", httpMethod="DELETE", notes="주문 정보 삭제 API.")
	@DeleteMapping(value="/order/info/{orderId}")
	public ResponseEntity<Object> deleteStore(@PathVariable String orderId)
	{
		orderInfoService.deleteOrder(orderId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
