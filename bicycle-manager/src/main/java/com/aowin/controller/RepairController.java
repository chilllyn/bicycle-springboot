package com.aowin.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.constants.BicycleInfoConst;
import com.aowin.exception.ServiceException;
import com.aowin.model.BicycleInfo;
import com.aowin.model.RepairRecord;
import com.aowin.model.Syuser;
import com.aowin.service.RepairRecordService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/main/repair")
public class RepairController {

	private Logger logger = Logger.getLogger(RepairController.class);

	@Autowired
	public RepairRecordService repairRecordServiceImpl;

	@RequestMapping("/listBicycle")
	public PageInfo<BicycleInfo> listBicycle(@RequestParam(defaultValue = "1") Integer pageNum,
	        BicycleInfo bicycleInfo) {
		bicycleInfo.setStatus(BicycleInfoConst.STATUS_REPAIR_FROM);
		return repairRecordServiceImpl.listBicycle(pageNum, bicycleInfo);
	}

	@RequestMapping(value = "/repairRecord", produces = { "text/html;charset=UTF-8;",
	        "application/json;charset=UTF-8;" }, method = { RequestMethod.POST })
	public String repairRecord(@Validated RepairRecord repairRecord, BindingResult br, HttpSession session) {
		if (br.hasErrors()) {
			System.out.println(br.hasErrors());
			return "数据输入错误!";
		}
		try {
			Syuser syuser = (Syuser) session.getAttribute("syuser");
			repairRecord.setUserId(syuser.getUserId());
			repairRecord.setRepairer(syuser.getUsername());
			repairRecordServiceImpl.repairRecord(repairRecord);
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