package main.java.wu.jeremy.woodcutting.impl;

import main.java.wu.jeremy.woodcutting.WuCutting;
import main.java.wu.jeremy.woodcutting.data.Location;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;




public class Traverse extends Task {
    @Override
    public boolean validate (){
       // return traverseToBank() || traverseToTrees();
        return true;
    }

    @Override
    public int execute (){
       // Movement.walkTo(traverseToBank() ? WuCutting.BANK_AREA.getCenter() : WuCutting.TREE_AREA.getCenter());
        return 300;
    }

    private boolean traverseToBank() {
      //  return Inventory.isFull() && !WuCutting.location.getBankArea().contains(Players.getLocal()) && !WuCutting.location.equals(Location.POWERCUT);
    return true;
    }

    private boolean traverseToTrees() {
       // return !Inventory.isFull() && !WuCutting.TREE_AREA.contains(Players.getLocal());
    return true;
    }

}
