package com.aowin.model;

public class BicycleDeploy {

	private Integer deployId;
	private Integer bicycleId;
	private Integer fromPileId;
	private Integer toPileId;
	private Integer fromCardId;
	private Integer toCardId;
	private Integer fromReason;
	private Integer toReason;

	public Integer getDeployId() {
		return deployId;
	}

	public void setDeployId(Integer deployId) {
		this.deployId = deployId;
	}

	public Integer getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(Integer bicycleId) {
		this.bicycleId = bicycleId;
	}

	public Integer getFromPileId() {
		return fromPileId;
	}

	public void setFromPileId(Integer fromPileId) {
		this.fromPileId = fromPileId;
	}

	public Integer getToPileId() {
		return toPileId;
	}

	public void setToPileId(Integer toPileId) {
		this.toPileId = toPileId;
	}

	public Integer getFromCardId() {
		return fromCardId;
	}

	public void setFromCardId(Integer fromCardId) {
		this.fromCardId = fromCardId;
	}

	public Integer getToCardId() {
		return toCardId;
	}

	public void setToCardId(Integer toCardId) {
		this.toCardId = toCardId;
	}

	public Integer getFromReason() {
		return fromReason;
	}

	public void setFromReason(Integer fromReason) {
		this.fromReason = fromReason;
	}

	public Integer getToReason() {
		return toReason;
	}

	public void setToReason(Integer toReason) {
		this.toReason = toReason;
	}
}
