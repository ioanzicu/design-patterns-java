package virtualproxy;
import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon; 
import javax.swing.Icon;

import virtualproxy.state.ImageLoaded;
import virtualproxy.state.ImageNotLoaded;
import virtualproxy.state.State;

public class ImageProxy implements Icon {
    ImageIcon imageIcon;
    URL imageURL;
    
    State noImageState;
    State hasImageState;
    State state;

    public ImageProxy(URL url) { 
        hasImageState = new ImageLoaded(this);
        noImageState = new ImageNotLoaded(this);
        
        this.imageURL = url; 
        // should be initialized in the constructor
        // or NullPointerException will be thrown (this is how SWING works)
        this.state = noImageState; 
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        state.paintIcon(c, g, x, y, imageURL);
    }

    @Override
    public int getIconWidth() {
        return state.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return state.getIconHeight();
    }
    
    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public State getNoImageState() {
        return noImageState;
    }

    public State getHasImageState() {
        return hasImageState;
    }
}
