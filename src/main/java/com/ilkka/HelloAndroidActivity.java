package com.ilkka;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.net.http.*;
import org.apache.http.client.methods.*;
import org.apache.http.message.*;
import org.apache.http.*;

public class HelloAndroidActivity extends Activity {

	private static String TAG = "testbench";

	private AndroidHttpClient mClient;
	private HttpResponse mResponse;

	/**
	 * Called when the activity is first created.
	 * @param savedInstanceState If the activity is being re-initialized after 
	 * previously being shut down then this Bundle contains the data it most 
	 * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
		setContentView(R.layout.main);
		try {
			if (mClient != null) {
				mResponse = mClient.execute(new HttpGet("http://www.example.com/"));
			}
		} catch(java.io.IOException ioe) {
			// nop
		}
	}

	/**
	 * Set HTTP client instance.
	 * @param client the client.
	 */
	public void setHttpClient(AndroidHttpClient client) {
		mClient = client;
	}

	public HttpResponse response() {
		return mResponse;
	}
}

