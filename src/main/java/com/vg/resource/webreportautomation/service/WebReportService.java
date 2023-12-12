package com.vg.resource.webreportautomation.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.vg.resource.webreportautomation.helper.WebReportHelper;
import com.vg.resource.webreportautomation.util.WebReportUtil;
import com.vg.resource.webreportautomation.util.WebReportUtilHelper;



@Service
public class WebReportService {
	
	public void generateFSExcel() throws IOException, SQLException {

			List<WebReportHelper> data = WebReportUtilHelper.readFSDataFromDatabase();

			FileOutputStream outputStream = null;

		    try (Workbook workbook = new XSSFWorkbook()) {

			File file = new File("C:/Users/dobanerj/Documents/Report/FSHCReport.xlsx");

		   File file1 = new File(WebReportUtil.HC_REPORT_LOCATION);	

			file.getParentFile().mkdirs(); // Will create parent directories if not exists

			file.createNewFile();	

			XSSFCellStyle style=(XSSFCellStyle) workbook.createCellStyle();

			XSSFCellStyle styleBlue=(XSSFCellStyle)workbook.createCellStyle();

			XSSFCellStyle styleORG=(XSSFCellStyle)workbook.createCellStyle();

		    XSSFSheet sheet = (XSSFSheet) workbook.createSheet("Data");

			int colIndex = 0;

			XSSFRow row=sheet.createRow(0);  
	 
		 	WebReportUtilHelper.createOrangeCell(colIndex++,row,styleORG).setCellValue(WebReportUtil.HC_REPORT_SR_NO);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_CREW_ID);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_LI_LR_ID);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_GG_ID);

			WebReportUtilHelper.createSrcCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_RESOURCE_NAME);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_CAP_EMAIL_ID);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_VG_EMAIL);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_CG_MANAGER);

			WebReportUtilHelper.createOrangeCell(colIndex++,row,styleORG).setCellValue(WebReportUtil.HC_REPORT_VG_MANAGER);

			WebReportUtilHelper.createSrcCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_LEVEL);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_GRADE_REVISED);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_LOCAL_GRADE);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_REGION);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_REGION_REVISED);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_GAD_COST_CENTER);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_PROJECT_CODE);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_PROJECT_NAME);

			WebReportUtilHelper.createSrcCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_JOB_ROLE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_SKILL);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_PRACTICE);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_SUB_PRACTICE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_PO);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_SOW_NAME);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_SOW_ID);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_SOW_START_DATE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_SOW_END_DATE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_EXHIBIT_TYPE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_RESOURCE_TYPE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_HOURS);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_HOURLY_RATE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_AMOUNT);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_ROLE_START_DATE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_ROLE_END_DATE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_LOCATION);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_LOCATION_VG);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_TOTAL_CONTRACT_AMOUNT);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_PAYMENT_TYPE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_COMMENT);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_SBU);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_LOB);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_DE);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_EM);

			//ReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(ReportUtil.HC_REPORT_CURRENT_STATUS);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_BU_PORTFOLIOS);

			//ReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(ReportUtil.HC_REPORT_END_DATE_R2D2);

			WebReportUtilHelper.createOrangeCell(colIndex++,row,styleORG).setCellValue(WebReportUtil.HC_REPORT_VDI_NAME);

			WebReportUtilHelper.createOrangeCell(colIndex++,row,styleORG).setCellValue(WebReportUtil.HC_REPORT_ODC_LOCATION);

			int index=1;

			int dataRowIndex =1 ;

			 for (WebReportHelper excel1 : data){

				int colNo =0;

				Row dataRow=sheet.createRow(dataRowIndex++);

				dataRow.createCell(colNo++).setCellValue(index++);

				dataRow.createCell(colNo++).setCellValue(excel1.getVgcrew_id());

				dataRow.createCell(colNo++).setCellValue(excel1.getLi_lr_id());

				dataRow.createCell(colNo++).setCellValue(excel1.getGgid());

				dataRow.createCell(colNo++).setCellValue(excel1.getResource_name());

				dataRow.createCell(colNo++).setCellValue(excel1.getCap_email());

				dataRow.createCell(colNo++).setCellValue(excel1.getVg_email());

				dataRow.createCell(colNo++).setCellValue(excel1.getCap_manager());

				dataRow.createCell(colNo++).setCellValue(excel1.getVg_manager());

				dataRow.createCell(colNo++).setCellValue(excel1.getLevel());

				dataRow.createCell(colNo++).setCellValue(excel1.getGrade_revised());

				dataRow.createCell(colNo++).setCellValue(excel1.getLocal_grade());

				dataRow.createCell(colNo++).setCellValue(excel1.getRegion());

				dataRow.createCell(colNo++).setCellValue(excel1.getRegion_revised()); 

				dataRow.createCell(colNo++).setCellValue(excel1.getCostcenter());

				dataRow.createCell(colNo++).setCellValue(excel1.getProject_Code());

				dataRow.createCell(colNo++).setCellValue(excel1.getProject_name());

				dataRow.createCell(colNo++).setCellValue(excel1.getJob_role());
				dataRow.createCell(colNo++).setCellValue(excel1.getPrimaryskill());

				dataRow.createCell(colNo++).setCellValue(excel1.getPractice());

				dataRow.createCell(colNo++).setCellValue(excel1.getSub_practice());

				dataRow.createCell(colNo++).setCellValue(excel1.getPo());

				dataRow.createCell(colNo++).setCellValue(excel1.getSow_name());

				dataRow.createCell(colNo++).setCellValue(excel1.getSow_id());

				dataRow.createCell(colNo++).setCellValue(excel1.getSow_start_date());

				dataRow.createCell(colNo++).setCellValue(excel1.getSow_end_date());

				dataRow.createCell(colNo++).setCellValue(excel1.getExhibit_type());

				dataRow.createCell(colNo++).setCellValue(excel1.getResource_type());
	 
				dataRow.createCell(colNo++).setCellValue(excel1.getHours());

				dataRow.createCell(colNo++).setCellValue(excel1.getHourly_rate());

				dataRow.createCell(colNo++).setCellValue(excel1.getAmount());

				dataRow.createCell(colNo++).setCellValue(excel1.getRole_start_date());

				dataRow.createCell(colNo++).setCellValue(excel1.getRole_end_date());

				dataRow.createCell(colNo++).setCellValue(excel1.getLocation());

				dataRow.createCell(colNo++).setCellValue(excel1.getVg_location());

				dataRow.createCell(colNo++).setCellValue(excel1.getTotal_contract_amount());
	 
				dataRow.createCell(colNo++).setCellValue(excel1.getPayment_type());

				dataRow.createCell(colNo++).setCellValue(excel1.getComment());

				dataRow.createCell(colNo++).setCellValue(excel1.getSbu());

				dataRow.createCell(colNo++).setCellValue(excel1.getLob());

				dataRow.createCell(colNo++).setCellValue(excel1.getDe());

				dataRow.createCell(colNo++).setCellValue(excel1.getEm_name());

				dataRow.createCell(colNo++).setCellValue(excel1.getBu_portfolios());
				dataRow.createCell(colNo++).setCellValue(excel1.getVdi_name());

				dataRow.createCell(colNo++).setCellValue(excel1.getOdc_location());

			}

			try 

			 {	

	            outputStream = new FileOutputStream(file,false); 

				workbook.write(outputStream);

	         } catch (IOException e) {

	             e.printStackTrace();

	         }finally{

				workbook.close();

				if(outputStream !=null)

					outputStream.close();

			 }

	     } catch (IOException e) {

	         e.printStackTrace();

	     }

	}

		public void generateNonFSExcel() throws IOException, SQLException {

			List<WebReportHelper> data = WebReportUtilHelper.readNonFSDataFromDatabase();

			FileOutputStream outputStream = null;

		    try (Workbook workbook = new XSSFWorkbook()) {

			File file = new File("C:/Users/dobanerj/Documents/Report/NOnHCReport.xlsx");

		   // File file = new File(ReportUtil.HC_REPORT_LOCATION);	

			file.getParentFile().mkdirs(); // Will create parent directories if not exists

			file.createNewFile();	

			XSSFCellStyle style=(XSSFCellStyle) workbook.createCellStyle();

			XSSFCellStyle styleBlue=(XSSFCellStyle)workbook.createCellStyle();

			XSSFCellStyle styleORG=(XSSFCellStyle)workbook.createCellStyle();

		    XSSFSheet sheet = (XSSFSheet) workbook.createSheet("Data");

			int colIndex = 0;

			XSSFRow row=sheet.createRow(0);  

			WebReportUtilHelper.createOrangeCell(colIndex++,row,styleORG).setCellValue(WebReportUtil.HC_REPORT_SR_NO);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_CREW_ID);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_LI_LR_ID);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_GG_ID);

			WebReportUtilHelper.createSrcCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_RESOURCE_NAME);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_CAP_EMAIL_ID);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_VG_EMAIL);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_CG_MANAGER);

			WebReportUtilHelper.createOrangeCell(colIndex++,row,styleORG).setCellValue(WebReportUtil.HC_REPORT_VG_MANAGER);

			WebReportUtilHelper.createSrcCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_LEVEL);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_GRADE_REVISED);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_LOCAL_GRADE);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_REGION);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_REGION_REVISED);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_GAD_COST_CENTER);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_PROJECT_CODE);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_PROJECT_NAME);

			WebReportUtilHelper.createSrcCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_JOB_ROLE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_SKILL);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_PRACTICE);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_SUB_PRACTICE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_PO);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_SOW_NAME);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_SOW_ID);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_SOW_START_DATE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_SOW_END_DATE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_EXHIBIT_TYPE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_RESOURCE_TYPE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_HOURS);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_HOURLY_RATE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_AMOUNT);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_ROLE_START_DATE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_ROLE_END_DATE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_LOCATION);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_LOCATION_VG);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_TOTAL_CONTRACT_AMOUNT);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_PAYMENT_TYPE);

			WebReportUtilHelper.createSrcCell(colIndex++,row,style).setCellValue(WebReportUtil.HC_REPORT_COMMENT);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_SBU);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_LOB);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_DE);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_EM);

			//ReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(ReportUtil.HC_REPORT_CURRENT_STATUS);

			WebReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(WebReportUtil.HC_REPORT_BU_PORTFOLIOS);

			//ReportUtilHelper.createGadCell(colIndex++,row,styleBlue).setCellValue(ReportUtil.HC_REPORT_END_DATE_R2D2);

			WebReportUtilHelper.createOrangeCell(colIndex++,row,styleORG).setCellValue(WebReportUtil.HC_REPORT_VDI_NAME);

			WebReportUtilHelper.createOrangeCell(colIndex++,row,styleORG).setCellValue(WebReportUtil.HC_REPORT_ODC_LOCATION);


			int index=1;

			int dataRowIndex =1 ;

			 for (WebReportHelper excel1 : data){

				int colNo =0;

				Row dataRow=sheet.createRow(dataRowIndex++);

				dataRow.createCell(colNo++).setCellValue(index++);

				dataRow.createCell(colNo++).setCellValue(excel1.getVgcrew_id());

				dataRow.createCell(colNo++).setCellValue(excel1.getLi_lr_id());

				dataRow.createCell(colNo++).setCellValue(excel1.getGgid());

				dataRow.createCell(colNo++).setCellValue(excel1.getResource_name());

				dataRow.createCell(colNo++).setCellValue(excel1.getCap_email());

				dataRow.createCell(colNo++).setCellValue(excel1.getVg_email());

				dataRow.createCell(colNo++).setCellValue(excel1.getCap_manager());

				dataRow.createCell(colNo++).setCellValue(excel1.getVg_manager());

				dataRow.createCell(colNo++).setCellValue(excel1.getLevel());

				dataRow.createCell(colNo++).setCellValue(excel1.getGrade_revised());

				dataRow.createCell(colNo++).setCellValue(excel1.getLocal_grade());

				dataRow.createCell(colNo++).setCellValue(excel1.getRegion());

				dataRow.createCell(colNo++).setCellValue(excel1.getRegion_revised()); 

				dataRow.createCell(colNo++).setCellValue(excel1.getCostcenter());

				dataRow.createCell(colNo++).setCellValue(excel1.getProject_Code());

				dataRow.createCell(colNo++).setCellValue(excel1.getProject_name());

				dataRow.createCell(colNo++).setCellValue(excel1.getJob_role());
				dataRow.createCell(colNo++).setCellValue(excel1.getPrimaryskill());

				dataRow.createCell(colNo++).setCellValue(excel1.getPractice());

				dataRow.createCell(colNo++).setCellValue(excel1.getSub_practice());

				dataRow.createCell(colNo++).setCellValue(excel1.getPo());

				dataRow.createCell(colNo++).setCellValue(excel1.getSow_name());

				dataRow.createCell(colNo++).setCellValue(excel1.getSow_id());

				dataRow.createCell(colNo++).setCellValue(excel1.getSow_start_date());

				dataRow.createCell(colNo++).setCellValue(excel1.getSow_end_date());

				dataRow.createCell(colNo++).setCellValue(excel1.getExhibit_type());

				dataRow.createCell(colNo++).setCellValue(excel1.getResource_type());
	 
				dataRow.createCell(colNo++).setCellValue(excel1.getHours());

				dataRow.createCell(colNo++).setCellValue(excel1.getHourly_rate());

				dataRow.createCell(colNo++).setCellValue(excel1.getAmount());

				dataRow.createCell(colNo++).setCellValue(excel1.getRole_start_date());

				dataRow.createCell(colNo++).setCellValue(excel1.getRole_end_date());

				dataRow.createCell(colNo++).setCellValue(excel1.getLocation());

				dataRow.createCell(colNo++).setCellValue(excel1.getVg_location());

				dataRow.createCell(colNo++).setCellValue(excel1.getTotal_contract_amount());
	 
				dataRow.createCell(colNo++).setCellValue(excel1.getPayment_type());

				dataRow.createCell(colNo++).setCellValue(excel1.getComment());

				dataRow.createCell(colNo++).setCellValue(excel1.getSbu());

				dataRow.createCell(colNo++).setCellValue(excel1.getLob());

				dataRow.createCell(colNo++).setCellValue(excel1.getDe());

				dataRow.createCell(colNo++).setCellValue(excel1.getEm_name());

				dataRow.createCell(colNo++).setCellValue(excel1.getBu_portfolios());
				dataRow.createCell(colNo++).setCellValue(excel1.getVdi_name());

				dataRow.createCell(colNo++).setCellValue(excel1.getOdc_location());			}

			try 

			 {	

	            outputStream = new FileOutputStream(file,false); 

				workbook.write(outputStream);

	         } catch (IOException e) {

	             e.printStackTrace();

	         }finally{

				workbook.close();

				if(outputStream !=null)

					outputStream.close();

			 }

	     } catch (IOException e) {

	         e.printStackTrace();

	     }

	}
 }
