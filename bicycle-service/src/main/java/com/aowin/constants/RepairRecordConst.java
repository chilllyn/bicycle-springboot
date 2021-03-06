package com.aowin.constants;

/**
 * @author 83998
 */
public interface RepairRecordConst {

	/**
	 * 普修
	 */
	int REPAIR_TYPE_NORMAL = 1;
	/**
	 * 更换零件
	 */
	int REPAIR_TYPE_REPLACE = 2;
	/**
	 * 普修+更换零件
	 */
	int REPAIR_TYPE_BOTH = 3;

	/**
	 * 维修结果
	 */
	int REPAIR_RESULT_SUCCESS = 1;
	int REPAIR_RESULT_FAILURE = 2;
}
