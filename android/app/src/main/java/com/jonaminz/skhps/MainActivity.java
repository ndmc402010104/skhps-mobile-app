package com.jonaminz.skhps;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (this.bridge != null && this.bridge.getWebView() != null) {
      WebView webView = this.bridge.getWebView();
      WebSettings settings = webView.getSettings();

      settings.setTextZoom(100);
      settings.setUseWideViewPort(true);
      settings.setLoadWithOverviewMode(false);
      settings.setBuiltInZoomControls(false);
      settings.setDisplayZoomControls(false);
      settings.setSupportZoom(false);
    }
  }

  @Override
  public void onBackPressed() {
    if (this.bridge != null && this.bridge.getWebView() != null && this.bridge.getWebView().canGoBack()) {
      this.bridge.getWebView().goBack();
    } else {
      super.onBackPressed();
    }
  }
}
