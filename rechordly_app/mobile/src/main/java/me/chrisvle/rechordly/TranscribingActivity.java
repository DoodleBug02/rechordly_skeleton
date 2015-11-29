package me.chrisvle.rechordly;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class TranscribingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transcribing);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));


//        ImageButton imageView = (ImageButton)findViewById(R.id.lyrics);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lyrics);
//
//        int imageWidth = bitmap.getWidth();
//        int imageHeight = bitmap.getHeight();
//
//        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
//
//        int newWidth = metrics.widthPixels;
//        float scaleFactor = (float)newWidth/(float)imageWidth;
//        int newHeight = (int)(imageHeight * scaleFactor);
//
//        bitmap = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true);
//        imageView.setImageBitmap(bitmap);
    }
}
