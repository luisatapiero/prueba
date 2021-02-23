import java.util.ArrayList;
import java.util.Iterator;

import processing.core.PApplet;

public class Main extends PApplet {

	private Cuadrados cuadradito;
	private ArrayList<Cuadrados> listaSqr;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	@Override
	public void settings() {
		size(500, 500);
	}

	@Override
	public void setup() {
		listaSqr = new ArrayList<Cuadrados>();
		rectMode(CENTER);
		frameRate(60);

	}

	@Override
	public void draw() {
		background(36, 30, 78);
		initSqr();
		drawSqr();
		reboteBorde();
		eliminarSqr();

	}

	public void mousePressed() {
		clickSqr();
	}

	private void initSqr() {
		if (frameCount == 60) {
			listaSqr.add(new Cuadrados((int) random(20, 55), (int) random(50, 450), 0, this));
			frameCount = 0;
		}
	}

	private void drawSqr() {
		for (int i = 0; i < listaSqr.size(); i++) {
			listaSqr.get(i).pintarSqr();

		}
	}

	private void clickSqr() {
		for (int i = 0; i < listaSqr.size(); i++) {
			if (mouseX > (listaSqr.get(i).getPosX() - (listaSqr.get(i).getTam() / 2))
					&& mouseX < (listaSqr.get(i).getPosX() + (listaSqr.get(i).getTam() / 2))
					&& mouseY > (listaSqr.get(i).getPosY() - (listaSqr.get(i).getTam() / 2))
					&& mouseY < (listaSqr.get(i).getPosY() + (listaSqr.get(i).getTam() / 2))) {
				listaSqr.get(i).setMov(!listaSqr.get(i).isMov());

			}

		}

	}

	private void reboteBorde() {
		for (int i = 0; i < listaSqr.size(); i++) {
			if (500 < (listaSqr.get(i).getPosY() + (listaSqr.get(i).getTam() / 2))) {
				listaSqr.get(i).setTouching(!listaSqr.get(i).isTouching());

			}

		}

	}

	private void eliminarSqr() {
		for (int i = 0; i < listaSqr.size(); i++) {
			if (listaSqr.get(i).getPosY() < 0 && listaSqr.get(i).isTouching() == true) {
				listaSqr.remove(i);

			}
		}
	}

}
