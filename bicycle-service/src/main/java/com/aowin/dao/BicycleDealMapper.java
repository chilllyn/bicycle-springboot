package com.aowin.dao;

import com.aowin.model.BicycleDeal;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 83998
 */
@Mapper
public interface BicycleDealMapper {

	/**
	 * 获取某车点某项业务的日均数
	 * @param stationId
	 * @param dealType
	 * @return
	 */
	Double getAvg(Integer stationId, Integer dealType);

	/**
	 * 插入业务流水
	 * @param bicycleDeal
	 * @return
	 */
	int insert(BicycleDeal bicycleDeal);
}
