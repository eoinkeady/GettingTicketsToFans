import java.util.ArrayList;


public class Event {

    private int eventID;
    private ArrayList<Integer> tickets;
    private int distance;
    private Point point;

    public Event(String[] eventDetails) {

        setEventID(Integer.parseInt(eventDetails[0]));
        Point point = new Point(Integer.parseInt(eventDetails[1]), Integer.parseInt(eventDetails[2]));
        setPoint(point);

       this.tickets = new ArrayList<>();
        for(int i = 3; i < eventDetails.length; i++) {
            tickets.add(Integer.parseInt(eventDetails[i]));
        }
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public ArrayList<Integer> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Integer> tickets) {
        this.tickets = tickets;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }




}
