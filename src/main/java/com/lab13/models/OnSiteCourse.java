package com.lab13.models;

public class OnSiteCourse extends Course {
    private String room;
    private int quota;

    public OnSiteCourse(String title, int duration, String room, int quota) {
        super(title, duration);
        this.room = room;
        this.quota = quota;
    }

    public OnSiteCourse(String title, int duration, String professor, String room, int quota) {
        super(title, duration, professor);
        this.room = room;
        this.quota = quota;
    }

    @Override
    public void showInformation() {
        System.out.println("\n[On Site] " + title + " (" + duration + " hs) - Professor: " + professor + " - Room: " + room + ", Quota: " + quota);
    }

    public String getRoom() {
        return room;
    }

    public int getQuota() {
        return quota;
    }
}
