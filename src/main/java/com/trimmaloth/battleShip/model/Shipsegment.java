package com.trimmaloth.battleShip.model;

public class Shipsegment {

    public Position getPosition() {
        return position;
    }

    private Position position;

    private boolean destroyed;

    public Shipsegment(Position position) {
        this.position = position;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroyIfHit(Position position) {
        if (position.equals(this.position)) this.destroyed = true;

    }
}
