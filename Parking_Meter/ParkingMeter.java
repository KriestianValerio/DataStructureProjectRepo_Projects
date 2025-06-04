package elice;

public class ParkingMeter {
	private double ratePerHour;
	private String adminPwd;
	ParkingSession currentSession;
	
	public ParkingMeter(double ratePerHour, String adminPwd) {
        // Implement here
		this.ratePerHour = ratePerHour;
        this.adminPwd = adminPwd;
        this.currentSession = null;
	}
	
	
	public void startSession(String carPlate, double amountPaid) {
		// Assume that amount Paid is positive
		
        // Implement here
        double hoursPaid = amountPaid/ratePerHour;
        currentSession = new ParkingSession(carPlate,hoursPaid);
		
		System.out.println("Parking started for " + carPlate + " for " + hoursPaid + " hours."); // Use this print statement
	}
	
	public boolean isSessionValid() {
        // Implement here
		if (currentSession == null) {
            return false;
        }
        else {
            return true;
        }
	}
	
	public void stopSession(String carPlate) {
        //Assume that this method is invoked when there is a parked car.
        
        // Implement here
		if (!currentSession.carPlate.equals(carPlate)) {
            System.out.println("Invalid carPlate");

        }
        else {
            System.out.println("Parking session ended for " + currentSession.carPlate);
            currentSession = null;
        }
        // Use this print statement
		
       
        
	}
	
	public void changeRate(String password, double newRate) {
        //Assume that newRate is positive
		
		
            System.out.println("Invalid admin password.");
            
        //Use this print statement
		

        if (!password.equals(adminPwd)) {
            System.out.println("Invalid admin password");

        }
        else {
            System.out.println("New rate set: $" + newRate + " per hour.");
            ratePerHour = newRate;
        }
	}
	
	public void showSession() {
         // implement here
        
          
        //Use this print statement
        

        if (currentSession == null) {
            System.out.println("No active session.");//Use this print statement

        }
        else {
            System.out.println("Active Session: Car " + currentSession.carPlate + " | Valid: " + currentSession.isValid()); 
        }
            
    }
    //Do not modify this method
    public double getRatePerHour(){
        return ratePerHour;
    }
    //Do not modify this method
    public String getAdminPwd(){
        return adminPwd;
    }