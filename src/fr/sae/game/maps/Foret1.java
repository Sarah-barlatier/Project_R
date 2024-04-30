package fr.sae.game.maps;

import org.newdawn.slick.state.BasicGameState;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.sae.game.DialogueBox;
import fr.sae.game.EntityAnimations;
import fr.sae.game.Global;
import fr.sae.game.Warp;
import fr.sae.menus.MainMenu;
import fr.sae.menus.OptionMenu;
import fr.sae.menus.SetCharacterName;

public class Foret1 extends BasicGameState{
	
	Warp Warp1;
	Warp Warp2;
	DialogueBox dialogueBoxPanneau; 
	
	public Foret1(int stateID) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.Warp1= new Warp(Global.width-10, Global.height-320, 10, 320, 500, 500);
		this.Warp2= new Warp(1324, 0, 66, 10, 500, 500);
		
		this.dialogueBoxPanneau = new DialogueBox(new String[] {
				"\n" +
			    "  ^  \n" +
			    "  |         Montagne du Nord\n" +
			    "  |  \n",
			    "\n" +
			    "\n" +
			    " --->       Village\n"+
			    "\n"
			});		
		
		this.dialogueBoxPanneau.setTriggerZone(Global.width-530,570,66,10);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(new Image("data/maps/Map001.png").getScaledCopy(Global.width, Global.height), 0, 0);
        dialogueBoxPanneau.render(g);

        try {
	    	Global.P1.Sprite(g);
	    	Global.P1.getAnimation().stop();
	    	
        }catch(Exception e) {	
        	e.getMessage();
        	System.out.print(e);
        }
        
		this.Warp1.warp(Global.P1, sbg, 12);
		this.Warp2.warp(Global.P1, sbg, 13);

//--------------------------------------------------------------------------------------------------------------------------
	//Temp	    

	    //Affiche toutes les collisions de la map et du joueur
	    if (true) {
		    g.draw(Global.P1.getHitbox());
		    
		    Global.CollisionMapForet1.drawCollisions(g);
		    
		    this.dialogueBoxPanneau.draw(g);
		    this.Warp1.draw(g);
		    this.Warp2.draw(g);
	    	}
//--------------------------------------------------------------------------------------------------------------------------

		}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Global.updatePlayerMovement(gc.getInput(), Global.CollisionMapForet1);
		Global.P1.AnimateWhileMoove();
		
		this.dialogueBoxPanneau.dialogBox(gc.getInput());
		
		
	}

	@Override
	public int getID() {
		return 11;
	}

}
