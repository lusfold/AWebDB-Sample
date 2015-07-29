package com.lusfold.awebdb.utils;

import org.apache.http.conn.util.InetAddressUtils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author <a href="http://www.lusfold.com" target="_blank">Lusfold</a>

 */
public class NetUtils {
    public static final int DefaultPort = 8080;

    /**
     * @param port
     * @return a legally port.
     */
    public static int getAGoodPort(int port) {
        return port < 1023 || port > 65535 ? DefaultPort : port;
    }

    /**
     * @return local ip address
     */
    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> infos = NetworkInterface
                    .getNetworkInterfaces();
            while (infos.hasMoreElements()) {
                NetworkInterface niFace = infos.nextElement();
                Enumeration<InetAddress> enumIpAddr = niFace.getInetAddresses();
                while (enumIpAddr.hasMoreElements()) {
                    InetAddress mInetAddress = enumIpAddr.nextElement();
                    if (!mInetAddress.isLoopbackAddress()
                            && InetAddressUtils.isIPv4Address(mInetAddress
                            .getHostAddress())) {
                        return mInetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {

        }
        return null;
    }
}
