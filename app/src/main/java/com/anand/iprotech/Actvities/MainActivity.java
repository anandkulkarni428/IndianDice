package com.anand.iprotech.Actvities;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anand.iprotech.R;

import java.util.Locale;
import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends Activity implements SimpleGestureFilter.SimpleGestureListener {


    TextView startBlinktxt;
    LinearLayout spinLayout;
    ImageView randomImg1, randomImg2, randomImg3, randomImg4, homeImg;
    int min = 1;
    int max = 9;
    Random random;
    Animation startAnimation, startTextAnimation, animation, blinkanimatiom;
    TextToSpeech tts;
    MediaPlayer player, mediaPlayer;
    private SimpleGestureFilter detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Detect touched area
        detector = new SimpleGestureFilter(this, this);


        randomImg1 = (ImageView) findViewById(R.id.random_img_1);
        randomImg2 = (ImageView) findViewById(R.id.random_img_2);
        randomImg3 = (ImageView) findViewById(R.id.random_img_3);
        randomImg4 = (ImageView) findViewById(R.id.random_img_4);
        homeImg = (ImageView) findViewById(R.id.home_img);
        startBlinktxt = (TextView) findViewById(R.id.blink_text);
        spinLayout = (LinearLayout) findViewById(R.id.spin_layout);

        random = new Random();

        player = MediaPlayer.create(this, R.raw.song2);
        mediaPlayer = MediaPlayer.create(this, R.raw.click2);


        startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        startTextAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.shake);

        blinkanimatiom = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);

        final LayoutAnimationController controller = new LayoutAnimationController(startAnimation, 0.2f);

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
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                mediaPlayer.start();
                if (player.isPlaying()) {
                    player.stop();
                }
                startActivity(intent);
                finish();
            }
        });


        startBlinktxt.startAnimation(blinkanimatiom);


    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent me) {
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }

    @Override
    public void onSwipe(int direction) {
        String str = "";

        switch (direction) {

            case SimpleGestureFilter.SWIPE_RIGHT:
                str = "Swipe Right";
                break;
            case SimpleGestureFilter.SWIPE_LEFT:
                str = "Swipe Left";
                break;
            case SimpleGestureFilter.SWIPE_DOWN:
                str = "Swipe Down";
                break;
            case SimpleGestureFilter.SWIPE_UP:
                player.start();
                randomImg1.setImageResource(R.mipmap.b);
                randomImg2.setImageResource(R.mipmap.b);
                randomImg4.setImageResource(R.mipmap.b);
                randomImg3.setImageResource(R.mipmap.b);

//                spinLayout.setLayoutAnimation(controller);

                randomImg1.startAnimation(startAnimation);
                randomImg2.startAnimation(startAnimation);
                randomImg3.startAnimation(startAnimation);
                randomImg4.startAnimation(startAnimation);

                startBlinktxt.setVisibility(View.GONE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        randomNum();
                        startBlinktxt.setVisibility(View.VISIBLE);
                    }
                }, 960);
                break;

        }
    }

    @Override
    public void onDoubleTap() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }


    public void randomNum() {
        int randomnum = random.nextInt((max - min) + 1) + min;

        if (randomnum == 1) {
            randomImg1.setImageResource(R.mipmap.a);
            randomImg2.setImageResource(R.mipmap.b);
            randomImg3.setImageResource(R.mipmap.b);
            randomImg4.setImageResource(R.mipmap.b);

            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);


        }

        if (randomnum == 2) {
            randomImg1.setImageResource(R.mipmap.a);
            randomImg2.setImageResource(R.mipmap.a);
            randomImg3.setImageResource(R.mipmap.b);
            randomImg4.setImageResource(R.mipmap.b);

            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);


        }
        if (randomnum == 3) {
            randomImg1.setImageResource(R.mipmap.a);
            randomImg2.setImageResource(R.mipmap.a);
            randomImg3.setImageResource(R.mipmap.a);
            randomImg4.setImageResource(R.mipmap.b);

            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);


        }
        if (randomnum == 4) {
            randomImg1.setImageResource(R.mipmap.a);
            randomImg2.setImageResource(R.mipmap.a);
            randomImg3.setImageResource(R.mipmap.a);
            randomImg4.setImageResource(R.mipmap.a);

            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);


        }
        if (randomnum == 5) {
            randomImg1.setImageResource(R.mipmap.b);
            randomImg2.setImageResource(R.mipmap.b);
            randomImg3.setImageResource(R.mipmap.a);
            randomImg4.setImageResource(R.mipmap.a);

            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);


        }

        if (randomnum == 6) {
            randomImg1.setImageResource(R.mipmap.b);
            randomImg2.setImageResource(R.mipmap.a);
            randomImg3.setImageResource(R.mipmap.a);
            randomImg4.setImageResource(R.mipmap.a);

            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);


        }

        if (randomnum == 7) {
            randomImg1.setImageResource(R.mipmap.a);
            randomImg2.setImageResource(R.mipmap.b);
            randomImg3.setImageResource(R.mipmap.b);
            randomImg4.setImageResource(R.mipmap.a);

            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);


        }

        if (randomnum == 8) {
            randomImg1.setImageResource(R.mipmap.b);
            randomImg2.setImageResource(R.mipmap.b);
            randomImg3.setImageResource(R.mipmap.b);
            randomImg4.setImageResource(R.mipmap.b);

            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);


        }
        if (randomnum == 9) {
            randomImg1.setImageResource(R.mipmap.a);
            randomImg2.setImageResource(R.mipmap.b);
            randomImg3.setImageResource(R.mipmap.a);
            randomImg4.setImageResource(R.mipmap.a);

            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);


        }
    }

    @Override
    public void onBackPressed() {


        final SweetAlertDialog dialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
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