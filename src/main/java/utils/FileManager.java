package utils;

import java.io.File;
import java.net.URL;

public class FileManager {

    public static File getFileFromResources(String fileName) {

        ClassLoader classLoader = FileManager.class.getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
}
