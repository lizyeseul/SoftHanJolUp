package o1.mobile.softhanjolup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class courseDB {
    public void createCourseDB(Context context){
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into courseDB (year, semester, course_name, credit, class) values (1,1,'인성세미나', 1, 1)");
        db.close();
    }
}
