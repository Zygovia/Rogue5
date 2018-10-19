package com.inte.group4;

import java.awt.*;
import java.util.Random;

public class Ogre extends Monster {
    private int mockAttackPoints;


    public Ogre(int ap, int hp){
        super(ap,hp);
    }


    public void mockAttack(int attack){
        mockAttackPoints = attack;
    }

    private int generateRandomForMoving(){
        //bröt ut till egen för att kunna ha kontroll vid testning
        Random random = new Random();
        return random.nextInt(4);
    }

    private Point ogreMove(int x, int y){
        Point up= new Point(x,y+1);
        Point down= new Point(x,y-1);
        Point left = new Point(x-1,y);
        Point right = new Point(x+1,y);

        Point directionArray[] = {up,down,left,right};
        return directionArray[generateRandomForMoving()];

    }

    @Override
    public Point moveMonster() {

        Point oldOgrePoint = getCurrentMonsterCords();
        int x = (int)oldOgrePoint.getX();
        int y = (int)oldOgrePoint.getY();
        Point newOgrePoint = ogreMove(x,y);
        setCurrentMonsterCords(newOgrePoint);
        return  currentMonsterCords;

    }

    @Override
    public void attack() {

    }

    @Override
    public void decreaseHp() {
        int newHp = getHp()-mockAttackPoints;
        setHp(newHp);
        if(getHp()<=0){
            //mockMap.removeMonsterFromList();
        }
    }

    public String toString() {
        String str = "Ogre " + super.toString();
        return str;
    }
}
