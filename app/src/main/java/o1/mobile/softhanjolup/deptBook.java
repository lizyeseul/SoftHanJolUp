package o1.mobile.softhanjolup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class deptBook {
    public void createDeptDB(Context context){
        DBHelperDeptBook helper = new DBHelperDeptBook(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into deptBookDB (bookNum, title, author) values (1, '불황의 경제학','홀 크루그먼')");
        db.execSQL("insert into deptBookDB (bookNum, title, author) values (1, '불황의 경제학','홀 크루그먼')");
        db.execSQL("insert into deptBookDB (bookNum, title, author) values (1, '불황의 경제학','홀 크루그먼')");
        db.close();
    }
}
