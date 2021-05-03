import processing.core.PApplet;

public class Bola implements Desenhavel {

    private float tamanho;
    private float posx;
    private float posy;
    private PApplet lugar;

    public Bola(float posx, float posy, float tamanho, PApplet lugar) {
        this.posx = posx;
        this.posy = posy;
        this.tamanho = tamanho;
        this.lugar = lugar;
    }

    public void desenha() {
        this.lugar.ellipse(posx, posy, tamanho, tamanho);
    }
}

