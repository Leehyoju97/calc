public class InfixToPostfix {
    private Expression expression;
    private String[] postfix;
    private Stack stack;
    private ArrayLength arrayLength;
    private Calculator calculator;

    public InfixToPostfix(Expression expression) {
        this.expression = expression;
        this.stack = new Stack();
        this.arrayLength = new ArrayLength(expression.getExpression().length);
        this.calculator = new Calculator(this, stack);
    }

    public void run(InfixToPostfix infixToPostfix) {
        infixToPostfix.change();
        infixToPostfix.printPostfix();
        calculator.run(calculator);
    }

    public String[] getPostfix() {
        return this.postfix;
    }

    // 중위식 -> 후위식 변경 기능이 많다 수정필요
    private void change() {
        String[] infix = expression.getExpression();
        postfix = new String[infix.length];
        int index = 0;

        for (int i = 0; i < infix.length; i++) {
            if (Character.isDigit(infix[i].charAt(0))) {
                postfix[index++] = infix[i];
            } else if (Operator.isOperator(infix[i])) {
                if (stack.isStrEmpty()) {
                    stack.push(infix[i]);
                } else if (Operator.getPriority(stack.strPeek()) < Operator.getPriority(infix[i])) {
                    stack.push(infix[i]);
                } else {
                    postfix[index++] = stack.strPop();
                    stack.push(infix[i]);
                }
            } else if (infix[i].equals("(")) {
                stack.push(infix[i]);
            } else if (infix[i].equals(")")) {
                while (!stack.strPeek().equals("(")) {
                    postfix[index++] = stack.strPop();
                }
                stack.strPop();

            } else {
                System.out.println("오류발생!! 계산기 프로그램을 종료합니다");
                return;
            }
        }

        while (!stack.isStrEmpty()) {
            postfix[index++] = stack.strPop();
        }

        postfix = arrayLength.setPostfixLength(getPostfix());
    }

    //후위식
    private void printPostfix() {
        System.out.print("후위표기식: ");
        for (int i = 0; i < postfix.length; i++)
            System.out.print(postfix[i]);
        System.out.println();
    }

}
