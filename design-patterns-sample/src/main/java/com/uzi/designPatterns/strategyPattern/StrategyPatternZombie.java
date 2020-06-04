package com.uzi.designPatterns.strategyPattern;

/**
 * @Description: 策略模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/6/2
 * ...
 */
public class StrategyPatternZombie {

    public static void main(String[] args) {
        Zombie zombie=new NormalZombie( );
        zombie.display();

        zombie.attack();
        zombie.move();

        zombie.setAttackable( new HitAttack() );
        zombie.attack();
    }

}

interface Moveable{
    void move();
}

interface Attackable{
    void attack();
}

abstract class Zombie{
    abstract public void display();
    Moveable moveable;
    Attackable attackable;

    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable=moveable;
        this.attackable=attackable;
    }

    abstract void move();
    abstract void attack();

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable=moveable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable=attackable;
    }
}

class StepByStepMove implements Moveable{

    @Override
    public void move() {
        System.out.println("一步一步移动.");
    }
}

class BiteAttack implements Attackable{

    @Override
    public void attack() {
        System.out.println("咬.");
    }
}

class HitAttack implements Attackable{

    @Override
    public void attack() {
        System.out.println("打.");
    }
}

class FlagZombie extends Zombie{

    public FlagZombie(){
        super(new StepByStepMove(),new BiteAttack());
    }

    public FlagZombie(Moveable moveable, Attackable attackable) {
        super( moveable, attackable );
    }

    @Override
    public void display() {
        System.out.println("我是旗手僵尸.");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}

class NormalZombie extends Zombie{

    public NormalZombie(){
        super(new StepByStepMove(),new BiteAttack());
    }

    public NormalZombie(Moveable moveable, Attackable attackable) {
        super( moveable, attackable );
    }

    @Override
    public void display() {
        System.out.println("我是普通僵尸.");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}
