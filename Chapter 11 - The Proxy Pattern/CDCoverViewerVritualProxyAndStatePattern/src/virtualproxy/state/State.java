package virtualproxy.state;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

public interface State {
    public int getIconHeight();
    public int getIconWidth();  
    public void paintIcon(Component c, Graphics g, int x, int y, URL imageURL);  
}
