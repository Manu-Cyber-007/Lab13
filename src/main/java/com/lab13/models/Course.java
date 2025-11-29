package com.lab13.models;

public class Course {
    protected String title;
    protected int duration;
    protected String professor;

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
        this.professor = "Unassigned";
    }

    public Course(String title, int duration, String professor) {
        this.title = title;
        this.duration = duration;
        this.professor = professor;
    }

    public void showInformation() {}

    public String getTitle() {
         return title; }

    public void setTitle(String title) {
         this.title = title; }
         
    public int getDuration() {
         return duration; }

    public void setDuration(int duration) {
         this.duration = duration; }

    public String getProfessor() {
         return professor; }

    public void setProfessor(String professor) {
         this.professor = professor; }

     public String showInformationString() {
         return "";
}
}
