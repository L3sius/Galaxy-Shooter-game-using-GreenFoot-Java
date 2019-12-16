import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int score = 0;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void Counter() 
    {
        setImage(new GreenfootImage("Score : " + score, 24, greenfoot.Color.RED , new Color(0,0,0,0)));
    }    
    public void act() 
    {
        setImage(new GreenfootImage("Score : " + score, 24, greenfoot.Color.RED , new Color(0,0,0,0)));
    }    
    public void addScore()
    {
        score++;
    }
}
