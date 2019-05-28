package com.example.rick.learnObjects.state;

import android.util.Log;

import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.emobadaragaminglib.Implementation.AndroidMusic;
import com.example.emobadaragaminglib.Implementation.AndroidSound;
import com.example.rick.learnObjects.R;
import com.example.rick.learnObjects.Screens.CategoriesScreen;
import com.example.rick.learnObjects.Screens.FruitScreen;
import com.example.rick.learnObjects.Screens.LegumeScreen;
import com.example.rick.learnObjects.Screens.VetementScreen;
import com.example.rick.learnObjects.assets.Animaux;
import com.example.rick.learnObjects.assets.Decor;
import com.example.rick.learnObjects.assets.Fruits;
import com.example.rick.learnObjects.assets.Legumes;
import com.example.rick.learnObjects.assets.MyScreen;
import com.example.rick.learnObjects.assets.Vetements;

import java.util.ArrayList;
import java.util.Collections;

public class CategoriesActivity extends AndroidGame {
    private static final String TAG = "CategoriesActivity";

    @Override
    public Screen getInitScreen() {
        clearAssets();
        initAssets();
        Log.i(TAG, "getInitScreen: Assets are Loaded");
        return new CategoriesScreen(this);
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
        Decor.title = null;
        Decor.circle = null;
        Decor.volumeBar = null;
        Decor.mute = null;
        Decor.volumeUp = null;
        Decor.quit = null;

    }

    public void initAssets(){
        if (MyScreen.langue.equals("fr")) {
            Decor.buttonPersonnalise = getGraphics().newImage(R.drawable.button_personnalise, Graphics.ImageFormat.ARGB8888,getResources());
            Decor.buttonAnimaux = getGraphics().newImage(R.drawable.button_animaux,Graphics.ImageFormat.ARGB8888,getResources());
            Decor.buttonVetement = getGraphics().newImage(R.drawable.button_vetement,Graphics.ImageFormat.ARGB8888,getResources());
            Decor.buttonLegume = getGraphics().newImage(R.drawable.button_legume,Graphics.ImageFormat.ARGB8888,getResources());
            Decor.buttonFruit = getGraphics().newImage(R.drawable.button_fruit,Graphics.ImageFormat.ARGB8888,getResources());
            Decor.title = getGraphics().newImage(R.drawable.title, Graphics.ImageFormat.ARGB8888,getResources());
        } else {
            Decor.buttonPersonnalise = getGraphics().newImage(R.drawable.parametrear, Graphics.ImageFormat.ARGB8888,getResources());
            Decor.buttonAnimaux = getGraphics().newImage(R.drawable.animauxar,Graphics.ImageFormat.ARGB8888,getResources());
            Decor.buttonVetement = getGraphics().newImage(R.drawable.vetementar,Graphics.ImageFormat.ARGB8888,getResources());
            Decor.buttonLegume = getGraphics().newImage(R.drawable.legumear,Graphics.ImageFormat.ARGB8888,getResources());
            Decor.buttonFruit = getGraphics().newImage(R.drawable.fruitar,Graphics.ImageFormat.ARGB8888,getResources());
            Decor.title = getGraphics().newImage(R.drawable.titlear, Graphics.ImageFormat.ARGB8888,getResources());
        }
        Decor.bg = getGraphics().newImage(R.drawable.background,Graphics.ImageFormat.ARGB8888,getResources());
        Decor.bgAudio = getAudio().createMusic(R.raw.background_music);

        Decor.circle = getGraphics().newImage(R.drawable.circle, Graphics.ImageFormat.ARGB8888, getResources());
        Decor.volumeBar = getGraphics().newImage(R.drawable.volumebar, Graphics.ImageFormat.ARGB8888, getResources());
        Decor.mute = getGraphics().newImage(R.drawable.mute, Graphics.ImageFormat.ARGB8888, getResources());
        Decor.volumeUp = getGraphics().newImage(R.drawable.volumeup, Graphics.ImageFormat.ARGB8888, getResources());
        Decor.quit = getGraphics().newImage(R.drawable.quit, Graphics.ImageFormat.ARGB8888, getResources());
    }

    @Override
    public void onBackPressed() {

    }


}

