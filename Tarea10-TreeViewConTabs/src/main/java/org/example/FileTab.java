package org.example;

import javafx.scene.control.Tab;

import java.io.File;

public class FileTab extends Tab {
    private File f;
    public FileTab(File f) {
        super(f.getName());
        this.f = f;
    }

    public File getFile() {
        return f;
    }
}
