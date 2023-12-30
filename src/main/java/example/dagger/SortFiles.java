package example.dagger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortFiles {

    private static final class FileName {
        private final int base;
        private final String fullName;

        private FileName(int base, String fullName) {
            this.base = base;
            this.fullName = fullName;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (input.hasNext()) {
            lines.add(input.nextLine());
        }
        lines.stream().map(s -> {
                    String[] tokens = s.split("\\.", -1);
                    return new FileName(Integer.parseInt(tokens[0]), s);
                })
                .sorted(Comparator.comparing(fileName -> fileName.base))
                .map(fileName -> fileName.fullName)
                .distinct()
                .forEach(System.out::println);
    }
}
