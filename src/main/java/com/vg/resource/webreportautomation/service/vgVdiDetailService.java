package com.vg.resource.webreportautomation.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vg.resource.webreportautomation.entity.VGVdiDetailEntity;
import com.vg.resource.webreportautomation.helper.VGVdiDetailHelper;
import com.vg.resource.webreportautomation.repo.vgVdiDetailRepo;

@Service
public class vgVdiDetailService {
	
	@Autowired
	private vgVdiDetailRepo vgvdidetailRepo;
	
	
	public void save(MultipartFile file)
	{
		try
		{
			List<VGVdiDetailEntity> sourceData = VGVdiDetailHelper.convertExceltoList(file.getInputStream());
			this.vgvdidetailRepo.saveAll(sourceData);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<VGVdiDetailEntity> getAllData()
	{
		return this.vgvdidetailRepo.findAll();
	}
	
	public VGVdiDetailEntity getVGVdiDetailById(String ggid)   
	{  
	return vgvdidetailRepo.findById(ggid).orElse(null);  
	}  
	
	public String delete(String ggid)   
	{  
		vgvdidetailRepo.deleteById(ggid);
		return "VGVDIDeatils data removed "+ggid;
	}
	
	public VGVdiDetailEntity updateVgVdiDetails(VGVdiDetailEntity vgvdiDetailEntity) {
		VGVdiDetailEntity existingData=vgvdidetailRepo.findById(vgvdiDetailEntity.getVg_email_id()).orElse(null);
		existingData.setVdi_ggid(vgvdiDetailEntity.getVdi_ggid());
		existingData.setResource_name(vgvdiDetailEntity.getResource_name());
		existingData.setVg_email_id(vgvdiDetailEntity.getVg_email_id());
		existingData.setVdi_name(vgvdiDetailEntity.getVdi_name());
		existingData.setOdc_location(vgvdiDetailEntity.getOdc_location());
		existingData.setStatus(vgvdiDetailEntity.getStatus());
		existingData.setLwd(vgvdiDetailEntity.getLwd());
		return vgvdidetailRepo.save(existingData);
	}

	public VGVdiDetailEntity saveVGVdiDetailEntity(VGVdiDetailEntity vgvdiDetailEntity) {
		// TODO Auto-generated method stub
		return null;
	}
}
