package com.anand.iprotech.Actvities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.anand.iprotech.R;
import com.anand.iprotech.Adapters.myNuberDumyGrid;
import com.anand.iprotech.Adapters.myNuberGrid;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class TambolaActivity extends AppCompatActivity {

    public static TextView primaryNotxt, completedMsgtxt;

    RecyclerView recNumbergrid, recNumberDumygrid;

    public static ImageView homeImg, resetImg;

    public static Animation blinkAnimation, animationDtoU, animationLtoR, shakeAnimation;

    List<Integer> numbersList;

    public static Button userRegbtn;
    int min = 1;
    int max = 90;
    int random;

    TextToSpeech tts;
    MediaPlayer player,mediaPlayer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        primaryNotxt = (TextView) findViewById(R.id.primary_no_txt);
        completedMsgtxt = (TextView) findViewById(R.id.completed_message_txt);
        recNumbergrid = (RecyclerView) findViewById(R.id.rec_num_grid);
        recNumberDumygrid = (RecyclerView) findViewById(R.id.rec_num_dummy_grid);
        userRegbtn = (Button) findViewById(R.id.reg_btn);
        homeImg = (ImageView) findViewById(R.id.home_img);
        resetImg = (ImageView) findViewById(R.id.reset_img);

        player = MediaPlayer.create(this, R.raw.gear);
        mediaPlayer = MediaPlayer.create(this, R.raw.click2);

        blinkAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        animationDtoU = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.down_to_up);
        animationLtoR = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.left_to_right);
        shakeAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.shake);


        completedMsgtxt.startAnimation(blinkAnimation);

        final LayoutAnimationController controller = new LayoutAnimationController(shakeAnimation, 0.2f);
        final LayoutAnimationController animationController = new LayoutAnimationController(animationLtoR, 0.1f);


        numbersList = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new GridLayoutManager(TambolaActivity.this, 10);
        recNumbergrid.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager1 = new GridLayoutManager(TambolaActivity.this, 10);
        recNumbergrid.setLayoutManager(linearLayoutManager);
        recNumberDumygrid.setLayoutManager(linearLayoutManager1);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.UK);
                }
            }
        });


        homeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TambolaActivity.this, HomeActivity.class);
                mediaPlayer.start();
                if (player.isPlaying()){
                    player.stop();
                }
                startActivity(intent);
                finish();
            }
        });

        primaryNotxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak(primaryNotxt.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, primaryNotxt.getText().toString());
                }
            }
        });


        recNumberDumygrid.setAdapter(new myNuberDumyGrid(TambolaActivity.this));
        recNumberDumygrid.setLayoutAnimation(animationController);
        player.start();


        resetImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                mediaPlayer.start();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userRegbtn.setEnabled(true);
                player.stop();
            }
        },5000);







        userRegbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userRegbtn.setEnabled(false);
                mediaPlayer.start();
                if (player.isPlaying()){
                    player.stop();
                }

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // This method will be executed once the timer is over




                        userRegbtn.setEnabled(true);
                        primaryNotxt.startAnimation(animationDtoU);

                        recNumberDumygrid.setVisibility(View.GONE);
                        recNumbergrid.setVisibility(View.VISIBLE);


                        userRegbtn.setText("Shuffle it!");


                        getUniqueRandomNumber();

                    }
                }, 500);// set time as per your requirement


            }
        });


    }

    public int getUniqueRandomNumber() {
        int runs = 1;
        int randomNum;
        do {
            Random rand = new Random();
            randomNum = rand.nextInt((max - min) + 1) + min;
            runs++;
        } while (numbersList.contains(randomNum) || runs > max);

        primaryNotxt.setText(String.valueOf(randomNum));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(String.valueOf(randomNum), TextToSpeech.QUEUE_FLUSH, null, String.valueOf(randomNum));
        }

        numbersList.add(randomNum);

        recNumbergrid.setAdapter(new myNuberGrid(TambolaActivity.this, numbersList));

        Log.d("TAG_LIST", numbersList.toString());

        return randomNum;


    }

    @Override
    public void onBackPressed() {


        final SweetAlertDialog dialog = new SweetAlertDialog(this,SweetAlertDialog.WARNING_TYPE);
                dialog.setTitleText("Are you sure?");
                dialog.setContentText("You want exit from this app!");
                dialog.show();
                dialog.setConfirmButton("Yes", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        finishAffinity();
                        player.stop();
                    }
                });
                dialog.setCancelButton("No", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        dialog.dismiss();
                    }
                });



    }
}