package dc.human.kimbanbagi.tableJava.dto;

public class WaitDTO {
	private String userId;
	private String phoneNumber;
	private String restaurantId;
	private String restaurantName;
	private int headCount;
	private int waitingNumber;
	private String waitingStatus;
	private String createdDate;
	private String createdId;
	private String updatedDate;
	private String updatedId;
	
	// Gettes and Setters
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public String getRestaurantId() {
		return restaurantId;
	}
	
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	
	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}
	
	public int getHeadCount() {
		return headCount;
	}
	
    public void setWaitingNumber(int waitingNumber) {
        this.waitingNumber = waitingNumber;
    }
    
	public int getWaitingNumber() {
        return waitingNumber;
    }

    public void setWaitingStatus(String waitingStatus) {
        this.waitingStatus = waitingStatus;
    }
    
    public String getWaitingStatus() {
        return waitingStatus;
    }
    
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    
    public String getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }
    
    public String getCreatedId() {
        return createdId;
    }
    
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    public String getUpdatedDate() {
        return updatedDate;
    }
   
    public void setUpdatedId(String updatedId) {
        this.updatedId = updatedId;
    }
    
    public String getUpdatedId() {
        return updatedId;
    }
	
	
}
