
package raffleapp;

/**
 *
 * @author joseph
 */
public class Attendee {
    
    private int numberOfTickets,prizeNumber; // Each attendee can won more than one prize and has a ticket number that increases the chance of winning
    private String name;
    
    public Attendee(String name , int numberOfTickets) {
        this.name = name;
        this.numberOfTickets = numberOfTickets;
        prizeNumber = 0;
        
    }
    

    public int getPrizeNumber() {
        return prizeNumber;
    }

    public void setPrizeNumber(int prizeNumber) {
        this.prizeNumber = prizeNumber;
    }
    

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}