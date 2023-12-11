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

import com.vg.resource.webreportautomation.entity.vgGadEntity;
import com.vg.resource.webreportautomation.helper.GadHelper;
import com.vg.resource.webreportautomation.service.GadService;

@RestController
public class GadController {
	@Autowired
	private GadService gadService;

	@PostMapping(path="/Gad/upload/",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> upload(@RequestPart("file") MultipartFile file)
	{
		if(GadHelper.checkExcelFormat(file))
		{
			this.gadService.save(file);
			return ResponseEntity.status(HttpStatus.OK).body("Successfull");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Upload Excel file only");
	}
	
	@GetMapping("/Gad")
	public List<vgGadEntity> getAllData()
		{
			return this.gadService.getAllData();
		}
	@GetMapping("/Gad/{ggid}")  
	private vgGadEntity getvgGad(@PathVariable("ggid") String ggid)   
	{  
		return gadService.getvgGadById(ggid);
	}  

	@DeleteMapping("/Gad/{ggid}")  
	private void deleteGGID(@PathVariable("ggid") String ggid)   
	{  
		gadService.delete(ggid);  
	}  
	@PutMapping("/Gad/updateData")
	public vgGadEntity updateData(@RequestBody vgGadEntity vggadEntity) {
		return gadService.savevgGadEntity(vggadEntity);
	}
}
