package com.trimmaloth.battleShip.controller;

import com.trimmaloth.battleShip.model.*;

public class ShipFactory {

    private Board board;

    private Player player;

    public ShipFactory(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public Ship constructShip(ShipType shipType, Position startingPosition, Orientation orientation) {
        switch (shipType) {
            case CARRIER:
                return new Ship(segmentBuilder(5, startingPosition, orientation));
            case BATTLESHIP:
                return new Ship(segmentBuilder(4, startingPosition, orientation));
            case CRUISER:
                return new Ship(segmentBuilder(3, startingPosition, orientation));
            case SUBMARINE:
                return new Ship(segmentBuilder(3, startingPosition, orientation));
            case DESTROYER:
                return new Ship(segmentBuilder(2, startingPosition, orientation));
        }
        return null;
    }

    private Shipsegment[] segmentBuilder(int shipSize, Position startingPosition, Orientation orientation) {
        Shipsegment[] shipsegments = new Shipsegment[shipSize];
        Position positionToAdd = startingPosition;
        for (int i = 0; i < shipsegments.length; i++) {
            if (isPositionValid(positionToAdd)) {
                shipsegments[i] = new Shipsegment(positionToAdd);
                if (orientation.equals(Orientation.VERTICAL)) {
                    positionToAdd = new Position(positionToAdd.getX(), positionToAdd.getY() + 1);
                } else if (orientation.equals(Orientation.HORIZONTAL)) {
                    positionToAdd = new Position(positionToAdd.getX() + 1, positionToAdd.getY());
                }
            } else {
                System.out.println("Position is invalid");
                return null;
            }
        }
        return shipsegments;
    }

    private boolean isPositionOnTheBoard(Position position) {
        if ((position.getX() < board.getWidth() && position.getX() >= 0) &&
                (position.getY() < board.getHeight() && position.getY() >= 0)) {
            return true;
        } else {
            System.out.println("Position is not in board boundaries!");
            return false;
        }
    }

    private boolean isPositionNotOnAnotherShip(Position position) {
        for (Ship ship: player.getShips()) {
            for (Shipsegment shipsegment: ship.getShipsegments()) {
                if (shipsegment.getPosition().equals(position)) return false;
            }
        }
        System.out.println("Position is on corssing another ship!");
        return true;
    }

    private boolean isPositionValid(Position position) {
        return isPositionOnTheBoard(position) && isPositionNotOnAnotherShip(position);
    }
}
