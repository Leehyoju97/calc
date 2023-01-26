public class Expression {

    private String[] expression;

    public Expression(String expression) {
        this.expression = expression.split(Constant.EXPRESSION_SPLITTER);
    }

    public String[] getExpression() {
        return expression;
    }
}
