package com.udacity.gradle.builditbigger.utils;

import android.view.View;

public class UIUtils {
    public static void adjustVisabilityBasedOnLoadingStatus(View standardViewElement, View loadingViewElement, boolean isLoading) {
        if ((standardViewElement != null) && (loadingViewElement != null)) {
            if (isLoading) {
                standardViewElement.setVisibility(View.GONE);
                loadingViewElement.setVisibility(View.VISIBLE);
            }
            else {
                standardViewElement.setVisibility(View.VISIBLE);
                loadingViewElement.setVisibility(View.GONE);
            }
        }
    }
}
