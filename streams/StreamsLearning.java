package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class StreamsLearning {


    public static void main(String[] args) {

        Predicate<String> a = (x) -> x.contains("Aso");
        System.out.println(a.test("Assumed"));

        BiPredicate<Integer, Integer> checkSum = (x, y) -> (x + y) > 20;
        System.out.println(checkSum.test(20, 2));


        Function<Integer, String> func = (x) -> x.toString();
        System.out.println(func.apply(2));

        BiFunction<Integer, Integer, Integer> func2 = (x, y) -> x * 2;
        System.out.println(func2.apply(100, 100));

        Consumer<String> c = (x) -> System.out.println(x);
        c.accept("Maybe Maybe not");

        BiConsumer<Integer, Integer> func3 = (x, y) -> System.out.println(x);
        func3.accept(10, 20);

        Supplier<Integer> supply = () -> 1 * 2;
        System.out.println(supply.get());

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        list.forEach((x) -> System.out.println(x));
        list.forEach(System.out::println);

        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5));

        BinaryOperator<Integer> sum = (d, b) -> d + b;
        System.out.println(sum.apply(10, 20));
    }
}