package com.vg.resource.webreportautomation.util;

public interface ReportUtil {
	public final String FSquery="SELECT Distinct  \"VG_GAD_DATA\".\"LI_LR_ID\" , \"SOW_MASTER\".\"SOW_NAME\",\"VG_GAD_DATA\".\"CAP_EMAIL_ID\" ,\"VG_GAD_DATA\".\"CG MANAGER\" , " +
			    "\"VG_GAD_DATA\".\"GRADE_REVISED\" ,\"VG_GAD_DATA\".\"LOCAL_GRADE\" , \"VG_GAD_DATA\".\"REGION\" , \"VG_GAD_DATA\".\"REGION_REVISED\","+
			    "\"VG_GAD_DATA\".\"GAD_COST_CENTER\" ,\"VG_GAD_DATA\".\"PROJECT_CODE\" ,\"VG_GAD_DATA\".\"PROJECT_NAME\", \"VG_GAD_DATA\".\"PRACTICE\","+
	            "\"VG_GAD_DATA\".\"SUB_PRACTICE\" ,\"VG_GAD_DATA\".\"LOCATION\",\"VG_GAD_DATA\".\"BU_PORTFOLIO\",\"VG_GAD_DATA\".\"CURRENT_STATUS\","+
	            "\"VG_GAD_DATA\".\"SBU\" ,\"VG_GAD_DATA\".\"LOB\" ,\"VG_GAD_DATA\".\"DE\" ,\"VG_GAD_DATA\".\"EM\",  \"VG_GAD_DATA\".\"END_DATE_R2D2\",\"VG_SOURCE\".\"GGID\" , \"VG_SOURCE\".\"AMOUNT\", "+
			    "\"VG_SOURCE\".\"COMMENTS\" ,\"VG_SOURCE\".\"HOURLY_RATE\" , \"VG_SOURCE\".\"HOURS\" , \"VG_SOURCE\".\"JOB_ROLE\" ,\"VG_SOURCE\".\"VG LOCATION\"," +
			    "\"VG_SOURCE\".\"PAYMENT TYPE\",\"VG_SOURCE\".\"SOW_START_DATE\",\"VG_SOURCE\".\"SOW_END_DATE\",\"VG_SOURCE\".\"LEVEL\" ,\"VG_SOURCE\".\"PO\" ,\"VG_SOURCE\".\"PRIMARY_SKILL\" , \"VG_SOURCE\".\"RESOURCE_NAME\" ,\"VG_SOURCE\".\"ROLE_END_DATE\" ,"+
			    "\"VG_SOURCE\".\"EXHIBIT TYPE\",\"VG_SOURCE\".\"RESOURCE TYPE\",\"VG_SOURCE\".\"VG_CREW_ID\" , \"VG_SOURCE\".\"SOW_ID\",\"VG_SOURCE\".\"TOTAL_CONTRACT_AMOUNT\" ,\"VG_SOURCE\".\"ROLE_START_DATE\",\"VG_VDI_DETAIL\".\"VG_EMAIL_ID\" ," +
				"\"VG_VDI_DETAIL\".\"VDI_NAME\" , \"VG_VDI_DETAIL\".\"ODC_LOCATION\", \"VG_VDI_DETAIL\".\"STATUS\", \"VG_VDI_DETAIL\".\"LWD\" "+
			   " FROM  \"VG_SOURCE\"  left join  \"VG_GAD_DATA\"   on  \"VG_SOURCE\".\"GGID\"  =  \"VG_GAD_DATA\".\"GGID\" "+
			   " LEFT JOIN  \"VG_VDI_DETAIL\"  on  \"VG_GAD_DATA\".\"GGID\"  = \"VG_VDI_DETAIL\".\"VDI_GGID\" "+
	           " JOIN \"SOW_MASTER\" on \"SOW_MASTER\".\"SOW_ID\" =  \"VG_SOURCE\".\"SOW_ID\" ";
	
		public final String NonFsquery="SELECT Distinct \"VG_GAD_DATA\".\"LI_LR_ID\" ,\"VG_GAD_DATA\".\"CAP_EMAIL_ID\" ,\"VG_GAD_DATA\".\"CG MANAGER\" ,"+
				
			    "\"VG_GAD_DATA\".\"GRADE_REVISED\" ,\"VG_GAD_DATA\".\"LOCAL_GRADE\" , \"VG_GAD_DATA\".\"REGION\" , \"VG_GAD_DATA\".\"REGION_REVISED\",\"VG_GAD_DATA\".\"GGID\",\"VG_GAD_DATA\".\"CG MANAGER\","+
			    "\"VG_GAD_DATA\".\"GAD_COST_CENTER\" ,\"VG_GAD_DATA\".\"PROJECT_CODE\" ,\"VG_GAD_DATA\".\"PROJECT_NAME\", \"VG_GAD_DATA\".\"PRACTICE\","+
	            "\"VG_GAD_DATA\".\"SUB_PRACTICE\" ,\"VG_GAD_DATA\".\"LOCATION\",\"VG_GAD_DATA\".\"BU_PORTFOLIO\",\"VG_GAD_DATA\".\"CURRENT_STATUS\","+
	            "\"VG_GAD_DATA\".\"SBU\" ,\"VG_GAD_DATA\".\"LOB\" ,\"VG_GAD_DATA\".\"DE\" ,\"VG_GAD_DATA\".\"EM\",  \"VG_GAD_DATA\".\"END_DATE_R2D2\", "+
			    "\"VG_NON_FS_MASTER_DATA\".\"VENDOR\" ,\"VG_NON_FS_MASTER_DATA\".\"EMP_ID\" , \"VG_NON_FS_MASTER_DATA\".\"MONTH\" , \"VG_NON_FS_MASTER_DATA\".\"ACCOUNT_NAME\" ," +
			    "\"VG_NON_FS_MASTER_DATA\".\"EMP_NAME\",\"VG_NON_FS_MASTER_DATA\".\"EMP_EMAIL_ID\",\"VG_NON_FS_MASTER_DATA\".\"EMP_USER_ID\",\"VG_NON_FS_MASTER_DATA\".\"DESIGNATION\" ,\"VG_NON_FS_MASTER_DATA\".\"PROJECT_CODE\" ,\"VG_NON_FS_MASTER_DATA\".\"PROJECT_NAME\" , \"VG_NON_FS_MASTER_DATA\".\"START_DATE\" ,\"VG_NON_FS_MASTER_DATA\".\"END_DATE\" ,"+
			    " \"VG_NON_FS_MASTER_DATA\".\"REGION\",\"VG_NON_FS_MASTER_DATA\".\"VG LOCATION\",\"VG_NON_FS_MASTER_DATA\".\"REVISED_REGION\" , \"VG_NON_FS_MASTER_DATA\".\"IBS\",\"VG_VDI_DETAIL\".\"VG_EMAIL_ID\" ," +
				"\"VG_VDI_DETAIL\".\"VDI_NAME\" , \"VG_VDI_DETAIL\".\"ODC_LOCATION\", \"VG_VDI_DETAIL\".\"STATUS\", \"VG_VDI_DETAIL\".\"LWD\" "+
			   " FROM  \"VG_GAD_DATA\"  left join  \"VG_VDI_DETAIL\"   on  \"VG_GAD_DATA\".\"GGID\"  =  \"VG_VDI_DETAIL\".\"VDI_GGID\" "+
			   " LEFT JOIN  \"VG_NON_FS_MASTER_DATA\"  on  \"VG_NON_FS_MASTER_DATA\".\"EMP_ID\"  = \"VG_GAD_DATA\".\"LI_LR_ID\" ";


		 public final String HC_REPORT_GENERATE_LOCATION= "C:/Report/";   
		    public final String HC_REPORT_SR_NO= "SR.No";
		    public final String HC_REPORT_CREW_ID= "VG CREW ID";  
		    public final String HC_REPORT_LI_LR_ID= "LI/LR ID"; 
		    public final String HC_REPORT_GG_ID= "GGID"; 
		    public final String HC_REPORT_RESOURCE_NAME= "RESOURCE NAME"; 
		    public final String HC_REPORT_CAP_EMAIL_ID= "CAP EMAIL ID"; 
		    public final String HC_REPORT_VG_EMAIL= "VG EMAIL"; 
		    public final String HC_REPORT_CG_MANAGER= "CG MANAGER"; 
		    public final String HC_REPORT_VG_MANAGER= "VG MANAGER"; 
		    public final String HC_REPORT_LEVEL= "LEVEL"; 
		    public final String HC_REPORT_GRADE_REVISED= "GRADE REVISED"; 
		    public final String HC_REPORT_LOCAL_GRADE= "LOCAL GRADE"; 
		    public final String HC_REPORT_REGION= "REGION"; 
		    public final String HC_REPORT_REGION_REVISED= "REGION REVISED"; 
		    public final String HC_REPORT_GAD_COST_CENTER= "COST CENTER"; 
		    public final String HC_REPORT_PROJECT_CODE= "PROJECT CODE"; 
		    public final String HC_REPORT_PROJECT_NAME= "PROJECT NAME"; 
		    public final String HC_REPORT_JOB_ROLE= "JOB ROLE"; 
		    public final String HC_REPORT_SKILL= "SKILL"; 
		    public final String HC_REPORT_PRACTICE= "PRACTICE"; 
		    public final String HC_REPORT_SUB_PRACTICE= "SUB PRACTICE";
		    public final String HC_REPORT_PO= "PO"; 
		    public final String HC_REPORT_SOW_NAME= "SOW NAME"; 
		    public final String HC_REPORT_SOW_ID= "SOW ID"; 
		    public final String HC_REPORT_SOW_START_DATE= "SOW START DATE"; 
		    public final String HC_REPORT_SOW_END_DATE= "SOW END DATE"; 
		    public final String HC_REPORT_EXHIBIT_TYPE= "EXHIBIT TYPE";
		    public final String HC_REPORT_RESOURCE_TYPE= "RESOURCE TYPE";
		    public final String HC_REPORT_HOURS= "HOURS";
		    public final String HC_REPORT_HOURLY_RATE= "HOURLY RATE";
		    public final String HC_REPORT_AMOUNT= "AMOUNT";
		    public final String HC_REPORT_ROLE_START_DATE= "ROLE START DATE";
		    public final String HC_REPORT_ROLE_END_DATE= "ROLE END DATE";
		    public final String HC_REPORT_LOCATION= "LOCATION"; 
		    public final String HC_REPORT_LOCATION_VG= "LOCATION VG"; 
		    public final String HC_REPORT_TOTAL_CONTRACT_AMOUNT= "TOTAL CONTRACT AMOUNT";
		    public final String HC_REPORT_PAYMENT_TYPE= "PAYMENT TYPE"; 
		    public final String HC_REPORT_COMMENT= "COMMENT"; 
		    public final String HC_REPORT_SBU= "SBU";
		    public final String HC_REPORT_LOB= "LOB"; 
		    public final String HC_REPORT_DE= "DE";
		    public final String HC_REPORT_EM= "EM"; 
		    public final String HC_REPORT_BU_PORTFOLIOS= "BU PORTFOLIOS"; 
		    public final String HC_REPORT_VDI_NAME= "VDI NAME"; 
		    public final String HC_REPORT_ODC_LOCATION= "ODC LOCATION"; 
		    public final String HC_REPORT_MONTH= "MONTH"; 
		    public final String HC_REPORT_ACCOUNT_NAME= "ACCOUNT NAME"; 
		    public final String HC_REPORT_LWD= "LWD"; 
		    public final String HC_REPORT_ID="ID";
		    public final String HC_REPORT_VG_EMAIL_ID="VG EMAIL ID";
		    public final String HC_REPORT_STATUS="STATUS";
		    public final String HC_REPORT_EMP_NAME="EMP NAME";
		    public final String HC_REPORT_EMP_ID="EMP ID";
		    public final String HC_REPORT_EMP_EMAIL_ID="EMP EMAIL ID";
		    public final String HC_REPORT_START_DATE="START DATE";
		    public final String HC_REPORT_END_DATE="END DATE";
		    public final String HC_REPORT_REGION_IN_GB="REGION(IN/GB/US/CA/FR)";
		    public final String HC_REPORT_REGION_REGION_OFFSHORE_ONSITE="REVISED REGION (OFFSHORE/ONSITE)";
		    public final String HC_REPORT_DESIGNATION_GRADE="DESIGNATION/GRADE";
		    public final String HC_REPORT_SUPERVISOR_NAME = "SUPERVISOR NAME";
		    public final String HC_REPORT_FS_NONFS_SUBK= "FS/NON FS/SUBK";
			public final String HC_REPORT_TEXT_COST_CENTER= "COST CENTER TEXT";
			public final String HC_REPORT_JOB_ROLE_INPUT= "JOB TITLE/ROLE (PLEASE USE DROP DOWN SELECTION)"; 			
		    public final String HC_REPORT_PROJECT_NUMBER= "PROJECT NUMBER"; 
			public final String HC_REPORT_LOCATION_INPUT= "LOCATION";
			public final String HC_REPORT_PRIMARY_SKILLS="Primary Skills";
	    

} 
