package com.hyperdev.swoosh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hyperdev.swoosh.R;
import com.hyperdev.swoosh.model.LeagueType;
import com.hyperdev.swoosh.model.SkillType;

public class SkillActivity extends AppCompatActivity {

    public static final String KEY_SKILL_TYPE = "key-skill-type";

    private Button mBtnFinish;

    private String mSkill;
    private String mDesiredLeague;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);

        findViews();

        Intent intent = getIntent();
        if (intent != null) {
            mDesiredLeague = intent.getStringExtra(LeagueActivity.KEY_DESIRED_LEAGUE);
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
        intent.putExtra(LeagueActivity.KEY_DESIRED_LEAGUE, mDesiredLeague);
        intent.putExtra(KEY_SKILL_TYPE, mSkill);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void setSkill(String skill) {
        mSkill = skill;
        mBtnFinish.setEnabled(true);
    }
}
