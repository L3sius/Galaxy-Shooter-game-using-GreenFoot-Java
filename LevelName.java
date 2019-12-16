import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelName here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelName extends Actor
{
    public LevelName(String text) 
    {
        GreenfootImage img = new GreenfootImage (text,34,greenfoot.Color.RED , new Color(0,0,0,0));
       // img.drawString(text, 50,20);
       // setImage(new GreenfootImage (text.length()*20,30), 24, greenfoot.Color.RED , new Color(0,0,0,0));
        setImage(img);
    }
    /**
     * Act - do whatever the LevelName wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      
    } 
    
}
