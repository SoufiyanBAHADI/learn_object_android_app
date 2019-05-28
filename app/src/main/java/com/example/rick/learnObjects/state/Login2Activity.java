package com.example.rick.learnObjects.state;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ensias_auth_library.FoxyAuth;
import com.example.ensias_auth_library.models.GameStat;
import com.example.rick.learnObjects.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        GameStats.gameStat = new GameStat();

        GameStats.gameStat.setApp_id("2019_1_8_1");
        GameStats.gameStat.setExercise_id("T_6_11");
        GameStats.gameStat.setLevel_id("1");
        GameStats.gameStat.setUpdated_at("dateFormat.format(date)");
        GameStats.gameStat.setCreated_at(dateFormat.format(date));
        GameStats.gameStat.setGame_date_id("NAN");
        GameStats.gameStat.setSuccessful_attempts("0");
        GameStats.gameStat.setFailed_attempts("0");
        GameStats.gameStat.setMin_time_succeed_sec("0");
        //GameStats.gameStat.setAvg_time_succeed_sec("0");
        GameStats.gameStat.setLongitude("a");
        GameStats.gameStat.setLatitude("a");
        GameStats.gameStat.setDevice("a");
        FoxyAuth.storeGameStat(this,GameStats.gameStat);
        FoxyAuth.emerge(this, CategoriesActivity.class);
    }
}
