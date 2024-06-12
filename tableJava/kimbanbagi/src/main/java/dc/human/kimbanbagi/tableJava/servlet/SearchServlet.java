package dc.human.kimbanbagi.tableJava.servlet;

import dc.human.kimbanbagi.tableJava.dao.*;
import dc.human.kimbanbagi.tableJava.dto.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String keywords = request.getParameter("keywords");
		
		RestaurantDAO dao = new RestaurantDAO();
		List<RestaurantDTO> dtoList = dao.searchRestaurant(keywords);
		
		if(dtoList.isEmpty()) {
			//결과 찾지 못 했을 시 alert 처리
			System.out.println("검색 결과를 찾지 못 했습니다.");
		}else {
			request.setAttribute("searchResult", dtoList);
			request.setAttribute("keywords", keywords);
			request.setAttribute("userId", userId);
			request.getRequestDispatcher("search.jsp").forward(request, response);
		}
	}

}
