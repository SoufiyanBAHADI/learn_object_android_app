package com.example.rick.learnObjects.Screens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.e_mobadara.audiomanaging.AudioSettingsActivity;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.emobadaragaminglib.Implementation.AndroidMusic;
import com.example.rick.learnObjects.R;
import com.example.rick.learnObjects.Sprites.AnimauxButton;
import com.example.rick.learnObjects.Sprites.Circle;
import com.example.rick.learnObjects.Sprites.FruitButton;
import com.example.rick.learnObjects.Sprites.Legume;
import com.example.rick.learnObjects.Sprites.LegumeButton;
import com.example.rick.learnObjects.Sprites.Mute;
import com.example.rick.learnObjects.Sprites.PersonaliseButton;
import com.example.rick.learnObjects.Sprites.Quit;
import com.example.rick.learnObjects.Sprites.Vetement;
import com.example.rick.learnObjects.Sprites.VetementButton;
import com.example.rick.learnObjects.Sprites.VolumeBar;
import com.example.rick.learnObjects.Sprites.VolumeUp;
import com.example.rick.learnObjects.assets.Decor;
import com.example.rick.learnObjects.assets.MyScreen;
import com.example.rick.learnObjects.state.CategoriesActivity;
import com.example.rick.learnObjects.state.GameActivity;
import com.example.rick.learnObjects.state.GameStats;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.emobadaragaminglib.Implementation.AndroidGraphics.TAG;

public class CategoriesScreen extends Screen {
    private Sprite fruitButton, legumeButton, animauxButton, vetementButton, personaliseButton, bg, title, circle, volumeBar, mute, volumeUp, quit;
    private int width = game.getGraphics().getWidth();
    private int height = game.getGraphics().getHeight();

    public CategoriesScreen(Game game) {
        super(game);



        Decor.bgAudio.play();
        Decor.bgAudio.setLooping(true);

        bg = new Sprite(Decor.bg, 0,0,height,width);
        fruitButton = new FruitButton(Decor.buttonFruit, width/2-(4*width/5)/2, height/5, 7*height/80 ,4*width/5);
        legumeButton = new LegumeButton(Decor.buttonLegume, width/2-(4*width/5)/2, fruitButton.getY()+fruitButton.getHeight()+height/20, 7*height/80 ,4*width/5);
        animauxButton = new AnimauxButton(Decor.buttonAnimaux, width/2-(4*width/5)/2, legumeButton.getY()+fruitButton.getHeight()+height/20, 7*height/80 ,4*width/5);
        vetementButton = new VetementButton(Decor.buttonVetement, width/2-(4*width/5)/2, animauxButton.getY()+fruitButton.getHeight()+height/20, 7*height/80 ,4*width/5);
        personaliseButton = new PersonaliseButton(Decor.buttonPersonnalise, width/2-(4*width/5)/2, vetementButton.getY()+fruitButton.getHeight()+height/20, 7*height/80 ,4*width/5);
        title = new FruitButton(Decor.title, width/2-(4*width/5)/2, height/25, 7*height/80 ,4*width/5);

        volumeBar = new VolumeBar(Decor.volumeBar,width/4+width/16,personaliseButton.getY()+height/5, height/80, 3*width/5);
        circle = new Circle(Decor.circle, width/4+width/16+3*width/5-(height/25)/2, volumeBar.getY()-height/50+volumeBar.getHeight()/2, height/25, height/25);
        mute = new Mute(Decor.mute, width/8+width/16, circle.getY(), circle.getHeight(), circle.getWidth());
        volumeUp = new VolumeUp(Decor.volumeUp, width/8+width/16, circle.getY(), circle.getHeight(), circle.getWidth());
        quit = new Quit(Decor.quit, width/16, circle.getY(), circle.getHeight(), circle.getWidth());

        addSprite(bg);
        addSprite(fruitButton);
        addSprite(legumeButton);
        addSprite(animauxButton);
        addSprite(vetementButton);
        addSprite(personaliseButton);
        addSprite(title);
        addSprite(volumeBar);
        addSprite(circle);
        addSprite(volumeUp);
        addSprite(quit);

    }

    @Override
    public void render(float deltaTime) {
        if(circle.getY()!=volumeBar.getY()-height/50+volumeBar.getHeight()/2 ){
            circle.setY(volumeBar.getY()-height/50+volumeBar.getHeight()/2);
        }
        if (circle.getX()<width/4+width/16){
            circle.setX(width/4+width/16);
        }
        if(circle.getX()>width/4+width/16+3*width/5-circle.getWidth()/2){
            circle.setX(width/4+width/16+3*width/5-circle.getWidth()/2);
        }
        float volume = ((float)(circle.getX()-volumeBar.getX())/(float)(3*width/5-circle.getWidth()/2));
        if (Decor.bgAudio!=null) {
            Decor.bgAudio.setVolume(volume);
        }


    }

    @Override
    public void handleTouchDown(int x, int y, int pointer) {
        super.handleTouchDown(x, y, pointer);
        Sprite s = getDraggedSprite();
        Log.i(TAG, "handleTouchDown: S class is: " + s.getClass());
        if (s != null && s.getClass() == FruitButton.class) {
            MyScreen.myScreen="fruits";
            Intent intent = new Intent( (Context) game, GameActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ((Context) game).getApplicationContext().startActivity(intent);
            ((Activity) game).finish();
        }else if (s != null && s.getClass() == LegumeButton.class) {
            MyScreen.myScreen="legumes";
            Intent intent = new Intent( (Context) game, GameActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ((Context) game).getApplicationContext().startActivity(intent);
            ((Activity) game).finish();
        }else if (s != null && s.getClass() == VetementButton.class) {
            MyScreen.myScreen="vetements";
            Intent intent = new Intent( (Context) game, GameActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ((Context) game).getApplicationContext().startActivity(intent);
            ((Activity) game).finish();
        }else if (s != null && s.getClass() == AnimauxButton.class) {
            MyScreen.myScreen="animaux";
            Intent intent = new Intent( (Context) game, GameActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ((Context) game).getApplicationContext().startActivity(intent);
            ((Activity) game).finish();
        }else if (s != null && s.getClass() == PersonaliseButton.class) {
            MyScreen.myScreen="personnalise";
            Intent intent = new Intent( (Context) game, GameActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ((Context) game).getApplicationContext().startActivity(intent);
            ((Activity) game).finish();
        }else if (s != null && s.getClass() == Mute.class) {
            Decor.bgAudio.play();
            Decor.bgAudio.setLooping(true);
            removeSprite(mute);
            Decor.volumeUp = game.getGraphics().newImage(R.drawable.volumeup, Graphics.ImageFormat.ARGB8888, game.getResources());
            volumeUp = new VolumeUp(Decor.volumeUp, width/8+width/16, circle.getY(), circle.getHeight(), circle.getWidth());
            addSprite(volumeUp);
        }else if (s != null && s.getClass() == VolumeUp.class) {
            Decor.bgAudio.setLooping(false);
            Decor.bgAudio.pause();
            removeSprite(volumeUp);
            Decor.mute = game.getGraphics().newImage(R.drawable.mute, Graphics.ImageFormat.ARGB8888, game.getResources());
            mute = new Mute(Decor.mute, width/8+width/16, circle.getY(), circle.getHeight(), circle.getWidth());
            addSprite(mute);
        }else if (s != null && s.getClass() == Quit.class){
            ((Activity) game).finishAffinity();
            @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            GameStats.gameStat.setUpdated_at(dateFormat.format(date));
            System.exit(0);
        }
    }

            @Override
    public void pause() {
        if(Decor.bgAudio!=null){
            Decor.bgAudio.setLooping(false);
            Decor.bgAudio.pause();
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void backButton() {
    }
}
