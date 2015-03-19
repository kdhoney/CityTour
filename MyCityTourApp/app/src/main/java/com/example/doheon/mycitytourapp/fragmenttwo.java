package com.example.doheon.mycitytourapp;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;



/**
 * Created by DoHeon on 2015-03-18.
 */
public class fragmenttwo extends Fragment{
    private String currentURL;

    public void init(String url) {
        currentURL = url;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_info, container, false);
        if (currentURL != null) {
            WebView wv = (WebView) v.findViewById(R.id.webPage);
            wv.getSettings().setJavaScriptEnabled(true);
            wv.setWebViewClient(new SwAWebClient());
            wv.loadUrl(currentURL);
        }
        return v;
    }

    public void updateUrl(String url) {
        currentURL = url;
        WebView wv = (WebView) getView().findViewById(R.id.webPage);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);
    }

    private class SwAWebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }
}
