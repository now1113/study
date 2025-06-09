package study.effective;

public class MyResource implements AutoCloseable{

    public void doSomething() {
        //
        System.out.println("자원 사용중.");
    }

    @Override
    public void close() throws Exception {
        //
        System.out.println("자원 사용 완료");
    }
}
