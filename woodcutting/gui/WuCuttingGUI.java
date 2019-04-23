package main.java.wu.jeremy.woodcutting.gui;

import main.java.wu.jeremy.woodcutting.WuCutting;
import main.java.wu.jeremy.woodcutting.data.Location;
import main.java.wu.jeremy.woodcutting.data.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WuCuttingGUI extends JFrame {

    private JComboBox treeCombobox; //tree
    private JComboBox locationCombobox; //location
    private JButton initiate;


    public WuCuttingGUI() {
        super ("WuCutting Configuration");
        setLayout(new FlowLayout());

        initiate = new JButton("Go");
        treeCombobox = new JComboBox(Tree.values()); //Getting it to a new comobox, parsing all the tree
        locationCombobox = new JComboBox(Location.values());

        add(treeCombobox); //Ading it the GUI
        add(locationCombobox);
        add(initiate);

        setDefaultCloseOperation(HIDE_ON_CLOSE); //Don't use EIT_ON_CLOSE. This hide's the GUI when it is exited
        pack(); //Packs the size to match the components

        //changement combobox si qqchose change
        locationCombobox.addActionListener (new ActionListener() { //addActionListenenr, requires the parmeter Actionlisterner, create a new one
            @Override
            public void actionPerformed(ActionEvent e){ //Import the methods (alt + enter)
                Location location = (Location) locationCombobox.getSelectedItem(); //this method is gets he currently selected (after change) Location. it's an object so cast it
                //we also passed Location.value() (which are all Location not String for exemple) when orginally setting this method
                treeCombobox.setModel(new DefaultComboBoxModel(location.getTrees()));
            }
        });
        //bouton initialiser
        initiate.addActionListener (new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            WuCutting.location = (Location) locationCombobox.getSelectedItem();
            WuCutting.tree = (Tree) treeCombobox.getSelectedItem();
            setVisible(true);
            System.out.println("GUI : Bouton init");
            System.out.println("GUI : WuCitting.location : "+WuCutting.location);
            System.out.println("GUI : WuCitting.tree : "+WuCutting.tree);
            }
        });
        }

}
