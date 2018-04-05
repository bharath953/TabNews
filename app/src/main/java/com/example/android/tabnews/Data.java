package com.example.android.tabnews;

public class Data {
    private String title, source;
    private String image;
    private String time;
    private String url;


    public Data(String title, String source, String image, String time, String url) {
        this.title = title;
        this.source = source;
        this.image = image;
        this.time = time;
        this.url = url;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}