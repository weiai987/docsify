package com.blb.bullet;

import com.blb.flyer.Flyer;

/**
 * 子弹
 */
public abstract class Bullet extends Flyer {

    int moveSpeed;              //移动速度

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
