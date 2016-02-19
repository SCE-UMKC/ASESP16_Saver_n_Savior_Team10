package app.com.example.pooja.loginfeatureplusdbconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by pooja on 2/19/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="user.db";
    private static final String TABLE_NAME="Users";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_FIRSTNAME="firstname";
    private static final String COLUMN_LASTNAME="lastname";
    private static final String COLUMN_EMAILID="emailid";
    private static final String COLUMN_PASSWORD="password";
    SQLiteDatabase db;
    private static final String TABLE_CREATE="create table Users(id integer primary key,"+"firstname text,lastname text,email text,password text";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.db = db;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    String query= "DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertUser(User user)
    {
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        String query="select * from User"+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();
        values.put(COLUMN_ID,count);
        values.put(COLUMN_FIRSTNAME,user.getFirstName());
        values.put(COLUMN_LASTNAME,user.getLastName());
        values.put(COLUMN_EMAILID,user.getEmailId());
        values.put(COLUMN_PASSWORD, user.getPassword());


        db.insert(TABLE_NAME, null, values);


    }
    public String searchUser(String uname)
    {
        db=this.getReadableDatabase();
        String query="select email,password from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="Not Found";
        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(2);
                if (a.equals(uname)) {
                    b = cursor.getString(3);
                    break;
                }
            } while(cursor.moveToNext());


        }
        return b;

    }
}
