package com.hyperdev.swoosh.activities;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hyperdev.swoosh.R;
import com.hyperdev.swoosh.model.LeagueType;
import com.hyperdev.swoosh.model.Player;

public class LeagueActivity extends AppCompatActivity {

    public static final String KEY_PLAYER = "key-player";
    private static final int REQ_TO_SKILL_SCREEN = 101;

    private Button mBtnMens;
    private Button mBtnWomens;
    private Button mBtnCoed;
    private Button mBtnNext;
    private TextView mTvSkill;
    private TextView mTvIAmA;

    private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);

        findViews();

        mPlayer = new Player();
    }

    private void findViews() {
        mBtnMens = (Button) findViewById(R.id.btnMens);
        mBtnWomens = (Button) findViewById(R.id.btnWomens);
        mBtnCoed = (Button) findViewById(R.id.btnCoed);
        mBtnNext = (Button) findViewById(R.id.btnNext);
        mTvSkill = (TextView) findViewById(R.id.tvSkill);
        mTvIAmA = (TextView) findViewById(R.id.tvIamA);
    }

    public void onMensLeaguePressed(View view) {
        setDesiredLeague(LeagueType.MENS);
    }

    public void onWomensLeaguePressed(View view) {
        setDesiredLeague(LeagueType.WOMENS);
    }

    public void onCoedLeaguePressed(View view) {
        setDesiredLeague(LeagueType.COED);
    }

    public void onNextPressed(View view) {
        Intent intent = new Intent(this, SkillActivity.class);
        intent.putExtra(KEY_PLAYER, mPlayer);
        startActivityForResult(intent, REQ_TO_SKILL_SCREEN);
    }

    public void setDesiredLeague(@LeagueType String desiredLeague) {
        mPlayer.setDesiredLeague(desiredLeague);
        mBtnNext.setEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_TO_SKILL_SCREEN) {
            if (resultCode == RESULT_OK) {
                Player player = data.getParcelableExtra(KEY_PLAYER);

                updateLeagueUi(player.getDesiredLeague());
                updateSkillUi(player.getSkill());
            }
        }
    }

    private void updateLeagueUi(String desiredLeague) {
        // Only enable the button with the desired league
        switch (desiredLeague) {
            case LeagueType.MENS:
                mBtnMens.setEnabled(true);
                mBtnWomens.setEnabled(false);
                mBtnCoed.setEnabled(false);
                break;

            case LeagueType.WOMENS:
                mBtnMens.setEnabled(false);
                mBtnWomens.setEnabled(true);
                mBtnCoed.setEnabled(false);
                break;

            case LeagueType.COED:
                mBtnMens.setEnabled(false);
                mBtnWomens.setEnabled(false);
                mBtnCoed.setEnabled(true);
                break;
        }
    }

    private void updateSkillUi(String skill) {
        // Hide Next Button
        // Display the skill type layout and set the appropriate skill to display
        mBtnNext.setVisibility(View.GONE);
        mTvIAmA.setVisibility(View.VISIBLE);
        mTvSkill.setVisibility(View.VISIBLE);
        mTvSkill.setText(skill);
    }
}
