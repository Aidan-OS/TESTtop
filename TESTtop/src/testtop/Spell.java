package testtop;

import java.util.ArrayList;

/*
 *  TESTtop. Making a better TTS for a happier experience.
 */



/**
 * @version 0.1
 * @author Leone Shamoth
 */
public class Spell
{
    private String castingTime;
    private String range;
    private String duration;
    
    private boolean[] components = new boolean [3]; //VSM
    private String materials;
    
    private String description;
    private String atHigherLevels;
    
    private boolean hasAttack;
    private Attack action;
    private int spellLevel;
    private boolean scaling;
    
    private ArrayList<DiceSet> higherLevelDamage;
    
    /**
     * Default constructor for objects of type spell
     */
    public Spell ()
    {
        this.castingTime = "1 Action";
        this.range = "Self";
        this.duration = "Instantaneous";
        
        this.components[0] = false;
        this.components[1] = false;
        this.components[2] = false;
        
        this.materials = "";
        
        this.description = "";
        this.atHigherLevels = "";
        
        this.hasAttack = false;
        this.action = new Attack ();
        this.spellLevel = 0;
        this.scaling = false;
        this.higherLevelDamage = new ArrayList<>();
    }
    
    /**
     * Constructor for a spell with no action
     * @param castingTime The spell's casting time
     * @param range The range of the spell
     * @param duration The duration of the spell
     * @param components The components for the spell
     * @param materials The materials used for the spell
     * @param description The spell's description
     * @param atHigherLevels The spell's affect at higher levels
     * @param spellLevel The spell's level
     * @param higherLevelDamage The damage done at higher level casting
     * @param scaling The amount of times the spell is to be cast
     */
    public Spell (String castingTime, String range, String duration, boolean[] components, String materials, String description, String atHigherLevels, int spellLevel, ArrayList<DiceSet> higherLevelDamage, boolean scaling)
    {
        this.castingTime = castingTime;
        this.range = range;
        this.duration = duration;
        
        this.components = components;
        this.materials = materials;
        
        this.description = description;
        this.atHigherLevels = atHigherLevels;
        
        this.hasAttack = false;
        this.action = new Attack ();
        this.spellLevel = spellLevel;
        this.scaling = scaling;
        this.higherLevelDamage = higherLevelDamage;
    }
    
    /**
    * Constructor for a spell with an action
     * @param castingTime The spell's casting time
     * @param range The range of the spell
     * @param duration The duration of the spell
     * @param components The components for the spell
     * @param materials The materials used for the spell
     * @param description The spell's description
     * @param atHigherLevels The spell's affect at higher levels
     * @param action The action that the spell causes
     * @param spellLevel The spell's level
     * @param higherLevelDamage The damage done at higher level casting
     * @param scaling The amount of times the spell is to be cast
     */
    public Spell (String castingTime, String range, String duration, boolean[] components, String materials, String description, String atHigherLevels, Attack action, int spellLevel, ArrayList<DiceSet> higherLevelDamage, boolean scaling)
    {
        this.castingTime = castingTime;
        this.range = range;
        this.duration = duration;
        
        this.components = components;
        this.materials = materials;
        
        this.description = description;
        this.atHigherLevels = atHigherLevels;
        
        this.hasAttack = true;
        this.action = action;
        this.spellLevel = spellLevel;
        this.higherLevelDamage = higherLevelDamage;
        
        this.scaling = scaling;
    }
    
    /////////////////////////////////////Getters and Setters/////////////////////////////
    
    public void setCastingTime (String castingTime)
    {
        this.castingTime = castingTime;
    }
    
    public String getCastingTime ()
    {
        return (this.castingTime);
    }
    
    public void setRange (String range)
    {
        this.range = range;
    }
    
    public String getRange ()
    {
        return (this.range);
    }
    
    public void setDuration (String duration)
    {
        this.duration = duration;
    }
    
    public String getDuration ()
    {
        return (this.duration);
    }
    
    public void setVocal (boolean vocal)
    {
        this.components[0] = vocal;
    }
    
    public boolean getVocal ()
    {
        return (this.components[0]);
    }
    
    public void setSomatic (boolean somatic)
    {
        this.components[1] = somatic;
    }
    
    public boolean getSomatic ()
    {
        return (this.components[1]);
    }
    
    public void setMaterial (boolean material)
    {
        this.components[2] = material;
    }
    
    public boolean getMaterial ()
    {
        return (this.components[2]);
    }
    
    public void setComponents (boolean[] components)
    {
        this.components = components;
    }
    
    public boolean[] getComponents ()
    {
        return (this.components);
    }
    
    public void setMaterials (String materials)
    {
        this.materials = materials;
    }
    
    public String getMaterials ()
    {
        return (this.materials);
    }
    
    public void setDescription (String description)
    {
        this.action.setDescription(description);
        this.description = description;
    }
    
    public String getDescription ()
    {
        return (this.description);
    }
    
    public void setHigherLevels (String atHigherLevels)
    {
        this.atHigherLevels = atHigherLevels;
    }
    
    public String getHigherLevels ()
    {
        return (this.atHigherLevels);
    }
    
    public void setHasAttack (boolean hasAttack)
    {
        this.hasAttack = hasAttack;
    }
    
    public boolean getHasAttack ()
    {
        return (this.hasAttack);
    }
    
    public void setAction (Attack action)
    {
        this.action = action;
    }
    
    public Attack getAction ()
    {
        return (this.action);
    }
    
    public void setSpellLevel (int spellLevel)
    {
        this.spellLevel = spellLevel;
    }
    
    public int getSpellLevel ()
    {
        return (this.spellLevel);
    }
    
    public void setscaling (boolean scaling)
    {
        this.scaling = scaling;
    }
    
    public boolean getscaling ()
    {
        return (this.scaling);
    }
    
    public void setHigherLevelDamage (ArrayList<DiceSet> higherLevelDamage)
    {
        this.higherLevelDamage = higherLevelDamage;
    }
    
    public ArrayList<DiceSet> getHigherLevelDamage()
    {
        return (this.higherLevelDamage);
    }
    
    public void addHigherDamageDie (DiceSet toAdd)
    {
        this.higherLevelDamage.add (toAdd);
    }
       
    //////////////////////////////////Utility Functions///////////////////////////////////
    
    /**
     * Returns the damage amount of the spell
     * @param level In case of a cantrip, the player level, in case of a spell, the level at which it is cast
     * @param damageModifier The damage modifier for the attack
     * @return Am optimized DamageSet of all damage dealt
     */
    public ArrayList<DamageSet> dealDamage (int level, int damageModifier)
    {
        if (hasAttack)
        {
            
            if (spellLevel == 0 && scaling) //Regular Cantrip
            {
                ArrayList<DamageSet> damage = action.rollAttack(damageModifier);
                        
                if (level >= 17)
                {
                    for (int i = 0; i < 3; i++)
                    {
                        ArrayList<DamageSet> temp = action.rollAttack (damageModifier);
                        
                        for (DamageSet toMerge : temp)
                        {
                            damage.get(damage.indexOf(toMerge)).merge(toMerge); //Merges the damages
                        }
                    }
                }
            
                else if (level >= 11)
                {
                    for (int i = 0; i < 2; i++)
                    {
                        ArrayList<DamageSet> temp = action.rollAttack (damageModifier);
                        
                        for (DamageSet toMerge : temp)
                        {
                            damage.get(damage.indexOf(toMerge)).merge(toMerge); //Merges the damages
                        }
                    }
                }
            
                else if (level >= 5)
                {
                    ArrayList<DamageSet> temp = action.rollAttack (damageModifier);
                        
                    for (DamageSet toMerge : temp)
                    {
                        damage.get(damage.indexOf(toMerge)).merge(toMerge); //Merges the damages
                    }
                }
                
                return (damage);
            }
        
            else if (spellLevel == 0) //non scaling Cantrip
            {
                return (action.rollAttack(damageModifier));
            }
            
            else //Normal spellcast
            {
                ArrayList<DamageSet> baseDamage = action.rollAttack (damageModifier);
                
                if (scaling)
                {
                    for (int i = level; i < this.spellLevel; i++)
                    {
                        ArrayList<DamageSet> scaledDamageTemp = Attack.rollAttack (0, higherLevelDamage);
                        
                        for (DamageSet toMerge : scaledDamageTemp)
                        {
                            baseDamage.get(baseDamage.indexOf(toMerge)).merge(toMerge); //Merges the damages
                        }
                    }
                }                
                return (baseDamage);
            }
        }
        
        return (null);
    }
}
