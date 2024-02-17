package edu.qc.seclass.fim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "StoreProduct.db";
    private static final int DATABASE_VERSION = 1;

    private static final String STORE_TABLE_NAME = "Store";
    private static final String COLUMN_STORE_ID = "_id";
    private static final String COLUMN_STORE_NAME = "store_name";
    private static final String COLUMN_STORE_LOCATION = "store_location";

    private static final String PRODUCT_TABLE_NAME = "Product";
    private static final String COLUMN_PRODUCT_ID = "_id";
    private static final String COLUMN_PRODUCT_NAME = "product_name";
    private static final String COLUMN_PRODUCT_COLOR = "product_color";
    private static final String COLUMN_PRODUCT_SIZE = "product_size";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String storeQuery = "CREATE TABLE " + STORE_TABLE_NAME + " (" + COLUMN_STORE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_STORE_NAME + " TEXT, " + COLUMN_STORE_LOCATION + " TEXT);";
        db.execSQL(storeQuery);

        String productQuery = "CREATE TABLE " + PRODUCT_TABLE_NAME + " (" + COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PRODUCT_NAME + " TEXT, " + COLUMN_PRODUCT_COLOR + " TEXT, " + COLUMN_PRODUCT_SIZE + " TEXT);";
        db.execSQL(productQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + STORE_TABLE_NAME);
        onCreate(db);
    }

    void addStore(String name, String location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STORE_NAME, name);
        cv.put(COLUMN_STORE_LOCATION, location);
        long result = db.insert(STORE_TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllStores() {
        String query = "SELECT * FROM " + STORE_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void addProduct(String name, String color, String size) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PRODUCT_NAME, name);
        cv.put(COLUMN_PRODUCT_COLOR, color);
        cv.put(COLUMN_PRODUCT_SIZE, size);
        long result = db.insert(PRODUCT_TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

}

