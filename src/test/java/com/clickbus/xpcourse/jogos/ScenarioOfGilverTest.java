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
        String expected = "";
        expected += "     \n";
        expected += "     \n";
        expected += "     \n";
        expected += "     \n";
        expected += "  A  \n";
        jogo.tick();
        jogo.tick();
        jogo.tick();
        assertEquals(expected, jogo.tela());
    }

    @Test
    public void testMoveLeft() {
        jogo.tick();
        String expectedFirstMove = "";
        expectedFirstMove += "     \n";
        expectedFirstMove += "     \n";
        expectedFirstMove += "     \n";
        expectedFirstMove += "     \n";
        expectedFirstMove += " A   \n";

        jogo.esquerda();
        assertEquals(expectedFirstMove, jogo.tela());

        String expectedSecondMove = "";
        expectedSecondMove += "     \n";
        expectedSecondMove += "     \n";
        expectedSecondMove += "     \n";
        expectedSecondMove += "     \n";
        expectedSecondMove += "A    \n";
        jogo.esquerda();
        assertEquals(expectedSecondMove, jogo.tela());

        String expectedThirdMove = "";
        expectedThirdMove += "     \n";
        expectedThirdMove += "     \n";
        expectedThirdMove += "     \n";
        expectedThirdMove += "     \n";
        expectedThirdMove += "A    \n";
        jogo.esquerda();
        assertEquals(expectedThirdMove, jogo.tela());
    }

    @Test
    public void testMoveRight() {
        jogo.tick();
        String expectedFirstMove = "";
        expectedFirstMove += "     \n";
        expectedFirstMove += "     \n";
        expectedFirstMove += "     \n";
        expectedFirstMove += "     \n";
        expectedFirstMove += "   A \n";
        jogo.direita();
        assertEquals(expectedFirstMove, jogo.tela());

        String expectedSecondMove = "";
        expectedSecondMove += "     \n";
        expectedSecondMove += "     \n";
        expectedSecondMove += "     \n";
        expectedSecondMove += "     \n";
        expectedSecondMove += "    A\n";
        jogo.direita();
        assertEquals(expectedSecondMove, jogo.tela());

        String expectedThirdMove = "";
        expectedThirdMove += "     \n";
        expectedThirdMove += "     \n";
        expectedThirdMove += "     \n";
        expectedThirdMove += "     \n";
        expectedThirdMove += "    A\n";
        jogo.direita();
        assertEquals(expectedThirdMove, jogo.tela());
    }

    @Test
    public void testManyMoves() {
        String expected = "";
        expected += "     \n";
        expected += "     \n";
        expected += "     \n";
        expected += "     \n";
        expected += " A   \n";
        jogo.tick();
        jogo.direita();
        jogo.direita();
        jogo.direita();
        jogo.esquerda();
        jogo.esquerda();
        jogo.esquerda();

        assertEquals(expected, jogo.tela());
    }

    @Test
    public void testEnemyShowed() {
        String expectedFirstMoment = "";
        expectedFirstMoment += "     \n";
        expectedFirstMoment += "     \n";
        expectedFirstMoment += "     \n";
        expectedFirstMoment += "     \n";
        expectedFirstMoment += "  A  \n";
        jogo.tick();
        assertEquals(expectedFirstMoment, jogo.tela());

        String expectedLater = "";
        expectedLater += "  V  \n";
        expectedLater += "     \n";
        expectedLater += "     \n";
        expectedLater += "     \n";
        expectedLater += "  A  \n";
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        assertEquals(expectedLater, jogo.tela());
    }

    @Test
    @Ignore
    public void testEnemyMovement() {
        String expected = "";
        expected += " V   \n";
        expected += "     \n";
        expected += "     \n";
        expected += "     \n";
        expected += "  A  \n";
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        assertEquals(expected, jogo.tela());
    }

    @Test
    @Ignore
    public void testEnemyShouldCollide() {
        String expected = "";
        expected += "     \n";
        expected += "V    \n";
        expected += "     \n";
        expected += "     \n";
        expected += "  A  \n";
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();

        assertEquals(expected, jogo.tela());
    }

    @Test
    @Ignore
    public void testShipShouldShoot() {

        String expected = "";
        expected += "  |  \n";
        expected += "  |  \n";
        expected += "  |  \n";
        expected += "  |  \n";
        expected += "  A  \n";

        jogo.tiro();
        assertEquals(expected, jogo.tela());
    }

    @Test
    @Ignore
    public void testShootShouldDisappear() {

        String expected = "";
        expected += "     \n";
        expected += "     \n";
        expected += "     \n";
        expected += "     \n";
        expected += "  A  \n";

        jogo.tiro();
        jogo.tick();
        assertEquals(expected, jogo.tela());
    }
}
