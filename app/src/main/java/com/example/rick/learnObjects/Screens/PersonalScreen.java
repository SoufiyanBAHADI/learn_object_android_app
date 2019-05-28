package com.example.rick.learnObjects.Screens;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.e_mobadara.audiomanaging.AudioSettingsActivity;
import com.e_mobadara.audiomanaging.MySignal;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.rick.learnObjects.R;
import com.example.rick.learnObjects.Sprites.Back;
import com.example.rick.learnObjects.Sprites.Home;
import com.example.rick.learnObjects.Sprites.Language;
import com.example.rick.learnObjects.assets.Decor;
import com.example.rick.learnObjects.assets.Legumes;
import com.example.rick.learnObjects.assets.MyScreen;
import com.example.rick.learnObjects.state.CategoriesActivity;

public class PersonalScreen extends Screen {

    private Sprite bg, ar, fr, lang, audioSettings, home, back;
    private int height, width;

    public PersonalScreen(Game game) {
        super(game);

        height = game.getGraphics().getHeight();
        width = game.getGraphics().getWidth();


        bg = new Sprite(Decor.bg, 0,0,height,width);
        if(MyScreen.langue.equals("fr")){
            ar = new Language(Decor.ar, "ar", width/2, height/5, height/10, height/10);
            fr = new Language(Decor.fr, "fr", width/2+height/10+height/40, height/5, height/10, height/10);
            lang = new Language(Decor.lang, "none", width/10, height/5, height/10, height/5);
        }else{
            lang = new Language(Decor.lang, "none", 7*width/10, height/5, height/10, height/8);
            ar = new Language(Decor.ar, "ar", lang.getX()-lang.getWidth()-height/40, height/5, height/10, height/10);
            fr = new Language(Decor.fr, "fr", ar.getX()-height/40-height/10, height/5, height/10, height/10);
        }
        audioSettings = new Language(Decor.audioparam, "settings", width/2-(4*width/5)/2, 2*height/5, 7*height/80, 4*width/5);
        home = new Language(Decor.homeButton, "home",10, game.getGraphics().getHeight()-game.getGraphics().getWidth()/5, game.getGraphics().getWidth()/6, game.getGraphics().getWidth()/6);

        addSprite(bg);
        addSprite(fr);
        addSprite(ar);
        addSprite(lang);
        addSprite(audioSettings);
        addSprite(home);

    }

    @Override
    public void render(float deltaTime) {
    }

    @Override
    public void handleTouchDown(int x, int y, int pointer) {
        super.handleTouchDown(x, y, pointer);
        Sprite s = getDraggedSprite();
        if (s != null && s.getClass() == Language.class) {
            Language language = (Language) s;
            if(language.getLang().equals("ar")){
                MyScreen.langue = "ar";
                removeSprite(ar);
                removeSprite(fr);
                removeSprite(lang);
                removeSprite(audioSettings);

                Decor.fr = game.getGraphics().newImage(R.drawable.fr, Graphics.ImageFormat.ARGB8888,game.getResources());
                Decor.ar = game.getGraphics().newImage(R.drawable.ar,Graphics.ImageFormat.ARGB8888,game.getResources());
                Decor.lang = game.getGraphics().newImage(R.drawable.langar,Graphics.ImageFormat.ARGB8888,game.getResources());
                Decor.audioparam = game.getGraphics().newImage(R.drawable.audioparamar, Graphics.ImageFormat.ARGB8888,game.getResources());

                lang = new Language(Decor.lang, "none", 7*width/10, height/5, height/10, height/8);
                ar = new Language(Decor.ar, "ar", lang.getX()-lang.getWidth()-height/40, height/5, height/10, height/10);
                fr = new Language(Decor.fr, "fr", ar.getX()-height/40-height/10, height/5, height/10, height/10);
                audioSettings = new Language(Decor.audioparam, "settings", width/2-(4*width/5)/2, 2*height/5, 7*height/80, 4*width/5);


                addSprite(fr);
                addSprite(ar);
                addSprite(lang);
                addSprite(audioSettings);
            }else if (language.getLang().equals("fr")){
                MyScreen.langue = "fr";
                removeSprite(ar);
                removeSprite(fr);
                removeSprite(lang);
                removeSprite(audioSettings);

                Decor.fr = game.getGraphics().newImage(R.drawable.fr,Graphics.ImageFormat.ARGB8888,game.getResources());
                Decor.ar = game.getGraphics().newImage(R.drawable.ar,Graphics.ImageFormat.ARGB8888,game.getResources());
                Decor.lang = game.getGraphics().newImage(R.drawable.lang,Graphics.ImageFormat.ARGB8888,game.getResources());
                Decor.audioparam = game.getGraphics().newImage(R.drawable.audioparam, Graphics.ImageFormat.ARGB8888,game.getResources());

                ar = new Language(Decor.ar, "ar", width/2, height/5, height/10, height/10);
                fr = new Language(Decor.fr, "fr", width/2+height/10+height/40, height/5, height/10, height/10);
                lang = new Language(Decor.lang, "none", width/10, height/5, height/10, height/5);
                audioSettings = new Language(Decor.audioparam, "settings", width/2-(4*width/5)/2, 2*height/5, 7*height/80, 4*width/5);


                addSprite(fr);
                addSprite(ar);
                addSprite(lang);
                addSprite(audioSettings);
            }else if (language.getLang().equals("settings")){
                Intent intent = new Intent( (Context) game, AudioSettingsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ((Context) game).getApplicationContext().startActivity(intent);
            }else if (language.getLang().equals("home")){
                Intent intent = new Intent( (Context) game, CategoriesActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ((Context) game).getApplicationContext().startActivity(intent);
                ((Activity) game).finish();
            }
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        if(MySignal.homeSignal){
            MySignal.homeSignal = false;
            Intent intent = new Intent( (Context) game, CategoriesActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ((Context) game).getApplicationContext().startActivity(intent);
            ((Activity) game).finish();
        }

    }

    @Override
    public void backButton() {

    }
}
