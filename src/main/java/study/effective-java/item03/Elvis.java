package study.effective;

import java.io.Serializable;

public class Elvis implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {
//        if (INSTANCE != null) {
//            throw new RuntimeException("생성자 호출 불가");
//        }
    }
    public void leaveTheBuilding() {}

    public static Elvis getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
