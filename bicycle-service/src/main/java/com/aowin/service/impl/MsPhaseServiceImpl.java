package com.aowin.service.impl;

import com.aowin.constants.PageConfig;
import com.aowin.dao.MsPhaseMapper;
import com.aowin.model.MsPhase;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 83998
 */
@Service
public class MsPhaseServiceImpl {

	@Resource
	MsPhaseMapper msPhaseMapper;

	/**
	 * 分页查询
	 * @param pageNum
	 * @param msPhase
	 * @return
	 */
	public PageInfo<MsPhase> select(int pageNum, MsPhase msPhase) {
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);
		List<MsPhase> phases = msPhaseMapper.select(msPhase);

		return new PageInfo<MsPhase>(phases);
	}

	/**
	 * @Author Chill_Lyn
	 * @Description 新增权限
	 * @Date 2020/5/25 21:24
	 * @Param [msPhase]
	 * @return int
	 **/
	public int insert(MsPhase msPhase) {
		return msPhaseMapper.insert(msPhase);
	}

	/**
	 * 修改权限
	 * @param msPhase
	 * @return
	 */
	public int update(MsPhase msPhase) {
		return msPhaseMapper.update(msPhase);
	}

	/**
	 * 删除权限
	 * @param phaseId
	 * @return
	 */
	public int delete(int phaseId) {
		return msPhaseMapper.delete(phaseId);
	}

	/**
	 * 根据id查询权限
	 * @param phaseId
	 * @return
	 */
	public MsPhase selectById(int phaseId) {
		return msPhaseMapper.selectById(phaseId);
	}
}
