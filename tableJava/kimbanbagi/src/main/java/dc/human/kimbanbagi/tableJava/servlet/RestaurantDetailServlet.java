package dc.human.kimbanbagi.tableJava.servlet;

import dc.human.kimbanbagi.tableJava.dao.*;
import dc.human.kimbanbagi.tableJava.dto.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*

PROJECT        : tablejava
PROGRAM ID    : RestaurantDetailServlet.java
PROGRAM NAME    : 식당 상세 정보 페이지
DESCRIPTION    : 식당 상세 정보를 불러오고 이후 예약과 웨이팅으로 넘어가는 처리 담당
AUTHOR        : 박지민
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   박지민        init

*/

@WebServlet("/restaurantDetail")
public class RestaurantDetailServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// jsp에서 보낸 request를 읽을 때
		String userId = request.getParameter("userId");
		String restaurantId = request.getParameter("restaurantId");
		
		// 서블릿에서 보낸 request를 읽을 때
		String uId = (String) request.getAttribute("userId");
		String rId = (String) request.getAttribute("restaurantId");
		
		if(uId== null) {
			RestaurantDAO dao = new RestaurantDAO();
			RestaurantDTO restaurant = dao.getRestaurantDetail(restaurantId);
			
			request.setAttribute("userId", userId);
			request.setAttribute("restaurantId", restaurantId);
			request.setAttribute("restaurant", restaurant);
			request.getRequestDispatcher("/restaurantDetail.jsp").forward(request, response);
		} else {
			RestaurantDAO dao = new RestaurantDAO();
			RestaurantDTO restaurant = dao.getRestaurantDetail(rId);
			
			request.setAttribute("userId", uId);
			request.setAttribute("restaurantId", rId);
			request.setAttribute("restaurant", restaurant);
			request.getRequestDispatcher("/restaurantDetail.jsp").forward(request, response);
		}
		
		
	}

}
