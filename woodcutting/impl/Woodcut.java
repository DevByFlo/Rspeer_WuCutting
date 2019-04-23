package main.java.wu.jeremy.woodcutting.impl;

import main.java.wu.jeremy.woodcutting.WuCutting;
import main.java.wu.jeremy.woodcutting.data.Location;
import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.task.Task;


public class Woodcut extends Task {

    private static final String CUT_ACTION = "Chop down";

    @Override
    public boolean validate() {
        System.out.println("Woodcut : Bouton init");
        System.out.println("Woodcut : WuCitting.location : "+WuCutting.location);
        System.out.println("Woodcut : WuCitting.tree : "+WuCutting.tree);
        return (WuCutting.tree!=null && WuCutting.location != null) && !Inventory.isFull() && WuCutting.location.getTreeArea().contains(Players.getLocal());
    }

    @Override
    public int execute() {
        final SceneObject tree = SceneObjects.getNearest(WuCutting.tree.getName());
        if (tree != null) {
            tree.interact(CUT_ACTION);
        }
        return 300;
    }
}