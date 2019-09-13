package com.clickbus.xpcourse.jogos;

public class SpaceOfGilver implements Jogo {

    private static int LINE_SIZE = 5;
    private static int COLUMN_SIZE = 5;
    private int countTick = 0;
    int enemyLinePosition = 0;
    int enemyColumnPosition = 2;
    int enemyLastLine;

    char[][] gameMap = new char[LINE_SIZE][COLUMN_SIZE];
    int shipLinePosition = 4;
    int shipColumnPosition = 2;
    boolean movingLeft = false;
    boolean movingRight = false;

    public SpaceOfGilver() {
        initMap();
    }

    private void initMap() {
        for (int i = 0; i < LINE_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                gameMap[i][j] = ' ';
            }
        }

        gameMap[shipLinePosition][shipColumnPosition] = 'A';

    }

    public String tela() {
        String tela = "";
        for (int i = 0; i < LINE_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                tela += gameMap[i][j];
            }
            tela += "\n";
        }
        return tela;
    }

    public void direita() {
        if (shipColumnPosition + 1 < COLUMN_SIZE) {
            shipColumnPosition = shipColumnPosition + 1;
            gameMap[shipLinePosition][shipColumnPosition] = 'A';
            gameMap[shipLinePosition][shipColumnPosition - 1] = ' ';
        }
    }

    public void esquerda() {
        if (shipColumnPosition - 1 >= 0) {
            shipColumnPosition = shipColumnPosition - 1;
            gameMap[shipLinePosition][shipColumnPosition] = 'A';
            gameMap[shipLinePosition][shipColumnPosition + 1] = ' ';
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
        gameMap[enemyLinePosition][enemyColumnPosition] = 'V';
    }

    public void moveEnemy(){

        if(!movingLeft && !movingRight){
            movingLeft = true;
        }

        if(movingRight){
            moveEnemyRight();
            return;
        }

        moveEnemyLeft();
    }

    private void moveEnemyDown(){

        if(enemyLinePosition + 1 < LINE_SIZE) {

            enemyLastLine = enemyLinePosition;

            enemyLinePosition = enemyLinePosition + 1;
            gameMap[enemyLinePosition][enemyColumnPosition] = 'V';
            gameMap[enemyLinePosition - 1][enemyColumnPosition] = ' ';

        }
    }

    private void moveEnemyLeft(){

        if(enemyColumnPosition - 1 >= 0){

            enemyColumnPosition = enemyColumnPosition - 1;
            gameMap[enemyLinePosition][enemyColumnPosition] = 'V';
            gameMap[enemyLinePosition][enemyColumnPosition + 1] = ' ';

        }else{
            moveEnemyDown();
            movingLeft = false;
            movingRight = true;
        }
    }

    private void moveEnemyRight(){

        if (enemyColumnPosition + 1 < COLUMN_SIZE) {

            enemyColumnPosition = enemyColumnPosition + 1;
            gameMap[enemyLinePosition][enemyColumnPosition] = 'V';
            gameMap[enemyLinePosition][enemyColumnPosition - 1] = ' ';

            enemyLastLine = enemyLinePosition;

        }else{
            moveEnemyDown();
            movingLeft = true;
            movingRight = false;
        }
    }

}
