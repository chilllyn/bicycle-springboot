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
public class BicycleDeploy {

	private Integer deployId;
	private Integer bicycleId;
	private Integer fromPileId;
	private Integer toPileId;
	private Integer fromCardId;
	private Integer toCardId;
	private Integer fromReason;
	private Integer toReason;

}
