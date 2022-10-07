<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Gym Check</title>

	<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
	
	
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
	
	<!-- 기초 설정 -->
	<link rel="stylesheet" href="/resources/css/home.css">
	<script type="text/javascript">
		$(function () {
			$('[data-toggle="tooltip"]').tooltip()
		})
	</script>
</head>
<body>

<section class="login-block">
    <div class="container">
	<div class="row">
		<!-- 좌측 설명 -->
		<div class="col-md-2 login-sec">
		    <h2 class="text-center">Check Now</h2>
		    <p class="text-center">These people are currently using the GYM</p>
		    <p class="text-center">오늘 누적 이용자 수  :  ${sumUser }명</p>
		    
		    <img id="adminImg" alt="user" src="/resources/img/preview.png">
		    
			<div class="copy-text">Created by BM</div>
		</div>
		
		<!-- 우측 안내 멘트 영역 -->
		<div class="col-md-10 banner-sec">
		    <div class="carousel-item active">
		    	<img id="user1" class="d-block img-fluid userImg" src="/resources/img/user1.png" alt="running 1">
		    	<img id="user2" class="d-block img-fluid userImg" src="/resources/img/user2.png" alt="running 2">
		    	<img id="user3" class="d-block img-fluid userImg" src="/resources/img/user3.png" alt="running 3">
		    	<img id="user4" class="d-block img-fluid userImg" src="/resources/img/user4.png" alt="cycle 4">
		    	<img id="user5" class="d-block img-fluid userImg" src="/resources/img/user5.png" alt="cycle 5">
		    	<img id="user6" class="d-block img-fluid userImg" src="/resources/img/user6.png" alt="mat 6">
		    	<img id="user7" class="d-block img-fluid userImg" src="/resources/img/user7.png" alt="dumb-bell 7">
		    	<img id="user8" class="d-block img-fluid userImg" src="/resources/img/user8.png" alt="dumb-bell 8">
		    	<img id="user9" class="d-block img-fluid userImg" src="/resources/img/user9.png" alt="dumb-bell 9">
		    	<img id="user10" class="d-block img-fluid userImg" src="/resources/img/user10.png" alt="dumb-bell 10">
		    	<img id="user11" class="d-block img-fluid userImg" src="/resources/img/user11.png" alt="jump-rope 11">
	    	</div>
	      	<div class="carousel-caption d-none d-md-block">
	        	<div class="banner-text">
	            	<h2>Current number of users: ${nowUser }명</h2>
	            	
	            	<c:set var="maxNum" value="${maxGym }" />
	            	<c:choose>
		            	<c:when test="${maxNum > 1}"> 
			            	<p class="mb-0">시설 정원: ${maxGym}명</p>
			            	<p> 현재시간: ${serverTime }</p>
		            	</c:when>
		            	<c:otherwise>
		            		<p>오픈 전입니다</p>
		            	</c:otherwise>
	            	</c:choose>
	        	</div>	
	  		</div>	    	
		</div>	
		    
	</div><!-- row end  -->
	</div><!-- container end  -->
	
</section>	

	<!-- 관리자 컨트롤 영역: button set -->
	<div class="btn-wrapper">
	
		<div class="float-right btn-set form-group d-flex flex-row">
			<!-- 클릭 시 정원을 넘겨주면서 생성 -->
			<form role="form" method='post' action="openProc">
				<input class="form-control w-50 d-inline" placeholder="정원수 설정" name="maxUser" type="number" value=""
					data-toggle="tooltip" data-placement="top" title="시설의 정원수를 입력하세요">
				<button type="submit" class="btn icon-btn btn-info" href="#"
					data-toggle="tooltip" data-placement="top" title="시설을 오픈하고, 정원수를 출력합니다">
					<i class="fas fa-door-open"></i>  open
				</button>
			</form>
			<form role="form" method='post' action="openProc">
				<input type="hidden" name="maxUser" value="0">
				<button type="submit" class="btn icon-btn btn-light mr-5" href="#"
					data-toggle="tooltip" data-placement="top" title="오늘 하루가 끝났습니다">
					<i class="fas fa-door-closed"></i>  close
				</button>
			</form>
		

			<!-- 클릭 시 현재 사용인원을 변경한다 -->
			<form role="form" method='post' action="addProc">
				<button type="submit" class="btn icon-btn btn-primary d-inline mr-1" href="#"
					data-toggle="tooltip" data-placement="top" title="회원증을 체크하고 시설을 이용합니다">
					<i class="fas fa-user-plus"></i>  Check-in
				</button>
			</form>
	
			<form role="form" method='post' action="minusProc">
				<button type="submit" class="btn icon-btn btn-warning" href="#"
					data-toggle="tooltip" data-placement="top" title="회원이 돌아갑니다">
					<i class="fas fa-user-minus"></i>  CheckOut
				</button>
			</form>
		</div>
	</div>

	
</body>
</html>
