package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class course {
    public void createCourseDB(Context context){
        DBHelperCourse helper = new DBHelperCourse(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into courseDB (year, semester, course_name, credit, class) values (1,1,'인성세미나', 1, 1)");
        db.execSQL("insert into courseDB (year, semester, course_name, credit, class) values (1,1,'의사소통', 1, 1)");
        db.execSQL("insert into courseDB (year, semester, course_name, credit, class) values (1,1,'인성과 리더십', 1, 2)");
        db.close();
    }
}
