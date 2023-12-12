package com.vg.resource.webreportautomation.helper;

import java.io.InputStream;
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

import com.vg.resource.webreportautomation.entity.WebvgGadEntity;
import com.vg.resource.webreportautomation.util.WebReportUtil;


public class WebGadHelper {	
	
	public static boolean checkExcelFormat(MultipartFile file)
	{
		String contentType = file.getContentType();
		if(contentType!=null && contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		{
			return true;
		}
		return false;
	}

	public static List<WebvgGadEntity> convertExceltoList(InputStream is)
	{
		List<WebvgGadEntity> list = new ArrayList<>();
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
					if(row!=null){
					WebvgGadEntity vggadEntity = new WebvgGadEntity();
					
					vggadEntity.setGgid(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_GG_ID))));
					vggadEntity.setLi_lrId(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_LI_LR_ID))));
					vggadEntity.setCapEmailid(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_CAP_EMAIL_ID))));
					vggadEntity.setGraderevised(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_GRADE_REVISED))));
					vggadEntity.setLocalgrade(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_LOCAL_GRADE))));
					vggadEntity.setRegion(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_REGION))));
					vggadEntity.setRegionRevised(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_REGION_REVISED))));
					vggadEntity.setGadCostCenter(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_TEXT_COST_CENTER))));
					vggadEntity.setProjectCode(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_PROJECT_CODE))));
					vggadEntity.setProjectName(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_PROJECT_NAME))));
					vggadEntity.setPractice(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_PRACTICE))));
					vggadEntity.setSbu(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_SBU))));
					vggadEntity.setFs_non_fs(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_FS_NONFS_SUBK))));
					vggadEntity.setBuPortfolio(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_BU_PORTFOLIOS))));
					vggadEntity.setLob(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_LOB))));
					vggadEntity.setDe(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_DE))));
					vggadEntity.setEm(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_EM))));
					vggadEntity.setSubPractise(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_SUB_PRACTICE))));
					vggadEntity.setLocation(formatter.formatCellValue(row.getCell(requiredHeaders.get(WebReportUtil.HC_REPORT_LOCATION))));
				//	vggadEntity.setSupervisor(formatter.formatCellValue(row.getCell(requiredHeaders.get(ReportUtil.HC_REPORT_SUPERVISOR_NAME))));
					list.add(vggadEntity);
					}
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
	