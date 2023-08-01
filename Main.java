package OrdenamientoAlfa;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numCodes = 10;
        int codeLength = 7;
        String[] codes = new String[numCodes];

        for (int i = 0; i < numCodes; i++) {
            codes[i] = generateAlphanumericCode(codeLength);
        }

        System.out.println("Códigos generados:");
        for (String code : codes) {
            System.out.println(code);
        }

        insertionSort(codes);

        System.out.println("\nCódigos ordenados:");
        for (String code : codes) {
            System.out.println(code);
        }
    }

    private static String generateAlphanumericCode(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    private static void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            String key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
