package java.com.dong.chap9;

import java.util.Objects;

public class ObjectSample implements Cloneable {

    private int a;
    private int b;

    public ObjectSample (int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectSample that = (ObjectSample) o;
        return a == that.a && b == that.b;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || !(o instanceof ObjectSample)) return false;
//        ObjectSample that = (ObjectSample) o;
//        return a == that.a && b == that.b;
//    }

    @Override
    protected ObjectSample clone() throws CloneNotSupportedException {
        return (ObjectSample) super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "ObjectSample{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
}
