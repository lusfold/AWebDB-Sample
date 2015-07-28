package com.lusfold.awebdb.net.nanohttpd;

import com.lusfold.awebdb.utils.LogUtil;
import com.lusfold.awebdb.db.DBUtil;
import com.lusfold.awebdb.mapper.HtmlMapper;

import java.net.URLDecoder;

/**
 * @author <a href="http://www.lusfold.com" target="_blank">Lusfold</a>
 * @data 15/7/28.
 */
public class XNanoHTTPD extends NanoHTTPD {

    /**
     * @param port
     */
    public XNanoHTTPD(int port) {
        super(port);
    }

    /**
     * @param hostname
     * @param port
     */
    public XNanoHTTPD(String hostname, int port) {
        super(hostname, port);
    }

    /**
     * @param session The HTTP session
     * @return
     */
    public Response serve(IHTTPSession session) {
        Method method = session.getMethod();
        LogUtil.d(method.toString());
        if (NanoHTTPD.Method.GET.equals(method)) {
            //get method
            String queryParams = session.getQueryParameterString();
            queryParams = URLDecoder.decode(queryParams);
            HtmlMapper htmlMapper = new HtmlMapper();
            DBUtil.inflateMapper(queryParams, htmlMapper);
            LogUtil.d(htmlMapper.map());
            return new HtmlResponse(htmlMapper);
        } else if (NanoHTTPD.Method.POST.equals(method)) {
            //post method
            HtmlMapper htmlMapper = new HtmlMapper();
            htmlMapper.addHeadInFo("Don't support post method");
            LogUtil.d(htmlMapper.map());
            return new HtmlResponse(htmlMapper);
        }
        return super.serve(session);
    }
}
