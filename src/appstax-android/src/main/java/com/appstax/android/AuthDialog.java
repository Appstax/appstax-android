package com.appstax.android;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.appstax.AxAuthConfig;
import com.appstax.AxAuthResult;
import com.appstax.AxException;

import java.math.BigInteger;
import java.security.SecureRandom;

public class AuthDialog extends DialogFragment {

    private AxAuthConfig config;
    private Callback<AxAuthResult> callback;
    private boolean running = false;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        WebView webView = new WebView(getActivity());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.d("AuthDialog", "onPageStarted() " + url);
                if(url.startsWith(config.getRedirectUri())) {
                    handleRedirect(url);
                }
            }
        });

        webView.clearCache(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(getAuthUrl());
        builder.setView(webView);

        AlertDialog dialog = builder.create();
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        return dialog;
    }

    public void run(AxAuthConfig config, FragmentManager manager, Callback<AxAuthResult> callback) {
        if(running) {
            return;
        }
        this.running = true;
        this.config = config;
        this.callback = callback;
        show(manager, "AxAuthDialog");
    }

    private void handleRedirect(String urlString) {
        if(!running) {
            return;
        }
        Uri uri = Uri.parse(urlString);
        String code = uri.getQueryParameter("code");
        String error = uri.getQueryParameter("error");
        String errorDescription = uri.getQueryParameter("error_description");

        dismiss();

        if(errorDescription != null) {
            callback.onError(new AxException(errorDescription));
        } else if(error != null) {
            callback.onError(new AxException(error));
        } else {
            callback.onSuccess(new AxAuthResult(code, config.getRedirectUri()));
        }
        running = false;
    }

    private String getAuthUrl() {
        return config.getUri()
                .replace("{redirectUri}", Uri.encode(config.getRedirectUri()))
                .replace("{clientId}", config.getClientId())
                .replace("{nonce}", generateNonce());
    }

    private String generateNonce() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

}
