package com.trimmaloth.battleShip.model;

public class Shipsegment {

    private Position position;

    private boolean destroyed;

    public Shipsegment(Position position) {
        this.position = position;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        this.destroyed = true;
    }
}
