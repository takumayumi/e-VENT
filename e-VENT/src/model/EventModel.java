package model;

import java.util.Calendar;

/**
 *
 * @author Yumi Takuma
 */
public class EventModel {
    Calendar date;    
    int id;
    
    public EventModel(int id , Calendar date) {
        this.id = id;
        this.date = date;
    }

    public Calendar getCalendar() {
        return date;
    }

    public void setCalendar(Calendar date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
