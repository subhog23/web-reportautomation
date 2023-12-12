package com.vg.resource.webreportautomation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vg.resource.webreportautomation.entity.WebvgGadEntity;
import com.vg.resource.webreportautomation.helper.WebGadHelper;
import com.vg.resource.webreportautomation.repo.WebvgGadRepo;

@Service
public class WebGadService {
	@Autowired
	private WebvgGadRepo vggadRepo;
	
	
	public void save(MultipartFile file)
	{
		try
		{
			List<WebvgGadEntity> vggadData = WebGadHelper.convertExceltoList(file.getInputStream());
			this.vggadRepo.saveAll(vggadData);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<WebvgGadEntity> getAllData()
	{
		return this.vggadRepo.findAll();
	}
	public WebvgGadEntity getvgGadById(String ggid)   
	{  
	return vggadRepo.findById(ggid).orElse(null);  
	}  
	
	public String delete(String ggid)   
	{  
		vggadRepo.deleteById(ggid);
		return "VGGAD data removed "+ggid;
	}
	public WebvgGadEntity updatevgGaddata(WebvgGadEntity vggadEntity) {
		WebvgGadEntity existingData=vggadRepo.findById(vggadEntity.getGgid()).orElse(null);
		existingData.setLi_lrId(vggadEntity.getLi_lrId());
		existingData.setCapEmailid(vggadEntity.getCapEmailid());
		existingData.setGraderevised(vggadEntity.getGraderevised());
		existingData.setLocalgrade(vggadEntity.getLocalgrade());
		existingData.setRegion(vggadEntity.getRegion());
		existingData.setRegionRevised(vggadEntity.getRegionRevised());
		existingData.setGadCostCenter(vggadEntity.getGadCostCenter());
		existingData.setProjectCode(vggadEntity.getProjectCode());
		existingData.setProjectName(vggadEntity.getProjectName());
		existingData.setPractice(vggadEntity.getPractice());
		existingData.setSbu(vggadEntity.getSbu());
		existingData.setFs_non_fs(vggadEntity.getFs_non_fs());
		existingData.setBuPortfolio(vggadEntity.getBuPortfolio());
		existingData.setLob(vggadEntity.getLob());
		existingData.setDe(vggadEntity.getDe());
		existingData.setEm(vggadEntity.getEm());
		existingData.setSubPractise(vggadEntity.getSubPractise());
		existingData.setLocation(vggadEntity.getLocation());
		existingData.setSupervisor(vggadEntity.getSupervisor());
		return vggadRepo.save(existingData);
	
	}

	public WebvgGadEntity savevgGadEntity(WebvgGadEntity vggadEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
