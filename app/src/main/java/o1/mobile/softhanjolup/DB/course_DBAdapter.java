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
        final TextView name = view.findViewById(R.id.name);
        final TextView age = (TextView)view.findViewById(R.id.age);

        name.setText("이름 : "+cursor.getString(cursor.getColumnIndex("name")));
        age.setText("나이 : "+cursor.getString(cursor.getColumnIndex("age")));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.course_listlayout_x, parent, false);
        return v;
    }
}
