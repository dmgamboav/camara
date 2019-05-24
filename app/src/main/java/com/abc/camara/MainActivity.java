package com.abc.camara;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private static final int REQUEST_IMAGE_CAPTURE = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
    }

    public void takePicture(View view) {
       Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       if(imageTakeIntent.resolveActivity(getPackageManager()) !=null) {
         startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CAPTURE);
       }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
          Bundle extras = data.getExtras();
          Bitmap imageBitmap = (Bitmap) extras.get("data");
          imageView.setImageBitmap(imageBitmap);
      }
    }
}
