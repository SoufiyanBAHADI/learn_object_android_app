package com.example.rick.learnObjects.Screens;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

import com.e_mobadara.audiomanaging.moblibAudioFileManager;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.emobadaragaminglib.Implementation.AndroidSound;
import com.example.rick.learnObjects.R;
import com.example.rick.learnObjects.Sprites.BackGround;
import com.example.rick.learnObjects.Sprites.Fruit;
import com.example.rick.learnObjects.Sprites.Home;
import com.example.rick.learnObjects.Sprites.Refresh;
import com.example.rick.learnObjects.Sprites.SayQuestion;
import com.example.rick.learnObjects.assets.Decor;
import com.example.rick.learnObjects.assets.Fruits;
import com.example.rick.learnObjects.assets.MyScreen;
import com.example.rick.learnObjects.assets.Position;
import com.example.rick.learnObjects.state.CategoriesActivity;
import com.example.rick.learnObjects.state.GameStats;

import java.util.ArrayList;
import java.util.Collections;

public class FruitScreen extends Screen {
    private static final String TAG = "FruitScreen";
    private Game game;

    private Fruit ananas, apricot, banane, cerise, citron, datte, fraise, kaki, melon, noix, orange, peche, poire, pomme, prune, raisin;
    private ArrayList<Fruit> myFruits, myFruitsNotShuffeled;
    private Sprite bg;
    private Home home;
    private Refresh refresh;
    private SayQuestion question;
    private boolean shufflePositions = false;
    private boolean stopNotifying = false;
    private boolean allowedToTouch = false;
    private boolean growing = true;
    private boolean shrinking = false;
    private boolean stopSound = false;
    private boolean stopQuestion2 = true;
    private boolean timeToMakePosition = false;
    private boolean startToShuffle = false;
    private boolean startAsking = false;
    private boolean answer0 = false;
    private boolean answer = false;
    private boolean shuffle = true;
    private boolean refreshing = false;
    private boolean repeatQuestion = false;
    private int nbrWhenToStart = 0;
    private boolean startTrackingToNotify = false;
    private int notifyMode = 0;
    private long startTime;
    private MediaPlayer oui,non;
    private AndroidSound oui2,non2;
    private Fruit fruitAnswer, fruitQuestion;
    private int nbrAnimation = 0;
    private int width;
    private int heigth;
    private int index = 0;
    private int index2 =0;
    private ArrayList<Position> positions = new ArrayList<Position>();
    private int xGauche;
    private int yHaut;
    private int xDroite;
    private int yBas;



    public FruitScreen(Game game) {
        super(game);
        this.game=game;
        width = game.getGraphics().getWidth()/4;
        heigth = game.getGraphics().getHeight()/6;

        xGauche = (game.getGraphics().getWidth()/4)-width/2;
        yHaut = (game.getGraphics().getHeight()/4)-heigth/4;
        xDroite = 3*(game.getGraphics().getWidth()/4)-width/2;
        yBas = 3*(game.getGraphics().getHeight()/4)-heigth/2;

        positions.add(new Position(xGauche, yHaut));
        positions.add(new Position(xDroite, yHaut));
        positions.add(new Position(xGauche, yBas));
        positions.add(new Position(xDroite, yBas));


//        Collections.shuffle(positions);

        Log.i(TAG, "FruitScreen: Initialized the Screen");

        bg = new BackGround(Decor.bg, 0, 0, game.getGraphics().getHeight(), game.getGraphics().getWidth());
        home = new Home(Decor.homeButton, 10, game.getGraphics().getHeight()-game.getGraphics().getWidth()/5, game.getGraphics().getWidth()/6, game.getGraphics().getWidth()/6);
        refresh = new Refresh(Decor.refreshButton, 10, 10, game.getGraphics().getWidth()/8, game.getGraphics().getWidth()/8);
        question = new SayQuestion(Decor.questionButton, 6*refresh.getWidth()/5, 10, game.getGraphics().getWidth()/8, game.getGraphics().getWidth()/8);

        addSprite(bg);
        addSprite(home);
        addSprite(refresh);
        addSprite(question);

        if (MyScreen.langue.equals("fr")) {
            oui = moblibAudioFileManager.getRandomAudioFile((Context) game, "good", "FR");
            non = moblibAudioFileManager.getRandomAudioFile((Context) game, "encouragement", "FR");
            oui2 = (AndroidSound) game.getAudio().createSound(R.raw.oui);
            non2 = (AndroidSound) game.getAudio().createSound(R.raw.non);
        } else {
            oui = moblibAudioFileManager.getRandomAudioFile((Context) game, "excellent", "AR");
            non = moblibAudioFileManager.getRandomAudioFile((Context) game, "encouragement", "AR");
            oui2 = (AndroidSound) game.getAudio().createSound(R.raw.ouiar);
            non2 = (AndroidSound) game.getAudio().createSound(R.raw.nonar);
        }
        Log.i(TAG, "FruitScreen: Initialized bg");

        myFruits = new ArrayList<Fruit>();
        if(Fruits.ananas!=null) {
            ananas = new Fruit(game, 1,Fruits.ananas, Fruits.ananasAudio, Fruits.qAnanasAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(ananas);
        }
        if(Fruits.apricot!=null){
            apricot = new Fruit(game, 2,Fruits.apricot, Fruits.apricotAudio,Fruits.qApricotAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(apricot);
        }
        if(Fruits.banane!=null){
            banane = new Fruit(game, 3,Fruits.banane, Fruits.bananeAudio,Fruits.qBananeAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(banane);
        }
        if(Fruits.cerise!=null){
            cerise = new Fruit(game, 4,Fruits.cerise, Fruits.ceriseAudio,Fruits.qCeriseAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(cerise);
        }
        if(Fruits.citron!=null){
            citron = new Fruit(game, 5,Fruits.citron, Fruits.citronAudio,Fruits.qCitronAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(citron);
        }
        if(Fruits.datte!=null){
            datte = new Fruit(game, 6,Fruits.datte, Fruits.datteAudio,Fruits.qDatteAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(datte);
        }
        if(Fruits.fraise!=null){
            fraise = new Fruit(game, 7,Fruits.fraise, Fruits.fraiseAudio,Fruits.qFraiseAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(fraise);
        }
        if(Fruits.kaki!=null){
            kaki = new Fruit(game, 8,Fruits.kaki, Fruits.kakiAudio,Fruits.qKakiAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(kaki);
        }
        if(Fruits.melon!=null){
            melon = new Fruit(game, 9,Fruits.melon, Fruits.melonAudio,Fruits.qMelonAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(melon);
        }
        if(Fruits.noix!=null){
            noix = new Fruit(game, 10,Fruits.noix, Fruits.noixAudio,Fruits.qNoixAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(noix);
        }
        if(Fruits.orange!=null){
            orange = new Fruit(game, 11,Fruits.orange, Fruits.orangeAudio,Fruits.qOrangeAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(orange);
        }
        if(Fruits.peche!=null){
            peche = new Fruit(game, 12,Fruits.peche, Fruits.pecheAudio,Fruits.qPecheAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(peche);
        }
        if(Fruits.poire!=null){
            poire = new Fruit(game, 13,Fruits.poire, Fruits.poireAudio,Fruits.qPoireAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(poire);
        }
        if(Fruits.pomme!=null){
            pomme = new Fruit(game, 14,Fruits.pomme, Fruits.pommeAudio,Fruits.qPommeAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(pomme);
        }
        if(Fruits.prune!=null){
            prune = new Fruit(game, 15,Fruits.prune, Fruits.pruneAudio,Fruits.qPruneAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(prune);
        }
        if(Fruits.raisin!=null){
            raisin = new Fruit(game, 16,Fruits.raisin, Fruits.raisinAudio,Fruits.qRaisinAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myFruits.add(raisin);
        }

        myFruitsNotShuffeled = ((ArrayList<Fruit>) myFruits.clone());
        //The Sprites will respect the order you put them into
        //So Make sure that you add your decor and background first before you put the
        //sprites that you want the user to interact with
        for(Fruit f : myFruits){
            addSprite(f);
        }

        positions.add(new Position(xGauche, yHaut));
        positions.add(new Position(xDroite, yHaut));
        positions.add(new Position(xGauche, yBas));
        positions.add(new Position(xDroite, yBas));

        startTime = System.currentTimeMillis();
    }

    @Override
    public void render(float deltaTime) {

        if(nbrWhenToStart>15){ //to hundle the problem of not saying the first sprite name
            if(!startToShuffle && !timeToMakePosition && !startAsking){
                if(notifyMode == 2){
                    for(Fruit fr : myFruits){
                        fr.setHeight(this.heigth);
                        fr.setWidth(this.width);
                    }
                    notifyMode = 0;
                }
                if(index < myFruitsNotShuffeled.size()) {
                    if(!stopSound){
                        myFruitsNotShuffeled.get(index).play();
                        stopSound=true;
                    }

                    try {

                        if (growing && myFruitsNotShuffeled.get(index).getWidth() <= 1.5 * this.width) {
                            for(int i= 0; i<20; i++){
                                myFruitsNotShuffeled.get(index).setWidth(myFruitsNotShuffeled.get(index).getWidth() + 1);
                                myFruitsNotShuffeled.get(index).setHeight(myFruitsNotShuffeled.get(index).getHeight() + 1);
                            }
                            //Thread.sleep(1);

                        } else if (myFruitsNotShuffeled.get(index).getWidth() > this.width) {

                            this.growing = false;
                            this.shrinking = true;

                            for (int i=0; i<20;i++) {
                                myFruitsNotShuffeled.get(index).setWidth(myFruitsNotShuffeled.get(index).getWidth() - 1);
                                myFruitsNotShuffeled.get(index).setHeight(myFruitsNotShuffeled.get(index).getHeight() - 1);
                            }
                            //Thread.sleep(1);

                        } else if (shrinking && myFruits.get(0).getWidth() == this.width) {
                            this.nbrAnimation++;
                            growing = true;
                            shrinking = false;
                            if (nbrAnimation%5==0) {
                                index++;
                                stopSound=false;
                            }
                        }
                    } catch (Exception e) {
                    }

                }else{
                    try {
                        Thread.sleep(200);
                        startToShuffle = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else if (!timeToMakePosition && !startAsking && startToShuffle){

                for(Fruit f : myFruits){
                    for(int i=0; i<40; i++){

                        if (f.getX() > (game.getGraphics().getWidth() / 2) - f.getWidth() / 2) {
                            f.setX(f.getX() - 1);

                        } else if (f.getX() < (game.getGraphics().getWidth() / 2) - f.getWidth() / 2) {
                            f.setX(f.getX() + 1);

                        }

                        if (f.getY() > (game.getGraphics().getHeight() / 2) - f.getHeight() / 2) {
                            f.setY(f.getY() - 1);

                        } else if (f.getY() < (game.getGraphics().getHeight() / 2) - f.getHeight() / 2) {
                            f.setY(f.getY() + 1);
                        }


                        if (index2 == myFruits.size()-1 && f.getX() == (game.getGraphics().getWidth() / 2) - f.getWidth() / 2 && f.getY() == (game.getGraphics().getHeight() / 2) - f.getHeight() / 2) {
                            startToShuffle = false;
                            timeToMakePosition = true;
                            shufflePositions = true;

                        }
                    }
                    index2 ++;
                    index2 = index2%myFruits.size();
                }

            }else if(!startAsking && !startToShuffle && timeToMakePosition){

                if(shufflePositions){
                    Collections.shuffle(positions);
                    shufflePositions = false;
                }
                index2 = 0;
                for(Fruit f : myFruits) {
                    index2 = index2 % myFruits.size();
                    for (int i = 0; i < 40; i++) {

                        if (f.getX() > positions.get(index2).getX()) {
                            f.setX(f.getX() - 1);

                        } else if (f.getX() < positions.get(index2).getX()) {
                            f.setX(f.getX() + 1);

                        }

                        if (f.getY() > positions.get(index2).getY()) {
                            f.setY(f.getY() - 1);

                        } else if (f.getY() < positions.get(index2).getY()) {
                            f.setY(f.getY() + 1);
                        }


                        if (index2 == myFruits.size()-1 && f.getX() == positions.get(index2).getX() && f.getY() == positions.get(index2).getY()) {
                            startToShuffle = false;
                            timeToMakePosition = false;
                            startAsking = true;


                        }
                    }
                    index2++;

                }

            }else{
                if(!answer0){
                    if(shuffle){
                        Collections.shuffle(myFruits);
                        shuffle = false;
                    }
                    Fruit f = myFruits.get(0);
                    fruitQuestion = myFruits.get(0);
                    if(!stopSound){
                        f.playQuestion();
                        stopSound = true;
                        allowedToTouch = true;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                    if(System.currentTimeMillis() - startTime >30000){
                        notifyMode = 1;
                    }
                    if(notifyMode == 1){
                        for(Fruit fr : myFruits){
                            try{
                                if (growing && fr.getWidth() <= 1.5 * this.width) {
                                    fr.setWidth(fr.getWidth() + 20);
                                    fr.setHeight(fr.getHeight() + 20);
                                    Thread.sleep(1);
                                } else if (fr.getWidth() > this.width) {

                                    this.growing = false;
                                    this.shrinking = true;

                                    fr.setWidth(fr.getWidth() - 20);
                                    fr.setHeight(fr.getHeight() - 20);
                                    Thread.sleep(1);

                                } else if (shrinking && myFruits.get(0).getWidth() == this.width) {
                                    growing = true;
                                    shrinking = false;
                                }
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }else if(notifyMode == 2) {
                        for (Fruit fr : myFruits) {
                            fr.setWidth(this.width);
                            fr.setHeight(this.heigth);
                        }
                    }
                }

                if(stopNotifying){
                    for(Fruit fr : myFruits){
                        fr.setWidth(width);
                        fr.setHeight(heigth);
                    }
                    stopNotifying = false;
                }else {
                    if(answer){
                        if(startTrackingToNotify){
                            if(System.currentTimeMillis() - startTime >30000){
                                notifyMode = 1;
                            }
                            if(notifyMode == 1){
                                for(Fruit fr : myFruits){
                                    try{
                                        if (growing && fr.getWidth() <= 1.5 * this.width) {
                                            fr.setWidth(fr.getWidth() + 20);
                                            fr.setHeight(fr.getHeight() + 20);
                                            Thread.sleep(1);
                                        } else if (fr.getWidth() > this.width) {

                                            this.growing = false;
                                            this.shrinking = true;

                                            fr.setWidth(fr.getWidth() - 20);
                                            fr.setHeight(fr.getHeight() - 20);
                                            Thread.sleep(1);

                                        } else if (shrinking && myFruits.get(0).getWidth() == this.width) {
                                            growing = true;
                                            shrinking = false;
                                        }
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }else if(notifyMode == 2) {
                                for (Fruit fr : myFruits) {
                                    fr.setWidth(this.width);
                                    fr.setHeight(this.heigth);
                                }
                            }
                        }

                        try{
                            if(fruitAnswer.getId() == myFruits.get(0).getId()){
                                allowedToTouch = false;
                                removeSprite(myFruits.get(0));
                                try {
                                    if (MyScreen.langue.equals("fr")) {
                                        oui = moblibAudioFileManager.getRandomAudioFile((Context) game, "good", "FR");
                                    } else {
                                        oui = moblibAudioFileManager.getRandomAudioFile((Context) game, "excellent", "AR");
                                    }
                                    oui.start();
                                } catch (Exception e) {
                                    oui2.play(1);
                                }
                                MyScreen.success++;
                                GameStats.gameStat.setSuccessful_attempts(""+MyScreen.success);
                                myFruitsNotShuffeled.remove(myFruits.get(0));
                                myFruits.remove(0);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Fruit f = myFruits.get(0);
                                fruitQuestion = myFruits.get(0);
                                if(!stopQuestion2){
                                    f.playQuestion();
                                    stopQuestion2 = true;
                                    try {
                                        Thread.sleep(2500);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    allowedToTouch = true;
                                }

                            }else {
                                try {
                                    if (MyScreen.langue.equals("fr")) {
                                        non = moblibAudioFileManager.getRandomAudioFile((Context) game, "encouragement", "FR");
                                    } else {
                                        non = moblibAudioFileManager.getRandomAudioFile((Context) game, "encouragement", "AR");
                                    }
                                    non.start();
                                } catch (Exception e) {
                                    non2.play(1);
                                }
                                MyScreen.failure++;
                                GameStats.gameStat.setFailed_attempts(""+MyScreen.failure);
                                try {
                                    Thread.sleep(2500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                allowedToTouch = true;
                            }


                        }catch (Exception e){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                            Intent intent = new Intent( (Context) game, CategoriesActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            ((Context) game).getApplicationContext().startActivity(intent);
                            ((Activity) game).finish();

                        }
                        answer = false;
                        startTrackingToNotify = true;

                    }
                }


            }

            if(repeatQuestion){
                repeatQuestion = false;
                if(!stopSound){
                    fruitQuestion.playQuestion();
                    stopSound = true;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    allowedToTouch = true;
                }

            }
        }

        else{
            nbrWhenToStart++;
        }

    }

    @Override
    public void handleTouchDown(int x, int y, int pointer) {
        super.handleTouchDown(x, y, pointer);
        Sprite s = getDraggedSprite();
        Log.i(TAG, "handleTouchDown: S class is: " + s.getClass());
        if (s != null && s.getClass() == Fruit.class && allowedToTouch) {
            //a way around a little problem I had
            allowedToTouch = false;
            fruitAnswer = (Fruit) s;
            if(fruitAnswer.getId() == myFruits.get(0).getId()){

                stopQuestion2 = false;
                answer0 = true;

            }
            stopNotifying = true;

            answer = true;


        }else if (s != null && s.getClass() == Refresh.class && allowedToTouch) {
            index = 0;
            startToShuffle = false;
            timeToMakePosition = false;
            startAsking = false;
            stopSound = false;
            answer0 = false;


        }else if (s != null && s.getClass() == SayQuestion.class && allowedToTouch) {
            allowedToTouch = false;
            repeatQuestion = true;
            stopSound = false;

        }else if (s != null && s.getClass() == Home.class){
            Intent intent = new Intent( (Context) game, CategoriesActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ((Context) game).getApplicationContext().startActivity(intent);
            ((Activity) game).finish();

        }
        if (!(s.getClass() == BackGround.class)) {
            startTime = System.currentTimeMillis();
            notifyMode = 2;
            startTrackingToNotify = false;
        }
    }

    @Override
    public void pause() {
        for(Fruit fr : myFruits){
            fr.getmAndroidSound().dispose();
            fr.getqAndroidSound().dispose();
        }

    }

    @Override
    public void resume() {


    }

    @Override
    public void backButton() {

    }



}