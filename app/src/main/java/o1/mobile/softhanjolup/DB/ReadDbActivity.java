package o1.mobile.softhanjolup.DB;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import o1.mobile.softhanjolup.DB.DBHelperDeptBook;
import o1.mobile.softhanjolup.R;

public class ReadDbActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_db);

        TextView titleView = findViewById(R.id.textView2);
        TextView contentView = findViewById(R.id.textView3);

        /*DBHelperCourse helper = new DBHelperCourse(this);
        SQLiteDatabase db = helper.getWritableDatabase();*/

        DBHelperDeptBook helper = new DBHelperDeptBook(this);
        SQLiteDatabase db = helper.getWritableDatabase();


        //Cursor cursor = db.rawQuery("select year, course_name  from courseDB" , null);
        Cursor cursor = db.rawQuery("select bookNum, title  from deptBookDB" , null);

        while (cursor.moveToNext()){
            titleView.setText(cursor.getString(0));
            contentView.setText(cursor.getString(1));
        }
        db.close();
    }
}
