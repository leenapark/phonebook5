<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="${pageContext.request.contextPath}/phone/modify2" method="post">
			이름(name):<input type="text" name="name" value="${requestScope.pMap.NAME }"><br>
			핸드폰(hp):<input type="text" name="hp" value="${pMap.HP }"><br>
			회사(company):<input type="text" name="company" value="${pMap.COMPANY }"><br>
			
			<!-- 아래 영역은 히든 처리로 노출하지 않는 부분 test 때만 text로 두고 확인한다 -->
			id: <input type="text" name="personId" value="${pMap.PERSONID }">		
			<button type="submit">등록</button>
		</form>
	
	
</body>
</html>