package com.example.rick.learnObjects.Sprites;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.emobadaragaminglib.Implementation.AndroidSound;

public class Animal extends Sprite {
    private int id;
    private AndroidSound mAndroidSound;
    private AndroidSound qAndroidSound;

    public Animal(Game game, int id, Image image, AndroidSound sound, AndroidSound question , int x, int y, int height, int width) {
        super( image, x, y, height, width);
        this.mAndroidSound = sound;
        this.qAndroidSound = question;
        this.id = id;
    }
    //we leave them static
    public void play(){
        this.mAndroidSound.play(1);
    }
    public void playQuestion() {this.qAndroidSound.play(1);}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AndroidSound getmAndroidSound() {
        return mAndroidSound;
    }

    public void setmAndroidSound(AndroidSound mAndroidSound) {
        this.mAndroidSound = mAndroidSound;
    }

    public AndroidSound getqAndroidSound() {
        return qAndroidSound;
    }

    public void setqAndroidSound(AndroidSound qAndroidSound) {
        this.qAndroidSound = qAndroidSound;
    }
}
