package com.vg.resource.webreportautomation.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vg.resource.webreportautomation.entity.WebVGSourceEntity;
import com.vg.resource.webreportautomation.helper.WebSourcelHelp;
import com.vg.resource.webreportautomation.repo.WebVGSourcRepo;



@Service
public class WebSourceService {
	@Autowired
	private WebVGSourcRepo sourcingRepo;
	
	
	public void save(MultipartFile file)
	{
		try
		{
			List<WebVGSourceEntity> sourceData = WebSourcelHelp.convertExceltoList(file.getInputStream());
			this.sourcingRepo.saveAll(sourceData);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<WebVGSourceEntity> getAllData()
	{
		return this.sourcingRepo.findAll();
	}
	
	public WebVGSourceEntity getVGSourceById(String gGId)   
	{  
	return sourcingRepo.findById(gGId).orElse(null);  
	}  
	
	public String delete(String gGId)   
	{  
		sourcingRepo.deleteById(gGId);
		return "sourcing data removed "+gGId;
	}
	public WebVGSourceEntity updateSource(WebVGSourceEntity vgSourceEntity) {
		WebVGSourceEntity existingData=sourcingRepo.findById(vgSourceEntity.getGGId()).orElse(null);
		existingData.setResourceName(vgSourceEntity.getResourceName());
		existingData.setLevel(vgSourceEntity.getLevel());
		existingData.setJobRole(vgSourceEntity.getJobRole());
		existingData.setPrimaryskill(vgSourceEntity.getPrimaryskill());
		existingData.setPo(vgSourceEntity.getPo());
		existingData.setSowId(vgSourceEntity.getSowId());
		existingData.setHours(vgSourceEntity.getHours());
		existingData.setHourlyRate(vgSourceEntity.getHourlyRate());
		existingData.setAmount(vgSourceEntity.getAmount());
		existingData.setRoleStartDate(vgSourceEntity.getRoleStartDate());
		existingData.setRoleEndDate(vgSourceEntity.getRoleEndDate());
		existingData.setTotalContractAmount(vgSourceEntity.getTotalContractAmount());
		existingData.setComment(vgSourceEntity.getComment());
		existingData.setExhibit_type(vgSourceEntity.getExhibit_type());
		existingData.setResourc_type(vgSourceEntity.getResourc_type());
		existingData.setPaymentType(vgSourceEntity.getPaymentType());
		existingData.setSowStartDate(vgSourceEntity.getSowStartDate());
		existingData.setSowEndDate(vgSourceEntity.getSowEndDate());
		existingData.setLocationVg(vgSourceEntity.getLocationVg());
		return sourcingRepo.save(existingData);
	
	}

	public WebVGSourceEntity savevgSourceEntity(WebVGSourceEntity vgSourceEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
