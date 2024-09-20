package com.jade;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ML extends MouseAdapter {
    public boolean mouseClicked = false;
    public boolean mouseDraged  = false;
    public int mouseButton = -1;

    public float x = -1.0f, y = -1.0f;
    public float dx = -1.0f, dy = -1.0f;

    @Override
    public void mouseClicked(MouseEvent mouseEvent){
        this.mouseClicked = true;
        this.mouseButton = mouseEvent.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent){
        this.mouseClicked = false;
        this.mouseDraged = false;
        this.dx = 0;
        this.dy = 0;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent){
        this.x = mouseEvent.getX();
        this.y = mouseEvent.getY();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent){
        this.mouseDraged = true;
        this.x = mouseEvent.getX() - this.x;
        this.y = mouseEvent.getY() - this.y;
    }
}
