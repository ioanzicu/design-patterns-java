package virtualproxy.state;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;

import virtualproxy.ImageProxy;

public class ImageNotLoaded implements State {
    ImageProxy imageProxy;
    boolean retrieving = false;
    Thread retrievalThread;

    public ImageNotLoaded(ImageProxy imageProxy) {
        this.imageProxy = imageProxy;
    }

    @Override
    public int getIconHeight() {
        return 600;
    }

    @Override
    public int getIconWidth() {
        return 800;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y, URL imageURL) {
        g.drawString("Loading CD cover, please wait...", x+300, y+190); 
        if (!retrieving) {
            retrieving = true;
            retrievalThread = new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        ImageIcon imageIcon = new ImageIcon(imageURL, "CD Cover");
                        imageProxy.setImageIcon(imageIcon);

                        // Image loaded, Transition to ImageLoaded state
                        State hasImageState = imageProxy.getHasImageState();
                        imageProxy.setState(hasImageState);

                        c.repaint();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } 
            });
            
            retrievalThread.start();
        }
    }
}
