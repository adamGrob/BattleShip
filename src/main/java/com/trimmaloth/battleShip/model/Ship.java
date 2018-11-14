package com.trimmaloth.battleShip.model;

public class Ship {

    private ShipClass shipClass;

    private Shipsegment[] shipsegments;

    public Ship(ShipClass shipClass, Shipsegment[] shipsegments) {
        this.shipClass = shipClass;
        this.shipsegments = shipsegments;
    }

    public void hitCheker (Position position) {

    }
}
