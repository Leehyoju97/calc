public class Calculator {
    String[]infix;
    String[]postfix;
    Stack stack;

    public Calculator(){}

    public Calculator(String []infix){
        stack = new Stack();
        postfix = new String[infix.length];
        this.infix = infix;
    }

    public void start(Calculator calculator){
        calculator.infixToPostfix(infix);
        calculator.printPostfix();
        calculator.postCalculate();
    }

    //중위식 -> 후위식
    public void infixToPostfix(String[] infix){
        int index = 0;

        for(int i=0; i<infix.length; i++){
            if(Character.isDigit(infix[i].charAt(0))){
                postfix[index++] = infix[i];
            }
            else if(isOperator(infix[i])){
                if(stack.isStrEmpty()){
                    stack.push(infix[i]);
                }
                else if(getPriority(stack.strPeek()) < getPriority(infix[i])){
                    stack.push(infix[i]);
                }
                else{
                    postfix[index++] = stack.strPop();
                    stack.push(infix[i]);
                }
            }
            else if(infix[i].equals("(")){
                stack.push(infix[i]);
            }
            else if(infix[i].equals(")")){
                while(!stack.strPeek().equals("(")){
                    postfix[index++] = stack.strPop();
                }
                stack.strPop();

            }
            else{
                System.out.println("오류발생!! 계산기 프로그램을 종료합니다");
                return;
            }
        }

        while(!stack.isStrEmpty()){
            postfix[index++] = stack.strPop();
        }

        setPostfixLength();
    }

    //연산자체크
    public boolean isOperator(String op){
        if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")){
            return true;
        }
        return false;
    }

    //연산자 우선순위
    public int getPriority(String op){
        if(op.equals("+") || op.equals("-")){
            return 1;
        }else if(op.equals("*") || op.equals("/")){
            return 2;
        }
        return 0;
    }

    //후위식
    public void printPostfix(){
        System.out.print("후위표기식: ");
        for(int i=0;i<postfix.length;i++)
            System.out.print(postfix[i]+" ");
        System.out.println();
    }

    //후위식 계산
    public void postCalculate(){
        for(int i=0; i<postfix.length; i++){
            if(Character.isDigit(postfix[i].charAt(0))){
                stack.push(Double.parseDouble(postfix[i]));
            }
            else if(isOperator(postfix[i])){
                double num2 = stack.numPop();
                double num1 = stack.numPop();
                double result = calculate(num1, num2, postfix[i]);
                stack.push(result);
            }
        }

        System.out.println("결과: " + stack.numPeek());
    }

    //사칙연산
    public double calculate(double num1, double num2, String op){
        double result = 0.0;

        if(op.equals("+")){
            result = num1 + num2;
        }else if(op.equals("-")){
            result = num1 - num2;
        }else if(op.equals("*")){
            result = num1 * num2;
        }else if(op.equals("/")){
            result = num1 / num2;
        }

        return result;
    }

    //후위식 길이
    public void setPostfixLength(){
        int index=0;
        while(index != postfix.length && postfix[index] != null)
            index++;

        if(postfix.length != index){
            String[] newPostfix = new String[index];
            System.arraycopy(postfix, 0, newPostfix, 0, index);
            postfix = newPostfix;
        }

    }
}
