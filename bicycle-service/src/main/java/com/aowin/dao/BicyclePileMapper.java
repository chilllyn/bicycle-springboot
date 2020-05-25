package com.aowin.dao;

import com.aowin.model.BicyclePile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 83998
 */
@Mapper
public interface BicyclePileMapper {
	/**
	 * 某车点车桩列表
	 * @param stationId
	 * @return
	 */
	List<BicyclePile> listPile(Integer stationId);

	/**
	 * @Author Chill_Lyn
	 * @Description 调出更新
	 * @Date 2020/5/25 20:27
	 * @Param [bicyclePile, beforeStatus, afterStatus]
	 * @return int
	 **/

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
