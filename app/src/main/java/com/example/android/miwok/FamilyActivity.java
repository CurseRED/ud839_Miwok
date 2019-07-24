/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> family = new ArrayList<Word>();

        family.add(new Word("Father", "әpә", R.drawable.family_father));
        family.add(new Word("Mother", "әṭa", R.drawable.family_mother));
        family.add(new Word("Son", "angsi", R.drawable.family_son));
        family.add(new Word("Daughter", "tune", R.drawable.family_daughter));
        family.add(new Word("Older brother", "taachi", R.drawable.family_older_brother));
        family.add(new Word("Younger brother", "chalitti", R.drawable.family_younger_sister));
        family.add(new Word("Older sister", "teṭe", R.drawable.family_older_sister));
        family.add(new Word("Younger sister", "kolliti", R.drawable.family_younger_sister));
        family.add(new Word("Grandmother", "ama", R.drawable.family_grandmother));
        family.add(new Word("Grandfather", "paapa", R.drawable.family_grandfather));

        WordAdapter wordAdapter = new WordAdapter(this, family, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.family_list_view);
        listView.setAdapter(wordAdapter);
    }
}
