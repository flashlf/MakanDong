/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;

import javax.swing.JPanel;

/**
 *
 * @author REDHAT
 */
public class PanelGradient extends JPanel implements MouseListener{
    private boolean rounded;
    private boolean backgroundPainted;
    private boolean entered, pressed;
    private Color enteredColor, pressedColor;
    private Color gradientBackgroundColor;
    private int gradientFocus;
    
    public PanelGradient() {
        super();
        rounded = false;
        backgroundPainted = true;
        gradientBackgroundColor = getForeground();
        entered = false; pressed = false;
        gradientFocus = 100;
        enteredColor = getBackground().brighter();
        pressedColor = getBackground().darker();
        addMouseListener(this);
    }
    
    public void setRounded(boolean rounded) {
        this.rounded = rounded;
    }

    public void setBackgroundPainted(boolean backgroundPainted) {
        this.backgroundPainted = backgroundPainted;
    }

    public void setEnteredColor(Color enteredColor) {
        this.enteredColor = enteredColor;
    }

    public void setPressedColor(Color pressedColor) {
        this.pressedColor = pressedColor;
    }

    public void setGradientBackgroundColor(Color gradientBackgroundColor) {
        this.gradientBackgroundColor = gradientBackgroundColor;
    }
    
    
    private Color color() {
        Color temp = getBackground();
        if (!isEnabled()) {
            return new Color(204,204,204);
        }
        if(pressed) {
            return pressedColor;
        }
        if(entered) {
            return enteredColor;                
        }
        return temp;
    }
    
    @Override
    public void setBackground(Color color) {
        super.setBackground(color); //To change body of generated methods, choose Tools | Templates.
        enteredColor = color.brighter();
        pressedColor = color.darker();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        Shape s = (rounded) ? new RoundRectangle2D.Double(0, 0, getWidth() -2, getHeight() -2, getHeight() - 2 ,getHeight() - 2) :
                new Rectangle2D.Double(0, 0, getWidth(), getHeight());

        if (backgroundPainted || (pressed && !backgroundPainted)) {
            //if (gradientBackgroundColor == null) {
            //    g2.setColor(color());
            //} else {
                GradientPaint gPaint = new GradientPaint(0, 0, getBackground(), gradientFocus, getHeight(), gradientBackgroundColor);
                g2.setPaint(gPaint);
            //}
            g2.fill(s);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }
    
    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void setGradientFocus(int gradientFocus) {
        this.gradientFocus = gradientFocus;
    }
}
