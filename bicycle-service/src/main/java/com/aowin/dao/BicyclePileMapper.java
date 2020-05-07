package com.aowin.dao;

import java.util.List;

import com.aowin.model.BicyclePile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BicyclePileMapper {
	/**
	 * 某车点车桩列表
	 * @param stationId
	 * @return
	 */
	List<BicyclePile> listPile(Integer stationId);

	/**
	 * 调出更新
	 * @param bicycleDeploy
	 * @param beforeStatus
	 * @param afterStatus
	 * @return
	 */
	int updateFrom(BicyclePile bicyclePile, int beforeStatus, int afterStatus);

	/**
	 * 调入更新
	 * @param bicyclePile
	 * @param beforeStatus
	 * @param afterStatus
	 * @return
	 */
	int updateTo(BicyclePile bicyclePile, int beforeStatus, int afterStatus);
}
