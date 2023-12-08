package com.vg.resource.webreportautomation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "\"VG_VDI_DETAIL\"")
@Entity
public class VGVdiDetailEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="\"SR.NO\"")
	private Integer serialNo;
	@Column(name="\"VDI_GGID\"" ,unique=false)
	private String vdi_ggid;
	@Column(name="\"RESOURCE_NAME\"")
	private String resource_name;
	@Column(name="\"VG_EMAIL_ID\"")
	private String vg_email_id;
	@Column(name="\"VDI_NAME\"")
	private String vdi_name;
	@Column(name="\"ODC_LOCATION\"")
	private String odc_location;
	@Column(name="\"STATUS\"")
	private String status;
	@Column(name="\"LWD\"")
	private String lwd;

}
