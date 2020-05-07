package com.aowin.dao;

import java.util.List;

import com.aowin.model.BicycleStation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BicycleStationMapper {

	/**
	 * 查询车点
	 * @param bicycleStation
	 * @return
	 */
	List<BicycleStation> listStation(BicycleStation bicycleStation);
}
