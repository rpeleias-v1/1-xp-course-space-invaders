package com.clickbus.xpcourse;

import java.util.ArrayList;
import java.util.List;

public class Scenario {

    public String renderLine() {
        return "----------------------------------------------------------";
    }

    public List<String> renderThreeLines() {
        List<String> threeLinesSpace = new ArrayList<String>();
        threeLinesSpace.add(renderLine());
        threeLinesSpace.add(renderLine());
        threeLinesSpace.add(renderLine());
        return threeLinesSpace;
    }
}
