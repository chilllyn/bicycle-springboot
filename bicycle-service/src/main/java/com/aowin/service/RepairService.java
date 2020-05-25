package com.aowin.service;

import com.aowin.model.BicycleDeploy;
import com.aowin.model.BicycleInfo;
import com.aowin.model.BicyclePile;
import com.aowin.model.BicycleStation;
import com.github.pagehelper.PageInfo;

/**
 * @author 83998
 */
public interface RepairService {

	/**
	 * 维修调入
	 * @param bicycleDeploy
	 */
	void to(BicycleDeploy bicycleDeploy);

	/**
	 * 维修调出
	 * @param bicycleDeploy
	 */
	void from(BicycleDeploy bicycleDeploy);

	/**
	 * 车点分页查询
	 * @param pageNum
	 * @param bicycleStation
	 * @return
	 */
	PageInfo<BicycleStation> listStation(Integer pageNum, BicycleStation bicycleStation);

	/**
	 * 车桩分页查询
	 * @param pageNum
	 * @param stationId
	 * @return
	 */
	PageInfo<BicyclePile> listPile(Integer pageNum, Integer stationId);

	/**
	 * 车辆分页查询
	 * @param pageNum
	 * @param bicycleInfo
	 * @return
	 */
	PageInfo<BicycleInfo> listBicycle(Integer pageNum, BicycleInfo bicycleInfo);
}
