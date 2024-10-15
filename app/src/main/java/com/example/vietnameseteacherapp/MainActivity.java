package com.example.vietnameseteacherapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button blackBtn,greenBtn,purpleBtn,redBtn,yellowBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        blackBtn = findViewById(R.id.blackBtn);
        greenBtn = findViewById(R.id.greenBtn);
        purpleBtn = findViewById(R.id.purpleBtn);
        redBtn = findViewById(R.id.redBtn);
        yellowBtn = findViewById(R.id.yellowBtn);

        yellowBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        redBtn.setOnClickListener(this);
        blackBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Find the button by ID and play the correct sound
        int clickBtnId = v.getId();

        if(clickBtnId == R.id.blackBtn) {
            playSound(R.raw.mau_den);
        }else if(clickBtnId == R.id.greenBtn){
            playSound(R.raw.mau_xanh);
        }else if(clickBtnId == R.id.purpleBtn){
            playSound(R.raw.mau_tim);
        }else if(clickBtnId == R.id.redBtn){
            playSound(R.raw.mau_do);
        }else if(clickBtnId == R.id.yellowBtn){
            playSound(R.raw.mau_vang);
        }else {
            Toast.makeText(this,"Error !",Toast.LENGTH_SHORT).show();
        }

    }
    public void playSound(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this,
                id
        );
        mediaPlayer.start();

    }
}