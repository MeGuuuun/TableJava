package dc.human.kimbanbagi.tableJava.servlet;

import java.io.IOException;

import dc.human.kimbanbagi.tableJava.dao.WaitDAO;
import dc.human.kimbanbagi.tableJava.dto.WaitDTO;

import java.util.*;
import java.text.SimpleDateFormat;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/wait")
public class WaitServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String phoneNumber = request.getParameter("phoneNumber");
		String restaurantId = request.getParameter("restaurantId");
		String restaurantName = request.getParameter("restaurantName");
		int headCount = Integer.parseInt(request.getParameter("headCount"));
		
		WaitDTO wait = new WaitDTO();
		wait.setUserId(userId);
		wait.setPhoneNumber(phoneNumber);
		wait.setRestaurantId(restaurantId);
		wait.setRestaurantName(restaurantName);
		wait.setHeadCount(headCount);
        wait.setWaitingStatus("WAITING");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sdf.format(new Date());
        wait.setCreatedDate(currentDate);
        wait.setCreatedId(userId);
        wait.setUpdatedDate(currentDate);
        wait.setUpdatedId(userId);
        
        WaitDAO dao = new WaitDAO();
        dao.addWaiting(wait);
        

        List<WaitDTO> waitingList = dao.getWaitingList(restaurantId);
        request.setAttribute("waitingList", waitingList);
        request.setAttribute("restaurantName", restaurantName);
        request.setAttribute("restaurantId", restaurantId);

        request.getRequestDispatcher("/wait.jsp").forward(request, response);
	}

}
