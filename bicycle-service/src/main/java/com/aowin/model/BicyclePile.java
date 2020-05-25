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
public class BicyclePile {

	private Integer pileId;
	private String pileCode;
	private Integer bicycleId;
	private String bicycleCode;

}
