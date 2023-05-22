package com.review.cinema.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ActionForwardVo {
	private boolean redirect;
	private String url;
}
