package testtop;

import java.util.ArrayList;

/*
 *  TESTtop. Making a better TTS for a happier experience.
 */

/**
 * @version 0.1
 * @author Leone Shamoth
 */

public class Attack
{
    private boolean isSave;
    private boolean isAttackRoll;
    private ArrayList<DiceSet> dice;
    
    private String description;
    private boolean descriptionOn;
    
    private String saveEffect;
    private String saveType;
    
    private String distance;
    private int longDistance;
    private String area;
    private boolean isAOE;
    
    /**
     * The blank constructor for attacks
     */
    public Attack ()
    {
        this.isSave = false;
        this.isAttackRoll = true;
        
        this.description = "";
        this.descriptionOn = false;
        
        this.saveEffect = "";
        this.saveType = "STRENGTH";
        
        this.distance = "5";
        this.longDistance = 0;
        this.area = "";
        this.isAOE = false;
        dice = new ArrayList<>();
    }
    
    /**
     * Full constructor for attacks
     * @param isSave Does the attack have a save component
     * @param isAttackRoll Does the attack have an attack roll
     * @param description The attacks description
     * @param descriptionOn If the description should be displayed on an attack
     * @param saveEffect The affect that occurs on a successful saving throw
     * @param saveType
     * @param distance The distance the attack can reach
     * @param longDistance The long distance (for disadvantage)
     * @param area The Area of effect
     * @param isAOE If the ability is an area of effect
     * @param dice The dice for damage, as well as the damage types
     */
    public Attack (boolean isSave, boolean isAttackRoll, String description, boolean descriptionOn, String saveEffect, String saveType, String distance, int longDistance, String area, boolean isAOE, ArrayList<DiceSet>dice)
    {
        this.isSave = isSave;
        this.isAttackRoll = isAttackRoll;
        
        this.description = description;
        this.descriptionOn = descriptionOn;
        
        this.saveEffect = saveEffect;
        this.saveType = saveType;
        
        this.distance = distance;
        this.longDistance = longDistance;
        this.area = area;
        this.isAOE = isAOE;
        
        this.dice = dice;
    }
 
///////////////////////////////////////GETTERS AND SETTERS//////////////////////////////
    public void setSave (boolean isSave)
    {
        this.isSave = isSave;
    }
    
    public boolean getSave ()
    {
        return (this.isSave);
    }
    
    public void setIsAttackRoll (boolean isAttackRoll)
    {
        this.isAttackRoll = isAttackRoll;
    }
    
    public boolean getIsAttackRoll ()
    {
        return (this.isAttackRoll);
    }
    
    public void setDescription (String description)
    {
        this.description = description;
    }
    
    public String getDescription ()
    {
        return (this.description);
    }
    
    public void setDescriptionDisplay (boolean descriptionOn)
    {
        this.descriptionOn = descriptionOn;
    }
    
    public boolean getDescriptionDisplay ()
    {
        return (this.descriptionOn);
    }
    
    public void setSaveEffect (String saveEffect)
    {
        this.saveEffect = saveEffect;
    }
    
    public String getSaveEffect ()
    {
        return (this.saveEffect);
    }
    
    public void setSaveType (String saveType)
    {
        this.saveType = saveType;
    }
    
    public String getSaveType ()
    {
        return (this.saveType);
    }
    
    public void setDistance (String distance)
    {
        this.distance = distance;
    }
    
    public String getDistance ()
    {
        return (this.distance);
    }
    
    public void setLongDistance (int longDistance)
    {
        this.longDistance = longDistance;
    }
    
    public int getLongDistance ()
    {
        return (this.longDistance);
    }
    
    public void setDice (ArrayList<DiceSet> dice)
    {
        this.dice = dice;
    }
    
    public ArrayList<DiceSet> getDice ()
    {
        return (this.dice);
    }
    
    /////////////////////////////////////////////////////////Utility Functions///////////////////////////////////////////////
    
    public void addDie (String type, int die, int count)
    {   
        dice.add(new DiceSet (type, die, count));
    }
    
    public ArrayList<DamageSet> rollAttack (int damageModifier)
    {
        ArrayList<DamageSet> damage = new ArrayList<>();
        
        for (DiceSet current : dice)
        {
            DamageSet toAdd = new DamageSet(current.getDamageType(), current.rollDamage(damageModifier));
            
            boolean didMerge = false;
            
            for (DamageSet merging : damage)
            {
                if (merging.merge(toAdd))
                {
                    didMerge = true;
                }
            }
            
            if (!didMerge)
            {
                damage.add (toAdd);
            }
        }
        
        return (damage);
    }
    
    public static ArrayList<DamageSet> rollAttack (int damageModifier, ArrayList<DiceSet> dice)
    {
        ArrayList<DamageSet> damage = new ArrayList<>();
        
        for (DiceSet current : dice)
        {
            DamageSet toAdd = new DamageSet(current.getDamageType(), current.rollDamage(damageModifier));
            
            boolean didMerge = false;
            
            for (DamageSet merging : damage)
            {
                if (merging.merge(toAdd))
                {
                    didMerge = true;
                }
            }
            
            if (!didMerge)
            {
                damage.add (toAdd);
            }
        }
        
        return (damage);
    }
}
