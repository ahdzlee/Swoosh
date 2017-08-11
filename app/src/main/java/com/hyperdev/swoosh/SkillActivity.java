package com.hyperdev.swoosh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SkillActivity extends AppCompatActivity {

    private Button mBtnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);

        findViews();
    }

    private void findViews() {
        mBtnFinish = (Button) findViewById(R.id.btnFinish);
    }

    public void onBeginnerPressed(View view) {
        mBtnFinish.setEnabled(true);
    }

    public void onBallerPressed(View view) {
        mBtnFinish.setEnabled(true);
    }

    public void onFinishPressed(View view) {
        finish();
    }
}
