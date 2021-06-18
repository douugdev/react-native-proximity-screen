package com.reactnativeproximityscreen;

import androidx.annotation.NonNull;
import android.os.PowerManager;
import android.content.Context;
import android.os.Bundle;
// import android.support.v7.app.AppCompatActivity;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = ProximityScreenModule.NAME)
public class ProximityScreenModule extends ReactContextBaseJavaModule {

    private PowerManager mPowerManager;
    private PowerManager.WakeLock mWakeLock;

    public static final String NAME = "ProximityScreen";

    public ProximityScreenModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mPowerManager = (PowerManager) reactContext.getSystemService(Context.POWER_SERVICE);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    // Example method
    // See https://reactnative.dev/docs/native-modules-android
    @ReactMethod
    public void activateSensor(Promise promise) {
        try {
            if (mWakeLock == null) {
                mWakeLock = mPowerManager.newWakeLock(PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK, "incall");
            }
            if (!mWakeLock.isHeld()) {
                mWakeLock.acquire();
            }
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void deactivateSensor(Promise promise) {
        try {
            if (mWakeLock != null && mWakeLock.isHeld()) {
                mWakeLock.release();
            }
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    // public static native void activateSensor();
    // public static native void activateSensor();
}
