package com.jade;

import com.util.Constants;
import com.util.Time;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {

    public ML mouseListener;
    public KL keyListener;

    private static Window window = null;
    private boolean isRunning = true;
    private Scene currentScene = new LevelEditorScene("Level Editor");
//    private Scene currentScene;
    private Image doubleBufferImage = null;
    private Graphics doubleBufferGraphics = null;


    //Constructor
    public Window(){
        this.mouseListener = new ML();
        this.keyListener = new KL();
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
        this.setLocationRelativeTo(null);
    }


    public void init(){
        changeScene(0);
    }

    public void changeScene(int scene){
        switch (scene){
            case 0:
                currentScene = new LevelEditorScene("Level Editor");
                break;
            default:
                System.out.println("Invalid scene selected");
                currentScene = null;
                break;

        }
    }


    //Create a window
    public static Window getWindow(){
        if(Window.window == null){
            Window.window = new Window();
        }
        return Window.window;
    }

    public void update(double dataTime){
        currentScene.update(dataTime);
        draw(getGraphics());
    }


    public void draw(Graphics g){
        if(doubleBufferImage == null){
            doubleBufferImage = createImage(this.getWidth(), this.getHeight());
            doubleBufferGraphics = doubleBufferImage.getGraphics();

        }
        renderOffScene(doubleBufferGraphics);

        g.drawImage(doubleBufferImage, 0, 0, getWidth(), getHeight(), null);
    }

    public void renderOffScene(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        currentScene.draw(g2);
    }


    @Override
    public void run() {

        double lastFrameTime = 0.0;
        try{
            while(isRunning){
                double time = Time.getTimeStarted();
                double deltatime = time - lastFrameTime;
                lastFrameTime = time;

                update(deltatime);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
