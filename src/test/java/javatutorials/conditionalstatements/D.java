package javatutorials.conditionalstatements;

public class D extends A {
    public void makeNoise() {
        System.out.println("bark");
    }

    public void play() {
        System.out.println("roll over");
    }

    A a = new D();
}
