package android.practice.com.hskhanzi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

/**
 * Class that performs read and write query operations on the database
 */
public class DatabaseController {

    private CreateDatabase database;

    DatabaseController(Context context){
        database = new CreateDatabase(context);
    }

    public final int STATS_MAX_ROWS = 5;
    public final int STATS_MAX_COLUMNS = 6;
    /**
     * Count the total number of characters that have a specific HSK(1 to 6) and LEVEL(0 to 4)
     * return a two dimension matrix of int where each cell contains the total number of
     * characters for each given HSK and LEVEL.
     */
    public int[][] getStats(){
        int[][] stats = new int[STATS_MAX_ROWS][STATS_MAX_COLUMNS];
        SQLiteDatabase mSqLiteDatabase;
        mSqLiteDatabase = database.getReadableDatabase();

        String[] columns = {CreateDatabase.HSK, CreateDatabase.LEVEL};

        Cursor cursor = mSqLiteDatabase.query(database.TABLE, columns,
                null, null, null, null, null);

        if (cursor.getCount() > 0){
            final String[] M_HSK = {"1", "2", "3", "4", "5", "6"};
            final String[] M_LEVEL = {"0", "1", "2", "3", "4"};

            while (cursor.moveToNext()){
                if (cursor.getString(cursor.getColumnIndex(CreateDatabase.HSK)).equals(M_HSK[0])){
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[0])){
                        stats[0][0]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[1])){
                        stats[1][0]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[2])){
                        stats[2][0]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[3])){
                        stats[3][0]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[4])){
                        stats[4][0]++;
                    }
                }
                if (cursor.getString(cursor.getColumnIndex(CreateDatabase.HSK)).equals(M_HSK[1])){
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[0])){
                        stats[0][1]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[1])){
                        stats[1][1]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[2])){
                        stats[2][1]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[3])){
                        stats[3][1]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[4])){
                        stats[4][1]++;
                    }
                }
                if (cursor.getString(cursor.getColumnIndex(CreateDatabase.HSK)).equals(M_HSK[2])){
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[0])){
                        stats[0][2]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[1])){
                        stats[1][2]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[2])){
                        stats[2][2]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[3])){
                        stats[3][2]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[4])){
                        stats[4][2]++;
                    }
                }
                if (cursor.getString(cursor.getColumnIndex(CreateDatabase.HSK)).equals(M_HSK[3])){
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[0])){
                        stats[0][3]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[1])){
                        stats[1][3]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[2])){
                        stats[2][3]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[3])){
                        stats[3][3]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[4])){
                        stats[4][3]++;
                    }
                }
                if (cursor.getString(cursor.getColumnIndex(CreateDatabase.HSK)).equals(M_HSK[4])){
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[0])){
                        stats[0][4]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[1])){
                        stats[1][4]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[2])){
                        stats[2][4]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[3])){
                        stats[3][4]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[4])){
                        stats[4][4]++;
                    }
                }
                if (cursor.getString(cursor.getColumnIndex(CreateDatabase.HSK)).equals(M_HSK[5])){
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[0])){
                        stats[0][5]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[1])){
                        stats[1][5]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[2])){
                        stats[2][5]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[3])){
                        stats[3][5]++;
                    }
                    if (cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)).equals(M_LEVEL[4])){
                        stats[4][5]++;
                    }
                }
            }
        }

        mSqLiteDatabase.close();
        cursor.close();

        return stats;
    }

    public ArrayList<Hanzi> getHanziListByHsk(int argHsk){
        SQLiteDatabase mSqLiteDatabase;
        mSqLiteDatabase = database.getReadableDatabase();
        ArrayList<Hanzi> hanziArrayList = new ArrayList<>();


        String[] columns = {CreateDatabase.ID, CreateDatabase.HSK, CreateDatabase.HANZI, CreateDatabase.PINYIN,
                CreateDatabase.ENGLISH, CreateDatabase.LEVEL};

        String selection = CreateDatabase.HSK+" = ? ";
        String[] selectionArgs = {String.valueOf(argHsk)};
        Cursor cursor = mSqLiteDatabase.query(database.TABLE, columns,
                selection, selectionArgs, null, null, null);

        if (cursor.getCount() <= 0){
            String noData = "No data";
            hanziArrayList.add(new Hanzi(noData, noData, noData, noData, noData, noData));
        }else {
            while (cursor.moveToNext()){
                hanziArrayList.add(new Hanzi(cursor.getString(cursor.getColumnIndex(CreateDatabase.ID)),
                        cursor.getString(cursor.getColumnIndex(CreateDatabase.HSK)),
                        cursor.getString(cursor.getColumnIndex(CreateDatabase.HANZI)),
                        cursor.getString(cursor.getColumnIndex(CreateDatabase.PINYIN)),
                        cursor.getString(cursor.getColumnIndex(CreateDatabase.ENGLISH)),
                        cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL))));
            }
        }

        mSqLiteDatabase.close();
        cursor.close();
        return hanziArrayList;
    }

    void levelPlusOne(int id){
        int level = 0;
        SQLiteDatabase mSqLiteDatabase;
        mSqLiteDatabase = database.getWritableDatabase();

        String[] columns = {CreateDatabase.LEVEL};
        String selection = CreateDatabase.ID+" = ? ";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = mSqLiteDatabase.query(database.TABLE, columns,
                selection, selectionArgs, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToNext();

            level = Integer.parseInt(cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)));
            level++;
        }

        ContentValues data = new ContentValues();
        data.put(CreateDatabase.LEVEL, Integer.toString(level));
        mSqLiteDatabase.update(database.TABLE, data, CreateDatabase.ID+"="+Integer.toString(id), null);

        mSqLiteDatabase.close();
        cursor.close();
    }

    void levelMinusOne(int id){
        int level = 0;
        SQLiteDatabase mSqLiteDatabase;
        mSqLiteDatabase = database.getWritableDatabase();

        String[] columns = {CreateDatabase.LEVEL};
        String selection = CreateDatabase.ID+" = ? ";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = mSqLiteDatabase.query(database.TABLE, columns,
                selection, selectionArgs, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToNext();

            level = Integer.parseInt(cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)));
            level--;
        }

        ContentValues data = new ContentValues();
        data.put(CreateDatabase.LEVEL, Integer.toString(level));
        mSqLiteDatabase.update(database.TABLE, data, CreateDatabase.ID+"="+Integer.toString(id), null);

        mSqLiteDatabase.close();
        cursor.close();
    }

    int getLevelById(int id){
        SQLiteDatabase mSqLiteDatabase;
        mSqLiteDatabase = database.getReadableDatabase();

        String[] columns = {CreateDatabase.LEVEL};
        String selection = CreateDatabase.ID+" = ? ";
        String[] selectionArgs = {String.valueOf(id)};
        Cursor cursor = mSqLiteDatabase.query(database.TABLE, columns,
                selection, selectionArgs, null, null, null);
        if (cursor.getCount() <= 0){
            mSqLiteDatabase.close();
            cursor.close();
            return 0;
        }else {
            cursor.moveToNext();
            int level = Integer.parseInt(cursor.getString(cursor.getColumnIndex(CreateDatabase.LEVEL)));
            mSqLiteDatabase.close();
            cursor.close();
            return level;
        }
    }
}
