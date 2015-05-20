package ui.window;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import ui.component.EventCalendar;

/**
 *
 * @author Yumi Takuma
 */
public class EventWindow extends JPanel{
    private EventCalendar calendar;
    private JButton test;
    private JScrollPane eventScroll;
    
    public EventWindow() {
        this.setLayout(new GridLayout(1, 2));
        calendar = new EventCalendar();
        this.add(calendar);
        
        test = new JButton("Test");
        this.add(test);
    }
}
