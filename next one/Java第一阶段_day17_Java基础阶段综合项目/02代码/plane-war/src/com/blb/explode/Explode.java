package com.blb.explode;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * 爆炸物
 */
public class Explode {

    public double x;                                                              //X
    public double y;                                                              //Y
    public int  num = 1;                                                          //序号
    public boolean del = false;                                                   //是否删除
    public static Image[] images = new Image[8];                                  //图片

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }

    static{
        for (int i = 0; i < images.length; i++) {
            images[i] = new Image("com/blb/img/explode"+(i+1)+".png");
        }
    }

    /**
     * 画爆炸物
     * @param gc
     */
    public void drwaExplde(GraphicsContext gc){
        gc.drawImage(images[num++], x, y);
        if(num==8){
            del = true;
        }
    }

}
