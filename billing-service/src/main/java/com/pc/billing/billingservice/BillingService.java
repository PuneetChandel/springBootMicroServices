package com.pc.billing.billingservice;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pc.billing.billingservice.bean.BillingInfo;
import com.pc.billing.billingservice.bean.BillingInfoRepository;


@RestController
public class BillingService {

	@Autowired
	BillingInfoRepository billingInfoRepository;
	
	@GetMapping("/billingService/{type}")
	public BillingInfo getBilling(@PathVariable String type)
	{
		BillingInfo billinfo= billingInfoRepository.findByTier(type);
		
		return billinfo;
	}
	
	@PostMapping("/billingService")
	public BillingInfo saveBilling(@RequestBody BillingInfo billInfo)
	{
		BillingInfo billinfo= billingInfoRepository.save(billInfo);
		
		return billinfo;
	}
	
	
}
