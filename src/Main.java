import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = List.of("aaaaaaaabbbb", "bbbbaaaa", "ccccccaaaaa", "dddddaaaccc", "aaaaaaaadddsdsdssdsd",
                "bbbbaaaaaaaaaaa", "ccccccaaaaaaaaaaa", "ddddaaacccaaaaaaaaaaa", "a", "b", "c", "d", "aaaaaa", "bbb", "ccc", "dddddddd");

        String twoColumnsTable = outputTable(strings, 2);
        String threeColumnsTable = outputTable(strings, 3);
        String fourColumnsTable = outputTable(strings, 4);

        System.out.println("--------FOUR COLUMNS--------\n\n" + fourColumnsTable);
        System.out.println("--------THREE COLUMNS--------\n\n" + threeColumnsTable);
        System.out.println("--------TWO COLUMNS--------\n\n" + twoColumnsTable);
    }

    public static String outputTable(List<String> strings, int columnCount) {
        StringBuilder table = new StringBuilder();

        int totalRows = (int) Math.ceil((double) strings.size() / columnCount);

        int maxLength = findMaxLength(strings);
        String format = generateFormat(maxLength, 5);

        int index = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < columnCount; col++) {
                if (index < strings.size()) {
                    table.append(String.format(format, strings.get(index)));
                    index++;
                } else {
                    table.append(String.format(format, ""));
                }
            }
            table.append("\n");
        }

        return table.toString();
    }

    public static int findMaxLength(List<String> strings) {
        int maxLength = 0;
        for (String str : strings) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }
        return maxLength;
    }

    public static String generateFormat(int maxLength, int padding) {
        return "%-" + (maxLength + padding) + "s";
    }
}