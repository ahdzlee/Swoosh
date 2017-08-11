package com.hyperdev.swoosh.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {

    private String mDesiredLeague;
    private String mSkill;

    public Player() {
    }

    public Player(String desiredLeague, String skill) {
        mDesiredLeague = desiredLeague;
        mSkill = skill;
    }

    protected Player(Parcel in) {
        mDesiredLeague = in.readString();
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

    public String getDesiredLeague() {
        return mDesiredLeague;
    }

    public void setDesiredLeague(String desiredLeague) {
        mDesiredLeague = desiredLeague;
    }

    public String getSkill() {
        return mSkill;
    }

    public void setSkill(String skill) {
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
