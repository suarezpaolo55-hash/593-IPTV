package com.iptv593;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.net.Uri;
import android.widget.VideoView;

public class MainActivity extends Activity {
    
    private EditText enlaceEntrada;
    private VideoView reproductor;
    private Button botonReproducir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        enlaceEntrada = findViewById(R.id.enlaceEntrada);
        reproductor = findViewById(R.id.reproductor);
        botonReproducir = findViewById(R.id.botonReproducir);
        
        botonReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = enlaceEntrada.getText().toString().trim();
                if(!url.isEmpty()) {
                    reproducirVideo(url);
                }
            }
        });
    }
    
    private void reproducirVideo(String url) {
        Uri uri = Uri.parse(url);
        reproductor.setVideoURI(uri);
        MediaController controles = new MediaController(this);
        controles.setAnchorView(reproductor);
        reproductor.setMediaController(controles);
        reproductor.start();
    }
}
