package com.hyperdev.swoosh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hyperdev.swoosh.R;
import com.hyperdev.swoosh.model.LeagueType;
import com.hyperdev.swoosh.model.Player;
import com.hyperdev.swoosh.model.SkillType;

public class SkillActivity extends AppCompatActivity {

    private Button mBtnFinish;

    private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);

        findViews();

        Intent intent = getIntent();
        if (intent != null) {
            mPlayer = intent.getParcelableExtra(LeagueActivity.KEY_PLAYER);
        }
    }

    private void findViews() {
        mBtnFinish = (Button) findViewById(R.id.btnFinish);
    }

    public void onBeginnerPressed(View view) {
        setSkill(SkillType.BEGINNER);
    }

    public void onBallerPressed(View view) {
        setSkill(SkillType.BALLER);
    }

    public void onFinishPressed(View view) {
        Intent intent = new Intent();
        intent.putExtra(LeagueActivity.KEY_PLAYER, mPlayer);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void setSkill(@SkillType String skill) {
        mPlayer.setSkill(skill);
        mBtnFinish.setEnabled(true);
    }
}
