package com.aowin.dao;

import com.aowin.model.RepairRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 83998
 */
@Mapper
public interface RepairRecordMapper {

	/**
	 * @Author Chill_Lyn
	 * @Description 查询报废车辆
	 * @Date 2020/5/25 21:04
	 * @Param [repairRecord, status]
	 * @return List<RepairRecord>
	 **/
	List<RepairRecord> listScrapBicycle(RepairRecord repairRecord, int status);

	/**
	 * 新增维修记录
	 * @param repairRecord
	 * @return
	 */
	int insert(RepairRecord repairRecord);
}
