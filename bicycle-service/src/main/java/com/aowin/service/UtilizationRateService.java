package com.aowin.service;

import com.aowin.model.BicycleStation;
import com.aowin.model.UtilizationRate;
import com.github.pagehelper.PageInfo;

public interface UtilizationRateService {

	/**
	 * 详情
	 * @param utilizationRate
	 * @return
	 */
	UtilizationRate detail(UtilizationRate utilizationRate);

	/**
	 * 车点分页查询
	 * @param pageNum
	 * @param bicycleStation
	 * @return
	 */
	PageInfo<BicycleStation> listStation(Integer pageNum, BicycleStation bicycleStation);
}
