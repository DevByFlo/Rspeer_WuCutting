package main.java.wu.jeremy.woodcutting;

import org.rspeer.script.ScriptMeta;
import org.rspeer.script.ScriptCategory;
import org.rspeer.script.task.Task;
import org.rspeer.script.task.TaskScript;
import main.java.wu.jeremy.woodcutting.data.Location;
import main.java.wu.jeremy.woodcutting.data.Tree;
import main.java.wu.jeremy.woodcutting.impl.Banking;
import main.java.wu.jeremy.woodcutting.impl.Drop;
import main.java.wu.jeremy.woodcutting.impl.Traverse;
import main.java.wu.jeremy.woodcutting.impl.Woodcut;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.event.listeners.RenderListener;
import org.rspeer.runetek.event.types.RenderEvent;

import main.java.wu.jeremy.woodcutting.gui.WuCuttingGUI;

import java.awt.*;

@ScriptMeta(name = "WuCtting Name",  desc = "Script description", developer = "Jeremy", category = ScriptCategory.WOODCUTTING)
public class WuCutting extends TaskScript implements RenderListener {

private static final Task[] TASKS = { new Woodcut() };
//new Banking(), new Drop(), new Traverse(),
public static Location location;
public static Tree tree;

    //TEMP
    public static boolean dropLogs = false;
   /* public static final Area BANK_AREA = Area.rectangular(null,null);
    public static final Area TREE_AREA = Area.rectangular(null,null);

    public static String logName ="";
    public static String treeName ="";*/


    @Override
    public void onStart() {
        //When the script is first started the segment of code in this method will be ran once.
       submit(TASKS);
        new WuCuttingGUI().setVisible(true);
    }

    /*@Override
    public int loop() {
        //Code in here starting from the top-down will be ran and repeated.
        Player local = Players.getLocal();
        if (!local.isMoving() && !local.isAnimating()) {
            if (Inventory.isFull()){
                if (dropLogs){
                    for (Item log : Inventory.getItems(item -> item.getName().equals(logName))) {
                        log.interact(DROP_ACTION);
                        Time.sleep(300);
                    }
                } else {
                    if (BANK_AREA.contains(local)) {
                        // Bank logs
                        if (Bank.isOpen()) {
                            Bank.depositAllExcept(AXE_PREDICATE);
                        } else {
                            // OPEN BANK
                        }
                    } else {
                        // Walk to bank
                        Movement.walkTo(BANK_AREA.getCenter());
                    }
                 }
            } else {
                if (TREE_AREA.contains(local)){
                    // CUT TREE
                    final SceneObject tree = SceneObjects.getNearest(treeName);
                    if (tree !=NULL){
                        tree.interact(CUT_ACTION);
                    }
                } else {
                    // Walk TO TREE
                    Movement.walkTo(TREE_AREA.getCenter());
                }
            }


        }
        return 0; // The rate of repeat is defined by the returning int, this number represents milliseconds. 1000ms = 1 second.
    }

     */

    @Override
    public void onStop() {
        //When the script is stopped the segment of code in this method will be ran once.
    }

    @Override
    public void notify(RenderEvent renderEvent) {
        Graphics g =renderEvent.getSource();
        g.drawString("String",-1,-1);
        g.drawRect(-1,-1,-1,-1);
        g.drawImage(null,-1,-1,null);
    }

}