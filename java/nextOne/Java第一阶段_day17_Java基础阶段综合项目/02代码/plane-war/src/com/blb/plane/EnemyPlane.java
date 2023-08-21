package com.blb.plane;

import com.blb.Game;
import com.blb.bullet.Bullet;
import com.blb.bullet.EnemyBullet;
import lombok.Data;

import java.util.List;
import java.util.Random;

/**
 * 敌机
 */
@Data
public abstract class EnemyPlane extends Plane {

    static Random random = new Random();

    public int score;                   //分数
    public int moveSpeed;               //移动速度
    public int bulletMoveSpeed;         //子弹移动速度

    @Override
    public void shoot(List<Bullet> enemyBullets) {
        //敌机X轴中心点
        double centerX = x + image.getWidth()/2;

        for (int i = 0; i < fire; i++) {
            //创建子弹对象
            EnemyBullet enemyBullet = new EnemyBullet(bulletMoveSpeed);
            //获取子弹对象图片宽度
            double width = enemyBullet.getImage().getWidth();
            //计算起始X坐标
            double startX = centerX -  (width * fire + (fire-1)*3)/ 2;
            //当前子弹X坐标
            double bulletX = startX + i * width;

            if(i!=0){
                bulletX+=3*i;
            }

            //当前子弹Y坐标
            double bulletY = y + image.getHeight();
            enemyBullet.setX(bulletX);
            enemyBullet.setY(bulletY);

            enemyBullets.add(enemyBullet);
        }
    }

    @Override
    public void move(double... point) {
        y+=moveSpeed;
        if(y> Game.HEIGHT){
            setStatus(false);
        }
    }

}
