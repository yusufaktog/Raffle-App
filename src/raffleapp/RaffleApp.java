
package raffleapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


 
public class RaffleApp {
    
    private final ArrayList<Attendee> attendees;
    private ArrayList<Attendee> namePool;
    

    public RaffleApp() {
        attendees = new ArrayList<>();
        namePool = new ArrayList<>();
    }
    
    // To see the effect of shuffling the name pool on the winning chances of the participants
   /* private void drawRaffleUnshuffled(int winnerNumber){ // draws the raffle without shuffle
        createAttendees(100);
        for (int i = 0; i < attendees.size(); i++) {
            for (int j = 0; j < attendees.get(i).getNumberOfTickets(); j++) {
                    namePool.add(attendees.get(i));
            }            
        }
        
        for (int i = 0; i < winnerNumber; i++) {
            Attendee attendee  = namePool.get(new Random().nextInt(namePool.size()));
            attendee.setPrizeNumber(attendee.getPrizeNumber()+1);
            
                      
        }
        showWinners();
    } */
    public void drawRaffleMultiplePrize(int winnerNumber){ // first shuffles the pool then draws the raflle
        for (int i = 0; i < attendees.size(); i++) { // Each attendee's name is added to pool as much as the number of tickets
            for (int j = 0; j < attendees.get(i).getNumberOfTickets(); j++) {
                    namePool.add(attendees.get(i));
            }            
        }
        
        Collections.shuffle(namePool); // pool shuffled 
        
        for (int i = 0; i < winnerNumber; i++) { // Raflle is being drawn
            
            Attendee attendee  = namePool.get(ThreadLocalRandom.current().nextInt(namePool.size()));
            attendee.setPrizeNumber(attendee.getPrizeNumber()+1);            
                      
        }
        
    }
    public void drawRaffleSinglePrize(int winnerNumber){ // first shuffles the pool then draws the raflle
        for (int i = 0; i < attendees.size(); i++) { // Each attendee's name is added to pool as much as the number of tickets
            for (int j = 0; j < attendees.get(i).getNumberOfTickets(); j++) {
                    namePool.add(attendees.get(i));
            }            
        }
        
        Collections.shuffle(namePool); // pool shuffled 
        
        for (int i = 0; i < winnerNumber; i++) { // Raflle is being drawn
            
            Attendee attendee  = namePool.get(ThreadLocalRandom.current().nextInt(namePool.size()));
            attendee.setPrizeNumber(attendee.getPrizeNumber()+1);
            deleteElement(attendee);
                      
        }
        
    }
    void deleteElement(Attendee attendee){
        ArrayList<Attendee> temp = new ArrayList<>();
        
        for(int i = 0; i < namePool.size(); i++) {
            if(namePool.get(i).getName().equals(attendee.getName()))
                temp.add( namePool.get(i) );

        }
        namePool.removeAll(temp);
        
    }
    
    public ArrayList<Attendee> getWinners(){
        ArrayList<Attendee> winners = new ArrayList<>();
        for (int i = 0; i < attendees.size(); i++) {
            if(attendees.get(i).getPrizeNumber() != 0){
                winners.add(attendees.get(i));
                
            }
        }
        return winners;
    }

    public ArrayList<Attendee> getAttendees() {
        return attendees;
    }

    public ArrayList<Attendee> getNamePool() {
        return namePool;
    }
    void createRandomAttendees(int attendeeNumber){ // testing purpose
        for (int i = 0; i < attendeeNumber; i++) {
            attendees.add( new Attendee(String.valueOf(i)+".Attendee",(i+1)%10));
            
        }
    }

    void createAttendee(String name,int numberOfTickets){
        attendees.add(new Attendee(name,numberOfTickets));        
    }
    
    /*
    public static void main(String[] args) { // Testing Purposes
        RaffleApp newRaffle = new RaffleApp();               
        //newRaffle.drawRaffleUnshuffled(1000);
        newRaffle.drawRaffleShuffled(1000);
       
    } */    
}