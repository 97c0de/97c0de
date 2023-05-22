package com.review.cinema.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserVo {
	private String id;
	private String password;
	private String name;
	private String gender;
	private String birth;
	private String email;
	private String phone_number;
	private String joindate;
	

}
