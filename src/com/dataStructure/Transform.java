package com.dataStructure;

import com.util.Vector2;

public class Transform {
    public Vector2 position;
    public Vector2 rotation;
    public Vector2 scale;

    public Transform(Vector2 position) {
        this.position = position;
        this.rotation = new Vector2(0, 0);
        this.scale = new Vector2(1, 1);
    }

    @Override
    public String toString() {
        return "Positon (" + position.x + ", " + position.y + ")";
    }
}
