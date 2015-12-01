package me.chrisvle.rechordly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PauseActivity extends Activity {

    private TextView mTextView;
    private GestureDetector mDetector;
    private ImageButton mImageButton;
    private static final String DEBUG_TAG = "Gestures";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                mImageButton = (ImageButton) stub.findViewById(R.id.pauseButton);
                mImageButton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (mDetector.onTouchEvent(event)) {
                            Log.d("Event: ", "onTouchEvent Fired!");
//                            finish();
                            return true;
                        }
                        return false;
                    }
                });
            }
        });

        // Configure a gesture detector
        mDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public void onLongPress(MotionEvent event) {
//                mDismissOverlay.show();
                Log.d(DEBUG_TAG, " onLongPress: " + event.toString());
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                                    float distanceY) {
                Log.d(DEBUG_TAG, "onScroll: Distance: " + String.valueOf(distanceX) + ", " + String.valueOf(distanceY));
                if (distanceX > 5.0) {
                    Log.d("Event: ", "onScrollEvent Fired!");
                    Intent intent = new Intent(getBaseContext(), WatchMain.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    return true;
                }

                Log.d(DEBUG_TAG, " onScroll: " + e1.toString()+e2.toString());
                return false;
            }
        });

    }

    public void goToPlaybackActivity(View view) {
        Intent intent = new Intent(this, PlaybackActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
    }
}
