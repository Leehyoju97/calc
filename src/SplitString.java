public class SplitString {

    public void run() {
        String data = Input.inputData();
        InfixToPostfix infixToPostfix = new InfixToPostfix(new Expression(data));

        infixToPostfix.run(infixToPostfix);
    }
}
