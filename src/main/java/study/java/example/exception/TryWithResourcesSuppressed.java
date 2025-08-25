package study.java.example.exception;

public class TryWithResourcesSuppressed {
    static class FragileResource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception("close failed");
        }
    }

    public static void main(String[] args) {
        try (FragileResource r = new FragileResource()) {
            throw new Exception("work failed");
        } catch (Exception e) {
            System.out.println("primary: " + e.getMessage());
            for (Throwable throwable : e.getSuppressed()) {
                System.out.println("suppressed: " + throwable.getMessage());
            }
        }
    }
}
