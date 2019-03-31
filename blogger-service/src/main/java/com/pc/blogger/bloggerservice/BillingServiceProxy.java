package com.pc.blogger.bloggerservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pc.blogger.bloggerservice.bean.BillingInfo;

@FeignClient(name="billing-service")
@RibbonClient(name="billing-service")

public interface BillingServiceProxy {

	@GetMapping("/billingService/{type}")
	public BillingInfo getBilling(@PathVariable String type);
	

	
}


