package me.chrisvle.rechordly;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));

        ImageButton ib = (ImageButton)findViewById(R.id.info);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.recording);

        int imageWidth = bitmap.getWidth();
        int imageHeight = bitmap.getHeight();

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();

        int newWidth = metrics.widthPixels;
        float scaleFactor = (float)newWidth/(float)imageWidth;
        int newHeight = (int)(imageHeight * scaleFactor);

        bitmap = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true);
        ib.setImageBitmap(bitmap);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lyrics = new Intent(getBaseContext(), TranscribingActivity.class);
                startActivity(lyrics);
            }
        });
    }

}
