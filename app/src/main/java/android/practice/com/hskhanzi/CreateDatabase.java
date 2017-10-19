package android.practice.com.hskhanzi;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class that creates and populates the database
 * Database content:
 * HSK          - Level of HSK test (1 to 6)
 * Hanzi        - Chinese character
 * Pinyin       - Pinyin of the chinese character
 * English      - Translation or explanation of Hanzi`s meaning
 * Level        - 0(not rated), 1(hard), 2(medium), 3(easy), 4(special)
 */

public class CreateDatabase extends SQLiteOpenHelper{
    private static final String LOG_TAG = "CreateDatabase";
    private Context mContext;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HSKHanzi";
    private final String TABLE = "characters";
    public static final String ID = "_id";
    public static final String HSK = "hsk";
    public static final String HANZI = "hanzi";
    public static final String PINYIN = "pinyin";
    public static final String ENGLISH = "english";
    public static final String LEVEL = "level";

    CreateDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE + " ("
                + ID + " integer primary key autoincrement, "
                + HSK + " text, "
                + HANZI + " text, "
                + PINYIN + " text, "
                + ENGLISH + " text, "
                + LEVEL + " text, "
                + ")";

        sqLiteDatabase.execSQL(sql);

        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(mContext.getAssets().open("Data.csv"), "UTF-8"));

            String myLine;
            String[] values;
            ContentValues contentValues = new ContentValues();

            while ((myLine = reader.readLine()) != null ){
                values = myLine.split("、");

                contentValues.put(HSK, values[0]);
                contentValues.put(HANZI, values[1]);
                contentValues.put(PINYIN, values[2]);
                contentValues.put(ENGLISH, values[3]);
                contentValues.put(LEVEL, values[4]);

                sqLiteDatabase.insert(TABLE, null, contentValues);
            }
        }catch (IOException e){
            Log.e(LOG_TAG, "Error Opening File: "+e.getMessage());
        }finally {
            if (reader != null){
                try {
                    reader.close();
                }catch (IOException e){
                    Log.e(LOG_TAG, "Error Closing File Reader: "+e.getMessage());
                }
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE);
        onCreate(db);
    }
}
