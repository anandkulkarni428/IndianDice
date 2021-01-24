package com.anand.iprotech.Actvities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.anand.iprotech.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class HomeActivity extends AppCompatActivity {

    CardView fourDiceimg,sevenDiceimg,tambolaDiceimg;
    Animation animationLtoR,animationRtoL;
    TextView appNametxt;

    MediaPlayer player;

    private float x1,x2;
    static final int MIN_DISTANCE = 150;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fourDiceimg = (CardView) findViewById(R.id.four_dice_card);
        sevenDiceimg = (CardView) findViewById(R.id.seven_dice_card);
        tambolaDiceimg = (CardView) findViewById(R.id.tambola_card);
        appNametxt = (TextView) findViewById(R.id.app_name_txt);


        player = MediaPlayer.create(this,R.raw.click2);

        animationLtoR = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.left_to_right);
        animationRtoL = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.right_to_left);


        fourDiceimg.startAnimation(animationLtoR);
        sevenDiceimg.startAnimation(animationRtoL);
        tambolaDiceimg.startAnimation(animationLtoR);
        appNametxt.startAnimation(animationRtoL);


        fourDiceimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                player.start();
                startActivity(intent);
                finish();
            }
        });

        tambolaDiceimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,TambolaActivity.class);
                player.start();
                startActivity(intent);
                finish();
            }
        });

        sevenDiceimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,PachisActivity.class);
                player.start();
                startActivity(intent);
                finish();
            }
        });


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;
                if (Math.abs(deltaX) > MIN_DISTANCE)
                {
                    // Left to Right swipe action
                    if (x2 > x1)
                    {
                        Toast.makeText(this, "Left to Right swipe [Next]", Toast.LENGTH_SHORT).show ();
                    }

                    // Right to left swipe action
                    else
                    {
                        Toast.makeText(this, "Right to Left swipe [Previous]", Toast.LENGTH_SHORT).show ();
                    }

                }
                else
                {
                    // consider as something else - a screen tap for example
                    Toast.makeText(this, "tap", Toast.LENGTH_SHORT).show ();
                }
                break;
        }
        return super.onTouchEvent(event);
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