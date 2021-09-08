import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import virtualproxy.ImageComponent;
import virtualproxy.ImageProxy;

public class ImageProxyTestDrive {
    ImageComponent imageComponent;
    JFrame frame = new JFrame("CD Cover Viewer");
    JMenuBar menuBar;
    JMenu menu;
    Hashtable<String, String> cds = new Hashtable<String, String>();

    public static void main (String[] args) throws Exception {
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }

    public ImageProxyTestDrive() throws Exception {
        
        cds.put("Beautiful and Colorful Tree", "https://w.wallhaven.cc/full/pk/wallhaven-pkw6y3.jpg");
        cds.put("Cyberpunk artwork", "https://w.wallhaven.cc/full/6o/wallhaven-6olw9x.jpg");
        cds.put("Contemporaneous Age City", "https://w.wallhaven.cc/full/72/wallhaven-7232p9.jpg");
        cds.put("Morning Mountain Panorama", "https://w.wallhaven.cc/full/lq/wallhaven-lqpv1l.jpg");
        
        URL initialUrl = new URL((String) cds.get("Beautiful and Colorful Tree"));
        
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite CDs");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        
        for (Enumeration<String> element = cds.keys(); element.hasMoreElements();) {
            String name = (String) element.nextElement();
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem);
            menuItem.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent event) {
                    imageComponent.setIcon(new ImageProxy(getCDUrl(event.getActionCommand())));
                    
                    System.out.println(event.getActionCommand());
                    
                    frame.repaint();
                }
                
            });
        }
        
        // set up frame and menus
        Icon icon = new ImageProxy(initialUrl);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    URL getCDUrl(String name) {
        try {
            return new URL((String) cds.get(name));
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
