package com.example.buddhima.neareststation;

/**
 * Created by Buddhima on 9/19/2017.
 */

import java.util.List;
public class LegsObject {
    private List<StepsObject> steps;
    public LegsObject(List<StepsObject> steps) {
        this.steps = steps;
    }
    public List<StepsObject> getSteps() {
        return steps;
    }
}
