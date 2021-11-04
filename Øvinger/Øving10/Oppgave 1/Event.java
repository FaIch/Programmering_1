package Oving10.Oppgave1;

public class Event {
    private int id;
    private String eventName;
    private String place;
    private String host;
    private String eventType;
    private long date;

    public Event (int id, String eventName, String place, String host, String eventType, long date){
        this.id = id;
        this.eventName = eventName;
        this.place = place;
        this.host = host;
        this.eventType = eventType;
        this.date = date;
    }

    public long getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public String getHost() {
        return host;
    }

    public String getPlace() {
        return place;
    }

    public String toString(){
        String t = String.valueOf(this.getDate());
        String time = t.substring(6, 8) + "." + t.substring(4, 6) + "." + t.substring(0, 4) + " kl. " + t.substring(8, 10) + ":" + t.substring(10, 12);
        return "Id: " + this.getId() + ", navn på arrangement: " + this.getEventName() + ", sted: " + this.getPlace() + ", arrangør: " +
                this.getHost() + ", type arrangement: " + this.getEventType() + ", tidspunkt: " + time;
    }
}
