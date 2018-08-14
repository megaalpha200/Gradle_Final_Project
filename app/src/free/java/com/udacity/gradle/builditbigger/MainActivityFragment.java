package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.utils.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.utils.PostExecutionAsyncTaskListener;
import com.udacity.gradle.builditbigger.utils.UIUtils;

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

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    @OnClick(R.id.tell_joke_btn)
    public void tellJoke() {
        UIUtils.adjustVisabilityBasedOnLoadingStatus(tellJokeButton, loadingProgressBar, true);
        new EndpointsAsyncTask().execute(new Pair<Context, PostExecutionAsyncTaskListener>(getContext(), this));
    }

    @Override
    public void onPostExecution() {
        UIUtils.adjustVisabilityBasedOnLoadingStatus(tellJokeButton, loadingProgressBar, false);
    }
}
