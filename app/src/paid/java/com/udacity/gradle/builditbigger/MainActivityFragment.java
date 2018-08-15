package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.jokelibrary.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.utils.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.utils.PostExecutionAsyncTaskListener;
import com.udacity.gradle.builditbigger.utils.UIUtils;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements PostExecutionAsyncTaskListener {

    @BindView(R.id.tell_joke_btn)
    Button tellJokeButton;

    @BindView(R.id.loading_progress_bar)
    ProgressBar loadingProgressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, root);

        return root;
    }

    @OnClick(R.id.tell_joke_btn)
    public void tellJoke() {
        UIUtils.adjustVisabilityBasedOnLoadingStatus(tellJokeButton, loadingProgressBar, true);
        new EndpointsAsyncTask().execute(new Pair<Context, PostExecutionAsyncTaskListener>(getContext(), this));
    }

    @Override
    public void onPostExecution(String result) {
        UIUtils.adjustVisabilityBasedOnLoadingStatus(tellJokeButton, loadingProgressBar, false);
        startActivity(JokeActivity.getJokeActivityIntent(getContext(), result));
    }
}
