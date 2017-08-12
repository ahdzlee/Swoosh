package com.hyperdev.swoosh.model;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.hyperdev.swoosh.model.LeagueType.COED;
import static com.hyperdev.swoosh.model.LeagueType.MENS;
import static com.hyperdev.swoosh.model.LeagueType.NONE;
import static com.hyperdev.swoosh.model.LeagueType.WOMENS;

@Retention(RetentionPolicy.SOURCE)
@StringDef({NONE, MENS, WOMENS, COED})
public @interface LeagueType {
    String NONE = "None";
    String MENS = "Mens";
    String WOMENS = "Womens";
    String COED = "Co-ed";
}
