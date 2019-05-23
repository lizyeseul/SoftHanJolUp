package o1.mobile.softhanjolup.Course;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import o1.mobile.softhanjolup.DB.course_DBAdapter;
import o1.mobile.softhanjolup.DB.course_DBAdapter_2;
import o1.mobile.softhanjolup.DB.course_DBHelper;
import o1.mobile.softhanjolup.R;

public class f_course_4th_j extends Fragment {

    ListView list, list2;
    course_DBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;

    final static String dbName = "SHJU_DB.db";
    final static int dbVersion = 3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.f_course_4th_x, container, false);
        dbHelper = new course_DBHelper(getActivity(), dbName, null, dbVersion);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbHelper.reset(db);

        list = (ListView)rootView.findViewById(R.id.fourth_list);
        list2 = (ListView)rootView.findViewById(R.id.fourth_2_list);
        selectDB();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Cursor se1 = se1Index(position);
                String str = se1.getString(se1.getColumnIndex("courseName"));
                Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Cursor se1 = se2Index(position);
                String str = se1.getString(se1.getColumnIndex("courseName"));
                Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
    private Cursor se1Index(int positon) {
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM DB_Course where year is 4 and semester is 1;";
        Cursor tempC = db.rawQuery(sql, null);
        tempC.moveToPosition(positon);

        return tempC;
    }
    private Cursor se2Index(int positon) {
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM DB_Course where year is 4 and semester is 2;";
        Cursor tempC = db.rawQuery(sql, null);
        tempC.moveToPosition(positon);

        return tempC;
    }
    private void selectDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM DB_Course where year is 4 and semester is 1;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            getActivity().startManagingCursor(cursor);
            course_DBAdapter dbAdapter = new course_DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
        sql = "SELECT * FROM DB_Course where year is 4 and semester is 2;";

        cursor = db.rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            getActivity().startManagingCursor(cursor);
            course_DBAdapter_2 dbAdapter = new course_DBAdapter_2(getActivity(), cursor);
            list2.setAdapter(dbAdapter);
        }
    }

}
