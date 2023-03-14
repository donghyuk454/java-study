package java.com.dong.chap6;

public class ClassVariables {
    /**
     * # final 말고 static 쓰면 좋은 점!
     * 1. INSTANCE 변수가 아닌 CLASS 변수로 선언되어 해당 변수에 대해 메모리를 또 할당하지 않아도 됨
     * */
    static int checkNumStatic = 3;
    private static int checkNumPrivateStatic = 3;
    private final int checkNumPrivateFinal = 1;
    private static final int checkNumPrivateStaticFinal = 1; // 그런 의미로 내부에 상수 선언하는건 이게 제일 좋은듯..?

    public static void setCheckNumPrivateStatic (int numStatic) {
        ClassVariables.checkNumPrivateStatic = numStatic;
        // CHECK_NUM_PRIVATE_STATIC = numStatic;
    }

//    public void setCheckNumPrivateStatic (int numStatic) {
//        ClassVariables.CHECK_NUM_PRIVATE_STATIC = numStatic;
//        // CHECK_NUM_PRIVATE_STATIC = numStatic;
//    }
}
