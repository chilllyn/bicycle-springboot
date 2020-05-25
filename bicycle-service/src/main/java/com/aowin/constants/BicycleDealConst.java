package com.aowin.constants;

/**
 * @author 83998
 */
public interface BicycleDealConst {

	/**
	 * 租出
	 */
	int DEAL_TYPE_BORROW = 2;
	String DEAL_NAME_BORROW = "租出";
	/**
	 * 还入
	 */
	int DEAL_TYPE_RETURN = 3;
	String DEAL_NAME_RETURN = "还入";
	/**
	 * 调出
	 */
	int DEAL_TYPE_FROM = 4;
	String DEAL_NAME_FROM = "调出";
	/**
	 * 调入
	 */
	int DEAL_TYPE_TO = 5;
	String DEAL_NAME_TO = "调入";
	/**
	 * 维修调出
	 */
	int DEAL_TYPE_REPAIR_FROM = 6;
	String DEAL_NAME_REPAIR_FROM = "维修调出";
	/**
	 * 维修调入
	 */
	int DEAL_TYPE_REPAIR_TO = 7;
	String DEAL_NAME_REPAIR_TO = "维修调入";
	/**
	 * 维修
	 */
	int DEAL_TYPE_REPAIR = 8;
	String DEAL_NAME_REPAIR = "维修";
	/**
	 * 报废
	 */
	int DEAL_TYPE_SCRAP = 9;
	String DEAL_NAME_SCRAP = "报废";

	/**
	 * 是否发生费用
	 */
	int IS_FEE_YES = 1;
	int IS_FEE_NO = 0;

	/**
	 * 费用类型，收入、支出
	 */
	int FEE_TYPE_IN = 1;
	int FEE_TYPE_OUT = 2;
}
