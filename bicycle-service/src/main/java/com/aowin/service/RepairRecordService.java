package com.aowin.service;

import com.aowin.model.BicycleInfo;
import com.aowin.model.RepairRecord;
import com.github.pagehelper.PageInfo;

/**
 * @author 83998
 */
public interface RepairRecordService {

	/**
	 * 维修记录
	 * @param repairRecord
	 */
	void repairRecord(RepairRecord repairRecord);

	/**
	 * 车辆分页查询
	 * @Author Chill_Lyn
	 * @Date 2020/5/25 21:29
	 * @Param [pageNum, bicycleInfo]
	 * @return com.github.pagehelper.PageInfo<com.aowin.model.BicycleInfo>
	 **/
	PageInfo<BicycleInfo> listBicycle(Integer pageNum, BicycleInfo bicycleInfo);

}
