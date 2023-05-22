package com.blb.bullet;

import com.blb.Game;
import javafx.scene.image.Image;

/**
 * 敌机子弹
 */
public class EnemyBullet extends Bullet {

    static Image image = new Image("com/blb/img/fire1.png");

    public EnemyBullet(int bulletMoveSpeed) {
        super.image = image;
        super.moveSpeed = bulletMoveSpeed;
    }

    @Override
    public void move(double... point) {
        y+=moveSpeed;
        if(y> Game.HEIGHT){
            setStatus(false);
        }
    }
}
