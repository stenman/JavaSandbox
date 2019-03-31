package com.example.sandbox.stuff;

public enum MimeTypes {
    GOOGLE_DRIVE_ODF ("application/vnd.google-apps.spreadsheet"),
    LOL ("text/ods"),
    APPLICATION_JSON ("application/json");

    private final String name;

    MimeTypes(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
