package com.jade;

import com.Component.BoxBounds;
import com.Component.Sprite;
import com.Component.SpriteSheet;
import com.dataStructure.AssetPool;
import com.dataStructure.Transform;
import com.util.Constants;
import com.util.Vector2;

import java.awt.*;

public class LevelEditorScene extends Scene{
        GameObject testObj;
//    GameObject testObj = new GameObject("Some game object", new Transform(new Vector2(0.0f, 0.0f)));

    public LevelEditorScene(String name) {
        super.Scene(name);
    }



    @Override
    public void init() {
        testObj = new GameObject("Some game object", new Transform(new Vector2(500, 350.0f)));
        SpriteSheet spriteSheet = new SpriteSheet("assets/player/layerOne.png", 42, 42, 2, 13, 13*5);
        testObj.addComponent(spriteSheet.sprites.get(43));
    }

    @Override
    public void update(double dt) {
//        System.out.println(testObj.getComponent(BoxBounds.class).name);
        testObj.update(dt);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        testObj.draw(g2);
    }
}
