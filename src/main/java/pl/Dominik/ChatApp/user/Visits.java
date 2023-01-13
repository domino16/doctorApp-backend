package pl.Dominik.ChatApp.user;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Visits {

    @Id
    @GeneratedValue
    private Integer id;

    private String comment;

    private Timestamp date;

    private String doctor;

    private String doctorImg;

    private String place;

    private String time;

    public Visits() {
    }

    public Visits(String comment, Timestamp date, String doctor, String doctorImg, String place, String time) {
        this.comment = comment;
        this.date = date;
        this.doctor = doctor;
        this.doctorImg = doctorImg;
        this.place = place;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDoctorImg() {
        return doctorImg;
    }

    public void setDoctorImg(String doctiorImg) {
        this.doctorImg = doctiorImg;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
