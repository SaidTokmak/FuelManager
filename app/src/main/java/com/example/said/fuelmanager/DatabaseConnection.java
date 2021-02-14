package com.example.said.fuelmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="fuelsystem";
    public static final int DATABASE_VERSION=1;
    public static final String USER_TABLE_NAME="users";
    public static final String FUEL_TABLE_NAME="fuelmanager";

    public static final String USER_ID="user_id";
    public static final String USER_NAME="user_name";
    public static final String MAIL_ADDRESS="mail";
    public static final String VEHICLE_INFO="vecihle_info";
    public static final String VEHICLES_KM="vehicles_km";

    public static final String FUEL_ID="fuel_id";
    public static final String LITER_PRICE="liter_price";
    public static final String LITER_AMOUNT="liter_amount";
    public static final String LAST_KM="last_km";
    public static final String DATE="date";
    public static final String FUEL_USER_ID="user_id";


    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ USER_TABLE_NAME +" ( " + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_NAME + " TEXT NOT NULL,"+ MAIL_ADDRESS + " TEXT NOT NULL, "+ VEHICLE_INFO +" TEXT NOT NULL, " +
                VEHICLES_KM + " INTEGER NOT NULL )");
        sqLiteDatabase.execSQL("CREATE TABLE "+ FUEL_TABLE_NAME +" ( " + FUEL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LITER_PRICE + " INTEGER NOT NULL,"+ LITER_AMOUNT + " INTEGER NOT NULL, "+ LAST_KM +" INTEGER NOT NULL, " +
                DATE + " TEXT, " + FUEL_USER_ID + " INTEGER NOT NULL )");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ USER_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ FUEL_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //User database process

    public void addUserData(String name,String mail,String info,int km){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(USER_NAME,name);
        values.put(MAIL_ADDRESS,mail);
        values.put(VEHICLE_INFO,info);
        values.put(VEHICLES_KM,km);

        db.insert(USER_TABLE_NAME,null,values);
        db.close();
    }
    public List<Users> getAllUsers(){
        List<Users> usersList=new ArrayList<>();
        String selectQuery="select * from " + USER_TABLE_NAME;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do {
                Users user=new Users();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setMail(cursor.getString(2));
                user.setInfo(cursor.getString(3));
                user.setKm(cursor.getInt(4));

                usersList.add(user);
            }while(cursor.moveToNext());
        }
        return usersList;
    }

    //Fuel databases process

    public void addNewFuel(double liter_price,double liter_amount,int last_km,int fuel_user_id){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(LITER_PRICE,liter_price);
        values.put(LITER_AMOUNT,liter_amount);
        values.put(LAST_KM,last_km);
        values.put(FUEL_USER_ID,fuel_user_id);

        db.insert(FUEL_TABLE_NAME,null,values);
        db.close();
    }
    public List<FuelManager> showAllFuels(){

        List<FuelManager> fuelManagers=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from " + FUEL_TABLE_NAME;

        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {
                FuelManager fuel=new FuelManager();
                fuel.setFuel_id(cursor.getInt(0));
                fuel.setLiter_price(cursor.getString(1));
                fuel.setLiter_amount(cursor.getString(2));
                fuel.setLast_km(cursor.getString(3));
                fuel.setFuel_user_id(cursor.getInt(5));

                fuelManagers.add(fuel);
            }while(cursor.moveToNext());
        }
        return fuelManagers;
    }
}
