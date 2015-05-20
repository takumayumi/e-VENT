package ui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import model.ClientModel;

/**
 * 
 * @author Yumi Takuma
 */
public class ClientViewer extends JPanel {

    private JScrollPane clientScroll;
    private JPanel clientPane;
    private ArrayList<ClientModel> cList;
    private int row;
    private int trigger = -1;
    ArrayList<ClientIcon> clients = new ArrayList<>();
    
    public ClientViewer(ArrayList<ClientModel> cList) {
        this.setLayout(new BorderLayout());
        this.cList = cList;
        row = cList.size() / 4;
        this.clientScroll = new JScrollPane(clientPane);
        this.clientPane = new JPanel(new GridLayout(row, 4));
        

        for (ClientModel cm : cList) {
            clients.add(new ClientIcon(cm.getId(), cm.getFirst() + " " + cm.getLastname()));
        }
        
        for(int i = 0; i<clients.size(); i++) {
            clientPane.add(clients.get(i));
        }
        this.add(BorderLayout.CENTER, clientPane);
        
    }

    public class ClientIcon extends JPanel {

        private int id;
        private Image pic;
        private JLabel name;
        private boolean selected;

        public ClientIcon(int id, String name) {
            this.setLayout(new BorderLayout());
            this.id = id;
            this.name = new JLabel(name);
            selected = false;
            this.setPreferredSize(new Dimension(100, 100));

            try {
                File fileName = new File("src/res/photos/" + id + ".png");
                if(fileName.exists()){
                    pic = ImageIO.read(new File("src/res/photos/" + id + ".png"));
                    this.repaint();
                } else {
                    pic = ImageIO.read(new File("src/res/images/user.png"));
                    this.repaint();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            this.add(BorderLayout.SOUTH, this.name);

            this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    selectClient();
                }

                @Override
                public void mousePressed(java.awt.event.MouseEvent e) {
                }

                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) {

                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {

                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    //not supported
                }
            });
        }

        private int selectClient() {
            this.setBorder(new LineBorder(Color.BLUE, 3, true));
            selected = true;
            
            return id;
        }
        
        Graphics2D gSettings;
        public void Paint(Graphics g) {
            gSettings = (Graphics2D)g;
            gSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            
            gSettings.drawImage(this.pic, 0, 0, null);
        }
    }

}
