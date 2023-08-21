package com.blb.flyer;

import javafx.scene.image.Image;
import lombok.Data;

/**
 * 飞行物
 */
@Data
public abstract class Flyer {

    public double x;                                    //X轴
    public double y;                                    //Y轴
    public boolean status = true;                       //状态：true存活； false死亡
    public Image image;                                 //图像

    //移动
    public abstract void move(double... point);

}
