package com.example.demo.order.core.application.object.command;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ToString
@NoArgsConstructor
@Getter
@Setter
public class OrderRequestDTO {

	@ApiModelProperty(example = "id01")
	String id;			//Order Id
	
	@ApiModelProperty(example = "1")
	String ordertype; 	//1. 충전, 2. 결제
	
	@ApiModelProperty(example = "store01")
	String storeid;	//주문에 연관된 가게 이름
	
	@ApiModelProperty(example = "team01")
	String teamid;	//주문에 연관된 팀 이름
	
	@ApiModelProperty(example = "500000")
	int money;
	
	@ApiModelProperty(example = "yyyy년 mm월dd일 hh시mm분ss초")
	LocalDateTime orderdate;
}
