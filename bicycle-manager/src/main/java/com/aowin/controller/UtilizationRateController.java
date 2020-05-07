package com.aowin.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.model.BicycleStation;
import com.aowin.model.UtilizationRate;
import com.aowin.service.UtilizationRateService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/main/utilizationRate")
public class UtilizationRateController {

	private Logger logger = Logger.getLogger(UtilizationRateController.class);

	@Autowired
	private UtilizationRateService UtilizationRateServiceImpl;

	@RequestMapping("/detail")
	public UtilizationRate detail(UtilizationRate utilizationRate) {
		return UtilizationRateServiceImpl.detail(utilizationRate);
	}

	/**
	 * 车点列表
	 * @param pageNum
	 * @param bicycleStation
	 * @return
	 */
	@RequestMapping("/listStation")
	public PageInfo<BicycleStation> listStation(@RequestParam(defaultValue = "1") Integer pageNum,
	        BicycleStation bicycleStation) {
		return UtilizationRateServiceImpl.listStation(pageNum, bicycleStation);
	}
}
