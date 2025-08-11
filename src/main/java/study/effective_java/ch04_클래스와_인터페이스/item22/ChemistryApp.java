package study.effective_java.ch04_클래스와_인터페이스.item22;

public class ChemistryApp implements PhysicalConstants{

    public void doSomething() {
        System.out.println(AVOGADROS_NUMBER);
        System.out.println(BOLTZMANN_CONSTANT);
    }
}
