package javatutorials.conditionalstatements;

public class Test {
    public static void main(String[] args) {

//        A a = new D();
//        ((D) a).play();

//        if (a instanceof D) {
//            D d = (D) a;  // casting down
//            d.play();
//        }
        A a1 =  new D();  // upcast ok with implicit cast
        A a2 = (A) (new D()); // u
    }
}
