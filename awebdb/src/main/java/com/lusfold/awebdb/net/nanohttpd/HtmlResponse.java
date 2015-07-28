package com.lusfold.awebdb.net.nanohttpd;

import com.lusfold.awebdb.mapper.Mapper;

import java.io.ByteArrayInputStream;

/**
 * @author <a href="http://www.lusfold.com" target="_blank">Lusfold</a>
 * @data 15/7/28.
 */
public class HtmlResponse extends NanoHTTPD.Response{
    private static final String DefaultMimeType = "text/HTML";
    private static final NanoHTTPD.Response.Status DefaultStatus = NanoHTTPD.Response.Status.OK;

    /**
     * @param mapper
     */
    protected HtmlResponse(Mapper mapper) {
        super(DefaultStatus, DefaultMimeType, new ByteArrayInputStream(mapper.map().getBytes()), mapper.map().getBytes().length);
    }
}
