package com.mehuljoisar.lockscreen.utils;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.mehuljoisar.lockscreen.LockScreenActivity;

public class LockscreenIntentReceiver extends BroadcastReceiver {

	// Handle actions and display Lockscreen
	@Override
	public void onReceive(Context context, Intent intent) {

		if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)
				|| intent.getAction().equals(Intent.ACTION_SCREEN_ON)
				|| intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
			start_lockscreen(context);
		}

	}

	// Display lock screen
	private void start_lockscreen(Context context) {
		KeyguardManager myKM = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
		if(!myKM.isDeviceLocked()) { //inKeyguardRestrictedInputMode()) {
			//it is not already locked
			Intent mIntent = new Intent(context, LockScreenActivity.class);
			mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(mIntent);
		}
	}

}
