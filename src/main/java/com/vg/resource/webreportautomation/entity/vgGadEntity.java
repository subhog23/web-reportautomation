package com.vg.resource.webreportautomation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
	@Data
	@Table(name = "\"VG_GAD_DATA\"")
	@Entity
	public class vgGadEntity {
		@Id
		@Column(name="\"GGID\"")
		private String ggid;
		@Column(name="\"LI_LR_ID\"")
		private String li_lrId;
		@Column(name="\"CAP_EMAIL_ID\"")
		private String CapEmailid;
		@Column(name="\"GRADE_REVISED\"")
		private String graderevised;
		@Column(name="\"LOCAL_GRADE\"")
		private String localgrade;
		@Column(name="\"REGION\"")
		private String region;
		@Column(name="\"REGION_REVISED\"")
		private String regionRevised;
		@Column(name="\"GAD_COST_CENTER\"")
		private String gadCostCenter;
		@Column(name="\"PROJECT_CODE\"")
		private String projectCode;
		@Column(name="\"PROJECT_NAME\"")
		private String projectName;
		@Column(name="\"PRACTICE\"")
		private String practice;
		@Column(name="\"SUB_PRACTICE\"")
	    private String subPractise;
		@Column(name="\"SBU\"")
		private String sbu;
		@Column(name="\"FS_NON_FS\"")
		private String fs_non_fs;
		@Column(name="\"BU_PORTFOLIO\"")
		private String buPortfolio;
		@Column(name="\"LOB\"")
		private String lob;
		@Column(name="\"DE\"")
		private String de;
		@Column(name="\"EM\"")
		private String em;
		@Column(name="\"CURRENT_STATUS\"")
		private String currentStatus;
		@Column(name="\"END_DATE_R2D2\"")
		private String endDateR2d2;	
		@Column(name="\"LOCATION\"")
	    private String location;
		@Column(name="\"CG MANAGER\"")
	    private String supervisor;

}
