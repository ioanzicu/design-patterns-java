package virtualproxy.state;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;

import virtualproxy.ImageProxy;

public class ImageLoaded implements State {
    ImageProxy imageProxy;
    ImageIcon imageIcon;

    public ImageLoaded(ImageProxy imageProxy) {
        this.imageProxy = imageProxy;
    }

    @Override
    public int getIconHeight() {
        imageIcon = imageProxy.getImageIcon();
        return imageIcon.getIconHeight();
    }

    @Override
    public int getIconWidth() {
        imageIcon = imageProxy.getImageIcon();
        return imageIcon.getIconWidth();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y, URL imageURL) {
        imageIcon = imageProxy.getImageIcon();
        imageIcon.paintIcon(c, g, x, y);
    }
}
