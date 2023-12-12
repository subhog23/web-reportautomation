package com.vg.resource.webreportautomation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vg.resource.webreportautomation.entity.WebvgGadEntity;

@Repository
public interface WebvgGadRepo  extends JpaRepository<WebvgGadEntity,String>{
	

}
