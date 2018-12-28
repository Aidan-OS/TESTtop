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
    
    public Item ()
    {
        this.name = "";
        this.isMagic = false;
        
        this.action = new ArrayList<>();
        this.attackBonus = 0;
        this.toHitBonus = 0;
        
        this.description = "";
        this.properties = "";
        this.weight = 0;
        
        this.cost = 0.00;
    }
    
    public Item (String name, boolean isMagic, int attackBonus, int toHitBonus, String description, String properties, int weight, double cost)
    {
        this.name = name;
        this.isMagic = isMagic;
        
        this.action = new ArrayList<>();
        this.attackBonus = attackBonus;
        this.toHitBonus = toHitBonus;
        
        this.description = description;
        this.properties = properties;
        this.weight = weight;
        
        this.cost = cost;
    }
    
    public Item (String name, boolean isMagic, int attackBonus, int toHitBonus, String description, String properties, double weight, double cost, ArrayList<Attack> action)
    {
        this.name = name;
        this.isMagic = isMagic;
        
        this.action = action;
        this.attackBonus = attackBonus;
        this.toHitBonus = toHitBonus;
        
        this.description = description;
        this.properties = properties;
        this.weight = weight;
        
        this.cost = cost;
    }
    
    /////////////////////////////////////////////////////////////Getters and Setters/////////////////////////////////
    
    public void setName (String name)
    {
        this.name = name;
    }
    
    public String getName ()
    {
        return (this.name);
    }
    
    public void setIsMagic (boolean isMagic)
    {
        this.isMagic = isMagic;
    }
    
    public boolean getIsMagic ()
    {
        return (this.isMagic);
    }
    
    public void setAttackBonus (int attackBonus)
    {
        this.attackBonus = attackBonus;
    }
    
    public int getAttackBonus ()
    {
        return (this.attackBonus);
    }
    
    public void setToHitBonus (int toHitBonus)
    {
        this.toHitBonus = toHitBonus;
    }
    
    public int getToHitBonus ()
    {
        return (this.toHitBonus);
    }
    
    public void setDescription (String description)
    {
        this.description = description;
    }
    
    public String getDescription ()
    {
        return (this.description);
    }
    
    public void setProperties (String properties)
    {
        this.properties = properties;
    }
    
    public String getProperties ()
    {
        return (this.properties);
    }
    
    public void setWeight (double weight)
    {
        this.weight = weight;
    }
    
    public double getWeight ()
    {
        return (this.weight);
    }
    
    public void setCost (double cost)
    {
        this.cost = cost;
    }
    
    public double getCost ()
    {
        return (this.cost);
    }
    
    public void setAction (ArrayList<Attack> action)
    {
        this.action = action;
    }
    
    public ArrayList<Attack> getAction ()
    {
        return (this.action);
    }
    
    public void addAction (Attack toAdd)
    {
        action.add (toAdd);
    }
    
    /////////////////////////////////////////////Utility Functions////////////////////////
    
    public ArrayList<DamageSet> rollDamage (int damageModifier)
    {
        // TODO Fill this in
    }
}
