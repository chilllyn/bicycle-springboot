package com.aowin.dao;

import java.util.List;

import com.aowin.model.BicycleInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BicycleInfoMapper {

	/**
	 * 查询自行车（车辆编号，操作时间，状态）
	 * @param bicycleInfo
	 * @return
	 */
	List<BicycleInfo> listBicycle(BicycleInfo bicycleInfo);

	/**
	 * 调出更新自行车信息
	 * @param bicycleInfo
	 * @param beforeStatus
	 * @param afterStatus
	 * @return
	 */
	int updateFrom(BicycleInfo bicycleInfo, int beforeStatus, int afterStatus);

	/**
	 * 调入更新自行车信息
	 * @param bicycleInfo
	 * @param beforeStatus
	 * @param afterStatus
	 * @return
	 */
	int updateTo(BicycleInfo bicycleInfo, int beforeStatus, int afterStatus);

	/**
	 * 维修/报废更新信息
	 * @param bicycleInfo
	 * @param beforeStatus
	 * @param afterStatus
	 * @return
	 */
	int updateRepair(BicycleInfo bicycleInfo, int beforeStatus, int afterStatus);
}
