package domen;

import java.io.Serializable;
import java.util.Objects;

public class Rad implements Serializable {

    private Integer radID;
    private String tema;
    private Student student;
    private Profesor profesor;

    public Rad() {
    }

    public Rad(Integer radID, String tema, Student student, Profesor profesor) {
        this.radID = radID;
        this.tema = tema;
        this.student = student;
        this.profesor = profesor;
    }

    public Rad(String tema, Student student, Profesor profesor) {
        this.tema = tema;
        this.student = student;
        this.profesor = profesor;
    }

    public Integer getRadID() {
        return radID;
    }

    public void setRadID(Integer radID) {
        this.radID = radID;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        String s = (student != null) ? student.toString() : "N/A student";
        String p = (profesor != null) ? profesor.toString() : "N/A profesor";
        return "Rad: " + tema + " | " + s + " | " + p;
    }

}
