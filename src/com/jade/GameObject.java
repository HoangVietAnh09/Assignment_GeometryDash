package com.jade;

import com.dataStructure.Transform;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject {
    private List<Component> components = new ArrayList<>();
    private String name;
    public Transform transform;

    public GameObject(String name, Transform transform) {
        this.name = name;
        this.transform = transform;
        this.components = new ArrayList<>();

    }

    public <T extends Component> T getComponent(Class<T> componentClass){
        for(Component component : components){
            if(componentClass.isAssignableFrom(component.getClass())){
                try{
                    return componentClass.cast(component);
                } catch (ClassCastException e){
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
        }
        return null;
    }

    public void addComponent(Component component){
        components.add(component);
        component.gameObject = this;
    }

    public void update(double deltaTime) {
//        System.out.println(this.name + " " + this.transform);
        for(Component component : components){
            component.update(deltaTime);
        }
    }

    public void draw(Graphics2D g2) {
        for(Component component : components){
            component.draw(g2);
        }
    }

}
