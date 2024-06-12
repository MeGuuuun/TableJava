package dc.human.kimbanbagi.tableJava.dao;

import java.sql.*;
import java.util.List;

import dc.human.kimbanbagi.tableJava.common.DBConnectionManager;
import dc.human.kimbanbagi.tableJava.dto.WaitDTO;

import java.util.ArrayList;

/*

PROJECT        : tablejava
PROGRAM ID    : WaitDAO.java
PROGRAM NAME    : 웨이팅
DESCRIPTION    : 웨이팅 관련 sql문 처리
AUTHOR        : 반재홍
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   반재홍        init

*/

public class WaitDAO {
	private Connection conn;
	int row=0; // insert 또는 update문이 잘 실행되었는지 확인할 때 쓰이는 변수

	//update 또는 insert 시 updated_date / created_date 칼럼에 사용
	java.util.Date now = new java.util.Date();
	Date sqlDate = new Date(now.getTime()); 
	
	// 웨이팅 추가 메소드
	public int addWaiting(WaitDTO wait) {
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "INSERT INTO waiting "
					+ "				user_id,"
					+ "				phone_number,"
					+ "				restaurant_id,"
					+ "				restaurant_name,"
					+ "				head_count,"
					+ "				waiting_number,"
					+ "				waiting_status,"
					+ "				created_date,"
					+ "				created_id "
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, wait.getUserId());
			pstmt.setString(2, wait.getPhoneNumber());
			pstmt.setString(3, wait.getRestaurantId());
			pstmt.setString(4, wait.getRestaurantName());
			pstmt.setString(5, wait.getHeadCount());
			pstmt.setString(6, wait.getWaitingNumber());
			pstmt.setString(7, wait.getWaitingStatus());
			pstmt.setDate(8, sqlDate);
			pstmt.setString(9, wait.getUserId());
			
			row = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	public int getNextWaitingNumber(String restaurantId) {
		int nextNumber = 1;
		
        try {
        	conn = DBConnectionManager.getConnection();
        	
            String sql = "SELECT MAX(waiting_number) FROM waiting WHERE restaurant_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, restaurantId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                nextNumber = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nextNumber;
	 }

	// 사용자의 웨이팅 내역 리스트를 보여주는 메소드
	public List<WaitDTO> getWaitingList(String id) {
        List<WaitDTO> waitingList = new ArrayList<>();
        try {
        	
        	conn = DBConnectionManager.getConnection();
        	
            String sql = "SELECT "
            		+ "				phone_number,"
            		+ "				restaurant_name,"
            		+ "				head_count,"
            		+ "				waiting_number "
            		+ "FROM waiting "
            		+ "WHERE user_id = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                WaitDTO wait = new WaitDTO();
                
                wait.setPhoneNumber(rs.getString("phone_number"));
                wait.setRestaurantName(rs.getString("restaurant_name"));
                wait.setHeadCount(rs.getString("head_count"));
                wait.setWaitingNumber(rs.getString("waiting_number"));

                waitingList.add(wait);
            }
            
            conn.close();
            pstmt.close();
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return waitingList;
    }
	
	
}
