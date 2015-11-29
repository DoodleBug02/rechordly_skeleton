package me.chrisvle.rechordly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.DismissOverlayView;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class WatchMain extends Activity {

    private TextView mTextView;
    private DismissOverlayView mDismissOverlay;
    private GestureDetector mDetector;
    private static final String DEBUG_TAG = "Gestures";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                // Obtain the DismissOverlayView element
                mDismissOverlay = (DismissOverlayView) findViewById(R.id.dismiss_overlay);
                mDismissOverlay.setIntroText(R.string.long_press_intro);
                mDismissOverlay.showIntroIfNecessary();
            }
        });

        // Configure a gesture detector
        mDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public void onLongPress(MotionEvent event) {
                mDismissOverlay.show();
                Log.d(DEBUG_TAG, " onLongPress: " + event.toString());
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                                    float distanceY) {
                Log.d(DEBUG_TAG, "onScroll: Distance: " + String.valueOf(distanceX) + ", " + String.valueOf(distanceY));
                if (distanceX > 5.0) {
                    Intent intent = new Intent(getBaseContext(), cropChooserActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                Log.d(DEBUG_TAG, " onScroll: " + e1.toString()+e2.toString());
                return true;
            }
        });
    }

    // Capture long presses
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return mDetector.onTouchEvent(ev) || super.onTouchEvent(ev);
    }
}
