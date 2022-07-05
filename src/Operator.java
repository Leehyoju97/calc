public class Operator {

    //연산자체크
    public static boolean isOperator(String op) {
        if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
            return true;
        }
        return false;
    }

    //연산자 우선순위
    public static int getPriority(String op) {
        if (op.equals("+") || op.equals("-")) {
            return 1;
        } else if (op.equals("*") || op.equals("/")) {
            return 2;
        }
        return 0;
    }
}
