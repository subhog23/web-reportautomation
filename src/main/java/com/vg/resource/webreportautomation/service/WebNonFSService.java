package com.vg.resource.webreportautomation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vg.resource.webreportautomation.entity.WebVGNonFSEntity;
import com.vg.resource.webreportautomation.helper.WebNonFSHelp;
import com.vg.resource.webreportautomation.repo.WebvgNonFSRepo;


@Service
public class WebNonFSService {
	@Autowired
	private WebvgNonFSRepo vgNonFsRepo;
	
	
	public void save(MultipartFile file)
	{
		try
		{
			List<WebVGNonFSEntity> vgNonfsData = WebNonFSHelp.convertExceltoList(file.getInputStream());
			this.vgNonFsRepo.saveAll(vgNonfsData);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<WebVGNonFSEntity> getAllData()
	{
		return this.vgNonFsRepo.findAll();
	}
	public WebVGNonFSEntity getNonFsById(String empID)   
	{  
	return vgNonFsRepo.findById(empID).orElse(null);  
	}  
	
	public String delete(String empID)   
	{  
		vgNonFsRepo.deleteById(empID);
		return "VGNonFS data removed "+empID;
	}
	
	public WebVGNonFSEntity updateNonFsdata(WebVGNonFSEntity vgNonFSEntity) {
		WebVGNonFSEntity existingData=vgNonFsRepo.findById(vgNonFSEntity.getEmpID()).orElse(null);
		existingData.setLob(vgNonFSEntity.getLob());
		existingData.setEmpName(vgNonFSEntity.getEmpName());
		existingData.setEmpEmailId(vgNonFSEntity.getEmpEmailId());
		existingData.setProjectcode(vgNonFSEntity.getProjectcode());
		existingData.setProjectname(vgNonFSEntity.getProjectname());
		existingData.setStartDate(vgNonFSEntity.getStartDate());
		existingData.setEndDate(vgNonFSEntity.getEndDate());
		existingData.setRegion(vgNonFSEntity.getRegion());
		existingData.setLocation(vgNonFSEntity.getLocation());
		existingData.setRevisedRegion(vgNonFSEntity.getRevisedRegion());
		existingData.setAccountName(vgNonFSEntity.getAccountName());
		existingData.setDesignation(vgNonFSEntity.getDesignation());
		return vgNonFsRepo.save(existingData);
	
	}

	public WebVGNonFSEntity savevgNonFSEntity(WebVGNonFSEntity vgNonFSEntity) {
		// TODO Auto-generated method stub
		return null;
	}
}
