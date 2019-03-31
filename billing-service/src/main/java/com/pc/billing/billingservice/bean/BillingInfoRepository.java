package com.pc.billing.billingservice.bean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // repository for which entity and primary key
public interface BillingInfoRepository extends JpaRepository<BillingInfo,Integer>{

	BillingInfo findByTier(String tier);
	
}