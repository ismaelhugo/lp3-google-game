import processing.core.PApplet;

//A ideia foi fazer os objetos terem comportamento parecido com aquele jogo do dinossauro do google
//O retangulo se comporta como jogador e ele pode pular toda vez que ele estiver encostado na linha do chão. (Ou seja, enquanto ele não tá pulando)
//Já a bola se comporta como o obstaculo que o jogador deve evitar, ela vai aumentando a velocidade toda vez que passa na tela.

public class Game extends PApplet {
    //define variaveis
    float circleX = 500;
    float x = 1.8f;

    float groundY = 250;

    float playerX = 140;
    float playerY = 100;
    float playerWidth = 20;
    float playerHeight = 50;
    float playerSpeedY = 0;

    float circleRadius = 10;

    boolean jumping = false;

    //ajusta tamanho da tela
    public void settings() {
        size(500, 500);
    }

    public void draw() {
        background(146, 0, 255);

        //inicia uma bola (instanciar bola)
        Bola bola = new Bola(circleX, groundY, circleRadius*2, this);
        bola.desenha(); //desenha a bola

        //movimenta a bola
        circleX = circleX - x;

        if (circleX <= 0) { //se a bola chegar no canto da tela

            x = x + 0.2f; //adiciona velocidade na bola toda vez que ela chegar no fim da tela

            circleX = 500; //a bola volta pro ponto inicial, ou seja, para o lado direito da tela
        }

        //inicia e desenha o jogador
        Retangulo jogador = new Retangulo(playerX, playerY, playerWidth, playerHeight, this);
        jogador.desenha();

        //desenha a linha do chao
        line(0, groundY, width, groundY);

        //mover o jogador
        playerY += playerSpeedY;

        //Identifica se o jogador esta colidindo com a linha (solo)
        if (playerY + playerHeight > groundY) {

            //Coloca a parte de baixo do retangulo do jogador na mesma posicao do solo
            playerY = groundY - playerHeight;

            //caida do jogador (jogador para de cair)
            playerSpeedY = 0;

            //permitir pular novamente
            jumping = false;
        }
        //Se o jogador nao esta colidindo com o solo entao...
        else {
            //aumenta a velocidade
            playerSpeedY++;
        }

    }
    public void keyPressed() {
        //definir que so eh possivel pular se vc nao estiver em um pulo
        if (!jumping) {

            //subida
            playerSpeedY = -15;

            //nao permitir pular enquanto ja pula
            jumping = true;
        }
    }


    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "Game" };
        PApplet.main(appletArgs);
    }
}
