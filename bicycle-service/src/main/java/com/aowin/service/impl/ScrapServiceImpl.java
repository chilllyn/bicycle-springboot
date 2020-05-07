package com.aowin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.constants.BicycleDealConst;
import com.aowin.constants.BicycleInfoConst;
import com.aowin.constants.PageConfig;
import com.aowin.dao.BicycleDealMapper;
import com.aowin.dao.BicycleInfoMapper;
import com.aowin.dao.RepairRecordMapper;
import com.aowin.exception.ServiceException;
import com.aowin.model.BicycleDeal;
import com.aowin.model.BicycleInfo;
import com.aowin.model.RepairRecord;
import com.aowin.service.ScrapService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ScrapServiceImpl implements ScrapService {

	@Autowired
	BicycleInfoMapper bicycleInfoMapper;
	@Autowired
	BicycleDealMapper bicycleDealMapepr;
	@Autowired
	RepairRecordMapper repairRecordMapper;

	@Transactional
	@Override
	public void scrap(RepairRecord repairRecord) {
		//修改车辆状态为（6：报废）
		BicycleInfo bicycleInfo = new BicycleInfo();
		bicycleInfo.setBicycleId(repairRecord.getBicycleId());
		int result = bicycleInfoMapper.updateRepair(bicycleInfo, BicycleInfoConst.STATUS_REPAIR_FAILURE,
		        BicycleInfoConst.STATUS_SCRAP);
		if (result != 1) {
			throw new ServiceException("车辆状态更新错误！");
		}
		//填写车辆业务流水，业务类型为（9：报废）关联的业务记录id填写车辆维修信息id，
		//业务名称填写（报废）是否发生费用为（0：未发生）费用金额填写0
		BicycleDeal bicycleDeal = new BicycleDeal();
		bicycleDeal.setBicycleId(repairRecord.getBicycleId());
		bicycleDeal.setChgMoney(0);
		bicycleDeal.setDealName(BicycleDealConst.DEAL_NAME_SCRAP);
		bicycleDeal.setDealType(BicycleDealConst.DEAL_TYPE_SCRAP);
		bicycleDeal.setIsFee(BicycleDealConst.IS_FEE_NO);
		bicycleDeal.setRecordId(repairRecord.getRecordId());
		bicycleDeal.setUserId(repairRecord.getUserId());
		result = bicycleDealMapepr.insert(bicycleDeal);
		if (result != 1) {
			throw new ServiceException("车辆业务流水增加错误！");
		}
	}

	/**
	 * 查询报废的自行车
	 */
	@Override
	public PageInfo<RepairRecord> listScrapBicycle(Integer pageNum, RepairRecord repairRecord) {
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);
		List<RepairRecord> repairRecordList = repairRecordMapper.listScrapBicycle(repairRecord,
		        BicycleInfoConst.STATUS_REPAIR_FAILURE);
		return new PageInfo<RepairRecord>(repairRecordList);
	}
}
