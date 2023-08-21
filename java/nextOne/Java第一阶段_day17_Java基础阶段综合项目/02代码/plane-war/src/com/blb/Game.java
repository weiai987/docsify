package com.blb;

import com.blb.bullet.Bullet;
import com.blb.explode.Explode;
import com.blb.plane.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.*;

/**
 * 游戏类
 */
public class Game extends Application {

    public static final double WIDTH = 480;                 //窗体宽度
    public static final double HEIGHT = 720;                //窗体高度
    public static Canvas canvas;                            //画布对象
    public static GraphicsContext gc;                       //画笔对象
    public static final String PREFIX = "com/blb/img/";                                 //画布对象
    public static final Image backGroundImage = new Image(PREFIX+"bg2.jpg");        //背景图像
    public static double y;                                 //背景图y坐标
    public static Timer timer;                              //定时器
    public static long score;                               //游戏得分
    public static HeroPlane heroPlane;                      //英雄机
    public static List<Bullet> heroBullets = new ArrayList<>();             //英雄机子弹
    public static long count;                                               //定时器执行计数
    public static Random random = new Random();
    public static List<EnemyPlane> enemyPlanes = new ArrayList<>();         //敌机
    public static List<Explode> explodes = new ArrayList<>();               //爆炸物
    public static List<Bullet> enemyBullets = new ArrayList<>();            //敌机子弹
    public static boolean runStatus = true;                                 //运行状态

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
        //开始游戏
        begin();
    }

    //游戏开始
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
        //结束后点击重新开始
        canvas.setOnMouseClicked(event -> {
            if(!runStatus){
                begin();
            }
        });

        //设置定时任务，延迟0毫秒，间隔10毫秒
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
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

                //英雄机发射子弹
                if(count% (1000/heroPlane.getShootSpeed())==0){
                    heroPlane.shoot(heroBullets);
                }
                //生成敌机
                if(count%50==0){
                    createEnemy();
                }
                //敌机发射子弹
                if(count%200==0){
                    enemyShoot();
                }

                //碰撞检测
                collisionCheck();

                count++;
            }
        },0,10);
    }

    //绘制背景
    public void drawBackground(){
        gc.drawImage(backGroundImage,0,y);                  //第1张背景图
        gc.drawImage(backGroundImage,0,y-HEIGHT);        //第2张背景图
        if(y++==HEIGHT){
            y=0;
        }
    }

    //画分数
    private void drawScore() {
        gc.setFont(Font.font("黑体", FontWeight.BOLD, FontPosture.REGULAR, 20));
        gc.setFill(Color.WHITE);
        gc.fillText("得分：" + score, 10, 25);
        gc.fillText("生命：" + heroPlane.getHp(), 10, 45);
        gc.fillText("火力：" + heroPlane.getFire(), 10, 65);
    }

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

    //敌机发射子弹
    private void enemyShoot(){
        Iterator<EnemyPlane> iterator = enemyPlanes.iterator();
        while (iterator.hasNext()){
            EnemyPlane enemyPlane = iterator.next();
            enemyPlane.shoot(enemyBullets);
        }
    }

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

}
