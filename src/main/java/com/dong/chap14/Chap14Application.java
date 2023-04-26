package main.java.com.dong.chap14;

public class Chap14Application {
    public static void main(String[] args) {

        // Supplier -> parameter : X, return : R
        String supplierResult = SampleMethods.doSupplier(() ->
            new StringBuilder()
                    .append("hi")
                    .append(" hello")
                    .toString()
        );
        System.out.println("supplierResult = " + supplierResult);

        // Consumer -> parameter : T, return : X
        SampleMethods.doConsumer( value -> System.out.println("consumerResult = " + value), "consumer");

        // Function -> parameter : T, return : R
        String functionResult = SampleMethods.doFunction(String::valueOf, 3);
        System.out.println("functionResult = " + functionResult);

        // Predicate -> parameter : T, return : boolean
        boolean predicateResult = SampleMethods.doPredicate(
                value -> !"".equals(value),
                "not empty");
        System.out.println("predicateResult = " + predicateResult);

        // BiConsumer -> parameter : T, U, return : X
        SampleMethods.doBiConsumer((value1, value2) -> {
            String value = value2.toString();
            System.out.println("BiConsumer -> is "
                    + value1
                    + " same with "
                    + value2
                    + "? "
                    + (value.equals(value1) ? "Yes" : "No"));
        }, "3", 3);

        // BiPredicate -> parameter : T, U, return : boolean
        boolean biPredicateResult = SampleMethods.doBiPredicate((value1, value2) -> {
            System.out.print("BiConsumer -> is "
                    + value1
                    + " same with "
                    + value2
                    + "? ");
            return value2.toString().equals(value1);
        }, "3",  3);
        System.out.println(biPredicateResult ? "Yes" : "No");

        // BiFunction -> parameter : T, U, return : R
        boolean biFunctionResult = SampleMethods.doBiFunction((value1, value2) -> {
            System.out.print("BiConsumer -> is "
                    + value1
                    + " same with "
                    + value2
                    + "? ");
            return value1.toString().equals(value2.toString());
        }, 3.3d, 3.3f);
        System.out.println(biFunctionResult ? "Yes" : "No");

        // UnaryOperator -> parameter : T, return : T
        String unaryOperatorResult = SampleMethods.doUnaryOperator(word -> "내 이름은 " + word + "이야", "이동혁");
        System.out.println("unaryOperatorResult = " + unaryOperatorResult);

        // BinaryOperator -> parameter : T, T, return : T
        String binaryOperatorResult = SampleMethods.doBinaryOperator((v1, v2) -> v1 + v2, "내 이름은 ", "이동혁이야");
        System.out.println("binaryOperatorResult = " + binaryOperatorResult);
    }
}
