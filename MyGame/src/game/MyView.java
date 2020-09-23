/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Color;
import static java.awt.Color.*;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * this class allows me to put in a background. it extends UserView
 */
public class MyView extends UserView {
    
    private Image background;
    private Game game;

    /**
     * initialises MyView
     * @param world
     * @param game
     * @param width
     * @param height
     */
    public MyView(World world, Game game, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/Background.png").getImage();
        this.game = game;
    }

    /**
     * paints the background
     * @param g
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }
    
    /**
     * paints the GUI
     * @param g
     */
    protected void paintForeground(Graphics2D g){
        g.setColor(YELLOW);
        g.setFont(new Font("Calibri", Font.BOLD, 25));
        g.drawString("Dragon Ball Count: " + game.getPlayer().getDragonBallCount(), 50, 50);
        g.drawString("Lives: " + game.getPlayer().getLifeCount(), 50, 100);
    }
}
