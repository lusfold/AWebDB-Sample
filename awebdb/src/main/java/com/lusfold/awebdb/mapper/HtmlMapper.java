package com.lusfold.awebdb.mapper;

import java.util.ArrayList;

/**
 * @author <a href="http://www.lusfold.com" target="_blank">Lusfold</a>
 */
public class HtmlMapper implements Mapper {
    private ArrayList<String> mHead;
    private ArrayList<String[]> mData;
    private StringBuilder mStringBuilder;

    public String map() {

        if ((mHead == null || mHead.size() == 0) && (mData == null || mData.size() == 0))
            return "";

        mStringBuilder = new StringBuilder();

        mStringBuilder.append(HTMLString.HTMLPrefix);

        if (mHead != null) {
            mStringBuilder.append(HTMLString.HeaderPrefix);
            int headSize = mHead.size();
            for (int i = 0; i < headSize; i++) {
                mStringBuilder.append(HTMLString.HeaderPrefix);
                mStringBuilder.append(mHead.get(i));
                mStringBuilder.append(HTMLString.HeaderSuffix);
            }
            mStringBuilder.append(HTMLString.HeaderSuffix);
        }

        if (mHead != null) {
            mStringBuilder.append(HTMLString.TablePrefix);
            int dataSize = mData.size();
            int columnSize = mData.get(0).length;
            for (int i = 0; i < dataSize; i++) {
                mStringBuilder.append(HTMLString.RowPrefix);
                for (int j = 0;j<columnSize;j++){
                    mStringBuilder.append(HTMLString.CellPrefix);
                    mStringBuilder.append(mData.get(i)[j]);
                    mStringBuilder.append(HTMLString.CellSuffix);
                }
                mStringBuilder.append(HTMLString.RowSuffix);
            }
            mStringBuilder.append(HTMLString.TableSuffix);
        }

        mStringBuilder.append(HTMLString.HTMLSuffix);

        return mStringBuilder.toString();
    }

    public HtmlMapper addHeadInFo(String head) {
        if (mHead == null)
            mHead = new ArrayList<>();
        mHead.add(head);
        return this;
    }

    public HtmlMapper addData(String[] data) {
        if (mData == null)
            mData = new ArrayList<>();
        mData.add(data);
        return this;
    }

    public static class HTMLString {
        public static final String HTMLPrefix = "<html><body>";
        public static final String HTMLSuffix = "</body></html>";
        public static final String HeaderPrefix = "<h3>";
        public static final String HeaderSuffix = "</h3>";
        public static final String TablePrefix = "<table border='1'>";
        public static final String TableSuffix = "</table>";
        public static final String RowPrefix= "<tr>";
        public static final String RowSuffix = "</tr>";
        public static final String CellPrefix= "<td>";
        public static final String CellSuffix = "</td>";

    }
}
