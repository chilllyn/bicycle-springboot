package com.aowin.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class RepairRecord {

	private Integer recordId;
	private Integer bicycleId;
	private String bicycleCode;
	private Integer repairType;

	@Pattern(regexp = "^[\\u4e00-\\u9fa5]+(\\u3001[\\u4e00-\\u9fa5]+)*$")
	@NotEmpty
	private String repairPart;

	private Integer repairResult;
	@Min(0)
	@Max(9999)
	private Double fee;
	private String repairer;
	private String repairDate;
	private String remark;
	private Integer userId;
	private String operatorTime;

	public String getBicycleCode() {
		return bicycleCode;
	}

	public void setBicycleCode(String bicycleCode) {
		this.bicycleCode = bicycleCode;
	}

	public String getRepairer() {
		return repairer;
	}

	public void setRepairer(String repairer) {
		this.repairer = repairer;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(Integer bicycleId) {
		this.bicycleId = bicycleId;
	}

	public Integer getRepairType() {
		return repairType;
	}

	public void setRepairType(Integer repairType) {
		this.repairType = repairType;
	}

	public String getRepairPart() {
		return repairPart;
	}

	public void setRepairPart(String repairPart) {
		this.repairPart = repairPart;
	}

	public Integer getRepairResult() {
		return repairResult;
	}

	public void setRepairResult(Integer repairResult) {
		this.repairResult = repairResult;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public String getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(String repairDate) {
		this.repairDate = repairDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOperatorTime() {
		return operatorTime;
	}

	public void setOperatorTime(String operatorTime) {
		this.operatorTime = operatorTime;
	}

}
