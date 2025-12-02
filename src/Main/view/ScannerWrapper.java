package Main.view;

import java.util.Scanner;

public class ScannerWrapper implements InputProvider {
    private final Scanner scanner;

    public ScannerWrapper(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public boolean hasNextInt() {
        return scanner.hasNextInt();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public String next() {
        return scanner.next();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
