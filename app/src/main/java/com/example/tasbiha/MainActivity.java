package com.example.tasbiha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView txtCounter;
    RelativeLayout btn;
    EditText txtNb;
    boolean isStarted=false;
    int nb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.progress_circular);
        btn=findViewById(R.id.btn);
        txtCounter=findViewById(R.id.txt_counter);
        txtNb=findViewById(R.id.txtNb);

        btn.setOnClickListener((v)->onBtnClick(v));
    }

    private void onBtnClick(View v) {

        prepare();
        update();
        reset();





    }

    private void update() {
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.scale);
        btn.startAnimation(animation);
        progressBar.setProgress(progressBar.getProgress()+1);
        txtCounter.setText(String.valueOf(progressBar.getProgress()));
    }

    private void reset() {
        if(progressBar.getProgress()>=nb){
            isStarted=false;
            txtNb.setEnabled(true);
        }
    }

    private void prepare() {
        if(!isStarted){
            nb =TextUtils.isEmpty(txtNb.getText())?0:Integer.parseInt(txtNb.getText().toString());
            progressBar.setMax(nb);
            progressBar.setProgress(0);
            isStarted=true;
            txtNb.setEnabled(false);
        }
    }
}