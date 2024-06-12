package dc.human.kimbanbagi.tableJava.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dc.human.kimbanbagi.tableJava.dao.*;
import dc.human.kimbanbagi.tableJava.dto.*;

/*

PROJECT        : tablejava
PROGRAM ID    : UserWaitListServlet.java
PROGRAM NAME    : 사용자 웨이팅 내역 리스트
DESCRIPTION    : 사용자의 웨이팅 내역을 보여주고 관리 함
AUTHOR        : 반재홍
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   반재홍        init

*/

@WebServlet("/UserWaitList")
public class UserWaitListServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// jsp에서 보낸 request 읽어오기
		String userId = request.getParameter("userId");
		
		WaitDAO dao = new WaitDAO();
		List<WaitDTO> waitList = dao.getWaitingList(userId);
		
		request.setAttribute("waitList", waitList);
		request.getRequestDispatcher("/userWaitList.jsp").forward(request, response);
	}

}


