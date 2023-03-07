package chap9;

public class CloneSample implements Cloneable {
    ObjectSample objectSample1;
    ObjectSample objectSample2;

    public CloneSample(ObjectSample objectSample1, ObjectSample objectSample2) {
        this.objectSample1 = objectSample1;
        this.objectSample2 = objectSample2;
    }


    @Override
    protected CloneSample clone() {
        try {
            return (CloneSample) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    protected CloneSample deepCopy() {
        CloneSample cloneSample = null;
        try {
            cloneSample = (CloneSample) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }

        cloneSample.objectSample1
                = new ObjectSample(this.objectSample1.getA(), this.objectSample1.getB());
        cloneSample.objectSample2
                = new ObjectSample(this.objectSample2.getA(), this.objectSample2.getB());

        return cloneSample;
    }
}
