import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    //실행 메소드
    public void run(){
        System.out.println("계산기 프로그램!!");
        System.out.println("수식을 입력할 때 띄어쓰기를 해주세요!!");
        System.out.println("--------------------");

        String str = scanner.nextLine();
        String []infix = str.split(" ");

        Calculator calculator = new Calculator(infix);
        calculator.start(calculator);
    }


}
