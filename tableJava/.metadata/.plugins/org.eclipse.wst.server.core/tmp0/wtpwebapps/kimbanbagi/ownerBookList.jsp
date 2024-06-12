<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ownerBookList</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function confirmStatus(rId, uId) {
	var status = "1";
	var restaurantId = rId;
	var userId = uId;
	
	$.ajax({
        type: "POST",
        url: "bookList",
        data: { action: "status", status: status, userId : userId, restaurantId : restaurantId },
        success: function(response) {
            alert("예약 확정되었습니다.");
            $("#confirmBtn").prop(disabled, true);
        },
        error: function() {
            alert("예약 확정에 실패했습니다. 다시 시도해주세요.");
        }
    });
}
	
function cancelStatus(rId, uId) {
    var status = "2";
    var restaurantId = rId;
    var userId = uId;
   
    $.ajax({
        type: "POST",
        url: "bookList",
        data: { action: "status", status: status, userId : userId, restaurantId : restaurantId },
        success: function(response) {
            alert("예약 취소되었습니다.");
            $("#cancelBtn").prop(disabled, true);
        },
        error: function() {
            alert("예약 취소에 실패했습니다. 다시 시도해주세요.");
        }
    });
}

</script>
</head>
<body>
	<div class="nav">
            <form method="POST" action="ownerMain">
            	<input type="hidden" name="userId" value="${userId }">
            	<input type="hidden" name="restaurantId" value="${restaurantId }">
            	<button type="submit">메인 화면</button>
            </form>
            <button onclick="location.reload()">예약/웨이팅</button>
            <button onclick="location.href='notification.jsp'">알림 화면</button>
            <form method="POST" action="MyPage">
            	<input type="hidden" name="userId" value="${userId }">
            	<input type="hidden" name="restaurantId" value="${restaurantId }">
            	<button onclick="location.href='myPage.jsp'">마이 페이지</button>
            </form>
    </div>
	<h1>예약 내역</h1>
	<form method="post" action="OwnerBookList">
	<ul>
		<c:forEach items="${bookList}" var="book">
			<div>
					예약자 : ${book.user_id } <br>
					예약 날짜 : ${book.date } <br>
					예약 시간 : ${book.time } <br>
					예약 인원 수 : ${book.a_count + book.k_count } 명 <br>
					유모차 사용 : ${book.s_count } 개<br>
					휠체어 사용 : ${book.w_count } 개<br>
					요청 사항 : ${book.requirement } <br>
				<div>
					예약 상태 : ${book.status }
				</div>
				<div>
					<button type="button" onclick="confirmStatus('${book.restaurant_id}', '${book.user_id }')" id="confirmBtn">예약 확정</button>
				</div>
				<div>
					<button type="button" onclick="cancelStatus('${book.restaurant_id}', '${book.user_id }')" id="cancelBtn">예약 취소</button>
				</div>
			</div>
		</c:forEach>
	</ul>
	</form>
</body>
</html>