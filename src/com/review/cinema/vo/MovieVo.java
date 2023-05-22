package com.review.cinema.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MovieVo {
	private String category;
	private int no;
	private String title;
	private String id;
	private String content;
	private String upload_date;
	private int read_count;
	private int comment_count;
	private String genre;
	private String actor;
	private String trailer;
	private int price;
	private String director;
	private String opening_year;
	private String opening_month;
	private String running_time;
	private String filename1;
	private int comment_no;
	private String comment_content;
	private int read_no;
	private String read_id;
	private String screening_end;
	
	
	public String getGenerKor(String genre) {
		if(genre.equals("romance")) return "로맨스";
		else if(genre.equals("fantasy"))return "공상";
		else if(genre.equals("thriller"))return "스릴러";
		else if(genre.equals("comedy"))return "코메디";
		else if(genre.equals("sf"))return "SF";
		else if(genre.equals("fear"))return "공포";
		else if(genre.equals("mystery"))return "미스테리";
		else if(genre.equals("documentary"))return "다큐멘터리";
		else if(genre.equals("animatedmovie"))return "애니메이션";
		else return "기타";
	}
	
	
	
}
