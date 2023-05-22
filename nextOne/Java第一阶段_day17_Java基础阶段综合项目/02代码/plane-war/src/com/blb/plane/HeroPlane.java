package com.blb.plane;

import com.blb.Game;
import com.blb.bullet.Bullet;
import com.blb.bullet.HeroBullet;
import javafx.scene.image.Image;

import java.util.List;

/**
 * 英雄机
 */
public class HeroPlane extends Plane {

    static Image image = new Image("com/blb/img/own1.png");

    public HeroPlane() {
        double initX = (Game.WIDTH - image.getWidth()) / 2;
        double inity = Game.HEIGHT / 4 * 3;
        super.x = initX;
        super.y = inity;
        super.image = image;
        super.fire = 1;
        super.hp = 3;
        super.shootSpeed = 50;
    }

    ///移动
    @Override
    public void move(double... point) {
        x = point[0] - image.getWidth()/2;
        y = point[1] - image.getHeight()/2;
    }

    @Override
    public void shoot(List<Bullet> heroBullets) {
        //英雄机X轴中心点
        double centerX = x + image.getWidth()/2;

        for (int i = 0; i < fire; i++) {
            //创建子弹对象
            HeroBullet heroBullet = new HeroBullet();
            //获取子弹对象图片宽度
            double width = heroBullet.getImage().getWidth();
            //计算起始X坐标
            double startX = centerX -  (width * fire + (fire-1)*2)/ 2;
            //当前子弹X坐标
            double bulletX = startX + i * width;

            if(i!=0){
                bulletX+=2*i;
            }

            //当前子弹Y坐标
            double bulletY = y - heroBullet.getImage().getHeight();
            heroBullet.setX(bulletX);
            heroBullet.setY(bulletY);

            heroBullets.add(heroBullet);
        }
    }
}
