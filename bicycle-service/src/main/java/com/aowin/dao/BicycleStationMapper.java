package com.aowin.dao;

import com.aowin.model.BicycleStation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 83998
 */
@Mapper
public interface BicycleStationMapper {

	/**
	 * 查询车点
	 * @param bicycleStation
	 * @return
	 */
	List<BicycleStation> listStation(BicycleStation bicycleStation);
}
