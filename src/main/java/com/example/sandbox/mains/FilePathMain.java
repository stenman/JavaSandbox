package com.example.sandbox.mains;

import com.example.sandbox.stuff.MimeTypes;

import java.io.File;

public class FilePathMain {
    public static void main(String[] args) {
        File directory = new File("files");
        if (!directory.exists()) {
            directory.mkdir();
        }

        File file = new File("files/tjena.txt");

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());

        System.out.println(MimeTypes.APPLICATION_JSON.toString());

    }
}
