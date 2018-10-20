package me.ohvalsgod.cs.a05.student;

import java.util.HashSet;
import java.util.Set;

public class Student {

    private String name;
    private String uniqueId;
    private Set<Double> grades;

    /*
        Constructor
     */
    public Student(String name, String uniqueId) {
        this.name = name;
        this.uniqueId = uniqueId;
        grades = new HashSet<>();
    }

    /*
        Getters
     */

    public String getName() {
        return name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public Set<Double> getGrades() {
        return grades;
    }

    /*
        Setters
     */

    public void setName(String name) {
        this.name = name;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    /*
        Methods
     */

    public void addGrade(Double d) {
        grades.add(d);
    }

    public void removeGrade(Double d) {
        grades.remove(d);
    }

}
