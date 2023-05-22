create database jspCinemaReview CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
 
create user `jspCinemaReview`@`%` identified by '1234';
grant all privileges on jspCinemaReview.* to `jspCinemaReview`@`%` ;


create user `jspCinemaReview`@`localhost` identified by '1234';
grant all privileges on jspCinemaReview.* to `jspCinemaReview`@`localhost` ;
			

	