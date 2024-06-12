package dc.human.kimbanbagi.tableJava.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*

PROJECT        : tablejava
PROGRAM ID    : MyPageServlet.java
PROGRAM NAME    : 마이 페이지
DESCRIPTION    : 마이 페이지 관련 servlet
AUTHOR        : 이경민
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   이경민        init

*/

@WebServlet("/MyPage")
public class MyPageServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        
        // jsp에서 보낸 request 읽기
        String userId = request.getParameter("userId");
        
        // users 테이블에서 회원 정보 끌어오는 메소드 만들어서 myPage.jsp로 보내는 코드 작성
    }

}
