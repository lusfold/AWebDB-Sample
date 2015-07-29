package com.lusfold.awebdb;

import android.content.Context;

import com.lusfold.awebdb.db.DBUtil;
import com.lusfold.awebdb.net.nanohttpd.XNanoHTTPD;
import com.lusfold.awebdb.utils.LogUtil;
import com.lusfold.awebdb.utils.NetUtils;

import java.io.IOException;
/**
 * @author <a href="http://www.lusfold.com" target="_blank">Lusfold</a>
 */
public class AWebDB {
    private static XNanoHTTPD mHttpd;

    /**
     * @param context
     * @param dbName
     * @param port
     */
    public static void hook(Context context, String dbName, int port) {

        DBUtil.init(context, dbName);
        port = NetUtils.getAGoodPort(port);
        mHttpd = new XNanoHTTPD(port);
        try {
            mHttpd.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    public static String getLocalIPAddress() {
        return NetUtils.getLocalIpAddress();
    }

    /**
     * @return
     */
    public static int getLocalServerPort() {
        return mHttpd == null ? -1 : mHttpd.getListeningPort();
    }

    /**
     * @param status
     */
    public static void enableLog(boolean status) {
        LogUtil.DEBUG = status;
    }
}
