package study.effective_java.ch07_람다와_스트림.item42;

abstract class Task {
    abstract void execute();

    void log() {
        System.out.println("logging");
    }
}
