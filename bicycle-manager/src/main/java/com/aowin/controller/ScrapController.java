package com.aowin.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.constants.RepairRecordConst;
import com.aowin.exception.ServiceException;
import com.aowin.model.RepairRecord;
import com.aowin.model.Syuser;
import com.aowin.service.ScrapService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/main/scrap")
public class ScrapController {

	private Logger logger = Logger.getLogger(ScrapController.class);

	@Autowired
	public ScrapService scrapServiceImpl;

	@RequestMapping("/listScrapBicycle")
	public PageInfo<RepairRecord> listScrapBicycle(@RequestParam(defaultValue = "1") Integer pageNum,
	        RepairRecord repairRecord) {
		repairRecord.setRepairResult(RepairRecordConst.REPAIR_RESULT_FAILURE);
		return scrapServiceImpl.listScrapBicycle(pageNum, repairRecord);
	}

	@RequestMapping(value = "/scrap", produces = { "text/html;charset=UTF-8;",
	        "application/json;charset=UTF-8;" }, method = { RequestMethod.POST })
	public String scrap(RepairRecord repairRecord, HttpSession session) {
		try {
			Syuser syuser = (Syuser) session.getAttribute("syuser");
			repairRecord.setUserId(syuser.getUserId());
			scrapServiceImpl.scrap(repairRecord);
			return "success";
		} catch (ServiceException e) {
			return e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("服务端异常", e);
			return "服务端异常，请重新登录";
		}
	}
}
