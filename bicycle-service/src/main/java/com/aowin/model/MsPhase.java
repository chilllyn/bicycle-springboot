package com.aowin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


/**
 * @author 83998
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsPhase {

	private Integer phaseId;
	
	/**
	 * url 以/开头的只能有字母数字组成 最大长度200
	 */
	@Pattern(regexp = "/[a-zA-Z\\d]{1,199}")
	@NotEmpty
	private String url;
	
	/**
	 * 描述 中文汉字 最多50个字符
	 */
	@Pattern(regexp = "[\u4e00-\u9fa5]{1,50}")
	@NotEmpty
	private String description;

}
