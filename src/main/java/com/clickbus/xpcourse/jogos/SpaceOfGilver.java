package com.clickbus.xpcourse.jogos;

public class SpaceOfGilver implements Jogo {

    private static int LINE_SIZE = 5;
    private static int COLUMN_SIZE = 5;

    char[][] gameLineArray = new char[LINE_SIZE][COLUMN_SIZE];

    public SpaceOfGilver() {
        for (int i = 0; i < LINE_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                gameLineArray[i][j] = ' ';
            }
        }
    }

    public String tela() {
        String tela = "";
        for (int i = 0; i < LINE_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                tela += gameLineArray[i][j];
            }
            tela += "\n";
        }
        return tela;
    }

    public void direita() {

    }

    public void esquerda() {

    }

    public void tiro() {

    }

    public void tick() {

    }
}
