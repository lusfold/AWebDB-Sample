package com.lusfold.awebdb.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lusfold.awebdb.mapper.HtmlMapper;
import com.lusfold.awebdb.utils.StringUtils;

/**
 * @author <a href="http://www.lusfold.com" target="_blank">Lusfold</a>
 */
public class DBUtil {
    private static SQLiteDatabase db;
    private static String dbName;
    private static Context mContext;

    public static void init(Context context, String name) {
        if (db != null || context == null || StringUtils.isBlank(name))
            return;
        dbName = name;
        mContext = context;
        db = mContext.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
    }

    public static void inflateMapper(String query, HtmlMapper htmlMapper) {

        if (StringUtils.isBlank(query) || htmlMapper == null)
            return;
        htmlMapper.addHeadInFo("QueryString: " + query);
        htmlMapper.addHeadInFo("DbVersion: " + db.getVersion());
        Cursor cursor = null;
        boolean status =true;
        try {
            cursor = db.rawQuery(query, null);

            int columnCount = cursor.getColumnCount();
            htmlMapper.addData(cursor.getColumnNames());
            while (cursor.moveToNext()) {
                String[] data = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    data[i] = cursor.getString(i);
                }
                htmlMapper.addData(data);
            }
        } catch (Exception e) {
            status=false;
            htmlMapper.addHeadInFo("Info: " + e.toString());
        } finally {
            if (cursor != null) {
                cursor.close();
                htmlMapper.addHeadInFo("Status: " + status);
            }
        }
    }

}
