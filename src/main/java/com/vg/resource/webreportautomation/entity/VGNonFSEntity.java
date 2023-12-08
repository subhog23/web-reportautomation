package com.vg.resource.webreportautomation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "\"VG_NON_FS_MASTER_DATA\"")
@Entity
@Data
public class VGNonFSEntity {


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="\"VENDOR\"")
	private Integer serialNo;
	@Id
	@Column(name="\"EMP_ID\"",unique=false)
	private String empID;
	@Column(name="\"MONTH\"")
	private String month;
	@Column(name="\"ACCOUNT_NAME\"")
	private String accountName;
	@Column(name="\"LOB\"")
	private String lob;
	@Column(name="\"EMP_NAME\"")
	private String empName;
	@Column(name="\"EMP_EMAIL_ID\"")
	private String empEmailId;
	@Column(name="\"EMP_USER_ID\"")
	private String empUserID;
	@Column(name="\"DESIGNATION\"")
	private String designation;
	@Column(name="\"PROJECT_CODE\"")
	private String projectcode ;
	@Column(name="\"PROJECT_NAME\"")
	private String projectname;
	@Column(name="\"START_DATE\"")
	private String startDate;
	@Column(name="\"END_DATE\"")
	private String endDate;
	@Column(name="\"REGION\"")
	private String region;
	@Column(name="\"VG LOCATION\"")
	private String location;
	@Column(name="\"REVISED_REGION\"")
	private String revisedRegion;
	@Column(name="\"IBS\"")
	private String lbs;
}
