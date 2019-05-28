package com.example.rick.learnObjects.state;

import android.util.Log;

import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.emobadaragaminglib.Implementation.AndroidSound;
import com.example.rick.learnObjects.R;
import com.example.rick.learnObjects.Screens.AnimauxScreen;
import com.example.rick.learnObjects.Screens.FruitScreen;
import com.example.rick.learnObjects.Screens.LegumeScreen;
import com.example.rick.learnObjects.Screens.PersonalScreen;
import com.example.rick.learnObjects.Screens.VetementScreen;
import com.example.rick.learnObjects.assets.Animaux;
import com.example.rick.learnObjects.assets.Decor;
import com.example.rick.learnObjects.assets.Fruits;
import com.example.rick.learnObjects.assets.Legumes;
import com.example.rick.learnObjects.assets.MyScreen;
import com.example.rick.learnObjects.assets.Vetements;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AndroidGame {
    private static final String TAG = "GameActivity";

    @Override
    public Screen getInitScreen() {
        clearAssets();
        initAssets();
        Log.i(TAG, "getInitScreen: Assets are Loaded");
        if(MyScreen.myScreen.equals("fruits")){
            return new FruitScreen(this);
        }else if(MyScreen.myScreen.equals("legumes")){
            return new LegumeScreen(this);
        }else if(MyScreen.myScreen.equals("vetements")) {
            return new VetementScreen(this);
        }else if(MyScreen.myScreen.equals("animaux"))
            return new AnimauxScreen(this);
        else {
            return new PersonalScreen(this);
        }
    }

    public void clearAssets(){

        Fruits.ananas = null;
        Fruits.ananasAudio = null;
        Fruits.qAnanasAudio = null;

        Fruits.apricot = null;
        Fruits.apricotAudio = null;
        Fruits.qApricotAudio = null;

        Fruits.banane = null;
        Fruits.bananeAudio = null;
        Fruits.qBananeAudio = null;

        Fruits.cerise = null;
        Fruits.ceriseAudio = null;
        Fruits.qCeriseAudio = null;

        Fruits.citron = null;
        Fruits.citronAudio = null;
        Fruits.qCitronAudio = null;

        Fruits.datte = null;
        Fruits.datteAudio = null;
        Fruits.qDatteAudio = null;

        Fruits.fraise = null;
        Fruits.fraiseAudio = null;
        Fruits.qFraiseAudio = null;

        Fruits.kaki = null;
        Fruits.kakiAudio = null;
        Fruits.qKakiAudio = null;

        Fruits.melon = null;
        Fruits.melonAudio = null;
        Fruits.qMelonAudio = null;

        Fruits.noix = null;
        Fruits.noixAudio = null;
        Fruits.qNoixAudio = null;

        Fruits.orange = null;
        Fruits.orangeAudio = null;
        Fruits.qOrangeAudio = null;

        Fruits.peche = null;
        Fruits.pecheAudio = null;
        Fruits.qPecheAudio = null;

        Fruits.poire = null;
        Fruits.poireAudio = null;
        Fruits.qPoireAudio = null;

        Fruits.pomme = null;
        Fruits.pommeAudio = null;
        Fruits.qPommeAudio = null;

        Fruits.prune = null;
        Fruits.pruneAudio = null;
        Fruits.qPruneAudio = null;

        Fruits.raisin = null;
        Fruits.raisinAudio = null;
        Fruits.qRaisinAudio = null;

        Legumes.ail = null;
        Legumes.ailAudio = null;
        Legumes.qAilAudio = null;

        Legumes.asperge = null;
        Legumes.aspergeAudio = null;
        Legumes.qAspergeAudio = null;

        Legumes.aubergine = null;
        Legumes.aubergineAudio = null;
        Legumes.qAubergineAudio = null;

        Legumes.brocolie = null;
        Legumes.brocolieAudio = null;
        Legumes.qBrocolieAudio = null;

        Legumes.cancombre = null;
        Legumes.cancombreAudio = null;
        Legumes.qCancombreAudio = null;

        Legumes.carotte = null;
        Legumes.carotteAudio = null;
        Legumes.qCarotteAudio = null;

        Legumes.choux = null;
        Legumes.chouxAudio = null;
        Legumes.qChouxAudio = null;

        Legumes.chouxFleure = null;
        Legumes.chouxFleureAudio = null;
        Legumes.qChouxFleureAudio = null;

        Legumes.cornichon = null;
        Legumes.cornichonAudio = null;
        Legumes.qCornichonAudio = null;

        Legumes.feve = null;
        Legumes.feveAudio = null;
        Legumes.qFeveAudio = null;

        Legumes.mais = null;
        Legumes.maisAudio = null;
        Legumes.qMaisAudio = null;

        Legumes.onion = null;
        Legumes.onionAudio = null;
        Legumes.qOnionAudio = null;

        Legumes.poiveronVert = null;
        Legumes.poiveronVertAudio = null;
        Legumes.qPoiveronVertAudio = null;

        Legumes.pommeTerre = null;
        Legumes.pommeTerreAudio = null;
        Legumes.qPommeTerreAudio = null;

        Legumes.tomate = null;
        Legumes.tomateAudio = null;
        Legumes.qTomateAudio = null;

        Legumes.radis = null;
        Legumes.radisAudio = null;
        Legumes.qRadisAudio = null;

        Vetements.gant = null;
        Vetements.gantAudio = null;
        Vetements.qgantAudio = null;

        Vetements.sandale = null;
        Vetements.sandaleAudio = null;
        Vetements.qsandaleAudio = null;

        Vetements.chaussette = null;
        Vetements.chaussetteAudio = null;
        Vetements.qchaussetteAudio = null;

        Vetements.chaussure = null;
        Vetements.chaussureAudio = null;
        Vetements.qchaussureAudio = null;

        Vetements.pantalon = null;
        Vetements.pantalonAudio = null;
        Vetements.qpantalonAudio = null;

        Vetements.monteau = null;
        Vetements.monteauAudio = null;
        Vetements.qmonteauAudio = null;

        Vetements.chapeau = null;
        Vetements.chapeauAudio = null;
        Vetements.qchapeauAudio = null;

        Vetements.montre = null;
        Vetements.montreAudio = null;
        Vetements.qmontreAudio = null;


        Vetements.casquette = null;
        Vetements.casquetteAudio = null;
        Vetements.qcasquetteAudio = null;


        Vetements.robe = null;
        Vetements.robeAudio = null;
        Vetements.qrobeAudio = null;


        Vetements.gourmette = null;
        Vetements.gourmetteAudio = null;
        Vetements.qgourmetteAudio = null;


        Vetements.lunette = null;
        Vetements.lunetteAudio = null;
        Vetements.qlunetteAudio = null;


        Vetements.tshirt = null;
        Vetements.tshirtAudio = null;
        Vetements.qtshirtAudio = null;


        Vetements.shortt = null;
        Vetements.shorttAudio = null;
        Vetements.qshorttAudio = null;


        Vetements.cravatte = null;
        Vetements.cravatteAudio = null;
        Vetements.qcravatteAudio = null;

        Vetements.echarpe = null;
        Vetements.echarpeAudio = null;
        Vetements.qecharpeAudio = null;

        Animaux.chat = null;
        Animaux.chatAudio = null;
        Animaux.qchatAudio = null;

        Animaux.coq = null;
        Animaux.coqAudio = null;
        Animaux.qcoqAudio = null;

        Animaux.vache = null;
        Animaux.vacheAudio = null;
        Animaux.qvacheAudio = null;

        Animaux.colombe = null;
        Animaux.colombeAudio = null;
        Animaux.qcolombeAudio = null;

        Animaux.elephant = null;
        Animaux.elephantAudio = null;
        Animaux.qelephantAudio = null;

        Animaux.cochon = null;
        Animaux.cochonAudio = null;
        Animaux.qcochonAudio = null;

        Animaux.tortue = null;
        Animaux.tortueAudio = null;
        Animaux.qtortueAudio = null;

        Animaux.canard = null;
        Animaux.canardAudio = null;
        Animaux.qcanardAudio = null;


        Animaux.poisson = null;
        Animaux.poissonAudio = null;
        Animaux.qpoissonAudio = null;


        Animaux.lion = null;
        Animaux.lionAudio = null;
        Animaux.qlionAudio = null;


        Animaux.singe = null;
        Animaux.singeAudio = null;
        Animaux.qsingeAudio = null;


        Animaux.souris = null;
        Animaux.sourisAudio = null;
        Animaux.qsourisAudio = null;


        Animaux.chien = null;
        Animaux.chienAudio = null;
        Animaux.qchienAudio = null;


        Animaux.cheval = null;
        Animaux.chevalAudio = null;
        Animaux.qchevalAudio = null;


        Animaux.serpent = null;
        Animaux.serpentAudio = null;
        Animaux.qserpentAudio = null;

        Animaux.ours = null;
        Animaux.oursAudio = null;
        Animaux.qoursAudio = null;


        Decor.buttonAnimaux = null;
        Decor.buttonFruit = null;
        Decor.buttonLegume = null;
        Decor.buttonVetement = null;
        Decor.buttonPersonnalise = null;
        Decor.bg = null;
        Decor.bgAudio = null;
        Decor.fr = null;
        Decor.ar = null;
        Decor.lang = null;
        Decor.back = null;
        Decor.questionButton = null;
    }

    public void initAssets(){
        int j = 0;
        ArrayList<Integer> mySprites = new ArrayList<Integer>();
        for (int i=1; i<17; i++) {
            mySprites.add(new Integer(i));
        }
        Collections.shuffle(mySprites);
        Decor.bg = getGraphics().newImage(R.drawable.background,Graphics.ImageFormat.ARGB8888,getResources());
        Decor.homeButton = getGraphics().newImage(R.drawable.home,Graphics.ImageFormat.ARGB8888,getResources());
        Decor.refreshButton = getGraphics().newImage(R.drawable.relire,Graphics.ImageFormat.ARGB8888,getResources());
        Decor.questionButton = getGraphics().newImage(R.drawable.question,Graphics.ImageFormat.ARGB8888,getResources());


        for(Integer i : mySprites){
            j++;
            if (j>4)
                break;
            if(MyScreen.myScreen.equals("fruits")){
                switch (i){
                    case 1:
                        Fruits.ananas = getGraphics().newImage(R.drawable.ananas,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.ananasAudio = (AndroidSound) getAudio().createSound(R.raw.ananas);
                            Fruits.qAnanasAudio = (AndroidSound) getAudio().createSound(R.raw.pananas);
                        } else if (MyScreen.langue.equals("ar")){
                            Fruits.ananasAudio = (AndroidSound) getAudio().createSound(R.raw.ananasar);
                            Fruits.qAnanasAudio = (AndroidSound) getAudio().createSound(R.raw.pananasar);
                        }

                        break;
                    case 2:
                        Fruits.apricot = getGraphics().newImage(R.drawable.apricot,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.apricotAudio = (AndroidSound) getAudio().createSound(R.raw.apricot);
                            Fruits.qApricotAudio = (AndroidSound) getAudio().createSound(R.raw.papricot);
                        } else {
                            Fruits.apricotAudio = (AndroidSound) getAudio().createSound(R.raw.apricotar);
                            Fruits.qApricotAudio = (AndroidSound) getAudio().createSound(R.raw.papricotar);
                        }
                        break;

                    case 3:
                        Fruits.banane = getGraphics().newImage(R.drawable.banane,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.bananeAudio = (AndroidSound) getAudio().createSound(R.raw.banane);
                            Fruits.qBananeAudio = (AndroidSound) getAudio().createSound(R.raw.pbanane);
                        } else {
                            Fruits.bananeAudio = (AndroidSound) getAudio().createSound(R.raw.bananear);
                            Fruits.qBananeAudio = (AndroidSound) getAudio().createSound(R.raw.pbananear);
                        }
                        break;

                    case 4:
                        Fruits.cerise = getGraphics().newImage(R.drawable.cerise,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.ceriseAudio = (AndroidSound) getAudio().createSound(R.raw.cerise);
                            Fruits.qCeriseAudio = (AndroidSound) getAudio().createSound(R.raw.pcerise);
                        } else {
                            Fruits.ceriseAudio = (AndroidSound) getAudio().createSound(R.raw.cerisear);
                            Fruits.qCeriseAudio = (AndroidSound) getAudio().createSound(R.raw.pcerisear);
                        }
                        break;

                    case 5:
                        Fruits.citron = getGraphics().newImage(R.drawable.citron,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.citronAudio = (AndroidSound) getAudio().createSound(R.raw.citron);
                            Fruits.qCitronAudio = (AndroidSound) getAudio().createSound(R.raw.pcitron);
                        } else {
                            Fruits.citronAudio = (AndroidSound) getAudio().createSound(R.raw.citronar);
                            Fruits.qCitronAudio = (AndroidSound) getAudio().createSound(R.raw.pcitronar);
                        }
                        break;

                    case 6:
                        Fruits.datte = getGraphics().newImage(R.drawable.datte,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.datteAudio = (AndroidSound) getAudio().createSound(R.raw.datte);
                            Fruits.qDatteAudio = (AndroidSound) getAudio().createSound(R.raw.pdatte);
                        } else {
                            Fruits.datteAudio = (AndroidSound) getAudio().createSound(R.raw.datte);
                            Fruits.qDatteAudio = (AndroidSound) getAudio().createSound(R.raw.pdatte);
                        }
                        break;

                    case 7:
                        Fruits.fraise = getGraphics().newImage(R.drawable.fraise,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.fraiseAudio = (AndroidSound) getAudio().createSound(R.raw.fraise);
                            Fruits.qFraiseAudio = (AndroidSound) getAudio().createSound(R.raw.pfraise);
                        } else {
                            Fruits.fraiseAudio = (AndroidSound) getAudio().createSound(R.raw.fraisear);
                            Fruits.qFraiseAudio = (AndroidSound) getAudio().createSound(R.raw.pfraisear);
                        }
                        break;

                    case 8:
                        Fruits.kaki = getGraphics().newImage(R.drawable.kaki,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.kakiAudio = (AndroidSound) getAudio().createSound(R.raw.kaki);
                            Fruits.qKakiAudio = (AndroidSound) getAudio().createSound(R.raw.pkaki);
                        } else {
                            Fruits.kakiAudio = (AndroidSound) getAudio().createSound(R.raw.kakiar);
                            Fruits.qKakiAudio = (AndroidSound) getAudio().createSound(R.raw.pkakiar);
                        }
                        break;

                    case 9:
                        Fruits.melon = getGraphics().newImage(R.drawable.melon,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.melonAudio = (AndroidSound) getAudio().createSound(R.raw.melon);
                            Fruits.qMelonAudio = (AndroidSound) getAudio().createSound(R.raw.pmelon);
                        } else {
                            Fruits.melonAudio = (AndroidSound) getAudio().createSound(R.raw.melonar);
                            Fruits.qMelonAudio = (AndroidSound) getAudio().createSound(R.raw.pmelonar);
                        }
                        break;

                    case 10:
                        Fruits.noix = getGraphics().newImage(R.drawable.noix,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.noixAudio = (AndroidSound) getAudio().createSound(R.raw.noix);
                            Fruits.qNoixAudio = (AndroidSound) getAudio().createSound(R.raw.pnoix);
                        } else {
                            Fruits.noixAudio = (AndroidSound) getAudio().createSound(R.raw.noixar);
                            Fruits.qNoixAudio = (AndroidSound) getAudio().createSound(R.raw.pnoixar);
                        }
                        break;

                    case 11:
                        Fruits.orange = getGraphics().newImage(R.drawable.orange,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.orangeAudio = (AndroidSound) getAudio().createSound(R.raw.orange);
                            Fruits.qOrangeAudio = (AndroidSound) getAudio().createSound(R.raw.porange);
                        } else {
                            Fruits.orangeAudio = (AndroidSound) getAudio().createSound(R.raw.orangear);
                            Fruits.qOrangeAudio = (AndroidSound) getAudio().createSound(R.raw.porangear);
                        }
                        break;

                    case 12:
                        Fruits.peche = getGraphics().newImage(R.drawable.peche,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.pecheAudio = (AndroidSound) getAudio().createSound(R.raw.peche);
                            Fruits.qPecheAudio = (AndroidSound) getAudio().createSound(R.raw.ppeche);
                        } else {
                            Fruits.pecheAudio = (AndroidSound) getAudio().createSound(R.raw.pechear);
                            Fruits.qPecheAudio = (AndroidSound) getAudio().createSound(R.raw.ppechear);
                        }
                        break;

                    case 13:
                        Fruits.poire = getGraphics().newImage(R.drawable.poires,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.poireAudio = (AndroidSound) getAudio().createSound(R.raw.poire);
                            Fruits.qPoireAudio = (AndroidSound) getAudio().createSound(R.raw.ppoire);
                        } else {
                            Fruits.poireAudio = (AndroidSound) getAudio().createSound(R.raw.poirear);
                            Fruits.qPoireAudio = (AndroidSound) getAudio().createSound(R.raw.ppoirear);
                        }
                        break;

                    case 14:
                        Fruits.pomme = getGraphics().newImage(R.drawable.pomme,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.pommeAudio = (AndroidSound) getAudio().createSound(R.raw.pomme);
                            Fruits.qPommeAudio = (AndroidSound) getAudio().createSound(R.raw.ppomme);
                        } else {
                            Fruits.pommeAudio = (AndroidSound) getAudio().createSound(R.raw.pommear);
                            Fruits.qPommeAudio = (AndroidSound) getAudio().createSound(R.raw.ppommear);
                        }
                        break;

                    case 15:
                        Fruits.prune = getGraphics().newImage(R.drawable.prune,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.pruneAudio = (AndroidSound) getAudio().createSound(R.raw.prune);
                            Fruits.qPruneAudio = (AndroidSound) getAudio().createSound(R.raw.pprune);
                        } else {
                            Fruits.pruneAudio = (AndroidSound) getAudio().createSound(R.raw.prunear);
                            Fruits.qPruneAudio = (AndroidSound) getAudio().createSound(R.raw.pprunear);
                        }
                        break;

                    case 16:
                        Fruits.raisin = getGraphics().newImage(R.drawable.raisin,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Fruits.raisinAudio = (AndroidSound) getAudio().createSound(R.raw.raisin);
                            Fruits.qRaisinAudio = (AndroidSound) getAudio().createSound(R.raw.praisin);
                        } else {
                            Fruits.raisinAudio = (AndroidSound) getAudio().createSound(R.raw.raisinar);
                            Fruits.qRaisinAudio = (AndroidSound) getAudio().createSound(R.raw.praisinar);
                        }
                        break;
                }
            }else if(MyScreen.myScreen.equals("legumes")){
                switch (i){
                    case 1:
                        Legumes.ail = getGraphics().newImage(R.drawable.ail,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.ailAudio = (AndroidSound) getAudio().createSound(R.raw.ail);
                            Legumes.qAilAudio = (AndroidSound) getAudio().createSound(R.raw.pail);
                        } else {
                            Legumes.ailAudio = (AndroidSound) getAudio().createSound(R.raw.ailar);
                            Legumes.qAilAudio = (AndroidSound) getAudio().createSound(R.raw.pailar);
                        }
                        break;
                    case 2:
                        Legumes.asperge = getGraphics().newImage(R.drawable.asperge,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.aspergeAudio = (AndroidSound) getAudio().createSound(R.raw.asperge);
                            Legumes.qAspergeAudio = (AndroidSound) getAudio().createSound(R.raw.pasperge);
                        } else {
                            Legumes.aspergeAudio = (AndroidSound) getAudio().createSound(R.raw.aspergear);
                            Legumes.qAspergeAudio = (AndroidSound) getAudio().createSound(R.raw.paspergear);
                        }
                        break;

                    case 3:
                        Legumes.aubergine = getGraphics().newImage(R.drawable.aubergine,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.aubergineAudio = (AndroidSound) getAudio().createSound(R.raw.aubergine);
                            Legumes.qAubergineAudio = (AndroidSound) getAudio().createSound(R.raw.paubergine);
                        } else {
                            Legumes.aubergineAudio = (AndroidSound) getAudio().createSound(R.raw.auberginear);
                            Legumes.qAubergineAudio = (AndroidSound) getAudio().createSound(R.raw.pauberginear);
                        }
                        break;

                    case 4:
                        Legumes.brocolie = getGraphics().newImage(R.drawable.brocolie,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.brocolieAudio = (AndroidSound) getAudio().createSound(R.raw.brocolie);
                            Legumes.qBrocolieAudio = (AndroidSound) getAudio().createSound(R.raw.pbrocolie);
                        } else {
                            Legumes.brocolieAudio = (AndroidSound) getAudio().createSound(R.raw.brocoliear);
                            Legumes.qBrocolieAudio = (AndroidSound) getAudio().createSound(R.raw.pbrocoliear);
                        }
                        break;

                    case 5:
                        Legumes.cancombre = getGraphics().newImage(R.drawable.cancombre,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.cancombreAudio = (AndroidSound) getAudio().createSound(R.raw.cancomber);
                            Legumes.qCancombreAudio = (AndroidSound) getAudio().createSound(R.raw.pconcambre);
                        } else {
                            Legumes.cancombreAudio = (AndroidSound) getAudio().createSound(R.raw.cancombrear);
                            Legumes.qCancombreAudio = (AndroidSound) getAudio().createSound(R.raw.pconcambrear);
                        }
                        break;

                    case 6:
                        Legumes.carotte = getGraphics().newImage(R.drawable.carotte,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.carotteAudio = (AndroidSound) getAudio().createSound(R.raw.carotte);
                            Legumes.qCarotteAudio = (AndroidSound) getAudio().createSound(R.raw.pcarotte);
                        } else {
                            Legumes.carotteAudio = (AndroidSound) getAudio().createSound(R.raw.carottear);
                            Legumes.qCarotteAudio = (AndroidSound) getAudio().createSound(R.raw.pcarottear);
                        }
                        break;

                    case 7:
                        Legumes.choux = getGraphics().newImage(R.drawable.choux,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.chouxAudio = (AndroidSound) getAudio().createSound(R.raw.choux);
                            Legumes.qChouxAudio = (AndroidSound) getAudio().createSound(R.raw.pchoux);
                        } else {
                            Legumes.chouxAudio = (AndroidSound) getAudio().createSound(R.raw.chouxar);
                            Legumes.qChouxAudio = (AndroidSound) getAudio().createSound(R.raw.pchouxar);
                        }
                        break;

                    case 8:
                        Legumes.chouxFleure = getGraphics().newImage(R.drawable.choux_fleure,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.chouxFleureAudio = (AndroidSound) getAudio().createSound(R.raw.choux_fleure);
                            Legumes.qChouxFleureAudio = (AndroidSound) getAudio().createSound(R.raw.pchouxfleur);
                        } else {
                            Legumes.chouxFleureAudio = (AndroidSound) getAudio().createSound(R.raw.choux_fleure_ar);
                            Legumes.qChouxFleureAudio = (AndroidSound) getAudio().createSound(R.raw.pchouxfleurar);
                        }
                        break;

                    case 9:
                        Legumes.cornichon = getGraphics().newImage(R.drawable.cornichon,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.cornichonAudio = (AndroidSound) getAudio().createSound(R.raw.cornichon);
                            Legumes.qCornichonAudio = (AndroidSound) getAudio().createSound(R.raw.pcornichon);
                        } else {
                            Legumes.cornichonAudio = (AndroidSound) getAudio().createSound(R.raw.cornichonar);
                            Legumes.qCornichonAudio = (AndroidSound) getAudio().createSound(R.raw.pcornichonar);
                        }
                        break;

                    case 10:
                        Legumes.feve = getGraphics().newImage(R.drawable.feve,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.feveAudio = (AndroidSound) getAudio().createSound(R.raw.feve);
                            Legumes.qFeveAudio = (AndroidSound) getAudio().createSound(R.raw.pfeve);
                        } else {
                            Legumes.feveAudio = (AndroidSound) getAudio().createSound(R.raw.fevear);
                            Legumes.qFeveAudio = (AndroidSound) getAudio().createSound(R.raw.pfevear);
                        }
                        break;

                    case 11:
                        Legumes.mais = getGraphics().newImage(R.drawable.mais,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.maisAudio = (AndroidSound) getAudio().createSound(R.raw.mais);
                            Legumes.qMaisAudio = (AndroidSound) getAudio().createSound(R.raw.pmais);
                        } else {
                            Legumes.maisAudio = (AndroidSound) getAudio().createSound(R.raw.maisar);
                            Legumes.qMaisAudio = (AndroidSound) getAudio().createSound(R.raw.pmaisar);
                        }
                        break;

                    case 12:
                        Legumes.onion = getGraphics().newImage(R.drawable.onion,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.onionAudio = (AndroidSound) getAudio().createSound(R.raw.onion);
                            Legumes.qOnionAudio = (AndroidSound) getAudio().createSound(R.raw.ponion);
                        } else {
                            Legumes.onionAudio = (AndroidSound) getAudio().createSound(R.raw.onionar);
                            Legumes.qOnionAudio = (AndroidSound) getAudio().createSound(R.raw.ponionar);
                        }
                        break;

                    case 13:
                        Legumes.poiveronVert = getGraphics().newImage(R.drawable.poiveron_vert,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.poiveronVertAudio = (AndroidSound) getAudio().createSound(R.raw.poiveron_vert);
                            Legumes.qPoiveronVertAudio = (AndroidSound) getAudio().createSound(R.raw.ppoiveronvert);
                        } else {
                            Legumes.poiveronVertAudio = (AndroidSound) getAudio().createSound(R.raw.poiveron_vert_ar);
                            Legumes.qPoiveronVertAudio = (AndroidSound) getAudio().createSound(R.raw.ppoiveronvertar);
                        }
                        break;

                    case 14:
                        Legumes.pommeTerre = getGraphics().newImage(R.drawable.pomme_terre,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.pommeTerreAudio = (AndroidSound) getAudio().createSound(R.raw.pomme_terre);
                            Legumes.qPommeTerreAudio = (AndroidSound) getAudio().createSound(R.raw.ppommeterre);
                        } else {
                            Legumes.pommeTerreAudio = (AndroidSound) getAudio().createSound(R.raw.pomme_terre_ar);
                            Legumes.qPommeTerreAudio = (AndroidSound) getAudio().createSound(R.raw.ppommeterrear);
                        }
                        break;

                    case 15:
                        Legumes.tomate = getGraphics().newImage(R.drawable.tomate,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.tomateAudio = (AndroidSound) getAudio().createSound(R.raw.tomate);
                            Legumes.qTomateAudio = (AndroidSound) getAudio().createSound(R.raw.ptomate);
                        } else {
                            Legumes.tomateAudio = (AndroidSound) getAudio().createSound(R.raw.tomatear);
                            Legumes.qTomateAudio = (AndroidSound) getAudio().createSound(R.raw.ptomatear);
                        }
                        break;

                    case 16:
                        Legumes.radis = getGraphics().newImage(R.drawable.radis,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Legumes.radisAudio = (AndroidSound) getAudio().createSound(R.raw.radis);
                            Legumes.qRadisAudio = (AndroidSound) getAudio().createSound(R.raw.pradis);
                        } else {
                            Legumes.radisAudio = (AndroidSound) getAudio().createSound(R.raw.radisar);
                            Legumes.qRadisAudio = (AndroidSound) getAudio().createSound(R.raw.pradisar);
                        }
                        break;
                }
            }else if(MyScreen.myScreen.equals("vetements")){
                switch (i){
                    case 1:
                        Vetements.gant = getGraphics().newImage(R.drawable.gant,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.gantAudio = (AndroidSound) getAudio().createSound(R.raw.gant);
                            Vetements.qgantAudio = (AndroidSound) getAudio().createSound(R.raw.pgant);
                        } else {
                            Vetements.gantAudio = (AndroidSound) getAudio().createSound(R.raw.gantar);
                            Vetements.qgantAudio = (AndroidSound) getAudio().createSound(R.raw.pgantar);
                        }
                        break;
                    case 2:
                        Vetements.sandale = getGraphics().newImage(R.drawable.sandale,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.sandaleAudio = (AndroidSound) getAudio().createSound(R.raw.sandale);
                            Vetements.qsandaleAudio = (AndroidSound) getAudio().createSound(R.raw.psandale);
                        } else {
                            Vetements.sandaleAudio = (AndroidSound) getAudio().createSound(R.raw.sandalear);
                            Vetements.qsandaleAudio = (AndroidSound) getAudio().createSound(R.raw.psandalear);
                        }
                        break;

                    case 3:
                        Vetements.chaussette = getGraphics().newImage(R.drawable.chaussette,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.chaussetteAudio = (AndroidSound) getAudio().createSound(R.raw.chaussette);
                            Vetements.qchaussetteAudio = (AndroidSound) getAudio().createSound(R.raw.pchaussette);
                        } else {
                            Vetements.chaussetteAudio = (AndroidSound) getAudio().createSound(R.raw.chaussettear);
                            Vetements.qchaussetteAudio = (AndroidSound) getAudio().createSound(R.raw.pchaussettear);
                        }
                        break;

                    case 4:
                        Vetements.chaussure = getGraphics().newImage(R.drawable.chaussure,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.chaussureAudio = (AndroidSound) getAudio().createSound(R.raw.chaussure);
                            Vetements.qchaussureAudio = (AndroidSound) getAudio().createSound(R.raw.pchaussure);
                        } else {
                            Vetements.chaussureAudio = (AndroidSound) getAudio().createSound(R.raw.chaussurear);
                            Vetements.qchaussureAudio = (AndroidSound) getAudio().createSound(R.raw.pchaussurear);
                        }
                        break;

                    case 5:
                        Vetements.pantalon = getGraphics().newImage(R.drawable.pantalon,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.pantalonAudio = (AndroidSound) getAudio().createSound(R.raw.pantalon);
                            Vetements.qpantalonAudio = (AndroidSound) getAudio().createSound(R.raw.ppantalon);
                        } else {
                            Vetements.pantalonAudio = (AndroidSound) getAudio().createSound(R.raw.pantalonar);
                            Vetements.qpantalonAudio = (AndroidSound) getAudio().createSound(R.raw.ppantalonar);
                        }
                        break;

                    case 6:
                        Vetements.monteau = getGraphics().newImage(R.drawable.monteau,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.monteauAudio = (AndroidSound) getAudio().createSound(R.raw.monteau);
                            Vetements.qmonteauAudio = (AndroidSound) getAudio().createSound(R.raw.pmonteau);
                        } else {
                            Vetements.monteauAudio = (AndroidSound) getAudio().createSound(R.raw.monteauar);
                            Vetements.qmonteauAudio = (AndroidSound) getAudio().createSound(R.raw.pmonteauar);
                        }
                        break;

                    case 7:
                        Vetements.chapeau = getGraphics().newImage(R.drawable.chapeau,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.chapeauAudio = (AndroidSound) getAudio().createSound(R.raw.chapeau);
                            Vetements.qchapeauAudio = (AndroidSound) getAudio().createSound(R.raw.pchapeau);
                        } else {
                            Vetements.chapeauAudio = (AndroidSound) getAudio().createSound(R.raw.chapeauar);
                            Vetements.qchapeauAudio = (AndroidSound) getAudio().createSound(R.raw.pchapeauar);
                        }
                        break;


                    case 8:
                        Vetements.montre = getGraphics().newImage(R.drawable.montre,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.montreAudio = (AndroidSound) getAudio().createSound(R.raw.montre);
                            Vetements.qmontreAudio = (AndroidSound) getAudio().createSound(R.raw.pmontre);
                        } else {
                            Vetements.montreAudio = (AndroidSound) getAudio().createSound(R.raw.montrear);
                            Vetements.qmontreAudio = (AndroidSound) getAudio().createSound(R.raw.pmontrear);
                        }
                        break;

                    case 9:
                        Vetements.casquette = getGraphics().newImage(R.drawable.casquette,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.casquetteAudio = (AndroidSound) getAudio().createSound(R.raw.casquette);
                            Vetements.qcasquetteAudio = (AndroidSound) getAudio().createSound(R.raw.pcasquette);
                        } else {
                            Vetements.casquetteAudio = (AndroidSound) getAudio().createSound(R.raw.casquettear);
                            Vetements.qcasquetteAudio = (AndroidSound) getAudio().createSound(R.raw.pcasquettear);
                        }
                        break;


                    case 10:
                        Vetements.robe = getGraphics().newImage(R.drawable.robe,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.robeAudio = (AndroidSound) getAudio().createSound(R.raw.robe);
                            Vetements.qrobeAudio = (AndroidSound) getAudio().createSound(R.raw.probe);
                        } else {
                            Vetements.robeAudio = (AndroidSound) getAudio().createSound(R.raw.robear);
                            Vetements.qrobeAudio = (AndroidSound) getAudio().createSound(R.raw.probear);
                        }
                        break;


                    case 11:
                        Vetements.gourmette = getGraphics().newImage(R.drawable.gourmette,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.gourmetteAudio = (AndroidSound) getAudio().createSound(R.raw.gourmette);
                            Vetements.qgourmetteAudio = (AndroidSound) getAudio().createSound(R.raw.pgourmette);
                        } else {
                            Vetements.gourmetteAudio = (AndroidSound) getAudio().createSound(R.raw.gourmettear);
                            Vetements.qgourmetteAudio = (AndroidSound) getAudio().createSound(R.raw.pgourmettear);
                        }
                        break;


                    case 12:
                        Vetements.lunette = getGraphics().newImage(R.drawable.lunette,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.lunetteAudio = (AndroidSound) getAudio().createSound(R.raw.lunette);
                            Vetements.qlunetteAudio = (AndroidSound) getAudio().createSound(R.raw.plunette);
                        }else{
                            Vetements.lunetteAudio = (AndroidSound) getAudio().createSound(R.raw.lunettear);
                            Vetements.qlunetteAudio = (AndroidSound) getAudio().createSound(R.raw.plunettear);
                        }
                        break;


                    case 13:
                        Vetements.tshirt = getGraphics().newImage(R.drawable.tshirt,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.tshirtAudio = (AndroidSound) getAudio().createSound(R.raw.tshirt);
                            Vetements.qtshirtAudio = (AndroidSound) getAudio().createSound(R.raw.ptshirt);
                        } else {
                            Vetements.tshirtAudio = (AndroidSound) getAudio().createSound(R.raw.tshirtar);
                            Vetements.qtshirtAudio = (AndroidSound) getAudio().createSound(R.raw.ptshirtar);
                        }
                        break;


                    case 14:
                        Vetements.shortt = getGraphics().newImage(R.drawable.shortt,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.shorttAudio = (AndroidSound) getAudio().createSound(R.raw.shortt);
                            Vetements.qshorttAudio = (AndroidSound) getAudio().createSound(R.raw.pshortt);
                        } else {
                            Vetements.shorttAudio = (AndroidSound) getAudio().createSound(R.raw.shorttar);
                            Vetements.qshorttAudio = (AndroidSound) getAudio().createSound(R.raw.pshorttar);
                        }
                        break;


                    case 15:
                        Vetements.cravatte = getGraphics().newImage(R.drawable.cravatte,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.cravatteAudio = (AndroidSound) getAudio().createSound(R.raw.cravatte);
                            Vetements.qcravatteAudio = (AndroidSound) getAudio().createSound(R.raw.pcravatte);
                        } else {
                            Vetements.cravatteAudio = (AndroidSound) getAudio().createSound(R.raw.cravattear);
                            Vetements.qcravatteAudio = (AndroidSound) getAudio().createSound(R.raw.pcravattear);
                        }
                        break;

                    case 16:
                        Vetements.echarpe = getGraphics().newImage(R.drawable.echarpe,Graphics.ImageFormat.ARGB8888,getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Vetements.echarpeAudio = (AndroidSound) getAudio().createSound(R.raw.echarpe);
                            Vetements.qecharpeAudio = (AndroidSound) getAudio().createSound(R.raw.pecharpe);
                        } else {
                            Vetements.echarpeAudio = (AndroidSound) getAudio().createSound(R.raw.echarpear);
                            Vetements.qecharpeAudio = (AndroidSound) getAudio().createSound(R.raw.pecharpear);
                        }
                        break;
                }
            }else if(MyScreen.myScreen.equals("animaux")){
                switch (i) {
                    case 1:
                        Animaux.chat = getGraphics().newImage(R.drawable.chat, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.chatAudio = (AndroidSound) getAudio().createSound(R.raw.chat);
                            Animaux.qchatAudio = (AndroidSound) getAudio().createSound(R.raw.pchat);
                        } else {
                            Animaux.chatAudio = (AndroidSound) getAudio().createSound(R.raw.chatar);
                            Animaux.qchatAudio = (AndroidSound) getAudio().createSound(R.raw.pchatar);
                        }
                        break;
                    case 2:
                        Animaux.coq = getGraphics().newImage(R.drawable.coq, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.coqAudio = (AndroidSound) getAudio().createSound(R.raw.coq);
                            Animaux.qcoqAudio = (AndroidSound) getAudio().createSound(R.raw.pcoq);
                        } else {
                            Animaux.coqAudio = (AndroidSound) getAudio().createSound(R.raw.coqar);
                            Animaux.qcoqAudio = (AndroidSound) getAudio().createSound(R.raw.pcoqar);
                        }
                        break;

                    case 3:
                        Animaux.vache = getGraphics().newImage(R.drawable.vache, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.vacheAudio = (AndroidSound) getAudio().createSound(R.raw.vache);
                            Animaux.qvacheAudio = (AndroidSound) getAudio().createSound(R.raw.pvache);
                        } else {
                            Animaux.vacheAudio = (AndroidSound) getAudio().createSound(R.raw.vachear);
                            Animaux.qvacheAudio = (AndroidSound) getAudio().createSound(R.raw.pvachear);
                        }
                        break;

                    case 4:
                        Animaux.colombe = getGraphics().newImage(R.drawable.colombe, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.colombeAudio = (AndroidSound) getAudio().createSound(R.raw.colombe);
                            Animaux.qcolombeAudio = (AndroidSound) getAudio().createSound(R.raw.pcolombe);
                        } else {
                            Animaux.colombeAudio = (AndroidSound) getAudio().createSound(R.raw.colombear);
                            Animaux.qcolombeAudio = (AndroidSound) getAudio().createSound(R.raw.pcolombear);
                        }
                        break;

                    case 5:
                        Animaux.elephant = getGraphics().newImage(R.drawable.elephant, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.elephantAudio = (AndroidSound) getAudio().createSound(R.raw.elephant);
                            Animaux.qelephantAudio = (AndroidSound) getAudio().createSound(R.raw.pelephant);
                        } else {
                            Animaux.elephantAudio = (AndroidSound) getAudio().createSound(R.raw.elephantar);
                            Animaux.qelephantAudio = (AndroidSound) getAudio().createSound(R.raw.pelephantar);
                        }
                        break;

                    case 6:
                        Animaux.cochon = getGraphics().newImage(R.drawable.cochon, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.cochonAudio = (AndroidSound) getAudio().createSound(R.raw.cochon);
                            Animaux.qcochonAudio = (AndroidSound) getAudio().createSound(R.raw.pcochon);
                        } else {
                            Animaux.cochonAudio = (AndroidSound) getAudio().createSound(R.raw.cochonar);
                            Animaux.qcochonAudio = (AndroidSound) getAudio().createSound(R.raw.pcochonar);
                        }
                        break;

                    case 7:
                        Animaux.tortue = getGraphics().newImage(R.drawable.tortue, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.tortueAudio = (AndroidSound) getAudio().createSound(R.raw.tortue);
                            Animaux.qtortueAudio = (AndroidSound) getAudio().createSound(R.raw.ptortue);
                        } else {
                            Animaux.tortueAudio = (AndroidSound) getAudio().createSound(R.raw.tortuear);
                            Animaux.qtortueAudio = (AndroidSound) getAudio().createSound(R.raw.ptortuear);
                        }
                        break;


                    case 8:
                        Animaux.canard = getGraphics().newImage(R.drawable.canard, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.canardAudio = (AndroidSound) getAudio().createSound(R.raw.canard);
                            Animaux.qcanardAudio = (AndroidSound) getAudio().createSound(R.raw.pcanard);
                        } else {
                            Animaux.canardAudio = (AndroidSound) getAudio().createSound(R.raw.canardar);
                            Animaux.qcanardAudio = (AndroidSound) getAudio().createSound(R.raw.pcanardar);
                        }
                        break;

                    case 9:
                        Animaux.poisson = getGraphics().newImage(R.drawable.poisson, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.poissonAudio = (AndroidSound) getAudio().createSound(R.raw.poisson);
                            Animaux.qpoissonAudio = (AndroidSound) getAudio().createSound(R.raw.ppoisson);
                        } else {
                            Animaux.poissonAudio = (AndroidSound) getAudio().createSound(R.raw.poissonar);
                            Animaux.qpoissonAudio = (AndroidSound) getAudio().createSound(R.raw.ppoissonar);
                        }
                        break;


                    case 10:
                        Animaux.lion = getGraphics().newImage(R.drawable.lion, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.lionAudio = (AndroidSound) getAudio().createSound(R.raw.lion);
                            Animaux.qlionAudio = (AndroidSound) getAudio().createSound(R.raw.plion);
                        } else {
                            Animaux.lionAudio = (AndroidSound) getAudio().createSound(R.raw.lionar);
                            Animaux.qlionAudio = (AndroidSound) getAudio().createSound(R.raw.plionar);
                        }
                        break;


                    case 11:
                        Animaux.singe = getGraphics().newImage(R.drawable.singe, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.singeAudio = (AndroidSound) getAudio().createSound(R.raw.singe);
                            Animaux.qsingeAudio = (AndroidSound) getAudio().createSound(R.raw.psinge);
                        } else {
                            Animaux.singeAudio = (AndroidSound) getAudio().createSound(R.raw.singear);
                            Animaux.qsingeAudio = (AndroidSound) getAudio().createSound(R.raw.psingear);
                        }
                        break;


                    case 12:
                        Animaux.souris = getGraphics().newImage(R.drawable.souris, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.sourisAudio = (AndroidSound) getAudio().createSound(R.raw.souris);
                            Animaux.qsourisAudio = (AndroidSound) getAudio().createSound(R.raw.psouris);
                        } else {
                            Animaux.sourisAudio = (AndroidSound) getAudio().createSound(R.raw.sourisar);
                            Animaux.qsourisAudio = (AndroidSound) getAudio().createSound(R.raw.psourisar);
                        }
                        break;


                    case 13:
                        Animaux.chien = getGraphics().newImage(R.drawable.chien, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.chienAudio = (AndroidSound) getAudio().createSound(R.raw.chien);
                            Animaux.qchienAudio = (AndroidSound) getAudio().createSound(R.raw.pchien);
                        } else {
                            Animaux.chienAudio = (AndroidSound) getAudio().createSound(R.raw.chienar);
                            Animaux.qchienAudio = (AndroidSound) getAudio().createSound(R.raw.pchienar);
                        }
                        break;


                    case 14:
                        Animaux.cheval = getGraphics().newImage(R.drawable.cheval, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.chevalAudio = (AndroidSound) getAudio().createSound(R.raw.cheval);
                            Animaux.qchevalAudio = (AndroidSound) getAudio().createSound(R.raw.pcheval);
                        } else {
                            Animaux.chevalAudio = (AndroidSound) getAudio().createSound(R.raw.chevalar);
                            Animaux.qchevalAudio = (AndroidSound) getAudio().createSound(R.raw.pchevalar);
                        }
                        break;


                    case 15:
                        Animaux.serpent = getGraphics().newImage(R.drawable.serpent, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.serpentAudio = (AndroidSound) getAudio().createSound(R.raw.serpent);
                            Animaux.qserpentAudio = (AndroidSound) getAudio().createSound(R.raw.pserpent);
                        } else {
                            Animaux.serpentAudio = (AndroidSound) getAudio().createSound(R.raw.serpentar);
                            Animaux.qserpentAudio = (AndroidSound) getAudio().createSound(R.raw.pserpentar);
                        }
                        break;

                    case 16:
                        Animaux.ours = getGraphics().newImage(R.drawable.ours, Graphics.ImageFormat.ARGB8888, getResources());
                        if (MyScreen.langue.equals("fr")) {
                            Animaux.oursAudio = (AndroidSound) getAudio().createSound(R.raw.ours);
                            Animaux.qoursAudio = (AndroidSound) getAudio().createSound(R.raw.pours);
                        } else {
                            Animaux.oursAudio = (AndroidSound) getAudio().createSound(R.raw.oursar);
                            Animaux.qoursAudio = (AndroidSound) getAudio().createSound(R.raw.poursar);
                        }
                        break;
                }
            }else if(MyScreen.myScreen.equals("personnalise")){
                Decor.fr = getGraphics().newImage(R.drawable.fr,Graphics.ImageFormat.ARGB8888,getResources());
                Decor.ar = getGraphics().newImage(R.drawable.ar,Graphics.ImageFormat.ARGB8888,getResources());
                Decor.back = getGraphics().newImage(R.drawable.back, Graphics.ImageFormat.ARGB8888,getResources());
                if (MyScreen.langue.equals("fr")){
                    Decor.lang = getGraphics().newImage(R.drawable.lang,Graphics.ImageFormat.ARGB8888,getResources());
                    Decor.audioparam = getGraphics().newImage(R.drawable.audioparam, Graphics.ImageFormat.ARGB8888,getResources());
                }else{
                    Decor.lang = getGraphics().newImage(R.drawable.langar,Graphics.ImageFormat.ARGB8888,getResources());
                    Decor.audioparam = getGraphics().newImage(R.drawable.audioparamar, Graphics.ImageFormat.ARGB8888,getResources());

                }

            }
        }
    }

    @Override
    public void onBackPressed() {

    }
}
