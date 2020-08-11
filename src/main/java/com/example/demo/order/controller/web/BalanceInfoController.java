package com.example.demo.order.controller.web;

import java.util.List;


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

import com.example.demo.order.core.application.object.command.BalanceInfoRequestDTO;
import com.example.demo.order.core.application.object.query.BalanceInfoResponseDTO;
import com.example.demo.order.core.entity.BalanceInfo;
import com.example.demo.order.core.service.BalanceInfoService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
public class BalanceInfoController {
	@Autowired
	BalanceInfoService balanceInfoService;
	
	@ApiOperation(value = "잔액 정보 전체 조회", httpMethod="GET", notes="잔액 정보 전체 조회 API.")
	@GetMapping(value="/balance/info/all")
	public ResponseEntity<List<BalanceInfo>> getAllBalanceInfo()
	{
		return new ResponseEntity<>(balanceInfoService.getAllBalanceList(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "잔액 정보 조회", httpMethod="GET", notes="잔액 정보 조회 API.")
	@GetMapping(value="/balance/info/{cid}/{sid}")
	public ResponseEntity<BalanceInfoResponseDTO> getOneBalance(@PathVariable String cid, @PathVariable String sid)
	{
		return new ResponseEntity<>(balanceInfoService.getOneBalance(cid, sid), HttpStatus.OK);
	}
	
	@ApiOperation(value = "고객 잔액 정보 조회", httpMethod="GET", notes="고객 잔액 정보 조회 API.")
	@GetMapping(value="/balance/info/customer/{cid}")
	public ResponseEntity<List<BalanceInfo>> getAllBalanceByCustomer(@PathVariable String cid)
	{
		return new ResponseEntity<>(balanceInfoService.getAllBalanceByCustomer(cid), HttpStatus.OK);
	}
	
	@ApiOperation(value = "가게 잔액 정보 조회", httpMethod="GET", notes="가게 잔액 정보 조회 API.")
	@GetMapping(value="/balance/info/store/{sid}")
	public ResponseEntity<List<BalanceInfo>> getAllBalanceByStore(@PathVariable String sid)
	{
		return new ResponseEntity<>(balanceInfoService.getAllBalanceByStore(sid), HttpStatus.OK);
	}
	
	@ApiOperation(value = "잔액 충전", httpMethod="PUT", notes="잔액 충전 API.")
	@PutMapping(value="/balance/info/charge/{cid}/{sid}/{amount}")
	public ResponseEntity<Object> chargeBalance(@PathVariable String cid, @PathVariable String sid, @PathVariable int amount)
	{
		balanceInfoService.chargeBalance(cid, sid, amount);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "잔액 사용", httpMethod="PUT", notes="잔액 사용 API.")
	@PutMapping(value="/balance/info/use/{cid}/{sid}/{amount}")
	public ResponseEntity<Object> useBalance(@PathVariable String cid, @PathVariable String sid, @PathVariable int amount)
	{
		balanceInfoService.useBalance(cid, sid, amount);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value ="잔액 정보 추가", httpMethod="POST", notes="잔액 정보 추가 API")
	@PostMapping(value="/balance/info/add")
	public ResponseEntity<Object> addBalanceInfo(@RequestBody BalanceInfoRequestDTO balanceInfoRequestDTO)
	{
		balanceInfoService.insertBalanceInfo(balanceInfoRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "잔액 정보 수정", httpMethod="PUT", notes="잔액 정보 수정 API.")
	@PutMapping(value="/balance/info/modify")
	public ResponseEntity<Object> updateBalanceInfo(@RequestBody BalanceInfoRequestDTO balanceInfoRequestDTO)
	{
		balanceInfoService.updateBalanceInfo(balanceInfoRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "주문 정보 삭제", httpMethod="DELETE", notes="주문 정보 삭제 API.")
	@DeleteMapping(value="/balance/info/{cid}/{sid}")
	public ResponseEntity<Object> deleteBalanceInfo(@PathVariable String cid, @PathVariable String sid)
	{
		balanceInfoService.deleteBalanecInfo(cid, sid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
