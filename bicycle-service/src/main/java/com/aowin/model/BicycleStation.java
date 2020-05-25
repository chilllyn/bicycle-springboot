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
public class BicycleStation {
	private Integer stationId;
	private String stationCode;
	private String stationName;
	private Integer bicyclePileNum;
	private String address;

}
