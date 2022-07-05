public class ArrayLength {
    private InfixToPostfix infixToPostfix;
    private String[] str;

    public ArrayLength(int strLength) {
        str = new String[strLength];
    }

    public String[] setPostfixLength(String[] postfix) {
        int index = 0;
        while (index != postfix.length && postfix[index] != null)
            index++;

        if (postfix.length != index) {
            String[] newPostfix = new String[index];
            System.arraycopy(postfix, 0, newPostfix, 0, index);
            postfix = newPostfix;
        }

        return postfix;
    }
}
