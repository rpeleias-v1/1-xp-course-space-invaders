package com.clickbus.xpcourse.jogos;

public class SpaceOfGilver implements Jogo {

    private static int LINE_SIZE = 5;
    private static int COLUMN_SIZE = 5;
    private int countTick = 0;
    int enemyLinePosition = 0;
    int enemyColumnPosition = 2;
    int enemyLastLine;

    char[][] gameLineArray = new char[LINE_SIZE][COLUMN_SIZE];
    int shipLinePosition;
    int shipColumnPosition;
    boolean movingLeft = false;
    boolean movingRight = false;

    public SpaceOfGilver() {
        inicializarMatriz();
    }

    private void inicializarMatriz() {
        for (int i = 0; i < LINE_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                gameLineArray[i][j] = ' ';
            }
        }

        shipLinePosition = LINE_SIZE - 1;
        shipColumnPosition = COLUMN_SIZE / 2;
        gameLineArray[shipLinePosition][shipColumnPosition] = 'A';


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
        if (shipColumnPosition + 1 < COLUMN_SIZE) {
            shipColumnPosition = shipColumnPosition + 1;
            gameLineArray[shipLinePosition][shipColumnPosition] = 'A';
            gameLineArray[shipLinePosition][shipColumnPosition - 1] = ' ';
        }
    }

    public void esquerda() {
        if (shipColumnPosition - 1 >= 0) {
            shipColumnPosition = shipColumnPosition - 1;
            gameLineArray[shipLinePosition][shipColumnPosition] = 'A';
            gameLineArray[shipLinePosition][shipColumnPosition + 1] = ' ';
        }
    }

    public void tiro() {

    }

    public void tick() {

        ++countTick;

        if(countTick == 5){
            createEnemy();
        }else if(countTick > 5){
            moveEnemy();
        }

    }

    public void createEnemy(){
        gameLineArray[enemyLinePosition][enemyColumnPosition] = 'V';
    }

    public void moveEnemy(){

        if(!movingLeft && !movingRight){
            moveEnemyLeft();
            movingLeft = true;
        }

        if(movingLeft){
            moveEnemyLeft();
        }

        if(movingRight){
            moveEnemyRight();
        }


    }

    public void desce(){

        if(enemyLinePosition + 1 < LINE_SIZE) {

            enemyLastLine = enemyLinePosition;

            enemyLinePosition = enemyLinePosition + 1;
            gameLineArray[enemyLinePosition][enemyColumnPosition] = 'V';
            gameLineArray[enemyLinePosition - 1][enemyColumnPosition] = ' ';

        }
    }

    public void moveEnemyLeft(){

        if(enemyColumnPosition - 1 >= 0){

            enemyColumnPosition = enemyColumnPosition - 1;
            gameLineArray[enemyLinePosition][enemyColumnPosition] = 'V';
            gameLineArray[enemyLinePosition][enemyColumnPosition + 1] = ' ';

        }else{
            desce();
            movingLeft = false;
            movingRight = true;
        }
    }

    public void moveEnemyRight(){

        if (enemyColumnPosition + 1 < COLUMN_SIZE) {

            enemyColumnPosition = enemyColumnPosition + 1;
            gameLineArray[enemyLinePosition][enemyColumnPosition] = 'V';
            gameLineArray[enemyLinePosition][enemyColumnPosition - 1] = ' ';

            enemyLastLine = enemyLinePosition;

        }else{
            desce();
            movingLeft = false;
            movingRight = true;
        }
    }

}
