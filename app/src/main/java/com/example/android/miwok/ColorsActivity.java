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

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Word> colors = new ArrayList<Word>();

        colors.add(new Word("Red", "weṭeṭṭi", R.drawable.color_red));
        colors.add(new Word("Green", "chokokki", R.drawable.color_green));
        colors.add(new Word("Brown", "ṭakaakki", R.drawable.color_brown));
        colors.add(new Word("Gray", "ṭopoppi", R.drawable.color_gray));
        colors.add(new Word("Black", "kululli", R.drawable.color_black));
        colors.add(new Word("White", "kelelli", R.drawable.color_white));
        colors.add(new Word("Dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        colors.add(new Word("Mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));

        WordAdapter wordAdapter = new WordAdapter(this, colors, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.colors_list_view);
        listView.setAdapter(wordAdapter);
    }
}
