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
import com.example.rick.learnObjects.Sprites.Legume;
import com.example.rick.learnObjects.Sprites.Home;
import com.example.rick.learnObjects.Sprites.Refresh;
import com.example.rick.learnObjects.Sprites.SayQuestion;
import com.example.rick.learnObjects.assets.Decor;
import com.example.rick.learnObjects.assets.Legumes;
import com.example.rick.learnObjects.assets.MyScreen;
import com.example.rick.learnObjects.assets.Position;
import com.example.rick.learnObjects.state.CategoriesActivity;
import com.example.rick.learnObjects.state.GameStats;

import java.util.ArrayList;
import java.util.Collections;

public class LegumeScreen extends Screen {
    private static final String TAG = "LegumeScreen";
    private Game game;

    private Legume ail, asperge, aubergine, brocolie, cancombre, carotte, choux, chouxFleure, cornichon,feve, mais, onion, poiveronVert,pommeTerre, tomate, radis;
    private ArrayList<Legume> myLegumes, myLegumesNotShuffeled;
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
    private int nbrWhenToStart = 0;
    private boolean startTrackingToNotify = false;
    private boolean repeatQuestion = false;
    private int notifyMode = 0;
    private long startTime;
    private MediaPlayer oui,non;
    private AndroidSound oui2,non2;
    private Legume legumeAnswer, legumeQuestion;
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



    public LegumeScreen(Game game) {
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

        Log.i(TAG, "LegumeScreen: Initialized the Screen");

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
        Log.i(TAG, "LegumeScreen: Initialized bg");

        myLegumes = new ArrayList<Legume>();
        if(Legumes.ail!=null) {
            ail = new Legume(game, 1,Legumes.ail, Legumes.ailAudio, Legumes.qAilAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(ail);
        }
        if(Legumes.asperge!=null){
            asperge = new Legume(game, 2,Legumes.asperge, Legumes.aspergeAudio, Legumes.qAspergeAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(asperge);
        }
        if(Legumes.aubergine!=null){
            aubergine = new Legume(game, 3,Legumes.aubergine, Legumes.aubergineAudio, Legumes.qAubergineAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(aubergine);
        }
        if(Legumes.brocolie!=null){
            brocolie = new Legume(game, 4,Legumes.brocolie, Legumes.brocolieAudio, Legumes.qBrocolieAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(brocolie);
        }
        if(Legumes.cancombre!=null){
            cancombre = new Legume(game, 5,Legumes.cancombre, Legumes.cancombreAudio, Legumes.qCancombreAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(cancombre);
        }
        if(Legumes.carotte!=null){
            carotte = new Legume(game, 6,Legumes.carotte, Legumes.carotteAudio, Legumes.qCarotteAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(carotte);
        }
        if(Legumes.choux!=null){
            choux = new Legume(game, 7,Legumes.choux, Legumes.chouxAudio, Legumes.qChouxAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(choux);
        }
        if(Legumes.chouxFleure!=null){
            chouxFleure = new Legume(game, 8,Legumes.chouxFleure, Legumes.chouxFleureAudio, Legumes.qChouxFleureAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(chouxFleure);
        }
        if(Legumes.cornichon!=null){
            cornichon = new Legume(game, 9,Legumes.cornichon, Legumes.cornichonAudio, Legumes.qCornichonAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(cornichon);
        }
        if(Legumes.feve!=null){
            feve = new Legume(game, 10,Legumes.feve, Legumes.feveAudio, Legumes.qFeveAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(feve);
        }
        if(Legumes.mais!=null){
            mais = new Legume(game, 11,Legumes.mais, Legumes.maisAudio, Legumes.qMaisAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(mais);
        }
        if(Legumes.onion!=null){
            onion = new Legume(game, 12,Legumes.onion, Legumes.onionAudio, Legumes.qOnionAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(onion);
        }
        if(Legumes.poiveronVert!=null){
            poiveronVert = new Legume(game, 13,Legumes.poiveronVert, Legumes.poiveronVertAudio, Legumes.qPoiveronVertAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(poiveronVert);
        }
        if(Legumes.pommeTerre!=null){
            pommeTerre = new Legume(game, 14,Legumes.pommeTerre, Legumes.pommeTerreAudio, Legumes.qPommeTerreAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(pommeTerre);
        }
        if(Legumes.radis!=null){
            radis = new Legume(game, 15,Legumes.radis, Legumes.radisAudio, Legumes.qRadisAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(radis);
        }
        if(Legumes.tomate!=null){
            tomate = new Legume(game, 16,Legumes.tomate, Legumes.tomateAudio, Legumes.qTomateAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myLegumes.add(tomate);
        }


        myLegumesNotShuffeled = ((ArrayList<Legume>) myLegumes.clone());
        //The Sprites will respect the order you put them into
        //So Make sure that you add your decor and background first before you put the
        //sprites that you want the user to interact with
        for(Legume f : myLegumes){
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
                    for(Legume fr : myLegumes){
                        fr.setHeight(this.heigth);
                        fr.setWidth(this.width);
                    }
                    notifyMode = 0;
                }
                if(index < myLegumesNotShuffeled.size()) {
                    if(!stopSound){
                        myLegumesNotShuffeled.get(index).play();
                        stopSound=true;
                    }

                    try {

                        if (growing && myLegumesNotShuffeled.get(index).getWidth() <= 1.5 * this.width) {
                            for(int i= 0; i<20; i++){
                                myLegumesNotShuffeled.get(index).setWidth(myLegumesNotShuffeled.get(index).getWidth() + 1);
                                myLegumesNotShuffeled.get(index).setHeight(myLegumesNotShuffeled.get(index).getHeight() + 1);
                            }
                            //Thread.sleep(1);

                        } else if (myLegumesNotShuffeled.get(index).getWidth() > this.width) {

                            this.growing = false;
                            this.shrinking = true;

                            for (int i=0; i<20;i++) {
                                myLegumesNotShuffeled.get(index).setWidth(myLegumesNotShuffeled.get(index).getWidth() - 1);
                                myLegumesNotShuffeled.get(index).setHeight(myLegumesNotShuffeled.get(index).getHeight() - 1);
                            }
                            //Thread.sleep(1);

                        } else if (shrinking && myLegumes.get(0).getWidth() == this.width) {
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

                for(Legume f : myLegumes){
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


                        if (index2 == myLegumes.size()-1 && f.getX() == (game.getGraphics().getWidth() / 2) - f.getWidth() / 2 && f.getY() == (game.getGraphics().getHeight() / 2) - f.getHeight() / 2) {
                            startToShuffle = false;
                            timeToMakePosition = true;
                            shufflePositions = true;

                        }
                    }
                    index2 ++;
                    index2 = index2%myLegumes.size();
                }

            }else if(!startAsking && !startToShuffle && timeToMakePosition){

                if(shufflePositions){
                    Collections.shuffle(positions);
                    shufflePositions = false;
                }
                index2 = 0;
                for(Legume f : myLegumes) {
                    index2 = index2 % myLegumes.size();
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


                        if (index2 == myLegumes.size()-1 && f.getX() == positions.get(index2).getX() && f.getY() == positions.get(index2).getY()) {
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
                        Collections.shuffle(myLegumes);
                        shuffle = false;
                    }
                    Legume f = myLegumes.get(0);
                    legumeQuestion = myLegumes.get(0);
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
                        for(Legume fr : myLegumes){
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

                                } else if (shrinking && myLegumes.get(0).getWidth() == this.width) {
                                    growing = true;
                                    shrinking = false;
                                }
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }else if(notifyMode == 2) {
                        for (Legume fr : myLegumes) {
                            fr.setWidth(this.width);
                            fr.setHeight(this.heigth);
                        }
                    }
                }

                if(stopNotifying){
                    for(Legume fr : myLegumes){
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
                                for(Legume fr : myLegumes){
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

                                        } else if (shrinking && myLegumes.get(0).getWidth() == this.width) {
                                            growing = true;
                                            shrinking = false;
                                        }
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }else if(notifyMode == 2) {
                                for (Legume fr : myLegumes) {
                                    fr.setWidth(this.width);
                                    fr.setHeight(this.heigth);
                                }
                            }
                        }

                        try{
                            if(legumeAnswer.getId() == myLegumes.get(0).getId()){
                                allowedToTouch = false;
                                removeSprite(myLegumes.get(0));
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
                                myLegumesNotShuffeled.remove(myLegumes.get(0));
                                myLegumes.remove(0);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Legume f = myLegumes.get(0);
                                legumeQuestion = myLegumes.get(0);
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
                    legumeQuestion.playQuestion();
                    stopSound = true;
                    allowedToTouch = true;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

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
        if (s != null && s.getClass() == Legume.class && allowedToTouch) {
            //a way around a little problem I had
            allowedToTouch = false;
            legumeAnswer = (Legume) s;
            if(legumeAnswer.getId() == myLegumes.get(0).getId()){

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
        for(Legume fr : myLegumes){
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