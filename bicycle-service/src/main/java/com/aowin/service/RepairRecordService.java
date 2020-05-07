package com.aowin.service;

import com.aowin.model.BicycleInfo;
import com.aowin.model.RepairRecord;
import com.github.pagehelper.PageInfo;

public interface RepairRecordService {

	/**
	 * 维修记录
	 * @param repairRecord
	 */
	void repairRecord(RepairRecord repairRecord);

	/**
	 * 车辆分页查询
	 * @param pageNum
	 * @param stationId
	 * @return
	 */
	PageInfo<BicycleInfo> listBicycle(Integer pageNum, BicycleInfo bicycleInfo);

}
