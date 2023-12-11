package com.vg.resource.webreportautomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vg.resource.webreportautomation.entity.VGVdiDetailEntity;
import com.vg.resource.webreportautomation.helper.VGVdiDetailHelper;
import com.vg.resource.webreportautomation.service.vgVdiDetailService;


@RestController
public class VGVdiDetailsController {
	@Autowired
	private vgVdiDetailService vgvdiDetailService;
	
	
	@PostMapping(path="/vgvdi/upload/",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> upload(@RequestPart("file") MultipartFile file)
	{
		if(VGVdiDetailHelper.checkExcelFormat(file))
		{
			this.vgvdiDetailService.save(file);
			return ResponseEntity.status(HttpStatus.OK).body("Successfull");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Upload Excel file only");
	}

	@GetMapping("/vgvdi/")
	public List<VGVdiDetailEntity> getAllData()
		{
			return this.vgvdiDetailService.getAllData();
		}
	
	@GetMapping("/vgvdi/{ggid}")  
	private VGVdiDetailEntity getVGVdidetail(@PathVariable("ggid") String ggid)   
	{  
	return vgvdiDetailService.getVGVdiDetailById(ggid);
	}  

	@DeleteMapping("/vgvdi/{ggid}")  
	private void deleteGGID(@PathVariable("ggid") String ggid)   
	{  
		vgvdiDetailService.delete(ggid);  
	}  
	
	@PutMapping("/vgvdi/updateData")
	public VGVdiDetailEntity updateData(@RequestBody VGVdiDetailEntity vgvdiDetailEntity) {
		return vgvdiDetailService.saveVGVdiDetailEntity(vgvdiDetailEntity);
	}
}
