package com.clickbus.xpcourse.jogos;

public class SpaceOfGilver implements Jogo {

    public static final char ENEMY = 'V';
    public static final char VAZIO = ' ';
    public static final char NAVE = 'A';
    public static final char TIRO = '|';
    private static int TAMANHO_LINHA = 5;
    private static int TAMANHO_COLUNA = 5;
    private int countTick = 0;
    int inimigoPosicaoLinha = 0;
    int inimigoPosicaoColuna = 2;
    int inimigoUltimaPosicao;
    private boolean gameOver;

    char[][] mapaJogo = new char[TAMANHO_LINHA][TAMANHO_COLUNA];
    int navePosicaoLinha = 4;
    int navePosicaoColuna = 2;
    boolean movendoInimigoEsquerda = false;
    boolean movendoInimigoDireita = false;

    public SpaceOfGilver() {
        this.gameOver = false;
        iniciaMapa();
    }

    private void iniciaMapa() {
        for (int i = 0; i < TAMANHO_LINHA; i++) {
            for (int j = 0; j < TAMANHO_COLUNA; j++) {
                mapaJogo[i][j] = VAZIO;
            }
        }

        mapaJogo[navePosicaoLinha][navePosicaoColuna] = NAVE;
    }

    public String tela() {
        if (this.gameOver) {
            return "Game over";
        }

        String tela = "";
        for (int i = 0; i < TAMANHO_LINHA; i++) {
            for (int j = 0; j < TAMANHO_COLUNA; j++) {
                tela += mapaJogo[i][j];
            }
            tela += "\n";
        }

        return tela;
    }

    public void direita() {
        if (navePosicaoColuna + 1 < TAMANHO_COLUNA) {
            navePosicaoColuna = navePosicaoColuna + 1;
            mapaJogo[navePosicaoLinha][navePosicaoColuna] = NAVE;
            mapaJogo[navePosicaoLinha][navePosicaoColuna - 1] = VAZIO;
        }
    }

    public void esquerda() {
        if (navePosicaoColuna - 1 >= 0) {
            navePosicaoColuna = navePosicaoColuna - 1;
            mapaJogo[navePosicaoLinha][navePosicaoColuna] = NAVE;
            mapaJogo[navePosicaoLinha][navePosicaoColuna + 1] = VAZIO;
        }
    }

    public void tiro() {

        for (int i = 1; i < TAMANHO_LINHA; i++ )
            mapaJogo[navePosicaoLinha - i][navePosicaoColuna] = TIRO;
    }

    public void tick() {

        ++countTick;

        if (countTick == 5) {
            criarInimigo();
        } else if (countTick > 5) {
            moverInimigo();
        }
    }

    private void criarInimigo() {
        mapaJogo[inimigoPosicaoLinha][inimigoPosicaoColuna] = ENEMY;
    }

    private void moverInimigo() {

        if (!movendoInimigoEsquerda && !movendoInimigoDireita) {
            movendoInimigoEsquerda = true;
        }

        if (movendoInimigoDireita) {
            moverInimigoParaDireita();
            return;
        }

        moverInimigoParaEsquerda();
    }

    private void moverInimigoParaBaixo() {

        if (inimigoPosicaoLinha + 1 < this.navePosicaoLinha) {
            inimigoUltimaPosicao = inimigoPosicaoLinha;
            inimigoPosicaoLinha = inimigoPosicaoLinha + 1;
            mapaJogo[inimigoPosicaoLinha][inimigoPosicaoColuna] = ENEMY;
            mapaJogo[inimigoPosicaoLinha - 1][inimigoPosicaoColuna] = VAZIO;
        } else {
            this.gameOver = true;
        }
    }

    private void moverInimigoParaEsquerda() {

        if (inimigoPosicaoColuna - 1 >= 0) {
            inimigoPosicaoColuna = inimigoPosicaoColuna - 1;
            mapaJogo[inimigoPosicaoLinha][inimigoPosicaoColuna] = ENEMY;
            mapaJogo[inimigoPosicaoLinha][inimigoPosicaoColuna + 1] = VAZIO;
            return;
        }

        if (inimigoPosicaoColuna == 0) {
            moverInimigoParaBaixo();
        }

        movendoInimigoEsquerda = false;
        movendoInimigoDireita = true;
    }

    private void moverInimigoParaDireita() {

        if (inimigoPosicaoColuna + 1 < TAMANHO_COLUNA) {

            inimigoPosicaoColuna = inimigoPosicaoColuna + 1;
            mapaJogo[inimigoPosicaoLinha][inimigoPosicaoColuna] = ENEMY;
            mapaJogo[inimigoPosicaoLinha][inimigoPosicaoColuna - 1] = VAZIO;
            return;
        }

        if (inimigoPosicaoColuna == TAMANHO_COLUNA - 1) {
            moverInimigoParaBaixo();
        }

        movendoInimigoDireita = false;
        movendoInimigoEsquerda = true;
    }

}
