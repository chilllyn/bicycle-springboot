package com.aowin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author 83998
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
