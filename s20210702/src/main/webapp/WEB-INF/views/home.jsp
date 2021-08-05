<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>메인페이지</title>
<!-- Bootstrap Styles-->
<link href="/resources/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="/resources/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->
<link href="/resources/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="/resources/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

</head>

<body>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="home.jsp"><i class="fa fa-gear"></i>
					<strong>2조</strong></a>
			</div>

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-messages">
						<li><a href="#">
								<div>
									<strong>조충범</strong> <span class="pull-right text-muted">
										<em>방금</em>
									</span>
								</div>
								<div>도망쳐서 정말 죄송하지만 사장님 혹시 지금 복귀 가능한가요 정말 열심히 할 자신있...</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<strong>백진상 차장</strong> <span class="pull-right text-muted">
										<em>5분전</em>
									</span>
								</div>
								<div>спаси́бо~ 사장님 방금 러시아에서 출장 마치고 복귀했습니다 사업관련해서 말씀드...</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<strong>이미나 대리</strong> <span class="pull-right text-muted">
										<em>3시간전</em>
									</span>
								</div>
								<div>사장님 저 먼저 퇴근해보겠습니다 수고하셨습니다~^^</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>모든
									메세지 보기</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul> <!-- /.dropdown-messages --></li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-tasks">
						<li><a href="#">
								<div>
									<p>
										<strong>성동구 방범용 CCTV 관리</strong> <span
											class="pull-right text-muted">60% 완료</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100" style="width: 60%">
											<span class="sr-only">60% 완료 (success)</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>인천공항 드론 관제시스템</strong> <span
											class="pull-right text-muted">28% 완료</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="28" aria-valuemin="0" aria-valuemax="100"
											style="width: 28%">
											<span class="sr-only">28% Complete</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>평택시청 상담원 관리</strong> <span
											class="pull-right text-muted">60% 완료</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100" style="width: 60%">
											<span class="sr-only">60% Complete (warning)</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>국방부 서버 유지보수</strong> <span
											class="pull-right text-muted">85% 완료</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="85" aria-valuemin="0"
											aria-valuemax="100" style="width: 85%">
											<span class="sr-only">85% Complete (danger)</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>모든
									프로젝트 보기</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul> <!-- /.dropdown-tasks --></li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-alerts">
						<li><a href="#">
								<div>
									<i class="fa fa-comment fa-fw"></i> 새로운 댓글 <span
										class="pull-right text-muted small">4 분전</span>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<i class="fa fa-envelope fa-fw"></i> 받은 메세지 3개 <span
										class="pull-right text-muted small">4 분전</span>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<i class="fa fa-tasks fa-fw"></i> 새 프로젝트 <span
										class="pull-right text-muted small">4 분전</span>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<i class="fa fa-upload fa-fw"></i> 결재 승인 완료 <span
										class="pull-right text-muted small">4 분전</span>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>모든
									알림 보기</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul>
				<!-- /.dropdown-alerts -->
				</li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> 사용자 정보</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> 정보 수정</a></li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-sign-out fa-fw"></i> 로그아웃</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
		</nav>
		<!--/. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div id="sideNav" href="">
				<i class="fa fa-caret-right"></i>
			</div>
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">

					<li><a class="active-menu" href="home.jsp"><i
							class="fa fa-dashboard"></i> 대시보드</a></li>
					<li><a href="ui-elements.html"><i class="fa fa-desktop"></i>
							사내 정보</a></li>
					<li><a href="chart.html"><i class="fa fa-bar-chart-o"></i>
							출퇴근 관리</a></li>
					<li><a href="tab-panel.html"><i class="fa fa-qrcode"></i>
							문서 결재</a></li>

					<li><a href="table.html"><i class="fa fa-table"></i> 일정표</a></li>
					<li><a href="form.html"><i class="fa fa-edit"></i> 게시판 </a></li>


					<li><a href="#"><i class="fa fa-sitemap"></i> 조직원 정보<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="#">공통 연락처</a></li>
							<li><a href="#">부서 조직도</a></li>
							<li><a href="#">멀티탭 예제<span class="fa arrow"></span></a>
								<ul class="nav nav-third-level">
									<li><a href="#">멀티탭 2 </a></li>
									<li><a href="#">멀티탭 3</a></li>
									<li><a href="#">멀티탭 4</a></li>

								</ul></li>
						</ul></li>
					<li>
						<a href="mailList.jsp">
							<i class="fa fa-fw fa-file"></i>
							메일</a>
					</li>
					<li>
						<a href="empty.html">
							<i class="fa fa-fw fa-file"></i>
							빈 페이지</a>
					</li>
				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">


				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">대시보드</h1>
						<ol class="breadcrumb">
							<li><a href="#">메인페이지</a></li>
							<li><a href="#">문서</a></li>
							<li class="active">데이터</li>
						</ol>
					</div>
				</div>


				<!-- /. ROW  -->

				<div class="row">
					<div class="col-md-3 col-sm-12 col-xs-12">
						<div
							class="panel panel-primary text-center no-boder bg-color-green green">
							<div class="panel-left pull-left green">
								<i class="fa fa-eye fa-5x"></i>

							</div>
							<div class="panel-right">
								<h3>7</h3>
								<strong> 출근 인원</strong>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-12 col-xs-12">
						<div
							class="panel panel-primary text-center no-boder bg-color-blue">
							<div class="panel-left pull-left blue">
								<i class="fa fa-shopping-cart fa-5x"></i>
							</div>

							<div class="panel-right">
								<h3>52,160</h3>
								<strong> 판매량</strong>

							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-12 col-xs-12">
						<div class="panel panel-primary text-center no-boder bg-color-red">
							<div class="panel-left pull-left red">
								<i class="fa fa fa-comments fa-5x"></i>

							</div>
							<div class="panel-right">
								<h3>3</h3>
								<strong> 메신저 알림 </strong>

							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-12 col-xs-12">
						<div
							class="panel panel-primary text-center no-boder bg-color-brown">
							<div class="panel-left pull-left brown">
								<i class="fa fa-users fa-5x"></i>

							</div>
							<div class="panel-right">
								<h3>27</h3>
								<strong>사원수</strong>

							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-5">
						<div class="panel panel-default">
							<div class="panel-heading">영역 차트</div>
							<div class="panel-body">
								<div id="morris-area-chart"></div>
							</div>
						</div>
					</div>

					<div class="col-md-7">
						<div class="panel panel-default">
							<div class="panel-heading">선도표</div>
							<div class="panel-body">
								<div id="morris-line-chart"></div>
							</div>
						</div>
					</div>

				</div>



				<div class="row">
					<div class="col-xs-6 col-md-3">
						<div class="panel panel-default">
							<div class="panel-body easypiechart-panel">
								<h4>거래처</h4>
								<div class="easypiechart" id="easypiechart-blue"
									data-percent="82">
									<span class="percent">82%</span>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-md-3">
						<div class="panel panel-default">
							<div class="panel-body easypiechart-panel">
								<h4>전체 판매량</h4>
								<div class="easypiechart" id="easypiechart-orange"
									data-percent="55">
									<span class="percent">55%</span>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-md-3">
						<div class="panel panel-default">
							<div class="panel-body easypiechart-panel">
								<h4>이익</h4>
								<div class="easypiechart" id="easypiechart-teal"
									data-percent="84">
									<span class="percent">84%</span>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-md-3">
						<div class="panel panel-default">
							<div class="panel-body easypiechart-panel">
								<h4>휴가자</h4>
								<div class="easypiechart" id="easypiechart-red"
									data-percent="46">
									<span class="percent">46%</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--/.row-->


				<div class="row">
					<div class="col-md-9 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">막대 그래프</div>
							<div class="panel-body">
								<div id="morris-bar-chart"></div>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">도넛 차트</div>
							<div class="panel-body">
								<div id="morris-donut-chart"></div>
							</div>
						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-md-12"></div>
				</div>
				<!-- /. ROW  -->





				<div class="row">
					<div class="col-md-4 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">알림창</div>
							<div class="panel-body">
								<div class="list-group">

									<a href="#" class="list-group-item"> <span class="badge">7
											분전</span> <i class="fa fa-fw fa-comment"></i>게시글에 새로운 댓글이 달렸습니다.
									</a> <a href="#" class="list-group-item"> <span class="badge">16
											분전</span> <i class="fa fa-fw fa-truck"></i> 주문 392 개
										배송중
									</a> <a href="#" class="list-group-item"> <span class="badge">36
											분전</span> <i class="fa fa-fw fa-globe"></i> 송장 653 개
										지불
									</a> <a href="#" class="list-group-item"> <span class="badge">1
											시간전</span> <i class="fa fa-fw fa-user"></i> 새로운 사용자가 추가되었습니다.
									</a> <a href="#" class="list-group-item"> <span class="badge">1
											시간전</span> <i class="fa fa-fw fa-user"></i> 새로운 사용자가 추가되었습니다.
									</a> <a href="#" class="list-group-item"> <span class="badge">어제</span>
										<i class="fa fa-fw fa-globe"></i> 결제 승인 대기중
									</a>
								</div>
								<div class="text-right">
									<a href="#">모든 알림 보기 <i class="fa fa-arrow-circle-right"></i></a>
								</div>
							</div>
						</div>

					</div>
					<div class="col-md-8 col-sm-12 col-xs-12">

						<div class="panel panel-default">
							<div class="panel-heading">반응형 테이블 에제</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>사원 번호</th>
												<th>성</th>
												<th>이름</th>
												<th>사용자 ID</th>
												<th>이메일 ID</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td>반</td>
												<td>데이크</td>
												<td>John15482</td>
												<td>name@site.com</td>
											</tr>
											<tr>
												<td>2</td>
												<td>킴</td>
												<td>카다시안</td>
												<td>Kim1425</td>
												<td>name@site.com</td>
											</tr>
											<tr>
												<td>3</td>
												<td>로지</td>
												<td>철수</td>
												<td>Rossy1245</td>
												<td>name@site.com</td>
											</tr>
											<tr>
												<td>4</td>
												<td>리카르도</td>
												<td>영희</td>
												<td>Rich5685</td>
												<td>name@site.com</td>
											</tr>
											<tr>
												<td>5</td>
												<td>제이콥</td>
												<td>안수</td>
												<td>Jac4587</td>
												<td>name@site.com</td>
											</tr>
											<tr>
												<td>6</td>
												<td>에데르</td>
												<td>밀리탕</td>
												<td>Wrap4585</td>
												<td>name@site.com</td>
											</tr>

										</tbody>
									</table>
								</div>
							</div>
						</div>

					</div>
				</div>
				<!-- /. ROW  -->


				<footer>
					<p>XX 주식회사 대표이사 : XXX 사업자등록번호 : XXX-XX-XXXXX  통신판매업 신고 :
						XXXX-XXX-XXXX 사업장주소 : XX시 XX구 호스팅서비스사업자 : XX
						 대표번호 : XX-XXXX-XXXX 제품/서비스/멤버십: XXXX-XXXX 구매문의 :
						XXXX-XXXX 본 사이트의 컨텐츠는 저작권법의 보호를 받는 바 무단 전재, 복사,
						배포 등을 금합니다. Copyright © 1995-XXXX XX법인. All Rights Reserved.</p>


				</footer>
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="/resources/js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="/resources/js/bootstrap.min.js"></script>

	<!-- Metis Menu Js -->
	<script src="/resources/js/jquery.metisMenu.js"></script>
	<!-- Morris Chart Js -->
	<script src="/resources/js/morris/raphael-2.1.0.min.js"></script>
	<script src="/resources/js/morris/morris.js"></script>


	<script src="/resources/js/easypiechart.js"></script>
	<script src="/resources/js/easypiechart-data.js"></script>

	<script src="/resources/js/Lightweight-Chart/jquery.chart.js"></script>

	<!-- Custom Js -->
	<script src="/resources/js/custom-scripts.js"></script>


</body>

</html>
