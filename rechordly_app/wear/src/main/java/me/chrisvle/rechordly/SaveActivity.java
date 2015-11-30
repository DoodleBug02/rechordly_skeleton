package me.chrisvle.rechordly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.wearable.view.WatchViewStub;
import android.widget.RelativeLayout;

public class SaveActivity extends Activity {

    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                layout = (RelativeLayout) stub.findViewById(R.id.save_layout);
                layout.setBackgroundResource(R.drawable.saving);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
//                        mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                    }
                    public void onFinish() {
//                        mTextField.setText("done!");
                        layout.setBackgroundResource(R.drawable.save_complete);
                        new CountDownTimer(2000, 1000) {
                            public void onTick(long millisUntilFinished) {
//                        mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                            }
                            public void onFinish() {
//                        mTextField.setText("done!");
                                Intent intent = new Intent(getBaseContext(), WatchMain.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        }.start();
                    }
                }.start();
            }
        });
    }
}
