package com.trimmaloth.battleShip.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;

    private List<Ship> ships;

    private List<Position> shots;

    public Player(String name) {
        this.name = name;
        ships = new ArrayList<>();
        shots = new ArrayList<>();
    }

    public void assignShip(Ship ship) {
        ships.add(ship);
    }

    public void addShot(Position shot) {
        shots.add(shot);
    }
}
