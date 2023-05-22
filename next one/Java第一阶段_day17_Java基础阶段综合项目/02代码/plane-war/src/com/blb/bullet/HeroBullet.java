package com.blb.bullet;

import javafx.scene.image.Image;

/**
 * 英雄机子弹
 */
public class HeroBullet extends Bullet {

    static Image image = new Image("com/blb/img/HeroBullet.png");

    public HeroBullet() {
        super.image = image;
        super.moveSpeed = 3;
    }

    @Override
    public void move(double... point) {
        y-=moveSpeed;
        if(y<0-image.getHeight()){
            setStatus(false);
        }
    }

}
