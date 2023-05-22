package com.review.cinema.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QnaVo {
	private int qna_no;
	private String id;
	private String qna_title;
	private String qna_content;
	private String qna_update_date;
	private int qna_comment_no;
	private String qna_comment_content;

}
