package com.aowin.service.impl;

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
import com.aowin.service.RepairRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 83998
 */
@Service
public class RepairRecordServiceImpl implements RepairRecordService {

	@Resource
	BicycleInfoMapper bicycleInfoMapper;
	@Resource
	RepairRecordMapper repairRecordMapper;
	@Resource
	BicycleDealMapper bicycleDealMapper;

	/**
	 * 查询维修调出的自行车
	 */
	@Override
	public PageInfo<BicycleInfo> listBicycle(Integer pageNum, BicycleInfo bicycleInfo) {
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);
		List<BicycleInfo> bicycleInfoList = bicycleInfoMapper.listBicycle(bicycleInfo);
		return new PageInfo<BicycleInfo>(bicycleInfoList);
	}

	/**
	 * 维修记录
	 */
	@Override
	@Transactional(rollbackFor = {})
	public void repairRecord(RepairRecord repairRecord) {
		BicycleInfo bicycleInfo = new BicycleInfo();
		bicycleInfo.setBicycleId(repairRecord.getBicycleId());
		bicycleInfo.setUserId(repairRecord.getUserId());
		//更改车辆状态
		int result = bicycleInfoMapper.updateRepair(bicycleInfo, BicycleInfoConst.STATUS_REPAIR_FROM,
		        repairRecord.getRepairResult() == 1 ? BicycleInfoConst.STATUS_REPAIR_SUCCESS
		                : BicycleInfoConst.STATUS_REPAIR_FAILURE);
		if (result != 1) {
			throw new ServiceException("车辆状态更新错误！");
		}
		//新增维修明细
		result = repairRecordMapper.insert(repairRecord);
		if (result != 1) {
			throw new ServiceException("维修明细新增错误！");
		}
		//新增车辆业务流水
		BicycleDeal bicycleDeal = new BicycleDeal();
		bicycleDeal.setBicycleId(repairRecord.getBicycleId());
		bicycleDeal.setChgMoney(repairRecord.getFee());
		bicycleDeal.setDealName(BicycleDealConst.DEAL_NAME_REPAIR);
		bicycleDeal.setDealType(BicycleDealConst.DEAL_TYPE_REPAIR);
		bicycleDeal.setFeeType(BicycleDealConst.FEE_TYPE_OUT);
		bicycleDeal.setIsFee(BicycleDealConst.IS_FEE_YES);
		bicycleDeal.setRecordId(repairRecord.getRecordId());
		bicycleDeal.setUserId(repairRecord.getUserId());
		result = bicycleDealMapper.insert(bicycleDeal);
		if (result != 1) {
			throw new ServiceException("车辆业务流水明细新增错误！");
		}
	}
}
