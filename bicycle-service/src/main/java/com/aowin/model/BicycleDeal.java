package com.aowin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 83998
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
