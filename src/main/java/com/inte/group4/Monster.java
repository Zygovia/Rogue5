package com.inte.group4;

import java.awt.*;

abstract public class Monster extends Sprite {
    private boolean isUpOrLeft;
    Point currentMonsterCords;
    private char monsterChar;
    private int deadLockCounter;

    public boolean isUpOrLeft() {
        return isUpOrLeft;
    }

    public void setMonsterChar(char monsterChar) {
        this.monsterChar = monsterChar;
    }

    public Monster(int ap, int hp, Point p) {
        super(ap, hp);
        currentMonsterCords = p;
    }

    abstract public Point generatePointForMonsterMovement();

    abstract protected void checkForBoundaries(Point currentPoint);

    public Point getCurrentMonsterCords() {
        return currentMonsterCords;
    }

    public void setCurrentMonsterCords(Point currentMonsterCords) {
        this.currentMonsterCords = currentMonsterCords;
        if (this instanceof Worm) {
            ((Worm) this).grow();
        }
    }

    @Override
    public String toString() {
        String str = super.toString() + " cords: " + currentMonsterCords.x + ":" + currentMonsterCords.y;
        return str;
    }

    public boolean getIsUpOrLeft() {
        return isUpOrLeft;
    }

    public void setUpOrLeft(boolean upOrLeft) {
        isUpOrLeft = upOrLeft;
    }

    public char getMonsterChar() {
        return monsterChar;
    }

    public int getDeadLockCounter() {
        return deadLockCounter;
    }

    public void resetDeadLockCounter() {
        deadLockCounter = 0;
    }

    public void incrementDeadLockCounter() {
        deadLockCounter++;
    }
}
