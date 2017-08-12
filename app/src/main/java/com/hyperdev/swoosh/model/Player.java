package com.hyperdev.swoosh.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {

    @LeagueType
    private String mDesiredLeague;

    @SkillType
    private String mSkill;

    public Player() {
    }

    public Player(@LeagueType String desiredLeague, @SkillType String skill) {
        mDesiredLeague = desiredLeague;
        mSkill = skill;
    }

    protected Player(Parcel in) {
        //noinspection WrongConstant - this is safe and we are sure that this is a valid LeagueType
        mDesiredLeague = in.readString();

        //noinspection WrongConstant - this is safe and we are sure that this is a valid SkillType
        mSkill = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    @LeagueType
    public String getDesiredLeague() {
        return mDesiredLeague;
    }

    public void setDesiredLeague(@LeagueType String desiredLeague) {
        mDesiredLeague = desiredLeague;
    }

    @SkillType
    public String getSkill() {
        return mSkill;
    }

    public void setSkill(@SkillType String skill) {
        mSkill = skill;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mDesiredLeague);
        parcel.writeString(mSkill);
    }
}
