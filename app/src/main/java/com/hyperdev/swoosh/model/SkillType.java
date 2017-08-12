package com.hyperdev.swoosh.model;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.hyperdev.swoosh.model.SkillType.NONE;
import static com.hyperdev.swoosh.model.SkillType.BALLER;
import static com.hyperdev.swoosh.model.SkillType.BEGINNER;

@Retention(RetentionPolicy.SOURCE)
@StringDef({NONE, BEGINNER, BALLER})
public @interface SkillType {
    String NONE = "None";
    String BEGINNER = "Beginner";
    String BALLER = "Baller";
}
