<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@page import="com.review.cinema.util.DBUtil"%>
<%@ page import="com.review.cinema.vo.UserVo"%>
<%@ page import = "javax.servlet.http.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="include/head.jsp" %>
<title>Cinema Review</title>
</head>
<body>


	<div>

	<%@ include file="include/head_menu.jsp" %>
	
	
	<c:if test="${banner eq 'on' }">
		
		<section class="banner" >
				<ul  class="slickSlider" style="border:0;">
					<li>
						<a href="movie_view.bbs?no=18">
							<img src="resources/image/banner_1.png">
							<h3 class="banner_title">슈퍼 마리오 브라더스</h3>
					      	<p class="banner-p">공식 사이트 | 2023년 4월 5일</p>
					      	<div class="banner_description">타단단단단단 ♫ 전 세계를 설레게 할 역대급 슈퍼 어드벤처의 등장전세계! 뉴욕의 평범한 배관공 형제 '마리오'와 '루이지'는 
					      	고장난 배수관으로 위기에 처한 도시를 구하려 하는데...</div>									
						</a>
					</li>
					<li>
						<a href="movie_view.bbs?no=19">
							<img src="resources/image/banner_2.png">
							<h3 class="banner_title">똑똑똑 (Knock at the Cabin)</h3>
							<p class="banner-p">2023년 2월 3일(영국)</p>
							<div class="banner_description">휴가 중인 한 가족이 별장에 무단 침입한 낯선 사람과 마주하게 됩니다.
							'레너드'(데이브 바티스타)와 이방인들이 세상의 종말을 막기 위해 찾아오고,
							그리고 가족 중 한 명을 희생해야 하는...
							</div>
						</a>
					</li>
					<li>
						<a href="movie_view.bbs?no=20">
							<img src="resources/image/banner_3.png">
							<h3 class="banner_title">존 윅: 4</h3>
							<p class="banner-p">(2023) 최종 예고편 – 키아누 리브스, 도니 옌, 빌 스카스가드</p>
							<div class="banner_description">존 윅은 죽음 직전에서 살아나 최고 위원회를 무너뜨릴 방법을 찾습니다. 마침내 우리는 완전한 자유의 희망을 보지만 악랄한 그라몬트 후작과 세계 최강 연합군, 심지어 존 윅의 오랜 친구까지...</div>							
						</a>
					</li>
					<li>
						<a href="movie_view.bbs?no=21">
							<img src="resources/image/banner_4.png">
							<h3 class="banner_title">미이라</h3>
							<p class="banner-p">공식 예고편 - Warner Bros. UK</p>
							<div class="banner_description">고고학자 로드 카나비(Lord Carnaby)가 훔친 왕가의 오래된 반지를 찾기 위해 세 명의 고대 미라가 런던으로 가는 여정을 그린 애니메이션</div>
						</a>
					</li>
					<li><a href="movie_view.bbs?no=17">
						<img src="resources/image/banner_5.png">
						<h3 class="banner_title">65</h3>
						<p class="banner-p">공식 예고편 - 현재 영화관에서만 제공</p>
						<div class="banner_description">우주 비행 중 행성과 치명적인 충돌을 겪은 후 파일럿 Mills와 탑승한 유일한 생존자 Koa는 공룡 시대 6,500만 년 전 지구에 불시착합니다. 모든 것은 위험과 죽음에 닿아 있습니다...</div>						
						</a>
					</li>
					
				</ul>
			</section>
</c:if>
		
		
		



		

	<% if(pagefile!=null){%>		
	 	<section class="default" style="margin-top: 50px;"> 
			<jsp:include page='<%= pagefile + ".jsp"%>'/> 
		</section> 
		
	<%	}%>	
		
	<%@ include file="include/footer.jsp" %>
	
	
<!-- 	
<script>
	$(document).ready(function() {
		$('.bxslider').bxSlider({
			mode : 'fade',
			auto : true,
			autoControls : true,
			pause : 2000,
			speed: 3000,        // 이동 속도를 설정
			autoHover: true,   // 마우스 호버시 정지 여부
		});
		//$('.bxslider2').bxSlider();
	});
</script>
 -->





<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script type="text/javascript">
$('.slickSlider').slick({
      dots:false,
 
  	/*   fade: true, */
    /*   cssEase: 'linear', */
           
      infinite: true , /* Move back to the front without ending at the end image */
      slidesToShow: 1, /* The number of images to be displayed on the screen  */
      slidesToScroll: 1,  /*  Number of images to move when scrolling */
      autoplay: true, /* Automatically show next image  */
      arrows: true, /* arrow  */
      autoplaySpeed:3000,/* Time to move on to the next image  */
       
      speed:1000 , /* Time taken to pass to the next image  */
      pauseOnHover:true, /* Stop moving slides on mouse hover  */
    //  nextArrow: '<i class="fa fa-angle-right"></i>',
      //prevArrow: '<i class="fa fa-angle-left" style="font-size:15px;"></i>'
 	
      draggable : true, 	//Draggability
       
      //vertical:true,/* Add if you want vertical slides// Default horizontal slides */       
      responsive: [
        { /* responsive web */
          breakpoint: 960, /* standard screen size */
     
          settings: {slidesToShow:2 } /* Settings to be applied to size */                   
       },
     
       {
             /* responsive web */
          breakpoint: 768, 
             /* standard screen size  */
          settings: {slidesToShow:1 } /* Settings to be applied to size  */ 
        }
     
     ]
});
</script>



</body>
</html>