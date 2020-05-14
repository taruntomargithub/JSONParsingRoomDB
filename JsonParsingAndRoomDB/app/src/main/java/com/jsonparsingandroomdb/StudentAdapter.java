package com.jsonparsingandroomdb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<Student> studentList;

    public StudentAdapter(Context mCtx, List<Student> studentList) {
        this.mCtx = mCtx;
        this.studentList = studentList;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_student, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Student t = studentList.get(position);
        holder.studentName.setText(t.getName());
        holder.studentAge.setText(t.getAge());
        holder.studentRollnumber.setText(t.getRollnumber());
        holder.studentClass.setText(t.getClassStd());


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView studentName, studentAge, studentRollnumber, studentClass;

        public TasksViewHolder(View itemView) {
            super(itemView);

            studentName = itemView.findViewById(R.id.studetName);
            studentAge = itemView.findViewById(R.id.studentAge);
            studentRollnumber = itemView.findViewById(R.id.studentRollnumber);
            studentClass = itemView.findViewById(R.id.studentClass);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
