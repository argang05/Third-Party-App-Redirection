package com.example.implicitintentapp
/*
-> Implicit intent is used when we want to move from one app to another.
-> Here we're going to present two card views pointing to different apps and use implicit intent to
redirect to the particular app.
 */
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Use Implicit Intent to provide a functionality so that if we click on spotify card view
        //Spotify app should open and if we click on cam card view then cam card view should open.

        val spotifyButton = findViewById<CardView>(R.id.spotCard);
        val cameraButton = findViewById<CardView>(R.id.camCard);

        spotifyButton.setOnClickListener {
            //Create an intent variable that stores reference to the third-party app.
            val intent = Intent(Intent.ACTION_VIEW);
            intent.data = Uri.parse("spotify:");

            //Start the activity of third party app:
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Spotify app could not be opened.", Toast.LENGTH_SHORT).show()
            }
        }

        cameraButton.setOnClickListener {
            //Create an intent variable that stores reference to the third-party app.
            //ACTION_IMAGE_CAPTURE used to open camera to capture image.
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            //Start the activity of third party app:
            startActivity(intent);
        }
    }
}