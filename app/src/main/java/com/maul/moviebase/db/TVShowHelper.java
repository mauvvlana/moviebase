package com.maul.moviebase.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.MediaStore;

import static com.maul.moviebase.db.DatabaseContract.FavoriteTV.TABLE_TV;

public class TVShowHelper {

    private static final String DATABASE_TABLE = TABLE_TV;
    private static DatabaseHelper helper;
    private static TVShowHelper INSTANCE;
    private static SQLiteDatabase database;

    public TVShowHelper(Context context) {
        helper = new DatabaseHelper(context);
    }

    public static TVShowHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TVShowHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        database = helper.getWritableDatabase();
    }


    public Cursor queryByIdProvider(String id) {
        return database.query(DATABASE_TABLE, null
                , MediaStore.Audio.Playlists.Members._ID + " = ?"
                , new String[]{id}
                , null
                , null
                , null
                , null);
    }

    public Cursor queryProvider() {
        return database.query(DATABASE_TABLE
                , null
                , null
                , null
                , null
                , null
                , MediaStore.Audio.Playlists.Members._ID + " DESC");
    }

    long insertProvider(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }

    int updateProvider(String id, ContentValues values) {
        return database.update(DATABASE_TABLE, values, MediaStore.Audio.Playlists.Members._ID + " =?", new String[]{id});
    }

    int deleteProvider(String id) {
        return database.delete(DATABASE_TABLE, MediaStore.Audio.Playlists.Members._ID + " = ?", new String[]{id});
    }
}


