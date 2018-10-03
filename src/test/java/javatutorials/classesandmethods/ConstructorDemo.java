package javatutorials.classesandmethods;

public class ConstructorDemo {

    public static void main(String[] args) {

        CarConstructor c1 = new CarConstructor();

        c1.setMake("BMW");
        System.out.println(c1.getMake());

        System.out.println(c1.speed);
        System.out.println(c1.gear);

        System.out.println("*********************");

        CarConstructor c2 = new CarConstructor(10, 1);
        System.out.println(c2.speed);
        System.out.println(c2.gear);
    }
}