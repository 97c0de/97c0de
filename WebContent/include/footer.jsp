<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<a id="topBtn" href="#" style="margin-left: 0px;">TOP</a>
<div style="height: 100px"></div>
<footer>
	<div class="footer02">
		<div style="width: 100%; text-align: center;">
			<p class="inner-copyright">
				Copyright © <span class="sitename-first">C</span>inema <span class="sitename-second">R</span>eview. All Rights Reserved.
			</p>
		</div>
	</div>
	</div>
</footer>
</div>

<script>
$(document).ready(function(){
	$("#my_menu").on("mouseenter",function(){
		$(".my_menu").stop().slideDown();
	});
	$("#my_menu").on("mouseleave",function(){
		$(".my_menu").stop().slideUp();
	});
	
	
	  $(window).scroll(function () {
		    var top =  $("#topBtn");
		        if ( $('body').height() <= (    $(window).height() + $(window).scrollTop() + 200 )) {
		 			 top.animate({"margin-left": "0px"},1500);
		 			top.show();
		        } else {
		            //top.animate({"margin-left": "-900%"},1500);
		            top.hide();
		        }
	  });

	    $("#topBtn").on('click', function () {
	        $("html, body").animate({scrollTop: 0}, 400);
	    });
		    
		   		    
});
</script>