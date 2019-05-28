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
import com.example.rick.learnObjects.Sprites.Animal;
import com.example.rick.learnObjects.Sprites.Home;
import com.example.rick.learnObjects.Sprites.Refresh;
import com.example.rick.learnObjects.Sprites.SayQuestion;
import com.example.rick.learnObjects.assets.Decor;
import com.example.rick.learnObjects.assets.Animaux;
import com.example.rick.learnObjects.assets.MyScreen;
import com.example.rick.learnObjects.assets.Position;
import com.example.rick.learnObjects.state.CategoriesActivity;
import com.example.rick.learnObjects.state.GameStats;

import java.util.ArrayList;
import java.util.Collections;

public class AnimauxScreen extends Screen {
    private static final String TAG = "Animauxcreen";
    private Game game;

    private Animal chat, coq, vache, colombe, elephant, cochon, tortue, canard, poisson, lion, singe, souris, chien, cheval, serpent, ours;
    private ArrayList<Animal> myAnimaux, myAnimauxNotShuffeled;
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
    private AndroidSound oui2,non2;
    private MediaPlayer oui,non;
    private Animal animalAnswer, animalQuestion;
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



    public AnimauxScreen(Game game) {
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

        Log.i(TAG, "Animauxcreen: Initialized the Screen");

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
        Log.i(TAG, "Animauxcreen: Initialized bg");

        myAnimaux = new ArrayList<Animal>();
        if(Animaux.chat!=null) {
            chat = new Animal(game, 1,Animaux.chat, Animaux.chatAudio, Animaux.qchatAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(chat);
        }
        if(Animaux.coq!=null){
            coq = new Animal(game, 2,Animaux.coq, Animaux.coqAudio, Animaux.qcoqAudio, positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(coq);
        }
        if(Animaux.vache!=null){
            vache = new Animal(game, 3,Animaux.vache, Animaux.vacheAudio, Animaux.qvacheAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(vache);
        }
        if(Animaux.colombe!=null){
            colombe = new Animal(game, 4,Animaux.colombe, Animaux.colombeAudio, Animaux.qcolombeAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(colombe);
        }
        if(Animaux.elephant!=null){
            elephant = new Animal(game, 5,Animaux.elephant, Animaux.elephantAudio, Animaux.qelephantAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(elephant);
        }
        if(Animaux.cochon!=null){
            cochon = new Animal(game, 6,Animaux.cochon, Animaux.cochonAudio, Animaux.qcochonAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(cochon);
        }
        if(Animaux.tortue!=null){
            tortue = new Animal(game, 7,Animaux.tortue, Animaux.tortueAudio, Animaux.qtortueAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(tortue);
        }
        if(Animaux.canard!=null){
            canard = new Animal(game, 8,Animaux.canard, Animaux.canardAudio, Animaux.qcanardAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(canard);
        }
        if(Animaux.poisson!=null){
            poisson = new Animal(game, 9,Animaux.poisson, Animaux.poissonAudio, Animaux.qpoissonAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(poisson);
        }
        if(Animaux.lion!=null){
            lion = new Animal(game, 10,Animaux.lion, Animaux.lionAudio, Animaux.qlionAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(lion);
        }
        if(Animaux.singe!=null){
            singe = new Animal(game, 11,Animaux.singe, Animaux.singeAudio, Animaux.qsingeAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(singe);
        }
        if(Animaux.souris!=null){
            souris = new Animal(game, 12,Animaux.souris, Animaux.sourisAudio, Animaux.qsourisAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(souris);
        }
        if(Animaux.chien!=null){
            chien = new Animal(game, 13,Animaux.chien, Animaux.chienAudio, Animaux.qchienAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(chien);
        }
        if(Animaux.cheval!=null){
            cheval = new Animal(game, 14,Animaux.cheval, Animaux.chevalAudio, Animaux.qchevalAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(cheval);
        }
        if(Animaux.serpent!=null){
            serpent = new Animal(game, 15,Animaux.serpent, Animaux.serpentAudio, Animaux.qserpentAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(serpent);
        }
        if(Animaux.ours!=null){
            ours = new Animal(game, 16,Animaux.ours, Animaux.oursAudio, Animaux.qoursAudio,positions.get(0).getX(), positions.get(0).getY(), heigth, width);
            positions.remove(0);
            myAnimaux.add(ours);
        }


        myAnimauxNotShuffeled = ((ArrayList<Animal>) myAnimaux.clone());
        //The Sprites will respect the order you put them into
        //So Make sure that you add your decor and background first before you put the
        //sprites that you want the user to interact with
        for(Animal f : myAnimaux){
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
                    for(Animal fr : myAnimaux){
                        fr.setHeight(this.heigth);
                        fr.setWidth(this.width);
                    }
                    notifyMode = 0;
                }
                if(index < myAnimauxNotShuffeled.size()) {
                    if(!stopSound){
                        myAnimauxNotShuffeled.get(index).play();
                        stopSound=true;
                    }

                    try {

                        if (growing && myAnimauxNotShuffeled.get(index).getWidth() <= 1.5 * this.width) {
                            for(int i= 0; i<20; i++){
                                myAnimauxNotShuffeled.get(index).setWidth(myAnimauxNotShuffeled.get(index).getWidth() + 1);
                                myAnimauxNotShuffeled.get(index).setHeight(myAnimauxNotShuffeled.get(index).getHeight() + 1);
                            }
                            //Thread.sleep(1);

                        } else if (myAnimauxNotShuffeled.get(index).getWidth() > this.width) {

                            this.growing = false;
                            this.shrinking = true;

                            for (int i=0; i<20;i++) {
                                myAnimauxNotShuffeled.get(index).setWidth(myAnimauxNotShuffeled.get(index).getWidth() - 1);
                                myAnimauxNotShuffeled.get(index).setHeight(myAnimauxNotShuffeled.get(index).getHeight() - 1);
                            }
                            //Thread.sleep(1);

                        } else if (shrinking && myAnimaux.get(0).getWidth() == this.width) {
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

                for(Animal f : myAnimaux){
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


                        if (index2 == myAnimaux.size()-1 && f.getX() == (game.getGraphics().getWidth() / 2) - f.getWidth() / 2 && f.getY() == (game.getGraphics().getHeight() / 2) - f.getHeight() / 2) {
                            startToShuffle = false;
                            timeToMakePosition = true;
                            shufflePositions = true;

                        }
                    }
                    index2 ++;
                    index2 = index2%myAnimaux.size();
                }

            }else if(!startAsking && !startToShuffle && timeToMakePosition){

                if(shufflePositions){
                    Collections.shuffle(positions);
                    shufflePositions = false;
                }
                index2 = 0;
                for(Animal f : myAnimaux) {
                    index2 = index2 % myAnimaux.size();
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


                        if (index2 == myAnimaux.size()-1 && f.getX() == positions.get(index2).getX() && f.getY() == positions.get(index2).getY()) {
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
                        Collections.shuffle(myAnimaux);
                        shuffle = false;
                    }
                    Animal f = myAnimaux.get(0);
                    animalQuestion = myAnimaux.get(0);
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
                        for(Animal fr : myAnimaux){
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

                                } else if (shrinking && myAnimaux.get(0).getWidth() == this.width) {
                                    growing = true;
                                    shrinking = false;
                                }
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }else if(notifyMode == 2) {
                        for (Animal fr : myAnimaux) {
                            fr.setWidth(this.width);
                            fr.setHeight(this.heigth);
                        }
                    }
                }

                if(stopNotifying){
                    for(Animal fr : myAnimaux){
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
                                for(Animal fr : myAnimaux){
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

                                        } else if (shrinking && myAnimaux.get(0).getWidth() == this.width) {
                                            growing = true;
                                            shrinking = false;
                                        }
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }else if(notifyMode == 2) {
                                for (Animal fr : myAnimaux) {
                                    fr.setWidth(this.width);
                                    fr.setHeight(this.heigth);
                                }
                            }
                        }

                        try{
                            if(animalAnswer.getId() == myAnimaux.get(0).getId()){
                                allowedToTouch = false;
                                removeSprite(myAnimaux.get(0));
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
                                myAnimauxNotShuffeled.remove(myAnimaux.get(0));
                                myAnimaux.remove(0);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Animal f = myAnimaux.get(0);
                                animalQuestion = myAnimaux.get(0);
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
                    animalQuestion.playQuestion();
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
        if (s != null && s.getClass() == Animal.class && allowedToTouch) {
            //a way around a little problem I had
            allowedToTouch = false;
            animalAnswer = (Animal) s;
            if(animalAnswer.getId() == myAnimaux.get(0).getId()){

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
        for(Animal fr : myAnimaux){
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