package Main.view;

public interface InputProvider {
    boolean hasNextLine();
    String nextLine();
    boolean hasNextInt();
    int nextInt();
    boolean hasNext();
    String next();
    void close();
}
