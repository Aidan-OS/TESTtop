package testtop;
/*
 *  TESTtop. Making a better TTS for a happier experience.
 */

import java.util.ArrayList;

/**
 * @version 0.1
 * @author Leone Shamoth
 */
public class Item 
{
    // TODO: When creating the items, only list the regular items and have the ability to chose a +x version of each item through code
    
    private String name;
    private boolean isMagic;
    
    private ArrayList<Attack> action;
    private int attackBonus;
    private int toHitBonus;
    
    private String description;
    private String properties;
    private double weight; //Weight in pounds
    
    private double cost; //Price is in gold
    
    
}
