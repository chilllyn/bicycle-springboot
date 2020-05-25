package com.aowin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @author 83998
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Syuser {
	private Integer userId;
	private Integer roleId;
	@NotEmpty
	private String loginName;
	private String username;
	@NotEmpty
	private String password;
	private Integer activeFlag;
	private String zxbj;
	private String officePhone;
	private String mobilePhone;
	private String verificationCode;
	private String email;

}
