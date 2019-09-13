package com.clickbus.xpcourse.jogos;

public class SpaceOfGilver implements Jogo {

    public static final char ENEMY = 'V';
    public static final char VAZIO = ' ';
    public static final char NAVE = 'A';
    private static int LINE_SIZE = 5;
    private static int TAMANHO_COLUNA = 5;
    private int countTick = 0;
    int enemyLinePosition = 0;
    int enemyColumnPosition = 2;
    int enemyLastLine;

    char[][] gameMap = new char[LINE_SIZE][TAMANHO_COLUNA];
    int shipLinePosition = 4;
    int shipColumnPosition = 2;
    boolean movendoInimigoEsquerda = false;
    boolean movendoInimigoDireita = false;

    public SpaceOfGilver() {
        initMap();
    }

    private void initMap() {
        for (int i = 0; i < LINE_SIZE; i++) {
            for (int j = 0; j < TAMANHO_COLUNA; j++) {
                gameMap[i][j] = VAZIO;
            }
        }

        gameMap[shipLinePosition][shipColumnPosition] = NAVE;
    }

    public String tela() {
        String tela = "";
        for (int i = 0; i < LINE_SIZE; i++) {
            for (int j = 0; j < TAMANHO_COLUNA; j++) {
                tela += gameMap[i][j];
            }
            tela += "\n";
        }

        return tela;
    }

    public void direita() {
        if (shipColumnPosition + 1 < TAMANHO_COLUNA) {
            shipColumnPosition = shipColumnPosition + 1;
            gameMap[shipLinePosition][shipColumnPosition] = NAVE;
            gameMap[shipLinePosition][shipColumnPosition - 1] = VAZIO;
        }
    }

    public void esquerda() {
        if (shipColumnPosition - 1 >= 0) {
            shipColumnPosition = shipColumnPosition - 1;
            gameMap[shipLinePosition][shipColumnPosition] = NAVE;
            gameMap[shipLinePosition][shipColumnPosition + 1] = VAZIO;
        }
    }

    public void tiro() {
        //TODO
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
        gameMap[enemyLinePosition][enemyColumnPosition] = ENEMY;
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

        if (enemyLinePosition + 1 < LINE_SIZE) {
            enemyLastLine = enemyLinePosition;
            enemyLinePosition = enemyLinePosition + 1;
            gameMap[enemyLinePosition][enemyColumnPosition] = ENEMY;
            gameMap[enemyLinePosition - 1][enemyColumnPosition] = VAZIO;
        }
    }

    private void moverInimigoParaEsquerda() {

        if (enemyColumnPosition - 1 >= 0) {
            enemyColumnPosition = enemyColumnPosition - 1;
            gameMap[enemyLinePosition][enemyColumnPosition] = ENEMY;
            gameMap[enemyLinePosition][enemyColumnPosition + 1] = VAZIO;
            return;
        }

        if (enemyColumnPosition == 0) {
            moverInimigoParaBaixo();
        }

        movendoInimigoEsquerda = false;
        movendoInimigoDireita = true;
    }

    private void moverInimigoParaDireita() {

        if (enemyColumnPosition + 1 < TAMANHO_COLUNA) {

            enemyColumnPosition = enemyColumnPosition + 1;
            gameMap[enemyLinePosition][enemyColumnPosition] = ENEMY;
            gameMap[enemyLinePosition][enemyColumnPosition - 1] = VAZIO;
            return;
        }

        if (enemyColumnPosition == TAMANHO_COLUNA - 1) {
            moverInimigoParaBaixo();
        }

        movendoInimigoDireita = false;
        movendoInimigoEsquerda = true;
    }

}
