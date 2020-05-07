package com.aowin.model;

public class BicycleDeal {

	private String createTime;
	private String dealName;
	private Integer dealType;
	private Integer recordId;
	private Integer cardId;
	private Integer isFee;
	private Double chgMoney;
	private Integer feeType;
	private Integer bicycleId;
	private Integer pileId;
	private Integer userId;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public Integer getDealType() {
		return dealType;
	}

	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Integer getIsFee() {
		return isFee;
	}

	public void setIsFee(Integer isFee) {
		this.isFee = isFee;
	}

	public double getChgMoney() {
		return chgMoney;
	}

	public void setChgMoney(double chgMoney) {
		this.chgMoney = chgMoney;
	}

	public Integer getFeeType() {
		return feeType;
	}

	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}

	public Integer getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(Integer bicycleId) {
		this.bicycleId = bicycleId;
	}

	public Integer getPileId() {
		return pileId;
	}

	public void setPileId(Integer pileId) {
		this.pileId = pileId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
