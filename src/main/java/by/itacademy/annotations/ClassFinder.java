package by.itacademy.annotations;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassFinder {
    public List<Class<?>> find(String scannedPackage) {
        String replacePath = scannedPackage.replace('.', '/');
        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(replacePath);
        if (scannedUrl == null) {
            throw new IllegalArgumentException();
        }
        File scannedDir = new File(scannedUrl.getFile());
        List<Class<?>> classes = new ArrayList<>();
        for (File file : scannedDir.listFiles()) {
            classes.addAll(find(file, scannedPackage));
        }
        return classes;
    }

    public List<Class<?>> find(File file, String scannedPackage) {
        List<Class<?>> classes = new ArrayList<>();
        String resource = scannedPackage + '.' + file.getName();
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                classes.addAll(find(child, resource));
            }
        } else if (resource.endsWith(".class")) {
            int endIndex = resource.length() - (".class").length();
            String className = resource.substring(0, endIndex);
            try {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException ignore) {
            }
        }
        return classes;
    }
}
