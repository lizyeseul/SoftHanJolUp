package o1.mobile.softhanjolup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ReadDbActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_db);

        TextView titleView = findViewById(R.id.textView2);
        TextView contentView = findViewById(R.id.textView3);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor corsor = db.rawQuery("select title, content from tb_memo order by _id desc limit 1" , null);

        while (corsor.moveToNext()){
            titleView.setText(corsor.getString(0));
            contentView.setText(corsor.getString(1));
        }
        db.close();
    }
}
