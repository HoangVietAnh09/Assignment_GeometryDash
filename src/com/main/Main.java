package com.main;


import game.Window;

public class Main {
    public static void main(String[] args) {
        Window window = Window.getWindow();
//        window.init();

        //Create a thread to run game
        Thread mainThread = new Thread(window);
        mainThread.start();

    }
}

//Test branch and merge
