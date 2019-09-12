package com.clickbus.xpcourse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScenarioTest {

    Scenario space;

    @Before
    public void setUp() throws Exception {
        space = new Scenario();
    }

    @Test
    public void testRender() {
        assertEquals("----------------------------------------------------------", space.renderLine());
    }

    @Test
    public void testRenderThreeLines() {
        assertEquals("----------------------------------------------------------", space.renderThreeLines());
    }
}
