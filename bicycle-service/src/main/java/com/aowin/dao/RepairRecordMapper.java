package com.aowin.dao;

import java.util.List;

import com.aowin.model.RepairRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RepairRecordMapper {

	/**
	 * 查询报废车辆
	 * @param bicycleInfo
	 * @return
	 */
	List<RepairRecord> listScrapBicycle(RepairRecord repairRecord, int status);

	/**
	 * 新增维修记录
	 * @param repairRecord
	 * @return
	 */
	int insert(RepairRecord repairRecord);
}
