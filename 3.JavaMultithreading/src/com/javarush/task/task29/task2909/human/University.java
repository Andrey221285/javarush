package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University extends UniversityPerson {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        super(name, age);
    }

    public Student getStudentWithAverageGrade(double averageGrade) {

        for (Student st : students) {
            if (st.getAverageGrade() == averageGrade) {
                return st;
            }
        }

        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student s = students.get(0);
        double max = s.getAverageGrade();
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > max) {
                s = students.get(i);
                max = students.get(i).getAverageGrade();
            }
        }

        return s;
    }
    public void expel(Student student){
        students.remove(students.indexOf(student));
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student s =students.get(0);
        double min=s.getAverageGrade();
        for(int i=1;i<students.size();i++){
            if(students.get(i).getAverageGrade()<min){
                s=students.get(i);
                min=students.get(i).getAverageGrade();
            }
        }
        return s;
    }
}