package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class course_DBHelper extends SQLiteOpenHelper {
    String sql;

    public course_DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        sql = "CREATE TABLE DB_Course (_id INTEGER PRIMARY KEY AUTOINCREMENT,year INTEGER,semester INTEGER, courseName TEXT, credit INTEGER, index_course INTEGER);" ;


        //sql = "CREATE TABLE test (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
        //        " name TEXT, age TEXT);";
        db.execSQL(sql);

        course tempCourse = new course(db);
        tempCourse.createCourseDB(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //버전이 업그레이드 됐을 경우 작업할 내용을 작성합니다.
    }
}
