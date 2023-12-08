package com.vg.resource.webreportautomation.helper;

import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.vg.resource.webreportautomation.entity.VGSourceEntity;
import com.vg.resource.webreportautomation.util.ReportUtil;
 
 
public class SourcelHelp {

	public static boolean checkExcelFormat(MultipartFile file)
	{
		String contentType = file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		{
			return true;
		}
		return false;
	}
	public static List<VGSourceEntity> convertExceltoList(InputStream is)
	{
		List<VGSourceEntity> list = new ArrayList<>();
		Map<String, Integer> requiredHeaders = new HashMap<>();
		try {
			DataFormatter formatter = new DataFormatter();
			try (Workbook workbook = new XSSFWorkbook(is)) {
				Sheet sheet = workbook.getSheetAt(0);				
				for (Cell cell : sheet.getRow(sheet.getFirstRowNum())) {
					requiredHeaders.put(cell.getStringCellValue().toUpperCase().trim(), cell.getColumnIndex());
				}
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					Row row = sheet.getRow(i);
					VGSourceEntity sourceExcelData = new VGSourceEntity();
					sourceExcelData.setGGId(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_CREW_ID))));
					sourceExcelData.setResourceName(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_RESOURCE_NAME))));
					sourceExcelData.setLevel(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_LEVEL))));
					sourceExcelData.setJobRole(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_JOB_ROLE_INPUT))));
					sourceExcelData.setPrimaryskill(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_PRIMARY_SKILLS))));
					sourceExcelData.setPo(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_PO))));
					if(!(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_SOW_ID))).isEmpty() || 
					 formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_SOW_ID))).equals("TBD")))
					sourceExcelData.setSowId(Integer.valueOf(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_SOW_ID)))));
					sourceExcelData.setHours(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_HOURS))));
					sourceExcelData.setHourlyRate(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_HOURLY_RATE))));
					sourceExcelData.setAmount(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_AMOUNT))));
					sourceExcelData.setRoleStartDate(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_ROLE_START_DATE))));
					sourceExcelData.setRoleEndDate(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_ROLE_END_DATE))));
					sourceExcelData.setTotalContractAmount(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_TOTAL_CONTRACT_AMOUNT))));
					sourceExcelData.setComment(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_COMMENT))));
					sourceExcelData.setExhibit_type(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_EXHIBIT_TYPE))));
					sourceExcelData.setResourc_type(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_RESOURCE_TYPE))));
					sourceExcelData.setPaymentType(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_PAYMENT_TYPE))));
					sourceExcelData.setSowStartDate(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_SOW_START_DATE))));
					sourceExcelData.setSowEndDate(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_SOW_END_DATE))));
					sourceExcelData.setLocationVg(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_LOCATION)))); 					
					list.add(sourceExcelData);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
}