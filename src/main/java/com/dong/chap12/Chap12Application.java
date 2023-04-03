package main.java.com.dong.chap12;

import java.lang.annotation.Annotation;

public class Chap12Application {
    public static void main(String[] args) {
        Chap12Application chap12Application = new Chap12Application();
        try {
            SampleAnnotation annotation = chap12Application.getClass().getMethod("sampleMethod").getAnnotation(SampleAnnotation.class);
            System.out.println("annotation sample string : " + annotation.sampleString());
            System.out.println("annotation sample int : " + annotation.sampleInt());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        MySampleProxy proxy = new MySampleProxy();
        proxy.call(new functionalMethod() {
            @Override
            public void method() {
                chap12Application.sampleMethod();
            }

            @Override
            public Annotation[] getAnnotations() throws NoSuchMethodException {
                return chap12Application.getClass().getMethod("sampleMethod").getDeclaredAnnotations();
            }
        });
    }

    @SampleAnnotation(sampleString = "time log", sampleInt = 2)
    public void sampleMethod() {
        System.out.println("sample method");
    }
}

class MySampleProxy {
    public void call (functionalMethod functionalMethod) {
        try {
            Annotation[] annotations = functionalMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(SampleAnnotation.class)) {
                    SampleAnnotation sampleAnnotation =
                            (SampleAnnotation) annotation;
                    System.out.println(sampleAnnotation.sampleString());
                    if (sampleAnnotation.sampleString().equals("time log")) {
                        long startTime = System.currentTimeMillis();
                        functionalMethod.method();
                        System.out.println("Time: " + (System.currentTimeMillis() - startTime));
                    } else {
                        System.out.println("no time log");
                        functionalMethod.method();
                    }
                    return;
                }
            }
            System.out.println("no time log");
            functionalMethod.method();
        } catch (NoSuchMethodException e) {
            System.out.println("no time log");
            functionalMethod.method();
        }
    }
}


interface functionalMethod {
    void method();
    Annotation[] getAnnotations () throws NoSuchMethodException;
}