package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class course {
    SQLiteDatabase db;

    course(SQLiteDatabase db){
        this.db = db;
    }

    public void createCourseDB(SQLiteDatabase db){
        db.execSQL("INSERT INTO DB_Course VALUES(0,1, 1,'인성세미나',1,1);");
        db.execSQL("INSERT INTO DB_Course VALUES(1,1, 1,'프잉1',1,1);");
    }
}
