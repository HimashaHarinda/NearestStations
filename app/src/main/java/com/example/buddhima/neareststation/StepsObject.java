package com.example.buddhima.neareststation;

/**
 * Created by Buddhima on 9/19/2017.
 */

public class StepsObject {
    private PolylineObject polyline;
    public StepsObject(PolylineObject polyline) {
        this.polyline = polyline;
    }
    public PolylineObject getPolyline() {
        return polyline;
    }
}