package com.aowin.service.impl;

import com.aowin.constants.BicycleDealConst;
import com.aowin.constants.BicycleInfoConst;
import com.aowin.constants.BicyclePileConst;
import com.aowin.constants.PageConfig;
import com.aowin.dao.*;
import com.aowin.exception.ServiceException;
import com.aowin.model.*;
import com.aowin.service.RepairService;
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
public class RepairServiceImpl implements RepairService {

	@Resource
	BicycleStationMapper bicycleStationMapper;
	@Resource
	BicyclePileMapper bicyclePileMapper;
	@Resource
	BicycleInfoMapper bicycleInfoMapper;
	@Resource
	BicycleDeployMapper bicycleDeployMapper;
	@Resource
	BicycleDealMapper bicycleDealMapper;

	/**
	 * 维修调入
	 */
	@Transactional(rollbackFor = {})
	@Override
	public void to(BicycleDeploy bicycleDeploy) {
		//修改车辆状态（7：维修成功）为（3：在桩）。
		BicycleInfo bicycleInfo = new BicycleInfo();
		bicycleInfo.setBicycleId(bicycleDeploy.getBicycleId());
		bicycleInfo.setCardId(bicycleDeploy.getToCardId());
		bicycleInfo.setPileId(bicycleDeploy.getToPileId());
		int result = bicycleInfoMapper.updateTo(bicycleInfo, BicycleInfoConst.STATUS_REPAIR_SUCCESS,
		        BicycleInfoConst.STATUS_AT);
		if (result != 1) {
			throw new ServiceException("车辆状态异常！");
		}
		//将调入车桩的状态改成（1：有车），存车辆id。
		BicyclePile bicyclePile = new BicyclePile();
		bicyclePile.setBicycleId(bicycleDeploy.getBicycleId());
		bicyclePile.setPileId(bicycleDeploy.getToPileId());
		result = bicyclePileMapper.updateTo(bicyclePile, BicyclePileConst.STATUS_NO_BIKE, BicyclePileConst.STATUS_BIKE);
		if (result != 1) {
			throw new ServiceException("车桩状态异常！");
		}
		//填写车辆调入信息。填写调入车桩，调入日期，调入人，调入原因为（7：维修调入）
		bicycleDeploy.setToReason(BicycleDealConst.DEAL_TYPE_REPAIR_TO);
		result = bicycleDeployMapper.insertTo(bicycleDeploy);
		if (result != 1) {
			throw new ServiceException("车辆调配明细异常！");
		}
		//写车辆业务流水，业务类型为（7：维修调入）关联的业务记录id填写车辆调配明细记录id，
		//业务名称填写（维修调入）是否发生费用为（0：未发生）费用金额填写0。
		BicycleDeal bicycleDeal = new BicycleDeal();
		bicycleDeal.setBicycleId(bicycleDeploy.getBicycleId());
		bicycleDeal.setCardId(bicycleDeploy.getToCardId());
		bicycleDeal.setChgMoney(0.0);
		bicycleDeal.setDealName(BicycleDealConst.DEAL_NAME_REPAIR_TO);
		bicycleDeal.setDealType(BicycleDealConst.DEAL_TYPE_REPAIR_TO);
		bicycleDeal.setIsFee(BicycleDealConst.IS_FEE_NO);
		bicycleDeal.setPileId(bicycleDeploy.getToPileId());
		bicycleDeal.setRecordId(bicycleDeploy.getDeployId());
		result = bicycleDealMapper.insert(bicycleDeal);
		if (result != 1) {
			throw new ServiceException("车辆业务流水异常！");
		}
	}

	/**
	 * 维修调出
	 */
	@Override
	@Transactional(rollbackFor = {})
	public void from(BicycleDeploy bicycleDeploy) {
		//将被选中的车辆的车辆状态改成（5：维修调出），将所在车桩的id清空。
		BicycleInfo bicycleInfo = new BicycleInfo();
		bicycleInfo.setBicycleId(bicycleDeploy.getBicycleId());
		bicycleInfo.setCardId(bicycleDeploy.getFromCardId());
		bicycleInfo.setPileId(bicycleDeploy.getFromPileId());
		int result = bicycleInfoMapper.updateFrom(bicycleInfo, BicycleInfoConst.STATUS_AT,
		        BicycleInfoConst.STATUS_REPAIR_FROM);
		if (result != 1) {
			throw new ServiceException("车辆状态异常！");
		}
		//将所设车桩的状态改成（2：无车），将所存车辆id清空。
		BicyclePile bicyclePile = new BicyclePile();
		bicyclePile.setBicycleId(bicycleDeploy.getBicycleId());
		bicyclePile.setPileId(bicycleDeploy.getFromPileId());
		result = bicyclePileMapper.updateFrom(bicyclePile, BicyclePileConst.STATUS_BIKE,
		        BicyclePileConst.STATUS_NO_BIKE);
		if (result != 1) {
			throw new ServiceException("车桩状态异常！");
		}
		//记录车辆调配明细，记录车辆id，调出车桩id，调出卡号等信息，调出原因填写（6：维修调出）。
		bicycleDeploy.setFromReason(BicycleDealConst.DEAL_TYPE_REPAIR_FROM);
		result = bicycleDeployMapper.insertFrom(bicycleDeploy);
		if (result != 1) {
			throw new ServiceException("车辆调配明细异常！");
		}
		//6．记录车辆业务流水，业务类型为（6：维修调出），关联的业务记录id填写车辆调配明细id，业务名称填写(维修调出)，是否发生费用为（0：未发生），费用金额填0。
		BicycleDeal bicycleDeal = new BicycleDeal();
		bicycleDeal.setBicycleId(bicycleDeploy.getBicycleId());
		bicycleDeal.setCardId(bicycleDeploy.getFromCardId());
		bicycleDeal.setChgMoney(0.0);
		bicycleDeal.setDealName(BicycleDealConst.DEAL_NAME_REPAIR_FROM);
		bicycleDeal.setDealType(BicycleDealConst.DEAL_TYPE_REPAIR_FROM);
		bicycleDeal.setIsFee(BicycleDealConst.IS_FEE_NO);
		bicycleDeal.setPileId(bicycleDeploy.getFromPileId());
		bicycleDeal.setRecordId(bicycleDeploy.getDeployId());
		result = bicycleDealMapper.insert(bicycleDeal);
		if (result != 1) {
			throw new ServiceException("车辆业务流水异常！");
		}
	}

	/**
	 * 车点分页查询
	 */
	@Override
	public PageInfo<BicycleStation> listStation(Integer pageNum, BicycleStation bicycleStation) {
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);
		List<BicycleStation> bicycleStationList = bicycleStationMapper.listStation(bicycleStation);
		return new PageInfo<BicycleStation>(bicycleStationList);
	}

	/**
	 * 车桩分页查询
	 */
	@Override
	public PageInfo<BicyclePile> listPile(Integer pageNum, Integer stationId) {
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);
		List<BicyclePile> bicyclePileList = bicyclePileMapper.listPile(stationId);
		return new PageInfo<BicyclePile>(bicyclePileList);
	}

	/**
	 * 车辆分页查询
	 */
	@Override
	public PageInfo<BicycleInfo> listBicycle(Integer pageNum, BicycleInfo bicycleInfo) {
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);
		bicycleInfo.setStatus(BicycleInfoConst.STATUS_REPAIR_SUCCESS);
		List<BicycleInfo> bicycleInfoList = bicycleInfoMapper.listBicycle(bicycleInfo);
		return new PageInfo<BicycleInfo>(bicycleInfoList);
	}

}
