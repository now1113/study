package study.effective_java.item42;

abstract class Task {
    abstract void execute();

    void log() {
        System.out.println("logging");
    }
}
