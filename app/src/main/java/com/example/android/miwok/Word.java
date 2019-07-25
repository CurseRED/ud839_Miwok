package com.example.android.miwok;

public class Word {
    private String mDefaultTranslation, mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private final static int NO_IMAGE_PROVIDED = -1;
    private int mSongResourceId;

    public Word(String defaultTranslation, String miwokTranslation, int songResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSongResourceId = songResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int songResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mSongResourceId = songResourceId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getSongResourceId() {
        return mSongResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
