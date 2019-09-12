package com.clickbus.xpcourse.jogos;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScenarioOfGilverTest {

    Jogo jogo = new SpaceOfGilver();

    @Test
    public void testTela() {
        String expected = "";
        expected += "     \n";
        expected += "     \n";
        expected += "     \n";
        expected += "     \n";
        expected += "     \n";
        assertEquals(expected, jogo.tela());
    }
}
