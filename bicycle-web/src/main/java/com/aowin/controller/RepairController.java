package com.aowin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.exception.ServiceException;
import com.aowin.model.BicycleDeploy;
import com.aowin.model.BicycleInfo;
import com.aowin.model.BicyclePile;
import com.aowin.model.BicycleStation;
import com.aowin.service.RepairService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/repair")
public class RepairController {

	@Autowired
	private RepairService repairServiceImpl;

	@RequestMapping(value = "/to", produces = { "text/html;charset=UTF-8;",
	        "application/json;charset=UTF-8;" }, method = { RequestMethod.POST })
	public String to(BicycleDeploy bicycleDeploy) {
		try {
			repairServiceImpl.to(bicycleDeploy);
			return "success";
		} catch (ServiceException e) {
			return e.getMessage();
		} catch (Exception e) {
			return "服务端 异常";
		}
	}

	@RequestMapping(value = "/from", produces = { "text/html;charset=UTF-8;",
	        "application/json;charset=UTF-8;" }, method = { RequestMethod.POST })
	public String from(BicycleDeploy bicycleDeploy) {
		try {
			repairServiceImpl.from(bicycleDeploy);
			return "success";
		} catch (ServiceException e) {
			return e.getMessage();
		} catch (Exception e) {
			return "服务端 异常";
		}
	}

	@RequestMapping("/listStation")
	public PageInfo<BicycleStation> listStation(@RequestParam(defaultValue = "1") Integer pageNum,
	        BicycleStation bicycleStation) {
		return repairServiceImpl.listStation(pageNum, bicycleStation);
	}

	@RequestMapping("/listPile")
	public PageInfo<BicyclePile> listPile(@RequestParam(defaultValue = "1") Integer pageNum, Integer stationId) {
		return repairServiceImpl.listPile(pageNum, stationId);
	}

	@RequestMapping("/listBicycle")
	public PageInfo<BicycleInfo> listBicycle(@RequestParam(defaultValue = "1") Integer pageNum,
	        BicycleInfo bicycleInfo) {
		return repairServiceImpl.listBicycle(pageNum, bicycleInfo);
	}
	
}
