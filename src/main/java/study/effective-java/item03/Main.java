package study.effective;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) throws Exception {
        Elvis instance1 = Elvis.INSTANCE;
        Elvis instance2 = Elvis.INSTANCE;

        assertSame(instance1, instance2);

        // 예외
        Constructor<Elvis> constructor = (Constructor<Elvis>) instance2.getClass().getDeclaredConstructor();
        constructor.setAccessible(true);

        Elvis instance3 = constructor.newInstance();

        assertSame(instance2, instance3);

        // 두번째
        Elvis elvis1 = Elvis.getInstance();
        Elvis elvis2 = Elvis.getInstance();

        // true
        assertSame(elvis1, elvis2);

        Supplier<Elvis> supplier =  Elvis::getInstance;
        Elvis elvis = supplier.get();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("elvis.ser"));
        out.writeObject(Elvis.INSTANCE);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("elvis.ser"));
        Elvis deserializedElvis = (Elvis) in.readObject();

        assertSame(Elvis.INSTANCE, deserializedElvis);
    }

    private static void assertSame(Elvis first, Elvis second){
        System.out.println(first == second);
    }

}
