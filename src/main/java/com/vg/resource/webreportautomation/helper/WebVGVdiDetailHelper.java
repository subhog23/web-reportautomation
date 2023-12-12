package com.vg.resource.webreportautomation.helper;

import java.io.InputStream;
import java.text.SimpleDateFormat;
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

import com.vg.resource.webreportautomation.entity.WebVGVdiDetailEntity;
import com.vg.resource.webreportautomation.util.WebReportUtil;


public class WebVGVdiDetailHelper {
	
	public static boolean checkExcelFormat(MultipartFile file)
	{
		String contentType = file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		{
			return true;
		}
		return false;
	}
	
	public static List<WebVGVdiDetailEntity> convertExceltoList(InputStream is)
	{
		List<WebVGVdiDetailEntity> list = new ArrayList<>();
		Map<String, Integer> requiredHeaders = new HashMap<>();
		try {
			DataFormatter formatter = new DataFormatter();
			Workbook workbook = new XSSFWorkbook(is);
			Sheet sheet = workbook.getSheetAt(0);
			for (Cell cell : sheet.getRow(0)) {				
				requiredHeaders.put(cell.getStringCellValue().toUpperCase().trim(), cell.getColumnIndex());
			}
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				WebVGVdiDetailEntity vdidata = new WebVGVdiDetailEntity();							
				vdidata.setVdi_ggid(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_ID))).toString());
				vdidata.setResource_name(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_RESOURCE_NAME))));
				vdidata.setVg_email_id(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_VG_EMAIL_ID))));
				vdidata.setVdi_name(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_VDI_NAME))));
				vdidata.setStatus(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_STATUS))));
				vdidata.setOdc_location(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_ODC_LOCATION))));				
				vdidata.setLwd(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_LWD))));				
				list.add(vdidata);
			}
			
			workbook.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
}