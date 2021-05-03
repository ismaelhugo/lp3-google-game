import processing.core.PApplet;

public class Retangulo implements Desenhavel {
    private float playerX;
    private float playerY;
    private float playerWidth;
    private float playerHeight;
    private PApplet lugar;

    public Retangulo(float playerX, float playerY, float playerWidth, float playerHeight, PApplet lugar) {
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
        this.lugar = lugar;
    }

    public void desenha() {
        this.lugar.rect(playerX, playerY, playerWidth, playerHeight);
    }
}
