package com.terrytsai.caloriecalculator;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class SelectExerciseGridAdapter extends BaseAdapter {

    private List<Exercise> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public SelectExerciseGridAdapter(Context aContext,  List<Exercise> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        //Log.d("listDataSize", String.valueOf(listData.size()));
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            //Log.d("convertView", "ConvertView is null");
            convertView = layoutInflater.inflate(R.layout.grid_select_layout, null);
            holder = new ViewHolder();
            holder.exerciseView = (ImageView) convertView.findViewById(R.id.imageView_exercise);
            holder.exerciseNameView = (TextView) convertView.findViewById(R.id.textView_exerciseName);
            convertView.setTag(holder);
        } else {
            //Log.d("convertView", "converTview is not null");
            holder = (ViewHolder) convertView.getTag();
        }

        Exercise exercise = this.listData.get(position);
        holder.exerciseNameView.setText(exercise.getExerciseName());
        int imageId = this.getMipmapResIdByName(exercise.getShortName());

        holder.exerciseView.setImageResource(imageId);

        return convertView;
    }

    // Find Image ID corresponding to the name of the image (in the directory mipmap).
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        //Log.i("CustomGridViewExercise", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView exerciseView;
        TextView exerciseNameView;
    }

}