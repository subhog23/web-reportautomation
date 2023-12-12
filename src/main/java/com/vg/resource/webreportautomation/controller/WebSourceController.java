package com.vg.resource.webreportautomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vg.resource.webreportautomation.entity.WebVGSourceEntity;
import com.vg.resource.webreportautomation.helper.WebSourcelHelp;
import com.vg.resource.webreportautomation.service.WebSourceService;

@RestController
@CrossOrigin("*")
public class WebSourceController {
	@Autowired
	private WebSourceService sourcService;
	
	
	@PostMapping(path="/source/upload/",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> upload(@RequestPart("file") MultipartFile file)
	{
		if(WebSourcelHelp.checkExcelFormat(file))
		{
			this.sourcService.save(file);
			return ResponseEntity.status(HttpStatus.OK).body("Successfull");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Upload Excel file only");
	}
	
	
	@GetMapping("source/")
	public List<WebVGSourceEntity> getAllData()
		{
			return this.sourcService.getAllData();
		}
	@GetMapping("/source/{ggId}")  
	private WebVGSourceEntity getVGSource(@PathVariable("gGId") String ggid)   
	{  
		return sourcService.getVGSourceById(ggid);
	}  

	@DeleteMapping("/source/{gGId}")  
	private void deleteGGID(@PathVariable("gGId") String ggid)   
	{  
		sourcService.delete(ggid);  
	}  
	@PutMapping("/source/updateData")
	public WebVGSourceEntity updateData(@RequestBody WebVGSourceEntity vgSourceEntity) {
		return sourcService.savevgSourceEntity(vgSourceEntity);
	}

}
