package study.effective_java.ch02_객체_생성과_파괴.item03.enums;

public enum Elvis {
    INSTANCE;

    public String getName() {
        return "Elvis";
    }

    public void leaveTheBuilding() {}
}
