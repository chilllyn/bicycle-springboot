package com.aowin.model;

public class BicycleInfo {

	private Integer bicycleId;
	private Integer status;
	private Integer pileId;
	private Integer cardId;
	private String destroyDate;
	private String bicycleCode;
	private String operatorTime;
	private Integer userId;
	private String remark;

	public String getDestroyDate() {
		return destroyDate;
	}

	public void setDestroyDate(String destroyDate) {
		this.destroyDate = destroyDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBicycleCode() {
		return bicycleCode;
	}

	public void setBicycleCode(String bicycleCode) {
		this.bicycleCode = bicycleCode;
	}

	public String getOperatorTime() {
		return operatorTime;
	}

	public void setOperatorTime(String operatorTime) {
		this.operatorTime = operatorTime;
	}

	public Integer getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(Integer bicycleId) {
		this.bicycleId = bicycleId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPileId() {
		return pileId;
	}

	public void setPileId(Integer pileId) {
		this.pileId = pileId;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

}
