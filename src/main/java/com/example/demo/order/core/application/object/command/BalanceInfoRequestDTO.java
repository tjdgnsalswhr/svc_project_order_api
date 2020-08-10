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
public class BalanceInfoRequestDTO {
	
	@ApiModelProperty(example = "balance01")
	String bid;

	@ApiModelProperty(example = "teamid01")
	String cid;			//Order Id
	
	@ApiModelProperty(example = "storeid01")
	String sid; 	//1. 충전, 2. 결제
	
	@ApiModelProperty(example = "1000000")
	int totalmoney;	//주문에 연관된 가게 이름
	
	@ApiModelProperty(example = "200000")
	int remainmoney;	//주문에 연관된 팀 이름
}
