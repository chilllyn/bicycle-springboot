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
public class UtilizationRate {

	private Integer stationId;
	private String stationCode;
	private String stationName;
	private Integer bicyclePileNum;

	private Double avgBorrow;
	private Double avgReturn;
	private Double avgFrom;
	private Double avgTo;
	private Double avgRepairFrom;
	private Double avgRepairTo;

}
