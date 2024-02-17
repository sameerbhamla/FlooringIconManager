package edu.qc.seclass.fim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ProductDB extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "ProductDB.db";
    private static final int DATABASE_VERSION = 1;

    private static final String PRODUCT_TABLE_NAME = "Product";
    private static final String COLUMN_STORE_ID = "store_id";
    private static final String COLUMN_PRODUCT_ID = "product_id";
    private static final String COLUMN_PRODUCT_NAME = "product_name";
    private static final String COLUMN_PRODUCT_COLOR = "product_color";
    private static final String COLUMN_PRODUCT_SIZE = "product_size";
    private static final String COLUMN_PRODUCT_BRAND = "product_brand";
    private static final String COLUMN_PRODUCT_TYPE = "product_type";
    private static final String COLUMN_PRODUCT_PRICE = "product_price";
    private static final String COLUMN_PRODUCT_CATEGORY = "product_category";
    private static final String COLUMN_PRODUCT_MATERIAL = "product_material";
    private static final String COLUMN_PRODUCT_SPECIES = "product_species";
    private static final String COLUMN_PRODUCT_WATER_RESISTANT = "product_water_resistant";



    public ProductDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String productQuery = "CREATE TABLE " + PRODUCT_TABLE_NAME + " ( " + COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PRODUCT_NAME + " TEXT, " + COLUMN_PRODUCT_COLOR + " TEXT, " + COLUMN_PRODUCT_SIZE + " TEXT, " + COLUMN_PRODUCT_BRAND + " TEXT, " + COLUMN_PRODUCT_TYPE + " TEXT, " + COLUMN_PRODUCT_PRICE + " TEXT, " + COLUMN_PRODUCT_CATEGORY + " TEXT, " + COLUMN_PRODUCT_MATERIAL + " TEXT, " + COLUMN_PRODUCT_SPECIES + " TEXT, " + COLUMN_PRODUCT_WATER_RESISTANT + " TEXT, " + COLUMN_STORE_ID + " TEXT);";
        db.execSQL(productQuery);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_TABLE_NAME);
        onCreate(db);
    }

    void addProduct(String name, String color, String size, String brand, String type, String price, String category, String material, String species, String waterResistant, String storeId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PRODUCT_NAME, name);
        cv.put(COLUMN_PRODUCT_COLOR, color);
        cv.put(COLUMN_PRODUCT_SIZE, size);
        cv.put(COLUMN_PRODUCT_BRAND, brand);
        cv.put(COLUMN_PRODUCT_TYPE, type);
        cv.put(COLUMN_PRODUCT_PRICE, price);
        cv.put(COLUMN_PRODUCT_CATEGORY, category);
        cv.put(COLUMN_PRODUCT_MATERIAL, material);
        cv.put(COLUMN_PRODUCT_SPECIES, species);
        cv.put(COLUMN_PRODUCT_WATER_RESISTANT, waterResistant);
        cv.put(COLUMN_STORE_ID, storeId);

        long result = db.insert(PRODUCT_TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllProducts(String storeId, String searchQuery) {
        String query = "SELECT * FROM " + PRODUCT_TABLE_NAME + " WHERE " + COLUMN_STORE_ID + " = ? AND " + COLUMN_PRODUCT_NAME + " LIKE ?";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, new String[]{String.valueOf(storeId), "%" + searchQuery + "%"});
        }
        return cursor;
    }

    void deleteProduct(String productId) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(PRODUCT_TABLE_NAME, COLUMN_PRODUCT_ID + "=?", new String[]{String.valueOf(productId)});
        if (result == 0) {
            Toast.makeText(context, "Failed to delete product", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Product deleted successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateProduct(String name, String color, String size, String brand, String type, String price, String category, String material, String species, String waterResistant, String productId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PRODUCT_NAME, name);
        cv.put(COLUMN_PRODUCT_COLOR, color);
        cv.put(COLUMN_PRODUCT_SIZE, size);
        cv.put(COLUMN_PRODUCT_BRAND, brand);
        cv.put(COLUMN_PRODUCT_TYPE, type);
        cv.put(COLUMN_PRODUCT_PRICE, price);
        cv.put(COLUMN_PRODUCT_CATEGORY, category);
        cv.put(COLUMN_PRODUCT_MATERIAL, material);
        cv.put(COLUMN_PRODUCT_SPECIES, species);
        cv.put(COLUMN_PRODUCT_WATER_RESISTANT, waterResistant);

        int result = db.update(PRODUCT_TABLE_NAME, cv, COLUMN_PRODUCT_ID + "=?", new String[]{String.valueOf(productId)});
        if (result == 0) {
            Toast.makeText(context, "Failed to update product", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Product updated successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public Product getProductById(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(PRODUCT_TABLE_NAME, new String[] { COLUMN_PRODUCT_ID, COLUMN_PRODUCT_NAME,
                COLUMN_PRODUCT_COLOR, COLUMN_PRODUCT_SIZE, COLUMN_PRODUCT_BRAND, COLUMN_PRODUCT_TYPE,
                COLUMN_PRODUCT_PRICE, COLUMN_PRODUCT_CATEGORY, COLUMN_PRODUCT_MATERIAL, COLUMN_PRODUCT_SPECIES,
                COLUMN_PRODUCT_WATER_RESISTANT }, COLUMN_PRODUCT_ID + "=?", new String[] { id }, null, null, null, null);


        if (cursor != null) {
            cursor.moveToFirst();
        }

        Product product = null;

        if (cursor.getCount() > 0) {
            product = new Product(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10));
        }

        cursor.close();
        db.close();

        return product;
    }







}

