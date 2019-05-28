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
import com.example.rick.learnObjects.Sprites.SayQuestion;
import com.example.rick.learnObjects.Sprites.Vetement;
import com.example.rick.learnObjects.Sprites.Home;
import com.example.rick.learnObjects.Sprites.Refresh;
import com.example.rick.learnObjects.assets.Decor;
import com.example.rick.learnObjects.assets.MyScreen;
import com.example.rick.learnObjects.assets.Vetements;
import com.example.rick.learnObjects.assets.Position;
import com.example.rick.learnObjects.state.CategoriesActivity;
import com.example.rick.learnObjects.state.GameStats;

import java.util.ArrayList;
import java.util.Collections;

public class VetementScreen extends Screen {
    private static final String TAG = "VetementScreen";
    private Game game;

    private Vetement gant, sandale, chaussette, chaussure, pantalon, monteau, chapeau, montre, casquette, robe, gourmette, lunette, tshirt, shortt, cravatte, echarpe;
    private ArrayList<Vetement> myVetements, myVetementsNotShuffeled;
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
    private Vetement vetementAnswer, vetementQuestion;
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



    public VetementScreen(Game game) {
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

        Log.i(TAG, "VetementScreen: Initialized the Screen");

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
        Log.i(TAG, "VetementScreen: Initialized bg");

        myVetements = new ArrayList<Vetement>();
        if(Vetements.gant!=null) {
            gant = new Vetement(game, 1,Vetements.gant, Vetements.gantAudio, Vetements.qgantAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(gant);
        }
        if(Vetements.sandale!=null){
            sandale = new Vetement(game, 2,Vetements.sandale, Vetements.sandaleAudio, Vetements.qsandaleAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(sandale);
        }
        if(Vetements.chaussette!=null){
            chaussette = new Vetement(game, 3,Vetements.chaussette, Vetements.chaussetteAudio, Vetements.qchaussetteAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(chaussette);
        }
        if(Vetements.chaussure!=null){
            chaussure = new Vetement(game, 4,Vetements.chaussure, Vetements.chaussureAudio, Vetements.qchaussureAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(chaussure);
        }
        if(Vetements.pantalon!=null){
            pantalon = new Vetement(game, 5,Vetements.pantalon, Vetements.pantalonAudio, Vetements.qpantalonAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(pantalon);
        }
        if(Vetements.monteau!=null){
            monteau = new Vetement(game, 6,Vetements.monteau, Vetements.monteauAudio, Vetements.qmonteauAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(monteau);
        }
        if(Vetements.chapeau!=null){
            chapeau = new Vetement(game, 7,Vetements.chapeau, Vetements.chapeauAudio, Vetements.qchapeauAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(chapeau);
        }
        if(Vetements.montre!=null){
            montre = new Vetement(game, 8,Vetements.montre, Vetements.montreAudio, Vetements.qmontreAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(montre);
        }
        if(Vetements.casquette!=null){
            casquette = new Vetement(game, 9,Vetements.casquette, Vetements.casquetteAudio, Vetements.qcasquetteAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(casquette);
        }
        if(Vetements.robe!=null){
            robe = new Vetement(game, 10,Vetements.robe, Vetements.robeAudio, Vetements.qrobeAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(robe);
        }
        if(Vetements.gourmette!=null){
            gourmette = new Vetement(game, 11,Vetements.gourmette, Vetements.gourmetteAudio, Vetements.qgourmetteAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(gourmette);
        }
        if(Vetements.lunette!=null){
            lunette = new Vetement(game, 12,Vetements.lunette, Vetements.lunetteAudio, Vetements.qlunetteAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(lunette);
        }
        if(Vetements.tshirt!=null){
            tshirt = new Vetement(game, 13,Vetements.tshirt, Vetements.tshirtAudio, Vetements.qtshirtAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(tshirt);
        }
        if(Vetements.shortt!=null){
            shortt = new Vetement(game, 14,Vetements.shortt, Vetements.shorttAudio, Vetements.qshorttAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(shortt);
        }
        if(Vetements.cravatte!=null){
            cravatte = new Vetement(game, 15,Vetements.cravatte, Vetements.cravatteAudio, Vetements.qcravatteAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(cravatte);
        }
        if(Vetements.echarpe!=null){
            echarpe = new Vetement(game, 16,Vetements.echarpe, Vetements.echarpeAudio, Vetements.qecharpeAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myVetements.add(echarpe);
        }


        myVetementsNotShuffeled = ((ArrayList<Vetement>) myVetements.clone());
        //The Sprites will respect the order you put them into
        //So Make sure that you add your decor and background first before you put the
        //sprites that you want the user to interact with
        for(Vetement f : myVetements){
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
                    for(Vetement fr : myVetements){
                        fr.setHeight(this.heigth);
                        fr.setWidth(this.width);
                    }
                    notifyMode = 0;
                }
                if(index < myVetementsNotShuffeled.size()) {
                    if(!stopSound){
                        myVetementsNotShuffeled.get(index).play();
                        stopSound=true;
                    }

                    try {

                        if (growing && myVetementsNotShuffeled.get(index).getWidth() <= 1.5 * this.width) {
                            for(int i= 0; i<20; i++){
                                myVetementsNotShuffeled.get(index).setWidth(myVetementsNotShuffeled.get(index).getWidth() + 1);
                                myVetementsNotShuffeled.get(index).setHeight(myVetementsNotShuffeled.get(index).getHeight() + 1);
                            }
                            //Thread.sleep(1);

                        } else if (myVetementsNotShuffeled.get(index).getWidth() > this.width) {

                            this.growing = false;
                            this.shrinking = true;

                            for (int i=0; i<20;i++) {
                                myVetementsNotShuffeled.get(index).setWidth(myVetementsNotShuffeled.get(index).getWidth() - 1);
                                myVetementsNotShuffeled.get(index).setHeight(myVetementsNotShuffeled.get(index).getHeight() - 1);
                            }
                            //Thread.sleep(1);

                        } else if (shrinking && myVetements.get(0).getWidth() == this.width) {
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

                for(Vetement f : myVetements){
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


                        if (index2 == myVetements.size()-1 && f.getX() == (game.getGraphics().getWidth() / 2) - f.getWidth() / 2 && f.getY() == (game.getGraphics().getHeight() / 2) - f.getHeight() / 2) {
                            startToShuffle = false;
                            timeToMakePosition = true;
                            shufflePositions = true;

                        }
                    }
                    index2 ++;
                    index2 = index2%myVetements.size();
                }

            }else if(!startAsking && !startToShuffle && timeToMakePosition){

                if(shufflePositions){
                    Collections.shuffle(positions);
                    shufflePositions = false;
                }
                index2 = 0;
                for(Vetement f : myVetements) {
                    index2 = index2 % myVetements.size();
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


                        if (index2 == myVetements.size()-1 && f.getX() == positions.get(index2).getX() && f.getY() == positions.get(index2).getY()) {
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
                        Collections.shuffle(myVetements);
                        shuffle = false;
                    }
                    Vetement f = myVetements.get(0);
                    vetementQuestion = myVetements.get(0);
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
                        for(Vetement fr : myVetements){
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

                                } else if (shrinking && myVetements.get(0).getWidth() == this.width) {
                                    growing = true;
                                    shrinking = false;
                                }
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }else if(notifyMode == 2) {
                        for (Vetement fr : myVetements) {
                            fr.setWidth(this.width);
                            fr.setHeight(this.heigth);
                        }
                    }
                }

                if(stopNotifying){
                    for(Vetement fr : myVetements){
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
                                for(Vetement fr : myVetements){
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

                                        } else if (shrinking && myVetements.get(0).getWidth() == this.width) {
                                            growing = true;
                                            shrinking = false;
                                        }
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }else if(notifyMode == 2) {
                                for (Vetement fr : myVetements) {
                                    fr.setWidth(this.width);
                                    fr.setHeight(this.heigth);
                                }
                            }
                        }

                        try{
                            if(vetementAnswer.getId() == myVetements.get(0).getId()){
                                allowedToTouch = false;
                                removeSprite(myVetements.get(0));
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
                                myVetementsNotShuffeled.remove(myVetements.get(0));
                                myVetements.remove(0);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Vetement f = myVetements.get(0);
                                vetementQuestion = myVetements.get(0);
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
                    vetementQuestion.playQuestion();
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
        if (s != null && s.getClass() == Vetement.class && allowedToTouch) {
            //a way around a little problem I had
            allowedToTouch = false;
            vetementAnswer = (Vetement) s;
            if(vetementAnswer.getId() == myVetements.get(0).getId()){

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
        for(Vetement fr : myVetements){
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