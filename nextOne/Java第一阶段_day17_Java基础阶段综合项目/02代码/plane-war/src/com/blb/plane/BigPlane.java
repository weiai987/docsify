package com.blb.plane;

import com.blb.Game;
import javafx.scene.image.Image;

/**
 * 大飞机
 */
public class BigPlane extends EnemyPlane {

    static Image image = new Image("com/blb/img/ep09.png");

    int direction;          //方向，0：左，1：右

    public BigPlane() {
        //随机X坐标
        int max = (int) (Game.WIDTH - image.getWidth());
        int randomX = random.nextInt(max);
        //随机Y坐标
        int y = random.nextInt(20);

        if(randomX<Game.WIDTH/2){
            direction = 1;
        }else{
            direction = 0;
        }

        setX(randomX);
        setY(y);
        setImage(image);
        setFire(5);
        setHp(5);
        setScore(50);
        setMoveSpeed(2);
        setBulletMoveSpeed(4);
    }

    @Override
    public void move(double... point) {
        if(direction==0){
            x-=1;
        }else{
            x+=1;
        }
        if(x<0-image.getWidth() || x>Game.WIDTH){
            setStatus(false);
        }
    }

}
