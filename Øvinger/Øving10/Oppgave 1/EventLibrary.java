package Oving10.Oppgave1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EventLibrary {
    private ArrayList<Event> events;

    public EventLibrary(){
        events = new ArrayList<Event>();
    }

    public int numberOfEvents(){
        return events.size();

    }

    public void newEvent(String name, String place, String host, String type, long date){
        int id = events.size();
        Event event = new Event(id, name, place, host, type, date);
        events.add(event);
    }

    public ArrayList<Event> getPlaceEvents(String p){
        ArrayList<Event> placeEvents = new ArrayList<Event>();
        for (int i = 0; i < numberOfEvents(); i++){
            if (events.get(i).getPlace().equals(p)){
                placeEvents.add(events.get(i));
            }
        }
        return placeEvents;
    }

    public ArrayList<Event> getTimeEvents (long d){
        ArrayList<Event> timeEvents = new ArrayList<Event>();
        for (int i = 0; i < numberOfEvents(); i++){
            if (events.get(i).getDate() == d){
                 timeEvents.add(events.get(i));
            }
        }
        return timeEvents;
    }

    public ArrayList<Event> getTimeToTimeEvents(long d1, long d2) {
        ArrayList<Event> eventList = new ArrayList<Event>();
        for (int i = 0; i < numberOfEvents(); i++) {
            long eventTime = events.get(i).getDate();
            if (eventTime >= d1 && eventTime <= d2) {
                eventList.add(events.get(i));
            }
        }
        Comparator<Event> sorted = (Event o1,Event o2) -> (int) ((long)o1.getDate() - (long)o2.getDate());
        Collections.sort(eventList, sorted);
        return eventList;
    }

    public ArrayList<Event> listSortedByDate(){
        Comparator<Event> sorted = (Event o1,Event o2) -> (int) ((long)o1.getDate() - (long)o2.getDate());
        Collections.sort(events, sorted);
        return events;
    }


    public ArrayList<Event> listSortedByPlace(){
        Comparator<Event> sorted = (Event o1,Event o2) -> (o1.getPlace().compareTo(o2.getPlace()));
        Collections.sort(events, sorted);
        return events;
    }

    public ArrayList<Event> listSortedByType(){
        Comparator<Event> sorted = (Event o1,Event o2) -> (o1.getEventType().compareTo(o2.getEventType()));
        Collections.sort(events, sorted);
        return events;
    }
}
