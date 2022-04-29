package controller;

import controller.player.PlayerActions;
import controller.menu.MenuActions;
import controller.battle.BattleCharger;
import controller.battle.BattleActions;
import controller.menu.MenuCharger;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import gui.elements.Base;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Orchestrator implements KeyListener, WindowFocusListener, Base{

    public enum ObjectTC{
        player,
        menu, 
        battle
    }
    
    private ObjectTC otc;
    public Actions actions = null;
    public Charger charger = null;

    public void chargeController()throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        switch (otc) {
            case player -> {
                actions = new PlayerActions();
            }
            case menu -> {
                actions = new MenuActions();
                charger = new MenuCharger();
            }
            case battle -> {
                actions = new BattleActions();
                charger = new BattleCharger();
            }
        }
        
        if (charger != null) {
            charger.charge();
        }
    }
    
    public void setOtc(ObjectTC otc) {this.otc = otc;}
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("controller.Orchestrator.keyPressed()");
        int codeKey = e.getKeyCode();

        if (!KeyPressedList.contains(codeKey)) {
            KeyPressedList.add(codeKey);
        }
        
        actions.KeyisPressed();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        KeyPressedList.remove((Object) e.getKeyCode());
        
        actions.KeyisPressed();
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {}

    @Override
    public void windowLostFocus(WindowEvent e) {
        System.out.println("controller.Orchestrator.windowLostFocus()");
        KeyPressedList.clear();
    }
}