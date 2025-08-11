package study.effective_java.ch02_객체_생성과_파괴.item09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {

        try (MyResource myResource = new MyResource()) {
            myResource.doSomething();
        }

        //
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 복잡함
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("test.txt"));
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
