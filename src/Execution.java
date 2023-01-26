public class Execution {

    //실행 메소드
    public static void run() {
        Execution execution = new Execution();
        execution.calculatePrint();

        SplitString splitString = new SplitString();
        splitString.run();
    }

    private void calculatePrint() {
        System.out.println("계산기 프로그램!!");
        System.out.println("수식을 입력할 때 띄어쓰기를 해주세요!!");
        System.out.println("--------------------");
    }
}
