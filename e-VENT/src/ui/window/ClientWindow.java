package ui.window;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.ClientModel;
import ui.component.ClientViewer;

/**
 * 
 * @author Yumi Takuma
 */
public class ClientWindow extends JPanel{
    private JButton addClient, searchBtn;
    private JTextField searchField;
    private ClientViewer cv;
    
    public ClientWindow(ArrayList<ClientModel> cList) {
        this.setLayout(new BorderLayout());
        cv = new ClientViewer(cList);
        this.add(BorderLayout.CENTER, cv);
        
    }
}
