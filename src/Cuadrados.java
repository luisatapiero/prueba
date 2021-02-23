import processing.core.PApplet;

public class Cuadrados {
	private int tam, posX, posY;
	private boolean isMov;
	private boolean isTouching;
	private PApplet app;

	public Cuadrados(int tam, int posX, int posY, PApplet app) {
		this.tam = tam;
		this.posX = posX;
		this.posY = posY;
		isMov = true;
		isTouching = false;
		this.app = app;
	}

	public void pintarSqr() {
		app.stroke(240, 0, 118);
		app.fill(240, 0, 118);
		app.rect(posX, posY, tam, tam);
		mover();
	}

	private void mover() {
		if (isMov && isTouching == false) {
			posY += 2;
		}
		if (isMov && isTouching) {
			posY -= 2;
		}

	}

	public int getTam() {
		return tam;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public boolean isMov() {
		return isMov;
	}

	public void setMov(boolean isMov) {
		this.isMov = isMov;
	}

	public boolean isTouching() {
		return isTouching;
	}

	public void setTouching(boolean isTouching) {
		this.isTouching = isTouching;
	}

}
