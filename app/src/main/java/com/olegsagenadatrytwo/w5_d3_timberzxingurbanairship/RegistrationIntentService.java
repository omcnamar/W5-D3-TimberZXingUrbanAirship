package com.olegsagenadatrytwo.w5_d3_timberzxingurbanairship;

import android.app.IntentService;
import android.content.Intent;

import timber.log.Timber;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class RegistrationIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_FOO = "com.olegsagenadatrytwo.w5_d3_timberzxingurbanairship.action.FOO";
    public static final String ACTION_BAZ = "com.olegsagenadatrytwo.w5_d3_timberzxingurbanairship.action.BAZ";

    // TODO: Rename parameters
    public static final String EXTRA_PARAM1 = "com.olegsagenadatrytwo.w5_d3_timberzxingurbanairship.extra.PARAM1";
    public static final String EXTRA_PARAM2 = "com.olegsagenadatrytwo.w5_d3_timberzxingurbanairship.extra.PARAM2";

    public RegistrationIntentService() {
        super("RegistrationIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Timber.d("message received");

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}