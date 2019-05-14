package fr.unilim.iut.spaceinvaders.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import fr.unilim.iut.spaceinvaders.model.SpaceInvaders;
import fr.unilim.iut.spaceinvaders.model.Vaisseau;
import fr.unilim.iut.spaceinvaders.moteurjeu.*;

public class DessinSpaceInvaders implements DessinJeu {

	/**
	 * lien vers le jeu a afficher
	 */
	private SpaceInvaders spaceInvaders;

	public DessinSpaceInvaders(SpaceInvaders spaceInvaders) {
		this.spaceInvaders = spaceInvaders;
	}

	@Override
	public void dessiner(BufferedImage image) {
		// Pour avoir la position du vaisseau
		if (!this.spaceInvaders.etreFini()) {
			if (this.spaceInvaders.aUnVaisseau()) {
				Vaisseau vaisseau = this.spaceInvaders.recupererVaisseau();
				this.dessinerUnSprite(vaisseau, image, Color.gray);
			}
			if (this.spaceInvaders.aUnMissile()) {
				List<Missile> missiles = this.spaceInvaders.recupererMissiles();
				for (int i = 0; i < missiles.size(); i++) {
					this.dessinerUnSprite(missiles.get(i), image, Color.green);
				}
			}
			if (this.spaceInvaders.aUnEnvahisseur()) {
				List<Envahisseur> envahisseurs = this.spaceInvaders.recupererEnvahisseurs();
				for (int i = 0; i < envahisseurs.size(); i++) {
					this.dessinerUnSprite(envahisseurs.get(i), image,Color.red);
				}
			}
		} else {
			this.dessinerLeMessageDeFin(image);

		}
		this.dessinerLeScore(spaceInvaders.getScore(), image);
	}
	
	private void dessinerUnSprite(Sprite sprite, BufferedImage image, Color couleur) {
		Graphics2D crayon = (Graphics2D) image.getGraphics();

		crayon.setColor(couleur);
		crayon.fillRect(sprite.abscisseLaPlusAGauche(), sprite.ordonneeLaPlusBasse(), sprite.longueur(),
				sprite.hauteur());
	}

	private void dessinerLeScore(int score, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();

		crayon.setColor(Color.pink);
		crayon.scale(2.5, 2.5);
		crayon.drawString("Score : " + Integer.toString(spaceInvaders.getScore()), Constante.SCORE_POSITION_X,
				Constante.SCORE_POSITION_Y);
	}

	public void dessinerLeMessageDeFin(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();

		crayon.setColor(Color.black);
		crayon.drawString("Félicitations !", Constante.ESPACEJEU_LONGUEUR / 2, Constante.ESPACEJEU_HAUTEUR / 2);
	}

}
