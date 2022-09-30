<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Gym Check</title>

	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
	
	<link rel="stylesheet" href="/resources/css/home.css">
	
</head>
<body>

<section class="login-block">
    <div class="container">
	<div class="row">
		<!-- 좌측 설명 -->
		<div class="col-md-2 login-sec">
		    <h2 class="text-center">Check Now</h2>
		    <p class="text-center">These people are currently using the GYM</p>
		    
		    <img id="adminImg" alt="user" src="/resources/img/preview.png">
		    
			<div class="copy-text">Created by BM</div>
		</div>
		
		<!-- 우측 안내 멘트 영역 -->
		<div class="col-md-10 banner-sec">
		    <div class="carousel-item active">
		    	<img id="user1" class="d-block img-fluid userImg" src="/resources/img/run1.png" alt="running 1">
	    	</div>
	      	<div class="carousel-caption d-none d-md-block">
	        	<div class="banner-text">
	            	<h2>Current number of users: 10</h2>
	            	<p>시설 정원: ${maxGym }명</p>
	        	</div>	
	  		</div>	    	
		</div>	
		    
	</div><!-- row end  -->
	</div><!-- container end  -->
	
</section>	

	<!-- button set -->
	<div class="btn-wrapper">
		<div class="float-left btn-set form-group d-flex flex-row">
		
		<form role="form" method='post' action="openProc">
			<!-- 클릭 시 정원을 넘겨주면서 생성 -->
			<input class="form-control w-50 d-inline" placeholder="정원" name="maxUser" type="number" value="">
			<button type="submit" class="btn icon-btn btn-info" href="#"><i class="fas fa-door-open"></i>  open</button>
		</form>
		<form role="form" method='post' action="closeProc">
			<button type="submit" class="btn icon-btn btn-light" href="#"><i class="fas fa-door-closed"></i>  close</button>
		</form>
		
		</div>
		
		<div class="float-right btn-set form-group d-flex flex-row">
		<!-- 클릭 시 현재 사용인원을 변경한다 -->
		<form role="form" method='post' action="addProc">
			<button type="submit" class="btn icon-btn btn-primary d-inline" href="#"><i class="fas fa-user-plus"></i>  Check-in</button>
		</form>

		<form role="form" method='post' action="minusProc">
			<button type="submit" class="btn icon-btn btn-warning" href="#"><i class="fas fa-user-minus"></i>  CheckOut</button>
		</form>
		</div>
	</div>

	
</body>
</html>
