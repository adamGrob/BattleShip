package com.trimmaloth.battleShip.model;

public class Ship {

    private Shipsegment[] shipsegments;

    private boolean destroyed;

    public Ship(Shipsegment[] shipsegments) {
        this.shipsegments = shipsegments;
    }

    public void hitChecker() {
        int hitpoints = shipsegments.length;
        for (Shipsegment shipsegment: shipsegments) {
            if (shipsegment.isDestroyed()) hitpoints--;
        }
        if (hitpoints <= 0) destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
