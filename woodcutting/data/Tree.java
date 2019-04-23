package main.java.wu.jeremy.woodcutting.data;

import org.rspeer.runetek.api.component.tab.Skill;
import org.rspeer.runetek.api.component.tab.Skills;

public enum Tree {

    REGULAR("Tree","Logs",1),
    OAK("Oak", "Oak Logs", 15),
    WILLOW("Willow", "Willow logs", 30),
    MAPLE("Maple", "Maple logs", 45),
    YEW("Yew", "Yew logs", 60),
    MAGIC("Magic", "Magic logs", 75);


    private final String name, logName;
    private final int requiredLevel;

    Tree(final String name, final String logName, final int requiredLevel){
        this.name = name;
        this.logName = logName;
        this.requiredLevel = requiredLevel;
    }

    public String getName() {return name;}
    public String getLogName() {return logName;}
    public int getRequiredLevel() {return requiredLevel;}
    public boolean isAccessible() {
        return Skills.getCurrentLevel(Skill.WOODCUTTING) >= requiredLevel;
    }


}
