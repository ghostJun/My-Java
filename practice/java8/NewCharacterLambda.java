package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Java8 lambda表达式
 */
public class NewCharacterLambda {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 1, 0);
        // 古代写法
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
        // 新写法1
        Collections.sort(list, (Integer o1, Integer o2) -> {
            return o1.compareTo(o2);
        });
        // 新写法2
        Collections.sort(list, (Integer o1, Integer o2) -> o2.compareTo(o1));
        // 新写法3
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
        list.forEach((val) -> {
            System.out.println(val);
        });
        // 实现Runnable
//        new Thread(() -> System.out.println("Thread create"), "Thread1").start();

        // 循环
        list.forEach(n -> System.out.print(n));
        System.out.println();
        list.forEach(System.out::println);
        System.out.println("---");
        // 过滤
        list.stream().filter(num -> num > 1).forEach(System.out::print);
        System.out.println();
        List<String> strings = Arrays.asList("Tom", "AM", "PM");
        strings.stream().sorted().forEach(System.out::print);
        System.out.println();
        System.out.println("---");
        strings.forEach(System.out::print);
        System.out.println();
        System.out.println("---");
        strings.stream().filter(str -> str.startsWith("A")).forEach(System.out::print);

    }
}
