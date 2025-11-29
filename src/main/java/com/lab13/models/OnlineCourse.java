package com.lab13.models;

public class OnlineCourse extends Course {
    private String platform;

    public OnlineCourse(String title, int duration, String platform) {
        super(title, duration);
        this.platform = platform;
    }

    public OnlineCourse(String title, int duration, String professor, String platform) {
        super(title, duration, professor);
        this.platform = platform;
    }

    @Override
    public void showInformation() {
        System.out.println("\n[Online] " + title + " (" + duration + " hs) - Professor: " + professor + " - Platform: " + platform);
    }

    public String getPlatform() {
        return platform;
    }
}
