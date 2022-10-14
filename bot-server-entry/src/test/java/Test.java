import java.util.Timer;
import java.util.TimerTask;

public class Test {
    public static void main(String[] args) {

        ClassC c=new ClassC();
        c.output();
    }

}

class ClassA{
    public void output(){
        System.out.println("I am A");
    }
}

class ClassB extends ClassA{
    public void output(){
        System.out.println("I am B");
    }
}

class ClassC extends ClassB{
    public void output(){
        super.output();
    }
}
