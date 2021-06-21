

public class Ticket {

    private String name;
    
    private String dob;
    
    private String fromStation;
    
    private String toStation;
    
    private String ticketType;
    
    private String passengerType;
    
    private float fair;

    public Ticket() {
    }

    public Ticket(String name, String dob, String fromStation, String toStation, String ticketType, String passengerType, float fair) {
        this.name = name;
        this.dob = dob;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.ticketType = ticketType;
        this.passengerType = passengerType;
        this.fair = fair;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public float getFair() {
        return fair;
    }

    public void setFair(float fair) {
        this.fair = fair;
    }

    @Override
    public String toString() {
        return "Ticket{" + "name=" + name + ", dob=" + dob + ", fromStation=" + fromStation + ", toStation=" + toStation + ", ticketType=" + ticketType + ", passengerType=" + passengerType + ", fair=" + fair + '}';
    }
    
    
    
    
}
