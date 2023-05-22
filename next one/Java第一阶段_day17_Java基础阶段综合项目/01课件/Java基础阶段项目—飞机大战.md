# Java基础阶段项目—飞机大战

## 1.项目介绍

飞机大战是一个基于Java实现的射击游戏，该游戏将Java基础中的面向对象、集合、常用类、泛型、Lambda表达式等技术柔和在一起，既锻炼了Java基础知识的综合应用，又不失趣味性。在彻底掌握后还可以进行魔改实现，实现个性化展示。

![image-20221117233055341](Java%E5%9F%BA%E7%A1%80%E9%98%B6%E6%AE%B5%E9%A1%B9%E7%9B%AE%E2%80%94%E9%A3%9E%E6%9C%BA%E5%A4%A7%E6%88%98.assets/image-20221117233055341.png)  

## 2.项目分析

游戏界面主要由飞机、子弹组成；而飞机又可以分为敌机和友机，子弹也可以分为我方子弹和敌方子弹，因此，可以采用面向对象的继承来实现这一系列对象。

因此设计实体类结构如下：

 ![未命名文件](Java%E5%9F%BA%E7%A1%80%E9%98%B6%E6%AE%B5%E9%A1%B9%E7%9B%AE%E2%80%94%E9%A3%9E%E6%9C%BA%E5%A4%A7%E6%88%98.assets/%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6.png) 

## 3.项目主要功能

项目主要功能包括如下：

- JavaFX窗体绘制
- 背景图绘制
- 背景图滚动
- 游戏得分面板绘制
- 英雄机生成
- 英雄机发射子弹
- 敌机生成
- 敌机发射子弹
- 碰撞检测
- 游戏结束界面及重新开始

### 3.1 JavaFX窗体绘制

每一个JavaFX的启动类都必须继承Application类，因此，

创建游戏类：Game.java，继承Application类，并实现内容如下：

```java
package com.blb;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 游戏类
 */
public class Game extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
    }
}
```

运行main方法，即可看到窗体显示。

诚然上述方法可用，但该窗口没有任何内容，因此修改如下：

```java
package com.blb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 游戏类
 */
public class Game extends Application {

    public static final double WIDTH = 480;                 //窗体宽度
    public static final double HEIGHT = 720;                //窗体高度
    public static Canvas canvas;                            //画布对象

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //创建画布对象
        canvas = new Canvas(WIDTH, HEIGHT);
        //创建布局容器，并将画布放入
        AnchorPane anchorPane = new AnchorPane(canvas);
        //将布局容器放到窗体中
        primaryStage.setScene(new Scene(anchorPane));
        //设置标题
        primaryStage.setTitle("飞机大战");
        //显示窗体
        primaryStage.show();
    }
}
```

### 3.2 背景图绘制

绘制背景图就是将图片画到画布上，需要使用画笔GraphicsContext对象的dragImage(image对象, 起始x, 起始y)方法。

创建包com.blb.img，将图片复制进去。

在Game类中添加如下类变量。

```java
public static GraphicsContext gc;                       //画笔对象
public static final String PREFIX = "com/blb/img/";                                 //画布对象
public static final Image backGroundImage = new Image(PREFIX+"bg2.jpg");        	//背景图像
```

新增begin方法，**并在start方法最后调用。**

```java
//游戏开始
public void begin(){
    //从画布对象中获取画笔对象
    gc = canvas.getGraphicsContext2D();
    drawBackground();
}
```

新增背景绘制方法

```java
//绘制背景
public void drawBackground(){
    gc.drawImage(backGroundImage,0,0);
}
```

此时，运行即可看到游戏背景。

如果出现：Caused by: java.lang.IllegalArgumentException: Invalid URL: Invalid URL or resource not found错误，请删掉out目录后重新运行。

![image-20221117173305766](Java%E5%9F%BA%E7%A1%80%E9%98%B6%E6%AE%B5%E9%A1%B9%E7%9B%AE%E2%80%94%E9%A3%9E%E6%9C%BA%E5%A4%A7%E6%88%98.assets/image-20221117173305766.png) 

### 3.3 背景滚动

- 游戏背景的滚动是通过2张图片同时向下移动来实现的，图片要求能首尾相连。

- 滚动效果需要通过定时器不断更新背景图的位置从而实现滚动效果。

在Game类中添加如下类变量

```java
public static Timer timer;                              //定时器
```

修改begin方法，加入定时器

```java
//游戏开始
public void begin(){
    //从画布对象中获取画笔对象
    gc = canvas.getGraphicsContext2D();
    //创建定时器
    timer = new Timer();
    //设置定时任务，延迟0毫秒，间隔10毫秒
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            //画背景
            drawBackground();
        }
    },0,10);
}
```

修改绘制背景方法，实现2张图片向下滚动

```java
//绘制背景
public void drawBackground(){
    gc.drawImage(backGroundImage,0,y);                  //第1张背景图
    gc.drawImage(backGroundImage,0,y-HEIGHT);        //第2张背景图
    if(y++==HEIGHT){
        y=0;
    }
}
```

此时再运行即可实现背景滚动

### 3.4 游戏得分面板绘制

在Game类中添加如下类变量

```java
public static long score;                               //游戏得分
```

新增画游戏得分方法

```java
//画分数
private void drawScore() {
    gc.setFont(Font.font("黑体", FontWeight.BOLD, FontPosture.REGULAR, 20));
    gc.setFill(Color.WHITE);
    gc.fillText("得分：" + score, 10, 25);
}
```

在begin方法中的定时任务中，加入drawScore();用来绘制得分

```java
//游戏开始
public void begin(){
    //从画布对象中获取画笔对象
    gc = canvas.getGraphicsContext2D();
    //创建定时器
    timer = new Timer();
    //设置定时任务，延迟0毫秒，间隔10毫秒
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            //画背景
            drawBackground();
            //画得分
            drawScore();
        }
    },0,10);
}
```

![image-20221117211720055](Java%E5%9F%BA%E7%A1%80%E9%98%B6%E6%AE%B5%E9%A1%B9%E7%9B%AE%E2%80%94%E9%A3%9E%E6%9C%BA%E5%A4%A7%E6%88%98.assets/image-20221117211720055.png) 

### 3.5 英雄机生成

按照第2章项目分析创建下面实体类。

```java
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
```

```java
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
```

```java
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
        super.shootSpeed = 10;
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
```

```java
package com.blb.plane;

import com.blb.Game;
import com.blb.bullet.Bullet;
import com.blb.bullet.EnemyBullet;

import java.util.List;
import java.util.Random;

/**
 * 敌机
 */
public abstract class EnemyPlane extends Plane {

    static Random random = new Random();
    
    public int score;          //分数

    @Override
    public void shoot(List<Bullet> enemyBullets) {
        //敌机X轴中心点
        double centerX = x + image.getWidth()/2;

        for (int i = 0; i < fire; i++) {
            //创建子弹对象
            EnemyBullet enemyBullet = new EnemyBullet();
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
        y+=2;
        if(y> Game.HEIGHT){
            setStatus(false);
        }
    }

}
```

```java
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
    }

}
```

```java
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
    }

}
```

```java
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
```

```java
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
```

```java
package com.blb.bullet;

import com.blb.flyer.Flyer;

/**
 * 子弹
 */
public abstract class Bullet extends Flyer {

    int moveSpeed;              //移动速度

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
```

```java
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
```

```java
package com.blb.bullet;

import com.blb.Game;
import javafx.scene.image.Image;

/**
 * 敌机子弹
 */
public class EnemyBullet extends Bullet {

    static Image image = new Image("com/blb/img/fire1.png");

    public EnemyBullet() {
        super.image = image;
        super.moveSpeed = 3;
    }

    @Override
    public void move(double... point) {
        y+=moveSpeed;
        if(y> Game.HEIGHT){
            setStatus(false);
        }
    }
}
```

在创建完以上这些类后

在Game类中添加如下类变量

```java
public static HeroPlane heroPlane;                      //英雄机
```

修改Game类中的begin方法

```java
public void begin(){
    //从画布对象中获取画笔对象
    gc = canvas.getGraphicsContext2D();
    //创建定时器
    timer = new Timer();
    //创建英雄机
    heroPlane = new HeroPlane();
    //英雄机移动
    canvas.setOnMouseMoved(event -> {
        heroPlane.move(event.getX(), event.getY());
    });

    //设置定时任务，延迟0毫秒，间隔10毫秒
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            //画背景
            drawBackground();
            //画得分
            drawScore();
            //画英雄机
            gc.drawImage(heroPlane.getImage(), heroPlane.getX(), heroPlane.getY());

        }
    },0,10);
}
```

![image-20221117222135373](Java%E5%9F%BA%E7%A1%80%E9%98%B6%E6%AE%B5%E9%A1%B9%E7%9B%AE%E2%80%94%E9%A3%9E%E6%9C%BA%E5%A4%A7%E6%88%98.assets/image-20221117222135373.png) 

### 3.6 英雄机发射子弹

在Game类中添加如下类变量

```java
public static List<Bullet> heroBullets = new ArrayList<>();             //英雄机子弹
public static long count;                                               //定时器执行计数
```

在Game类中添加如下方法用于画英雄机子弹

```java
//画英雄机子弹
private void drawHeroBullet() {
    Iterator<Bullet> iterator = heroBullets.iterator();
    while (iterator.hasNext()){
        Bullet bullet = iterator.next();
        if(!bullet.status){
            iterator.remove();
            continue;
        }
        gc.drawImage(bullet.image, bullet.x, bullet.y);
        bullet.move();
    }
}
```

在Game类的定时任务中加入如下代码

```java
//画英雄机子弹
drawHeroBullet();

//英雄机发射子弹
if(count% (1000/heroPlane.getShootSpeed())==0){
    heroPlane.shoot(heroBullets);
}

count++;
```

![image-20221117222237730](Java%E5%9F%BA%E7%A1%80%E9%98%B6%E6%AE%B5%E9%A1%B9%E7%9B%AE%E2%80%94%E9%A3%9E%E6%9C%BA%E5%A4%A7%E6%88%98.assets/image-20221117222237730.png) 

### 3.7 敌机生成

在Game类中添加如下类变量

```java
public static Random random = new Random();
public static List<EnemyPlane> enemyPlanes = new ArrayList<>();         //敌机
public static List<Explode> explodes = new ArrayList<>();               //爆炸物
```

在Game类中添加如下方法用于生成敌机

```java
//生成敌机
private void createEnemy(){
    int num = random.nextInt(10);
    if(num<6){
        //小飞机
        enemyPlanes.add(new SmallPlane());
    }else if(num < 9){
        //中型飞机
        enemyPlanes.add(new MiddlePlane());
    }else{
        //大飞机
        enemyPlanes.add(new BigPlane());
    }
}
```

在Game类中添加如下方法用于画敌机

```java
//画敌机
private void drawEnemyPlane(){
    Iterator<EnemyPlane> iterator = enemyPlanes.iterator();
    while (iterator.hasNext()){
        EnemyPlane enemyPlane = iterator.next();
        enemyPlane.move();
        gc.drawImage(enemyPlane.image, enemyPlane.x, enemyPlane.y);
        if(!enemyPlane.status){
            //移除，并生成爆炸类
            explodes.add(new Explode(enemyPlane.x, enemyPlane.y));
            iterator.remove();
            continue;
        }
    }
}
```

在Game类中添加如下方法用于画爆炸物

```java
//画爆炸物
private void drawExplode(){
    Iterator<Explode> iterator = explodes.iterator();
    while (iterator.hasNext()){
        Explode explode = iterator.next();
        explode.drwaExplde(gc);
        if(explode.del){
            iterator.remove();
        }
    }
}
```

在Game类的定时任务中加入如下代码

```java
//画敌机
drawEnemyPlane();
//画爆炸物
drawExplode();

//生成敌机
if(count%100==0){
    createEnemy();
}
```

![image-20221117222357276](Java%E5%9F%BA%E7%A1%80%E9%98%B6%E6%AE%B5%E9%A1%B9%E7%9B%AE%E2%80%94%E9%A3%9E%E6%9C%BA%E5%A4%A7%E6%88%98.assets/image-20221117222357276.png) 

### 3.8 敌机发射子弹

在Game类中添加如下类变量

```java
public static List<Bullet> enemyBullets = new ArrayList<>();            //敌机子弹
```

在Game类中添加如下方法用于发射敌方子弹

```java
//敌机发射子弹
private void enemyShoot(){
    Iterator<EnemyPlane> iterator = enemyPlanes.iterator();
    while (iterator.hasNext()){
        EnemyPlane enemyPlane = iterator.next();
        enemyPlane.shoot(enemyBullets);
    }
}

```

在Game类中添加如下方法用于画敌方子弹

```java
//画敌机子弹
private void drawEnemyBullet(){
    Iterator<Bullet> iterator = enemyBullets.iterator();
    while (iterator.hasNext()){
        Bullet bullet = iterator.next();
        gc.drawImage(bullet.image, bullet.x, bullet.y);
        bullet.move();
        if(!bullet.status){
            iterator.remove();
        }
    }
}
```

在Game类的定时任务中加入如下代码

```java
//敌机发射子弹
if(count%200==0){
    enemyShoot();
}
```

![image-20221117222502645](Java%E5%9F%BA%E7%A1%80%E9%98%B6%E6%AE%B5%E9%A1%B9%E7%9B%AE%E2%80%94%E9%A3%9E%E6%9C%BA%E5%A4%A7%E6%88%98.assets/image-20221117222502645.png) 

### 3.9 碰撞检测

在Game类中添加如下方法用于碰撞检测

```java
//碰撞检测
public void collisionCheck(){
    //敌机碰到我方子弹
    for (int i = 0; i < enemyPlanes.size(); i++) {
        EnemyPlane e = enemyPlanes.get(i);
        for (int j = 0; j < heroBullets.size(); j++) {
            Bullet b = heroBullets.get(j);
            if((b.x>e.x && b.x < (e.x + e.getImage().getWidth()) &&
                    b.y>e.y && b.y < (e.y + e.getImage().getHeight())) ||
                    (b.x+b.getImage().getWidth()) > e.x && (b.x+b.getImage().getWidth()) < (e.x + e.getImage().getWidth()) &&
                            b.y>e.y && b.y < (e.y + e.getImage().getHeight())){
                b.setStatus(false);
                e.hp-=1;
                if(e.hp<=0){
                    e.setStatus(false);
                    this.score += e.score;
                }
                break;
            }
        }
    }

    //我方飞机碰撞敌方飞机
    for (int i = 0; i < enemyPlanes.size(); i++) {
        EnemyPlane enemyPlane = enemyPlanes.get(i);
        if((heroPlane.x>enemyPlane.x && heroPlane.x < (enemyPlane.x + enemyPlane.getImage().getWidth()) &&
                heroPlane.y>enemyPlane.y && heroPlane.y < (enemyPlane.y + enemyPlane.getImage().getHeight())) ||
                (heroPlane.x+heroPlane.getImage().getWidth()) > enemyPlane.x && (heroPlane.x+heroPlane.getImage().getWidth()) < (enemyPlane.x + enemyPlane.getImage().getWidth()) &&
                        heroPlane.y>enemyPlane.y && heroPlane.y < (enemyPlane.y + enemyPlane.getImage().getHeight())){
            heroPlane.hp-=1;
            heroPlane.fire=1;
            enemyPlane.hp-=1;
            if(heroPlane.hp<=0){
                drawGameOver();
                break;
            }
            if(enemyPlane.hp<=0){
                enemyPlane.setStatus(false);
                this.score += enemyPlane.score;
            }
        }
    }

    //我方飞机碰撞敌方子弹
    for (int i = 0; i < enemyBullets.size(); i++) {
        Bullet enemyBullet = enemyBullets.get(i);
        if(enemyBullet.getX() > heroPlane.getX() && enemyBullet.getX() < (heroPlane.getX()+heroPlane.getImage().getWidth())
                && enemyBullet.getY() > heroPlane.getY() && enemyBullet.getY() < (heroPlane.getY() + heroPlane.getImage().getHeight())){
            enemyBullet.setStatus(false);
            heroPlane.hp-=1;
            heroPlane.fire=1;
            if(heroPlane.hp<=0){
                drawGameOver();
                break;
            }
        }
    }
}
```

### 3.10 游戏结束界面及重新开始

在Game类中添加如下方法用于绘制游戏结束

```java
//游戏结束
public void drawGameOver(){
    gc.setFont(Font.font("黑体", FontWeight.BOLD, FontPosture.REGULAR, 30));
    gc.setFill(Color.BLUE);
    gc.fillText("最终得分：" + score, 110, 360);
    gc.fillText("点击重新开始", 110, 420);
    timer.cancel();
    timer = null;
    score = 0;
    heroBullets.clear();
    enemyPlanes.clear();
    enemyBullets.clear();
    runStatus = false;
}
```

在Game类的begin方法中加入下面代码

```java
//结束后点击重新开始
canvas.setOnMouseClicked(event -> {
    if(!runStatus){
        begin();
    }
});
```

### 3.11 优化程序

将画图任何放到其它线程去执行，提高流畅度，即将代码放在Platform.runLater中

```java
Platform.runLater(()->{
    //画背景
    drawBackground();
    //画敌机
    drawEnemyPlane();
    //画敌机子弹
    drawEnemyBullet();
    //画爆炸物
    drawExplode();
    //画英雄机子弹
    drawHeroBullet();
    //画英雄机
    gc.drawImage(heroPlane.getImage(), heroPlane.getX(), heroPlane.getY());
    //画得分
    drawScore();
});
```

修改游戏结束部分代码如下，否则会出错

```java
//游戏结束
public void drawGameOver(){
    Platform.runLater(()->{
        if(timer!=null){
            timer.cancel();
        }
        timer = null;
        heroBullets.clear();
        enemyPlanes.clear();
        enemyBullets.clear();
        runStatus = false;
        gc.setFont(Font.font("黑体", FontWeight.BOLD, FontPosture.REGULAR, 30));
        gc.setFill(Color.BLUE);
        gc.fillText("最终得分：" + score, 110, 360);
        gc.fillText("点击重新开始", 110, 420);
        score = 0;
    });
}
```

