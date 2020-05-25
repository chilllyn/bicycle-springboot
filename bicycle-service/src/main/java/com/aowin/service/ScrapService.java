package com.aowin.service;

import com.aowin.model.RepairRecord;
import com.github.pagehelper.PageInfo;

/**
 * @author 83998
 */
public interface ScrapService {

	/**
	 * 报废登记
	 * @param repairRecord
	 */
	void scrap(RepairRecord repairRecord);

	/**
	 * 报废车辆分页查询
	 * @Author Chill_Lyn
	 * @Date 2020/5/25 21:30
	 * @Param [pageNum, repairRecord]
	 * @return com.github.pagehelper.PageInfo<com.aowin.model.RepairRecord>
	 **/
	PageInfo<RepairRecord> listScrapBicycle(Integer pageNum, RepairRecord repairRecord);
}
