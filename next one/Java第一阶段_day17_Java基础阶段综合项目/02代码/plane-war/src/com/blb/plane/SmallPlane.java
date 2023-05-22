package com.blb.plane;

import com.blb.Game;
import javafx.scene.image.Image;

/**
 * 小飞机
 */
public class SmallPlane extends EnemyPlane {

    static Image image = new Image("com/blb/img/ep00.png");

    public SmallPlane() {
        //随机X坐标
        int max = (int) (Game.WIDTH - image.getWidth());
        int randomX = random.nextInt(max);
        //随机Y坐标
        int y = random.nextInt(20);

        setX(randomX);
        setY(y);
        setImage(image);
        setFire(1);
        setHp(1);
        setScore(10);
        setMoveSpeed(2);
        setBulletMoveSpeed(3);
    }

}
