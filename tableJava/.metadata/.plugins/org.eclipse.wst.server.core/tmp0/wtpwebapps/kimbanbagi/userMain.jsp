<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 메인 화면</title>
    <link rel="stylesheet" type="text/css" href="css/userMain.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="navbar">
        <button onclick="location.reload()">메인 화면</button>
        <form method="post" action="UserBookList">
        	<input type="hidden" name="userId" value="${userId }">
        	<button name="action" value="bookList">예약/웨이팅</button>
        </form>
        <button onclick="location.href='notification.jsp'">알림</button>
        <form method="post" action="MyPage">
        	<input type="hidden" name="userId" value="${userId }">
        	<button onclick="location.href='myPage.jsp'">마이 페이지</button>
        </form>
    </div>
    <div>
    </div>
    <div class="search-section">
        <div class="search-conditions">
            <label for="search">검색 조건</label>
            <select id="search-conditions">
                <option value="restaurant">식당 이름</option>
                <option value="location">지역</option>
            </select>
        </div>
        <div class="search-box">
            <input type="text" id="search-input" placeholder="검색...">
            <button id="search-button" onclick="search()">🔍</button>
        </div>
    </div>
    <div class="map-section">
        <div id="map" style="width:100%;height:400px;"></div>
    </div>
    <div class="list-section">
        <ul id="restaurant-list">
            사용자 위치 기반 주위 식당 리스트
        </ul>
    </div>
</body>
</html>
