package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyFragment extends Fragment {
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_family, container, false);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> family = new ArrayList<Word>();

        family.add(new Word("Father", "әpә", R.drawable.family_father, R.raw.family_father));
        family.add(new Word("Mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        family.add(new Word("Son", "angsi", R.drawable.family_son, R.raw.family_son));
        family.add(new Word("Daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        family.add(new Word("Older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        family.add(new Word("Younger brother", "chalitti", R.drawable.family_younger_sister, R.raw.family_younger_brother));
        family.add(new Word("Older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        family.add(new Word("Younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        family.add(new Word("Grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        family.add(new Word("Grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter wordAdapter = new WordAdapter(getActivity(), family, R.color.category_family);
        ListView listView = (ListView) rootView.findViewById(R.id.family_list_view);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), family.get(position).getSongResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }
        });
        return rootView;
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
    }
}
