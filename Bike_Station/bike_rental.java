package elice;

public class BikeRentalStation{
    private double ratePerHour;
    private BikeRentalSession[] sessions;
    private int sessionCount;
    
    public BikeRentalStation(double ratePerHour, int maxRentals){
        this.ratePerHour = ratePerHour;
        this.sessions = new BikeRentalSession[maxRentals];
        this.sessionCount = 0;
    }
    
    // If the amountPaid is not sufficient for at least 1 hour, the rental is not allowed
    // Assume that bikeID and amountPaid are always positive and in the valid range
    public void startRental(String userName, int bikeID, double amountPaid){
        //ToDo: implement here
        if(sessionCount==sessions.length){
            System.out.println("No bikes available.");
            return;
        }
        if(amountPaid<ratePerHour){
            System.out.println("Insufficient payment for " + userName);
            return;
        }
        sessions[sessionCount] = new BikeRentalSession(userName,bikeID,amountPaid);
        sessionCount++;
        System.out.println(userName+ " successfully rented bike" + bikeID);
        //Use the print statements below
        //String userName, int bikeID, double amountPaid

        
    }
    


    public void stopRental(String userName){
        //ToDo: implement here
        

        int sameindexindicator = -1;
        
        for (int i = 0; i<sessionCount;i++) {
            if (sessions[i] != null && sessions[i].userName.equals(userName)) {
                sameindexindicator = i;
                break;
            }
        }   

        if (sameindexindicator==-1) {
            System.out.println("No active rental for "+ userName);
            return;

        }

        for (int i = sameindexindicator;i<sessionCount-1;i++){
            sessions[i] = sessions[i+1];
        }
       
        sessionCount--;



        //Use the print statements below
        System.out.println("Rental has ended for "+ userName);   
        
    }
    
    //Please do not modify this method
    public void displayRentals(){
        System.out.println("****Active Rentals****");
        for(int i=0; i<sessionCount; i++){
            if(sessions[i]!=null){
                sessions[i].show();
            }
        }
    }
    
    //Please do not modify this method
    public double getRatePerHour() {
        return ratePerHour;
    }

    //Please do not modify this method
    public BikeRentalSession[] getSessions() {
        return sessions.clone();
    }
    
    //Please do not modify this method
    public int getSessionCount() {
        return sessionCount;
    }
}
