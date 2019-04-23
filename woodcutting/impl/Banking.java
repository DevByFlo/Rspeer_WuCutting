package main.java.wu.jeremy.woodcutting.impl;

import main.java.wu.jeremy.woodcutting.WuCutting;
import org.rspeer.runetek.adapter.component.Item;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;

import java.util.function.Predicate;

public class Banking extends Task {
    private static final Predicate<Item> AXE_PREDICATE = item -> item.getName().contains("axe");

    @Override
    public  boolean validate() {
       return (WuCutting.tree !=null && WuCutting.location !=null) && Inventory.isFull() && WuCutting.location.getBankArea().contains(Players.getLocal());
    }
    @Override
    public int execute() {
        if (Bank.isOpen()){
            Bank.depositAllExcept(AXE_PREDICATE);
        }
        else {
            //open bank
        }
        return 300;
    }
}

