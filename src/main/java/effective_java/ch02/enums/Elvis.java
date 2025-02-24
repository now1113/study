package effective_java.ch02.enums;

public enum Elvis {
    INSTANCE;

    public String getName() {
        return "Elvis";
    }

    public void leaveTheBuilding() {}
}
