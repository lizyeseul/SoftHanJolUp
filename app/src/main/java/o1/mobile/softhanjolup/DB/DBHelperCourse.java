package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperCourse extends SQLiteOpenHelper {
    public static final int COURSE_DATABASE_VERSION =1;
    public DBHelperCourse(Context context){
        super(context, "courseDB", null, COURSE_DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String memoSQL = "create table courseDB (year integer, semester integer, course_name string, credit integer, class integer)";
        db.execSQL(memoSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if(newVersion == COURSE_DATABASE_VERSION){
            db.execSQL("drop table courseDB");
            onCreate(db);
        }
    }
}
