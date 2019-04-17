package fr.unilim.iut.spaceinvaders.moteurjeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * classe qui represente un controleur en lien avec un KeyListener
 * 
 * @author vthomas
 * 
 */
public class Controleur implements KeyListener {

	/**
	 * commande en cours
	 */
	private Commande commandeEnCours;
	/**
	 * commande a retourner la difference avec la commandeencours vient du fait
	 * qu'on veut memoriser une touche appuyee
	 */
	private  Commande commandeARetourner;

	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public Controleur() {
		this.commandeEnCours = new Commande();
		this.commandeARetourner = new Commande();
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Commande getCommande() {
		Commande aRetourner = this.commandeARetourner;
		this.commandeARetourner = new Commande(this.commandeEnCours);
		return (aRetourner);
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_Q:
			this.commandeEnCours.gauche = true;
			this.commandeARetourner.gauche = true;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			this.commandeEnCours.droite = true;
			this.commandeARetourner.droite = true;
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_Z:
			this.commandeEnCours.haut = true;
			this.commandeARetourner.haut = true;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			this.commandeEnCours.bas = true;
			this.commandeARetourner.bas = true;
			break;
		default:
			break;
		}

	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_Q:
			this.commandeEnCours.gauche = false;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			this.commandeEnCours.droite = false;
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_Z:
			this.commandeEnCours.haut = false;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			this.commandeEnCours.bas = false;
			break;
		default: break;
		}

	}

	@Override
	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}

}
