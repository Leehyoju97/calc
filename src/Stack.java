import java.util.EmptyStackException;

public class Stack {
    int num_top;
    int str_top;
    double[] num_data;
    String[] str_data;

    public Stack() {
        this.num_top = 0;
        this.str_top = 0;
        this.num_data = new double[50];
        this.str_data = new String[50];
    }

    public void push(double num) {
        this.num_data[num_top++] = num;
    }

    public void push(String str) {
        this.str_data[str_top++] = str;
    }

    public double numPop() {
        if (isNumEmpty()) {
            throw new EmptyStackException();
        }

        return this.num_data[--num_top];
    }

    public String strPop() {
        if (isStrEmpty()) {
            throw new EmptyStackException();
        }

        return this.str_data[--str_top];
    }

    public boolean isNumEmpty() {
        if (num_top == 0)
            return true;
        else
            return false;
    }

    public boolean isStrEmpty() {
        if (str_top == 0)
            return true;
        else
            return false;
    }

    public String strPeek() {
        return this.str_data[str_top - 1];
    }

    public double numPeek() {
        return this.num_data[num_top - 1];
    }
}