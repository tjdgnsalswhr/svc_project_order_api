package com.example.demo.order.core.entity;

import java.time.LocalDateTime;

import java.util.Date;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.order.core.application.object.command.BalanceInfoRequestDTO;
import com.example.demo.order.core.application.object.command.BalanceRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j //로그 기록을 위한 Annotation
@ToString //tostirng method 자동 생성
@NoArgsConstructor //파라미터가 없는 생성자 생

@Getter //접근자 자동 생성
@Setter //설정자 자동 생성
@Table(name="balanceinfos") //entity와 매핑할 테이블. 생략시 매핑한 엔티티 이름을 테이블 이름으로 사용.
@Entity //JPA를 사용해서 테이블과 매핑할 클래스. 이 Annotation이 붙으면 JPA가 관리하는 것
public class BalanceInfo {
	
	@Id
	String bid;
	String cid;			//Order Id
	String sid; 	//1. 충전, 2. 결제
	int totalmoney;	//주문에 연관된 가게 이름
	int remainmoney;
	
	@Builder
	public BalanceInfo(String bid, String cid, String sid, int totalmoney, int remainmoney)
	{
		this.bid = bid;
		this.cid = cid;
		this.sid = sid;
		this.totalmoney = totalmoney;
		this.remainmoney = remainmoney;
	}
	
	public void update(BalanceInfoRequestDTO balanceInfoRequestDTO)
	{
		this.bid = balanceInfoRequestDTO.getBid();
		this.cid = balanceInfoRequestDTO.getCid();
		this.sid = balanceInfoRequestDTO.getSid();
		this.totalmoney = balanceInfoRequestDTO.getTotalmoney();
		this.remainmoney = balanceInfoRequestDTO.getRemainmoney();
	}

}
