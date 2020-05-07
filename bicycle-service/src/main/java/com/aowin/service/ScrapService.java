package com.aowin.service;

import com.aowin.model.RepairRecord;
import com.github.pagehelper.PageInfo;

public interface ScrapService {

	/**
	 * 报废登记
	 * @param repairRecord
	 */
	void scrap(RepairRecord repairRecord);

	/**
	 * 报废车辆分页查询
	 * @param pageNum
	 * @param bicycleInfo
	 * @return
	 */
	PageInfo<RepairRecord> listScrapBicycle(Integer pageNum, RepairRecord repairRecord);
}
