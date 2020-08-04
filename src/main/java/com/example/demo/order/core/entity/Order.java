package com.example.demo.order.core.entity;

import java.time.LocalDateTime;
import java.util.Date;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.order.core.application.object.command.OrderRequestDTO;

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
@Table(name="orders") //entity와 매핑할 테이블. 생략시 매핑한 엔티티 이름을 테이블 이름으로 사용.
@Entity //JPA를 사용해서 테이블과 매핑할 클래스. 이 Annotation이 붙으면 JPA가 관리하는 것
public class Order {
	
	@Id
	String id;			//Order Id
	String ordertype; 	//1. 충전, 2. 결제
	String storeid;	//주문에 연관된 가게 이름
	String teamid;	//주문에 연관된 팀 이름
	int money;
	LocalDateTime orderdate;
	
	@Builder
	public Order(String OrderId, String Ordertype ,String StoreId, String TeamId, int money, LocalDateTime date)
	{
		this.id = OrderId;
		this.ordertype = Ordertype;
		this.storeid = StoreId;
		this.teamid = TeamId;
		this.money = money;
		this.orderdate = date;
	}
	
	public void update(OrderRequestDTO orderRequestDTO)
	{
		this.id = orderRequestDTO.getId();
		this.ordertype = orderRequestDTO.getOrdertype();
		this.storeid = orderRequestDTO.getStoreid();
		this.teamid = orderRequestDTO.getTeamid();
		this.money = orderRequestDTO.getMoney();
		this.orderdate = orderRequestDTO.getOrderdate();
	}

}
