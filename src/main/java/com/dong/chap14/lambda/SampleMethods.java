package main.java.com.dong.chap14.lambda;

import java.util.function.*;

public class SampleMethods {

    private SampleMethods() {}

    public static String doSupplier(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void doConsumer(Consumer<String> consumer, String value) {
        consumer.accept(value);
    }

    public static String doFunction(Function<Integer, String> function, Integer value) {
        return function.apply(value);
    }

    public static boolean doPredicate(Predicate<String> predicate, String value) {
        return predicate.test(value);
    }

    public static void doBiConsumer(BiConsumer<String, Integer> biConsumer, String value1, Integer value2) {
        biConsumer.accept(value1, value2);
    }

    public static <T, U> boolean doBiPredicate(BiPredicate<T, U> biPredicate, T t, U u) {
        return biPredicate.test(t, u);
    }

    public static <T, U> boolean doBiFunction(BiFunction<T,U,Boolean> biFunction, T t, U u) {
        return biFunction.apply(t,u);
    }

    public static String doUnaryOperator(UnaryOperator<String> operator, String value) {
        return operator.apply(value);
    }

    public static <T> String doBinaryOperator(BinaryOperator<T> operator, T t1, T t2) {
        return operator.apply(t1, t2).toString();
    }
}
