package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import o1.mobile.softhanjolup.R;

public class course_DBAdapter extends CursorAdapter {
    public course_DBAdapter(Context context, Cursor c){
        super(context, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor){
        final TextView year = view.findViewById(R.id.year);
        final TextView semester = view.findViewById(R.id.semester);
        final TextView courseName = view.findViewById(R.id.courseName);
        final TextView credit = view.findViewById(R.id.credit);
        final TextView index_course = view.findViewById(R.id.index_course);

        year.setText("학년 : "+cursor.getString(cursor.getColumnIndex("year")));
        semester.setText("학기 : "+cursor.getString(cursor.getColumnIndex("semester")));
        courseName.setText("과목명 : "+cursor.getString(cursor.getColumnIndex("courseName")));
        credit.setText("학점 : "+cursor.getString(cursor.getColumnIndex("credit")));
        index_course.setText("인덱스 : "+cursor.getString(cursor.getColumnIndex("index_course")));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.course_listlayout_x, parent, false);
        return v;
    }
}
