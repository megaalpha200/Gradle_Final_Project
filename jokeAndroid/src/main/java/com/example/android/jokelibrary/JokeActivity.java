package com.example.android.jokelibrary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class JokeActivity extends AppCompatActivity {

    private String providedJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView JokeTextView = findViewById(R.id.joke_text_view);
        providedJoke = JokeTextView.getText().toString();

        Bundle intentExtras = getIntent().getExtras();

        if (savedInstanceState != null) {
            providedJoke = savedInstanceState.getString(getString(R.string.joke_extra));
        }
        else if (intentExtras != null) {
            providedJoke = intentExtras.getString(getString(R.string.joke_extra));
        }

        JokeTextView.setText(providedJoke);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(getString(R.string.joke_extra), providedJoke);
    }

    public static Intent getJokeActivityIntent(Context context, String joke) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(context.getString(R.string.joke_extra), joke);
        return intent;
    }
}
