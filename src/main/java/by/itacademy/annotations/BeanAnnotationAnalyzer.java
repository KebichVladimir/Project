package by.itacademy.annotations;

import java.util.List;

public class BeanAnnotationAnalyzer {
    public void analyze() {
        List<Class<?>> classes = new ClassFinder().find("by.itacademy");
        int count = 0;
        for (Class clazz : classes) {
            if (clazz.isAnnotationPresent(Bean.class)) {
                System.out.println(clazz);
                count++;
            }
        }
        System.out.println("Количество классов с аннотацией @Bean - " + count);
    }
}

