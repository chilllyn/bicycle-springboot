package com.aowin.service.impl;

import com.aowin.constants.BicycleDealConst;
import com.aowin.constants.PageConfig;
import com.aowin.dao.BicycleDealMapper;
import com.aowin.dao.BicycleStationMapper;
import com.aowin.model.BicycleStation;
import com.aowin.model.UtilizationRate;
import com.aowin.service.UtilizationRateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 83998
 */
@Service
public class UtilizationRateServiceImpl implements UtilizationRateService {

	@Resource
	BicycleStationMapper bicycleStationMapper;
	@Resource
	BicycleDealMapper bicycleDealMapper;

	/**
	 * 车点列表
	 */
	@Override
	public PageInfo<BicycleStation> listStation(Integer pageNum, BicycleStation bicycleStation) {
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);
		List<BicycleStation> bicycleStationList = bicycleStationMapper.listStation(bicycleStation);
		return new PageInfo<BicycleStation>(bicycleStationList);
	}

	/**
	 * 详情
	 */
	@Override
	public UtilizationRate detail(UtilizationRate utilizationRate) {
		Integer stationId = utilizationRate.getStationId();
		utilizationRate.setAvgBorrow(bicycleDealMapper.getAvg(stationId, BicycleDealConst.DEAL_TYPE_BORROW));
		utilizationRate.setAvgReturn(bicycleDealMapper.getAvg(stationId, BicycleDealConst.DEAL_TYPE_RETURN));
		utilizationRate.setAvgFrom(bicycleDealMapper.getAvg(stationId, BicycleDealConst.DEAL_TYPE_FROM));
		utilizationRate.setAvgTo(bicycleDealMapper.getAvg(stationId, BicycleDealConst.DEAL_TYPE_TO));
		utilizationRate.setAvgRepairFrom(bicycleDealMapper.getAvg(stationId, BicycleDealConst.DEAL_TYPE_REPAIR_FROM));
		utilizationRate.setAvgRepairTo(bicycleDealMapper.getAvg(stationId, BicycleDealConst.DEAL_TYPE_REPAIR_TO));
		return utilizationRate;
	}

}
