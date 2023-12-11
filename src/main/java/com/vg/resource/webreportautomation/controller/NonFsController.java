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

import com.vg.resource.webreportautomation.entity.VGNonFSEntity;
import com.vg.resource.webreportautomation.helper.NonFSHelp;
import com.vg.resource.webreportautomation.service.NonFSService;

@RestController
public class NonFsController {

	@Autowired
	private NonFSService nonFSService;
	
	
	@PostMapping(path="/nonfs/upload/",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> upload(@RequestPart("file") MultipartFile file)
	{
		if(NonFSHelp.checkExcelFormat(file))
		{
			this.nonFSService.save(file);
			return ResponseEntity.status(HttpStatus.OK).body("Successfull");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Upload Excel file only");
	}

	@GetMapping("/nonfs/")
	public List<VGNonFSEntity> getAllData()
		{
			return this.nonFSService.getAllData();
		}
	@GetMapping("/nonfs/{empID}")  
	private VGNonFSEntity getNonFs(@PathVariable("empID") String ggid)   
	{  
		return nonFSService.getNonFsById(ggid);
	}  

	@DeleteMapping("/nonfs/{empID}")  
	private void deleteGGID(@PathVariable("empID") String ggid)   
	{  
		nonFSService.delete(ggid);  
	}  
	
	@PutMapping("/nonfs/updateData/")
	public VGNonFSEntity updateData(@RequestBody VGNonFSEntity vgNonFSEntity) {
		return nonFSService.savevgNonFSEntity(vgNonFSEntity);
	}

}
