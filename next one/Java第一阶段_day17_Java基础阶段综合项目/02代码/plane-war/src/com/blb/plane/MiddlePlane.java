package com.blb.plane;

import com.blb.Game;
import javafx.scene.image.Image;

/**
 * 中型飞机
 */
public class MiddlePlane extends EnemyPlane {

    static Image image = new Image("com/blb/img/ep05.png");

    public MiddlePlane() {
        //随机X坐标
        int max = (int) (Game.WIDTH - image.getWidth());
        int randomX = random.nextInt(max);
        //随机Y坐标
        int y = random.nextInt(20);

        setX(randomX);
        setY(y);
        setImage(image);
        setFire(2);
        setHp(2);
        setScore(20);
        setMoveSpeed(2);
        setBulletMoveSpeed(3);
    }

}
