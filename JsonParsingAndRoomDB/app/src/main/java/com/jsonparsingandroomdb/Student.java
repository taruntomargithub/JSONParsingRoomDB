package com.jsonparsingandroomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @ColumnInfo(name = "id")
    public Integer id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "rollNumber")
    public String rollnumber;

    @ColumnInfo(name = "age")
    public String age;

    @ColumnInfo(name = "class")
    public String classStd;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClassStd() {
        return classStd;
    }

    public void setClassStd(String classStd) {
        this.classStd = classStd;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
