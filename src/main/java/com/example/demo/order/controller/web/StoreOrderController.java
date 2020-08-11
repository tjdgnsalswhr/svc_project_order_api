package com.example.demo.order.controller.web;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.order.core.service.StoreOrderService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
public class StoreOrderController {
	
	@Autowired
	StoreOrderService storeOrderService;
	
	@ApiOperation(value="최근 일주일 내역 조회", httpMethod = "GET", notes="최근 일주일 내역 조회 API.")
	@GetMapping(value="/order/store/list/{storeid}")
	public ResponseEntity<Object> getRecentWeekOrderListByStore(@PathVariable String storeid)
	{
		LocalDateTime enddate = LocalDateTime.now();
		LocalDateTime startdate = enddate.minusDays(7);
		
		return new ResponseEntity<>(storeOrderService.getOrderList(storeid, startdate, enddate), HttpStatus.OK);
	}
	
	@ApiOperation(value="기간 검색 내역 조회", httpMethod = "GET", notes="기간 검색 내역 조회 API.")
	@GetMapping(value="/order/store/list/{storeid}/{startdate}/{enddate}")
	public ResponseEntity<Object> getSearchingOrderList(@PathVariable String storeid, @PathVariable String startdate, @PathVariable String enddate)
	{
		LocalDateTime from = LocalDateTime.parse(startdate);
		LocalDateTime to = LocalDateTime.parse(enddate);
		return new ResponseEntity<>(storeOrderService.getOrderList(storeid, from, to), HttpStatus.OK);
	}

}
