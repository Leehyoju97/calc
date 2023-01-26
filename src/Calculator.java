public class Calculator {
    private InfixToPostfix infixToPostfix;
    private String[] postfix;
    private Stack stack;
    private Operator operator;

    public Calculator(InfixToPostfix infixToPostfix, Stack stack) {
        this.infixToPostfix = infixToPostfix;
        this.stack = new Stack();
    }

    public void run(Calculator calculator) {
        calculator.postCalculate();
    }

    //후위식 계산
    private void postCalculate() {
        postfix = infixToPostfix.getPostfix();
        for (int i = 0; i < postfix.length; i++) {
            if (Character.isDigit(postfix[i].charAt(0))) {
                stack.push(Double.parseDouble(postfix[i]));
            } else if (Operator.isOperator(postfix[i])) {
                double num2 = stack.numPop();
                double num1 = stack.numPop();
                double result = calculate(num1, num2, postfix[i]);
                stack.push(result);
            }
        }

        System.out.println("결과: " + stack.numPeek());
    }

    //사칙연산
    private double calculate(double num1, double num2, String op) {
        double result = 0.0;

        if (op.equals("+")) {
            result = num1 + num2;
        } else if (op.equals("-")) {
            result = num1 - num2;
        } else if (op.equals("*")) {
            result = num1 * num2;
        } else if (op.equals("/")) {
            result = num1 / num2;
        }

        return result;
    }
}