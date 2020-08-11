package com.example.demo.order.controller.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.order.core.service.TeamCustomerOrderService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
public class TeamCustomerOrderController {
	
	@Autowired
	TeamCustomerOrderService teamCustomerOrderService;
	
	@ApiOperation(value="최근 일주일 내역 조회", httpMethod = "GET", notes="최근 일주일 내역 조회 API.")
	@GetMapping(value="/order/teamcustomer/list/{teamid}")
	public ResponseEntity<Object> getRecentWeekOrderList(@PathVariable String teamid)
	{
		LocalDateTime enddate = LocalDateTime.now();
		LocalDateTime startdate = enddate.minusDays(7);
		return new ResponseEntity<>(teamCustomerOrderService.getOrderList(teamid, startdate, enddate), HttpStatus.OK);
	}
	
	@ApiOperation(value="기간 검색 내역 조회", httpMethod = "GET", notes="기간 검색 내역 조회 API.")
	@GetMapping(value="/order/teamcustomer/list/{teamid}/{startdate}/{enddate}")
	public ResponseEntity<Object> getSearchingOrderList(@PathVariable String teamid, @PathVariable String startdate, @PathVariable String enddate)
	{ 
		LocalDateTime from = LocalDateTime.parse(startdate);
		LocalDateTime to = LocalDateTime.parse(enddate);
		return new ResponseEntity<>(teamCustomerOrderService.getOrderList(teamid, from, to), HttpStatus.OK);
	}
	

}
