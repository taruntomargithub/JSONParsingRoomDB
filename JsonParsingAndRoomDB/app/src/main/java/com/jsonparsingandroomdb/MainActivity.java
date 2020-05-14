package com.jsonparsingandroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview_tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        saveDataTORoom();
        getStudent();
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("StudentData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void saveDataTORoom() {
        try {
            JSONArray citiesJsonArray = new JSONArray(loadJSONFromAsset());
            Student student = new Student();


            for (int i = 0; i < citiesJsonArray.length(); i++) {

                JSONObject data = citiesJsonArray.getJSONObject(i);
                String name = data.getString("name");
                String rollNumber = data.getString("rollNumber");
                String age = data.getString("age");
                String classStd = data.getString("class");

                student.setName(name);
                student.setRollnumber(rollNumber);
                student.setAge(age);
                student.setClassStd(classStd);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getStudent() {
        class GetStudent extends AsyncTask<Void, Void, List<Student>> {

            @Override
            protected List<Student> doInBackground(Void... voids) {
                List<Student> taskList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .studentDao()
                        .getAll();
                return taskList;
            }
            @Override
            protected void onPostExecute(List<Student> students) {
                super.onPostExecute(students);
                StudentAdapter adapter = new StudentAdapter(MainActivity.this, students);
                recyclerView.setAdapter(adapter);
            }
        }

        GetStudent gs = new GetStudent();
        gs.execute();
        }
    }
