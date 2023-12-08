package com.vg.resource.webreportautomation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vg.resource.webreportautomation.entity.VGSourceEntity;
@Repository
public interface VGSourcRepo extends JpaRepository<VGSourceEntity,String>{

}
