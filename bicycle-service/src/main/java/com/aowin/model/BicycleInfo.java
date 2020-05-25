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

}
