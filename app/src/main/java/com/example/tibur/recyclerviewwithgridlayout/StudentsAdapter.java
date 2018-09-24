package com.example.tibur.recyclerviewwithgridlayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {
    ArrayList<Student> students;

    public StudentsAdapter(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_layout, null);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewName.setText(students.get(position).getName());
        holder.textViewSurname.setText(students.get(position).getSurname());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewSurname;


        public ViewHolder(View v) {
            super(v);
            this.textViewName = v.findViewById(R.id.textViewName);
            this.textViewSurname = v.findViewById(R.id.textViewSurname);
        }
    }
}
