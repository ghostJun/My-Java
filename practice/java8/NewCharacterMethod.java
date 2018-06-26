package java8;

/**
 * Java8新特性(接口静态和默认方法)
 */
public class NewCharacterMethod {
    public static void main(String[] args) {
    }
}

interface DefaultInterface {
    default String notRequired() {
        return "Hello World!";
    }
}

class A implements DefaultInterface {
}

class B implements DefaultInterface {
    @Override
    public String notRequired() {
        return "A";
    }
}

interface CInterface extends DefaultInterface {
    default String noRequired() {
        return "Hello!";
    }
}

class C implements DefaultInterface, CInterface {
    public static void main(String[] args) {
        System.out.println(new C().noRequired());
    }
}
