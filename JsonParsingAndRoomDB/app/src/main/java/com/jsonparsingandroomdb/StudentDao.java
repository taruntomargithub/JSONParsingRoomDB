package com.jsonparsingandroomdb;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface StudentDao {
    @Query("SELECT * FROM student")
    List<Student> getAll();

    @Insert
    void insert(Student student);

    @Delete
    void delete(Student student);

    @Update
    void update(Student student);
}
