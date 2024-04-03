package com.example.markdowndemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import io.noties.markwon.Markwon;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Markwon markwon = Markwon.create(this);

        // 文本格式，以markdown格式寫的
        String markdown = "# Hello, Markwon!";
        Spanned spanned = markwon.toMarkdown(markdown);

        WebView webView = findViewById(R.id.webView);

        // 將文本轉成HTML格式
        String html = Html.toHtml(spanned, Html.TO_HTML_PARAGRAPH_LINES_CONSECUTIVE);

        // "text/html"：HTML 文本。
        webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);


    }
}