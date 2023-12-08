package com.vg.resource.webreportautomation.helper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.vg.resource.webreportautomation.entity.VGNonFSEntity;
import com.vg.resource.webreportautomation.repo.vgNonFSRepo;
import com.vg.resource.webreportautomation.util.ReportUtil;



public class NonFSHelp {
	@Autowired
	private vgNonFSRepo noFSExcelRepo;
	public static boolean checkExcelFormat(MultipartFile file)
	{
		String contentType = file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		{
			return true;
		}
		return false;
	}
	
	public static List<VGNonFSEntity> convertExceltoList(InputStream is)
	{
		List<VGNonFSEntity> list = new ArrayList<>();
		Map<String, Integer> requiredHeaders = new HashMap<>();
		try {
			DataFormatter formatter = new DataFormatter();
			try (Workbook workbook = new XSSFWorkbook(is)) {
				Sheet sheet = workbook.getSheetAt(0);
				for (Cell cell : sheet.getRow(0)) {
					requiredHeaders.put(cell.getStringCellValue().toUpperCase().trim(), cell.getColumnIndex());
				}
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					Row row = sheet.getRow(i);
					VGNonFSEntity noFSExceldata = new VGNonFSEntity();
					noFSExceldata.setEmpID(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_EMP_ID))));
					noFSExceldata.setLob(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_LOB))));
					noFSExceldata.setEmpName(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_EMP_NAME))));
					noFSExceldata.setEmpEmailId(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_EMP_EMAIL_ID))));
					noFSExceldata.setProjectcode(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_PROJECT_CODE))));
					noFSExceldata.setProjectname(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_PROJECT_NAME))));
					noFSExceldata.setStartDate(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_START_DATE))));
					noFSExceldata.setEndDate(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_END_DATE))));
					noFSExceldata.setRegion(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_REGION_IN_GB))));	
					noFSExceldata.setLocation(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_LOCATION))));	
					noFSExceldata.setRevisedRegion(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_REGION_REGION_OFFSHORE_ONSITE))));
					noFSExceldata.setAccountName(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_ACCOUNT_NAME))));	
					noFSExceldata.setDesignation(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_DESIGNATION_GRADE))));	
					list.add(noFSExceldata);
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