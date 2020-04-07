package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Photo extends AppCompatActivity {

    //private Camera mCamera = null;
    //  Camera camera = Camera.open();
    // Camera.Parameters params = camera.getParameters();
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView imageView;
    private ImageButton back;
    private Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        back = (ImageButton) findViewById(R.id.imageBack2);
        imageView = (ImageView) findViewById(R.id.photoMatch);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        takePicture();
    }

    private void takePicture() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    public void onBackPressed(){
        Intent intent = new Intent(this, Statistiques.class);
        intent.putExtra("imageBitmap", imageBitmap);
        startActivity(intent);
    }
}
