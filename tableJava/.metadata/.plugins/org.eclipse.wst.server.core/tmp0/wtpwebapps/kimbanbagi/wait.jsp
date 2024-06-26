<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웨이팅 화면</title>
<body>
	 <h1>가게 정보</h1>
	 <p>${restaurantName } 웨이팅 하기</p>
    <div>
    	<div>
        	<h2>현재 웨이팅 순서</h2>
        	<p>${waitNumber } 번째 대기 입니다.</p>
    	</div>
        <form action="wait" method="post">
        	<input type="hidden" name="userId" value="${userId }">
            <input type="hidden" name="restaurantId" value="${restaurantId}">
            <input type="hidden" name="restaurantName" value="${restaurantName}">
            <input type="hidden" name="waitNumber" value="${waitNumber }">
            
            <label for="headCount">인원수: </label>
            <input type="number" id="headCount" name="headCount" min="1" required>
            <label>전화 번호 입력 : </label>
            <input type="text" name="phoneNumber" required>
            <button type="submit" name="action" value="addBook">웨이팅 하기</button>
        </form>
    </div>
</body>
</html>