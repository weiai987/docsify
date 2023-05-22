package com.blb.plane;

import com.blb.bullet.Bullet;
import com.blb.flyer.Flyer;
import lombok.Data;

import java.util.List;

/**
 * 飞机
 */
@Data
public abstract class Plane extends Flyer {

    public int shootSpeed;      //射速
    public int  fire;           //火力
    public int hp;              //生命

    //射击
    public abstract void shoot(List<Bullet> heroBullets);
}
