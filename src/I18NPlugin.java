package com.zeosworld.cordova;

import java.util.Locale;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.example.R;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;

public class I18NPlugin extends CordovaPlugin {
    private Activity activity;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
	super.initialize(cordova, webView);
	activity = cordova.getActivity();
    }

    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
	if (action.equals("translate")) {
	    String key = args.getString(0).replace(' ', '_').toLowerCase(Locale.US);
	    String message = args.getString(0);
	    try {
		message = activity.getString(R.string.class.getField(key).getInt(null));
	    } catch (IllegalArgumentException e) {
		e.printStackTrace();
	    } catch (IllegalAccessException e) {
		e.printStackTrace();
	    } catch (NoSuchFieldException e) {
		e.printStackTrace();
	    }
	    this.echo(message, callbackContext);
	    return true;
	}
	return false;
    }

    private void echo(String message, CallbackContext callbackContext) {
	if (message != null && message.length() > 0) {
	    callbackContext.success(message);
	} else {
	    callbackContext.error("Expected one non-empty string argument.");
	}
    }

}
