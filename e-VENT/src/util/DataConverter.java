package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yumi Takuma
 */
public class DataConverter {
    public static Calendar resultToCalendar(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Calendar d =  Calendar.getInstance();
        
        try {
            d.setTime(sdf.parse(s));
        } catch (ParseException ex) {
            Logger.getLogger(DataConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return d;
    }
}
