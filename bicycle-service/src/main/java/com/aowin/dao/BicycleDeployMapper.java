package com.aowin.dao;

import com.aowin.model.BicycleDeploy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 83998
 */
@Mapper
public interface BicycleDeployMapper {

	/**
	 * @Author Chill_Lyn
	 * @Description 增加调出明细
	 * @Date 2020/5/25 21:03
	 * @Param [bicycleDeploy]
	 * @return int
	 **/
	int insertFrom(BicycleDeploy bicycleDeploy);

	/**
	 * 增加调入明细
	 * @param bicycleDeploy
	 * @return
	 */
	int insertTo(BicycleDeploy bicycleDeploy);
}
