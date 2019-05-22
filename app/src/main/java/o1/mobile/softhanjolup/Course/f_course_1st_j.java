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
import o1.mobile.softhanjolup.DB.course_DBHelper;
import o1.mobile.softhanjolup.R;

public class f_course_1st_j extends Fragment {

    ListView list;
    course_DBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;

    final static String dbName = "SHJU_DB.db";
    final static int dbVersion = 2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.f_course_1st_x, container, false);

        list = (ListView)rootView.findViewById(R.id.first_list);
        dbHelper = new course_DBHelper(getActivity(), dbName, null, dbVersion);

        selectDB();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                cursor.moveToPosition(position);
                String str = cursor.getString(cursor.getColumnIndex("name"));
                Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
            }
        });



        return rootView;
    }

    private void selectDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM DB_Course;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            getActivity().startManagingCursor(cursor);
            course_DBAdapter dbAdapter = new course_DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
    }


}
