import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class Viagogo {

    private static DecimalFormat df2 = new DecimalFormat(".##");
    public static void main(String[] args) {



        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Point> buyers = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Plese enter how many events are to be included");
        int numberOfEvents = Integer.parseInt(sc.nextLine());





        // ID X Y tickets1 ticket2 ticket 3

        while(numberOfEvents >0) {
            System.out.println("Please enter details for event " + (numberOfEvents));

            String eventLine = sc.nextLine();
            String[] eventDetails = eventLine.split(" ");
            Event event = new Event(eventDetails);
            events.add(event);

            numberOfEvents--;
        }

        System.out.println("Please enter number of buyers");
        int numberofBuyers = Integer.parseInt(sc.nextLine());

        while(numberofBuyers > 0) {
            System.out.println("Please enter details for user " + (numberofBuyers - (numberofBuyers-1)));

            String buyerLine = sc.nextLine();
            String[] buyerDetails = buyerLine.split(" ");

            Point point = new Point(Integer.parseInt(buyerDetails[0]), Integer.parseInt(buyerDetails[1]));

            buyers.add(point);
            numberofBuyers--;
        }


        for(int i = 0; i<buyers.size(); i++) {
            int shortestDistance = getManhattanDistance(buyers.get(i), events.get(0).getPoint());
            int shortestEvent = 0;
            for(int j = 0; j<events.size(); j++) {

                int currentDistance = getManhattanDistance(buyers.get(i), events.get(0).getPoint());

                if(currentDistance < shortestDistance) {
                    shortestDistance = currentDistance;
                    shortestEvent = j;
                }

            }

            System.out.println("For buyer " + i);
            System.out.println("Shortest event is " + events.get(shortestEvent).getEventID());
            if(events.get(shortestEvent).getTickets().size() > 0) {
                double currentPrice = events.get(i).getTickets().get(0);
                int cheapest = 0;
                for (int k = 1; k < events.get(i).getTickets().size(); k++) {
                    double newPrice = events.get(i).getTickets().get(k);
                    if (newPrice < currentPrice) {
                        cheapest = k;
                    }
                }

                System.out.println("Cheapest ticket " + df2.format(events.get(i).getTickets().get(cheapest)));
                events.get(i).getTickets().remove(cheapest);
            } else {
                System.out.println("No tickets available");
            }
        }

    }
    

    private static void testData(ArrayList<Event> events, ArrayList<Point> buyers) {

        System.out.println("------Events-------");
        for(int i = 0; i<events.size(); i++ ) {
            System.out.println("Event ID: " + events.get(i).getEventID() + " ");
            for(int j = 0; j < events.get(i).getTickets().size(); j++) {
                System.out.println("ticket " + j + ": " + events.get(i).getTickets().get(j));

            }

            for(int k = 0; k< buyers.size(); k++ ) {
                System.out.println("Distance to user " + k + " " + getManhattanDistance(events.get(i).getPoint(), buyers.get(k)));
            }
        }

    }

    private static int getManhattanDistance(final Point eventPoint, final Point buyerPoint) {


        int distance;
        int userX = buyerPoint.getX();
        int userY = buyerPoint.getY();
        int eventX = eventPoint.getX();
        int eventY = eventPoint.getY();
        distance = Math.abs(userX - eventX) + Math.abs(userY - eventY);

        return distance;
    }


}


