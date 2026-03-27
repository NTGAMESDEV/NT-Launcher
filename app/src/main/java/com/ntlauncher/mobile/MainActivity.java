package com.ntlauncher.mobile;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String gameUrl = "https://example.com/game.zip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        Button downloadBtn = new Button(this);
        downloadBtn.setText("Download Game");

        Button playBtn = new Button(this);
        playBtn.setText("Enter Server");

        layout.addView(downloadBtn);
        layout.addView(playBtn);

        setContentView(layout);

        downloadBtn.setOnClickListener(v -> downloadGame());

        playBtn.setOnClickListener(v -> {
            Toast.makeText(this, "Launching Game...", Toast.LENGTH_SHORT).show();
        });
    }

    void downloadGame() {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(gameUrl));
        request.setTitle("Downloading...");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "nt_game.zip");

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }
          }
