package com.clickbus.xpcourse.jogos;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScenarioOfGilverTest {

    Jogo jogo;

    @Before
    public void setup() {
        this.jogo = new SpaceOfGilver();
    }

    @Test
    public void testSpaceTicked() {
        tick(3);
        testarTela("     ",
                            "     ",
                            "     ",
                            "     ",
                            "  A  "
        );
    }

    @Test
    public void testMoveLeft() {
        tick(1);
        jogo.esquerda();
        testarTela("     ",
                                  "     ",
                                  "     ",
                                  "     ",
                                  " A   "
        );
        jogo.esquerda();
        testarTela("     ",
                                  "     ",
                                  "     ",
                                  "     ",
                                  "A    "
        );
        jogo.esquerda();
        testarTela("     ",
                                  "     ",
                                  "     ",
                                  "     ",
                                  "A    "
        );
    }

    @Test
    public void testMoveRight() {
        tick(1);
        jogo.direita();
        testarTela("     ",
                                  "     ",
                                  "     ",
                                  "     ",
                                  "   A "
        );
        jogo.direita();
        testarTela("     ",
                                  "     ",
                                  "     ",
                                  "     ",
                                  "    A"
        );
        jogo.direita();
        testarTela("     ",
                                  "     ",
                                  "     ",
                                  "     ",
                                  "    A"
        );
    }

    @Test
    public void testManyMoves() {
        tick(1);
        jogo.direita();
        jogo.direita();
        jogo.direita();
        jogo.esquerda();
        jogo.esquerda();
        jogo.esquerda();

        testarTela("     ",
                                  "     ",
                                  "     ",
                                  "     ",
                                  " A   "
        );
    }

    @Test
    public void testEnemyShowed() {
        tick(1);
        testarTela("     ",
                                  "     ",
                                  "     ",
                                  "     ",
                                  "  A  "
        );

        tick(4);
        testarTela("  V  ",
                                  "     ",
                                  "     ",
                                  "     ",
                                  "  A  "
        );
    }

    @Test
    public void testEnemyMovement() {
        tick(6);
        testarTela(" V   ",
                "     ",
                "     ",
                "     ",
                "  A  "
        );
    }

    @Test
    public void testEnemyShouldCollide() {
        tick(8);
        testarTela("     ",
                                  "V    ",
                                  "     ",
                                  "     ",
                                  "  A  "
        );
    }

    @Test
    public void testShipShouldShoot() {
        jogo.tiro();
        testarTela("  |  ",
                                   "  |  ",
                                   "  |  ",
                                   "  |  ",
                                   "  A  "
        );
    }

    @Test
    public void testShootShouldDisappear() {
        jogo.tiro();
        tick(2);
        testarTela("     ",
                                   "     ",
                                   "     ",
                                   "     ",
                                   "  A  "
        );
    }

    @Test
    @Ignore
    public void testEnemyShouldBeDestroyedWhenHit() {
        tick(5);
        jogo.tiro();
        testarTela("  X  ",
                                   "  |  ",
                                   "  |  ",
                                   "  |  ",
                                   "  A  "
        );
    }

    @Test
    @Ignore
    public void testEnemyShipShouldBeDestroyedInADifferentPosition() {
        tick(5);
        jogo.tiro();
        testarTela("     ",
                "  X  ",
                "  |  ",
                "  |  ",
                "  A  "
        );
    }

    @Test
    @Ignore
    public void testGameOver() {
        tick(18);
        testarTela("Game over");
    }

    private void tick(int quantos)
    {
        for(int i = 0; i < quantos; i++)
        {
            jogo.tick();
        }
    }

    private void testarTela(String... linhasEsperadas)
    {
        String esperada =
                linhasEsperadas[0] + "\n" +
                linhasEsperadas[1] + "\n" +
                linhasEsperadas[2] + "\n" +
                linhasEsperadas[3] + "\n" +
                linhasEsperadas[4] + "\n";

        assertEquals(esperada, jogo.tela());
    }

}
