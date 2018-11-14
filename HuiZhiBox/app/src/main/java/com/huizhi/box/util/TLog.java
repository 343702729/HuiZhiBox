package com.huizhi.box.util;

import android.util.Log;

public class TLog {
	public static final String LOG_TAG = "HuiZhiBox";
	public static boolean DEBUG = true;
	private static String merid = "";

	public TLog() {
	}

	public static final void analytics(String log) {
		if (DEBUG)
			Log.d(LOG_TAG, log);
	}

	public static final void error(String log) {
		if (DEBUG)
			Log.e(LOG_TAG, "" + log);
	}

	public static final void log(String log) {
		if (DEBUG)
			Log.i(LOG_TAG, log);
//        addLocalLog(log);
	}

	public static final void log(String tag, String log) {
		if (DEBUG)
			Log.i(tag, log);
	}

	public static final void logv(String log) {
		if (DEBUG)
			Log.v(LOG_TAG, log);
	}

	public static final void warn(String log) {
		if (DEBUG)
			Log.w(LOG_TAG, log);
	}

//	private static void addLocalLog(String log){
//		String merid = SharePreferenceUtils.getmerNum(UiUtils.getContext());
//		log = Utility.getCurrentDate("yyyy-MM-dd HH:mm:ss") + ":" + log;
//		String filename = Utility.formatDateTime(new Date(), "yyyy-MM-dd") + "-" + merid + ".txt";
//		FileUtil.saveDateToFile(log, filename);
//
//    }
}
