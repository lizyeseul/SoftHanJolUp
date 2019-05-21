package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperDeptBook extends SQLiteOpenHelper {
    public static final int DEPT_DATABASE_VERSION =1;
    public DBHelperDeptBook(Context context){
        super(context, "deptBookDB", null, DEPT_DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String memoSQL = "create table deptBookDB (bookNum integer, title string, author string)";
        db.execSQL(memoSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if(newVersion == DEPT_DATABASE_VERSION){
            db.execSQL("drop table deptBookDB");
            onCreate(db);
        }
    }
}
