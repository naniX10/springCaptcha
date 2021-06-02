<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>구글 reCaptcha</title>
		<script src="https://www.google.com/recaptcha/api.js"></script>
		<script>
			function inSubmit() {
				docment.getElementById("frm").submit();
			}
		</script>
		<style>
		</style>
	</head>
	<body>
		<h1>구글 reCaptcha</h1>
		
		<form method="POST" id="frm">
		   <div>아이디 : <input type="text" id="userid" name="userid"></div>
		   <div>비밀번호 : <input type="password" id="passwd" name="passwd"></div>
		   <div class="g-recaptcha" 
		   data-sitekey="6LfdIwgbAAAAAGZdSMWuY4f3zaKP-dIuhTMUrU8_" 
		   data-callback="onSubmit"></div>
		   <div><button type="submit">입력완료</button></div>
		 </form>
		
	</body>
</html>
<!-- // captcha
	 // Completely Automated Public Turning
	 // test to tell Computers and Humans Apart
	 // 어떤 사용자가 실제 사람인지 봇(컴퓨터 프로그램)인지
	 // 구별하기 위해 사용하는 기법을 의미 (튜링 테스트의 일종)
	 // 봇은 쉽게 구별할 수 없는 그림을 주고 그 그림에 쓰여진 내용을
	 // 묻는 방법으로 부터 시작해서 지금은 다양한 기법으로 사용되고 있음
	
	 // 웹사이트에 접근하는 대상이 사람인지 봇인지 판단하기 위해
	 // 사용하는 테스트의 일종
	 
	 // Google reCaptcha
	 // 구글에서 제공하는 봇 방지 API
	 // 버젼1을 거쳐 지금 현재는 버젼2(행위기반/반응기반)와 
	 // 버젼3(화면 로딩시 확인)이 주로 사용
	 // developers.google.com/recaptcha
	 
	 // recaptcha 일반키와 비밀키 발급
	 // www.google.com/recaptcha/admin
	 
	 
 -->