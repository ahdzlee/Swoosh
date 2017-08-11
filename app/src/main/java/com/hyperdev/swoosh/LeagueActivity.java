package com.hyperdev.swoosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LeagueActivity extends AppCompatActivity {

    private Button mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);

        findViews();
    }

    private void findViews() {
        mBtnNext = (Button) findViewById(R.id.btnNext);
    }

    public void onMensLeaguePressed(View view) {
        mBtnNext.setEnabled(true);
    }

    public void onWomensLeaguePressed(View view) {
        mBtnNext.setEnabled(true);
    }

    public void onCoedLeaguePressed(View view) {
        mBtnNext.setEnabled(true);
    }

    public void onNextPressed(View view) {
        Intent intent = new Intent(this, SkillActivity.class);
        startActivity(intent);
    }
}
