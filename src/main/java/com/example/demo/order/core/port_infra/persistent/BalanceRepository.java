package com.example.demo.order.core.port_infra.persistent;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.order.core.entity.BalanceInfo;


@Repository
public interface BalanceRepository extends JpaRepository<BalanceInfo, String> 
{
	public List<BalanceInfo> findByCid(String cid);
	public List<BalanceInfo> findBySid(String sid);
	public Optional<BalanceInfo> findByCidAndSid(String cid, String sid);
}
