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

import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class PachisActivity extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    TextView startBlinktxt,endBlinkText;
    ImageView randomImg1, randomImg2, randomImg3, randomImg4,randomImg5,randomImg6,randomImg7, homeImg;
    LinearLayout spinLayout;
    int min = 1;
    int max = 8;
    Random random;
    Animation startAnimation, startTextAnimation,animation,blinkAnimation;
    TextToSpeech tts;
    MediaPlayer player,mediaPlayer;
    private SimpleGestureFilter detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pachis);

        detector = new SimpleGestureFilter(this, this);

        endBlinkText = (TextView) findViewById(R.id.log_btn);
        randomImg1 = (ImageView) findViewById(R.id.random_img_1);
        randomImg2 = (ImageView) findViewById(R.id.random_img_2);
        randomImg3 = (ImageView) findViewById(R.id.random_img_3);
        randomImg4 = (ImageView) findViewById(R.id.random_img_4);
        randomImg5 = (ImageView) findViewById(R.id.random_img_5);
        randomImg6 = (ImageView) findViewById(R.id.random_img_6);
        randomImg7 = (ImageView) findViewById(R.id.random_img_7);
        startBlinktxt = (TextView) findViewById(R.id.blink_text);
        homeImg = (ImageView) findViewById(R.id.home_img);
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

        blinkAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);

        final LayoutAnimationController controller = new LayoutAnimationController(startAnimation, 0.2f);


        homeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PachisActivity.this, HomeActivity.class);
                mediaPlayer.start();
                if (player.isPlaying()){
                    player.stop();
                }
                startActivity(intent);
                finish();
            }
        });

        endBlinkText.setVisibility(View.VISIBLE);
        startBlinktxt.setVisibility(View.VISIBLE);
        endBlinkText.startAnimation(blinkAnimation);


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        this.detector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onSwipe(int direction) {

        String str = "";

        switch (direction){
            case SimpleGestureFilter.SWIPE_UP :
                player.start();

                endBlinkText.setVisibility(View.GONE);
                startBlinktxt.setVisibility(View.GONE);

                randomImg1.setImageResource(R.mipmap.b);
                randomImg2.setImageResource(R.mipmap.b);
                randomImg3.setImageResource(R.mipmap.b);
                randomImg4.setImageResource(R.mipmap.b);
                randomImg5.setImageResource(R.mipmap.b);
                randomImg6.setImageResource(R.mipmap.b);
                randomImg7.setImageResource(R.mipmap.b);

//                spinLayout.setLayoutAnimation(controller);

                randomImg1.startAnimation(startAnimation);
                randomImg2.startAnimation(startAnimation);
                randomImg3.startAnimation(startAnimation);
                randomImg4.startAnimation(startAnimation);
                randomImg5.startAnimation(startAnimation);
                randomImg6.startAnimation(startAnimation);
                randomImg7.startAnimation(startAnimation);



                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        randomNum();
                        endBlinkText.setVisibility(View.VISIBLE);
                        startBlinktxt.setVisibility(View.VISIBLE);
                    }
                },960);
                break;

            case SimpleGestureFilter.SWIPE_RIGHT:
                str = "Swipe Right";
                break;
            case SimpleGestureFilter.SWIPE_LEFT:
                str = "Swipe Left";
                break;
            case SimpleGestureFilter.SWIPE_DOWN:
                str = "Swipe Down";
                break;
        }

    }

    @Override
    public void onDoubleTap() {

    }


    public void randomNum() {
        int randomnum = random.nextInt((max - min) + 1) + min;

        if (randomnum == 1) {
            randomImg1.setImageResource(R.mipmap.a);
            randomImg2.setImageResource(R.mipmap.b);
            randomImg3.setImageResource(R.mipmap.b);
            randomImg4.setImageResource(R.mipmap.b);
            randomImg5.setImageResource(R.mipmap.b);
            randomImg6.setImageResource(R.mipmap.b);
            randomImg7.setImageResource(R.mipmap.b);

            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);
            randomImg5.startAnimation(startTextAnimation);
            randomImg6.startAnimation(startTextAnimation);
            randomImg7.startAnimation(startTextAnimation);

            startBlinktxt.setText("10");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                tts.speak(startBlinktxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null,startBlinktxt.getText().toString());
//            }
        }

        if (randomnum == 2) {
            randomImg1.setImageResource(R.mipmap.a);
            randomImg2.setImageResource(R.mipmap.a);
            randomImg3.setImageResource(R.mipmap.b);
            randomImg4.setImageResource(R.mipmap.b);
            randomImg5.setImageResource(R.mipmap.b);
            randomImg6.setImageResource(R.mipmap.b);
            randomImg7.setImageResource(R.mipmap.b);


            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);
            randomImg5.startAnimation(startTextAnimation);
            randomImg6.startAnimation(startTextAnimation);
            randomImg7.startAnimation(startTextAnimation);

            startBlinktxt.setText("2");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                tts.speak(startBlinktxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null,startBlinktxt.getText().toString());
//            }
        }
        if (randomnum == 3) {
            randomImg1.setImageResource(R.mipmap.a);
            randomImg2.setImageResource(R.mipmap.a);
            randomImg3.setImageResource(R.mipmap.a);
            randomImg4.setImageResource(R.mipmap.b);
            randomImg5.setImageResource(R.mipmap.b);
            randomImg6.setImageResource(R.mipmap.b);
            randomImg7.setImageResource(R.mipmap.b);


            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);
            randomImg5.startAnimation(startTextAnimation);
            randomImg6.startAnimation(startTextAnimation);
            randomImg7.startAnimation(startTextAnimation);

            startBlinktxt.setText("3");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                tts.speak(startBlinktxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null,startBlinktxt.getText().toString());
//            }
        }
        if (randomnum == 4) {
            randomImg1.setImageResource(R.mipmap.a);
            randomImg2.setImageResource(R.mipmap.a);
            randomImg3.setImageResource(R.mipmap.a);
            randomImg4.setImageResource(R.mipmap.a);
            randomImg5.setImageResource(R.mipmap.b);
            randomImg6.setImageResource(R.mipmap.b);
            randomImg7.setImageResource(R.mipmap.b);


            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);
            randomImg5.startAnimation(startTextAnimation);
            randomImg6.startAnimation(startTextAnimation);
            randomImg7.startAnimation(startTextAnimation);

            startBlinktxt.setText("4");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                tts.speak(startBlinktxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null,startBlinktxt.getText().toString());
//            }
        }
        if (randomnum == 5) {
            randomImg1.setImageResource(R.mipmap.a);
            randomImg2.setImageResource(R.mipmap.a);
            randomImg3.setImageResource(R.mipmap.a);
            randomImg4.setImageResource(R.mipmap.a);
            randomImg5.setImageResource(R.mipmap.a);
            randomImg6.setImageResource(R.mipmap.b);
            randomImg7.setImageResource(R.mipmap.b);


            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);
            randomImg5.startAnimation(startTextAnimation);
            randomImg6.startAnimation(startTextAnimation);
            randomImg7.startAnimation(startTextAnimation);

            startBlinktxt.setText("25");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                tts.speak(startBlinktxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null,startBlinktxt.getText().toString());
//            }
        }

        if (randomnum == 6) {
            randomImg1.setImageResource(R.mipmap.b);
            randomImg2.setImageResource(R.mipmap.a);
            randomImg3.setImageResource(R.mipmap.a);
            randomImg4.setImageResource(R.mipmap.a);
            randomImg5.setImageResource(R.mipmap.a);
            randomImg6.setImageResource(R.mipmap.a);
            randomImg7.setImageResource(R.mipmap.a);


            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);
            randomImg5.startAnimation(startTextAnimation);
            randomImg6.startAnimation(startTextAnimation);
            randomImg7.startAnimation(startTextAnimation);

            startBlinktxt.setText("30");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                tts.speak(startBlinktxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null,startBlinktxt.getText().toString());
//            }
        }

        if (randomnum == 7) {
            randomImg1.setImageResource(R.mipmap.b);
            randomImg2.setImageResource(R.mipmap.b);
            randomImg3.setImageResource(R.mipmap.b);
            randomImg4.setImageResource(R.mipmap.b);
            randomImg5.setImageResource(R.mipmap.b);
            randomImg6.setImageResource(R.mipmap.b);
            randomImg7.setImageResource(R.mipmap.b);


            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);
            randomImg5.startAnimation(startTextAnimation);
            randomImg6.startAnimation(startTextAnimation);
            randomImg7.startAnimation(startTextAnimation);

            startBlinktxt.setText("7");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                tts.speak(startBlinktxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null,startBlinktxt.getText().toString());
//            }
        }

        if (randomnum == 8) {
            randomImg1.setImageResource(R.mipmap.a);
            randomImg2.setImageResource(R.mipmap.a);
            randomImg3.setImageResource(R.mipmap.a);
            randomImg4.setImageResource(R.mipmap.a);
            randomImg5.setImageResource(R.mipmap.a);
            randomImg6.setImageResource(R.mipmap.a);
            randomImg7.setImageResource(R.mipmap.a);


            randomImg1.startAnimation(startTextAnimation);
            randomImg2.startAnimation(startTextAnimation);
            randomImg3.startAnimation(startTextAnimation);
            randomImg4.startAnimation(startTextAnimation);
            randomImg5.startAnimation(startTextAnimation);
            randomImg6.startAnimation(startTextAnimation);
            randomImg7.startAnimation(startTextAnimation);

            startBlinktxt.setText("14");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                tts.speak(startBlinktxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null,startBlinktxt.getText().toString());
//            }
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
            randomImg5.startAnimation(startTextAnimation);
            randomImg6.startAnimation(startTextAnimation);
            randomImg7.startAnimation(startTextAnimation);

            startBlinktxt.setText("3");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                tts.speak(startBlinktxt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null,startBlinktxt.getText().toString());
//            }
        }
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