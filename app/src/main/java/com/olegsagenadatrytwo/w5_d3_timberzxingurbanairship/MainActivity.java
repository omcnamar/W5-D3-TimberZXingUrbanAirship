package com.olegsagenadatrytwo.w5_d3_timberzxingurbanairship;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;
import com.squareup.leakcanary.RefWatcher;
import com.urbanairship.UAirship;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private ZXingScannerView scanner;
    private MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.plant(new Timber.DebugTree());
        UAirship.shared().getPushManager().setUserNotificationsEnabled(true);
        mainActivity = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.d("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.d("onResume");
    }

    public void scanBarCode(View view) {
        scanner = new ZXingScannerView(this);
        scanner.setResultHandler(new ZXingScannerResultHandler());
        setContentView(scanner);
        scanner.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(scanner != null) {
            scanner.stopCamera();
        }
    }

    public void goToSecond(View view) {
        new MyAsyncTask().execute(this);
    }

    class ZXingScannerResultHandler implements ZXingScannerView.ResultHandler{

        @Override
        public void handleResult(Result result) {
            Toast.makeText(mainActivity, result.getText(), Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
            scanner.stopCamera();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = MyApplication.getRefWatcher(this);
        refWatcher.watch(this);
    }

    public class MyAsyncTask extends AsyncTask<Object, String, String> {
        private Context context;

        @Override
        protected String doInBackground(Object... params) {
            context = (Context)params[0];

            // Invoke the leak!
            SingletonSavesContext.getInstance().setContext(context);

            // Simulate long running task
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }

            return "result";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Intent newActivity = new Intent(context, SecondActivity.class);
            startActivity(newActivity);
        }
    }
}

