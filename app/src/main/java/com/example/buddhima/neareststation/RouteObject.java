package com.example.buddhima.neareststation;

/**
 * Created by Buddhima on 9/19/2017.
 */

import java.util.List;
public class RouteObject {
    private List<LegsObject> legs;
    public RouteObject(List<LegsObject> legs) {
        this.legs = legs;
    }
    public List<LegsObject> getLegs() {
        return legs;
    }
}