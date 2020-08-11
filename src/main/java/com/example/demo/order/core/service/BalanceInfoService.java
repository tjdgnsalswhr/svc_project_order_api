package com.example.demo.order.core.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.common.error.exception.BusinessException;

import com.example.demo.order.core.application.object.command.BalanceInfoRequestDTO;
import com.example.demo.order.core.application.object.query.BalanceInfoResponseDTO;
import com.example.demo.order.core.entity.BalanceInfo;
import com.example.demo.order.core.port_infra.persistent.BalanceRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
@Getter
@Setter
public class BalanceInfoService {
	
	private final BalanceRepository balanceRepository;
	private final ModelMapper modelMapper;
	
	public List<BalanceInfo> getAllBalanceList()
	{
		return balanceRepository.findAll();
	}
	
	public BalanceInfoResponseDTO getOneBalance(String cid, String sid) //계속 주고 받는 것에 DTO를 쓰는 이유는 원래 객체를 망가뜨리지 않기 위해서 비슷한 것을 복제해 사용하는 것임
	{
		Optional<BalanceInfo> optionalBalanceInfo = balanceRepository.findByCidAndSid(cid, sid);
		if(optionalBalanceInfo.isPresent())
		{
			return modelMapper.map(optionalBalanceInfo.get(), BalanceInfoResponseDTO.class);
		}
		else
			return null;
	}
	
	public List<BalanceInfo> getAllBalanceByCustomer(String cid)
	{
		return balanceRepository.findByCid(cid);
	}
	
	public List<BalanceInfo> getAllBalanceByStore(String sid)
	{
		return balanceRepository.findBySid(sid);
	}
	
	public void chargeBalance(String cid, String sid, int amount)
	{	
		
		Optional<BalanceInfo> optionalBalanceInfo = balanceRepository.findByCidAndSid(cid, sid);
		BalanceInfo balanceInfo = optionalBalanceInfo.get();
		
		BalanceInfoRequestDTO balanceInfoRequestDTO = modelMapper.map(optionalBalanceInfo.get(), BalanceInfoRequestDTO.class);
		int total = balanceInfoRequestDTO.getTotalmoney() + amount;
		int remain = balanceInfoRequestDTO.getRemainmoney() + amount;
		balanceInfoRequestDTO.setRemainmoney(remain);
		balanceInfoRequestDTO.setTotalmoney(total);
		balanceInfo.update(balanceInfoRequestDTO);
	}
	
	public void useBalance(String cid, String sid, int amount)
	{
		Optional<BalanceInfo> optionalBalanceInfo = balanceRepository.findByCidAndSid(cid, sid);
		BalanceInfo balanceInfo = optionalBalanceInfo.get();
		
		BalanceInfoRequestDTO balanceInfoRequestDTO = modelMapper.map(optionalBalanceInfo.get(), BalanceInfoRequestDTO.class);
		int remain = balanceInfoRequestDTO.getRemainmoney() - amount;
		balanceInfoRequestDTO.setRemainmoney(remain);
		balanceInfo.update(balanceInfoRequestDTO);
	}
	
	
	public void insertBalanceInfo(BalanceInfoRequestDTO balanceInfoRequestDTO)
	{
		BalanceInfo balanceInfo = modelMapper.map(balanceInfoRequestDTO, BalanceInfo.class);
		balanceRepository.save(balanceInfo);
	}
	
	public void updateBalanceInfo(BalanceInfoRequestDTO balanceInfoRequestDTO)	
	{
		
		Optional<BalanceInfo> optionalBalanceInfo = balanceRepository.findByCidAndSid(balanceInfoRequestDTO.getCid(), balanceInfoRequestDTO.getSid());
		if(!optionalBalanceInfo.isPresent())
		{
			throw new BusinessException("0000","There is No Order");
		}
		BalanceInfo balanceInfo = optionalBalanceInfo.get();
		balanceInfo.update(balanceInfoRequestDTO);
		balanceRepository.save(balanceInfo);
		
	}
	
	public void deleteBalanecInfo(String cid, String sid)
	{
		Optional<BalanceInfo> optionalBalanceInfo = balanceRepository.findByCidAndSid(cid, sid);
		if(!optionalBalanceInfo.isPresent())
		{
			throw new BusinessException("0000","There is No Order");
		}
		balanceRepository.delete(optionalBalanceInfo.get());
	}
}
