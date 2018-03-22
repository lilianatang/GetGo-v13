/**
 * Created by Michael on 2018-03-21.
 */

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import android.content.Context;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "getgo.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}