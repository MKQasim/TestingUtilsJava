import java.io.File;
import java.io.IOException;
import org.bitbucket.kienerj.io.OptimizedRandomAccessFile;

public class CommonUtilsSolutions {

    /**
     * @param needle
     * @param haystack
     * @return
     */
    public static boolean findInFile(String needle, String haystack) {
        if (needle == null || needle.isEmpty()) {
            System.out.println("Issue: Needle is null or empty");
            return false;
        }

        OptimizedRandomAccessFile raf = null;

        try {
            raf = new OptimizedRandomAccessFile(haystack, "r");
            long offset = 0;
            int nl = needle.length();
            byte[] tbuf = new byte[nl];
            boolean returnValue = false;

            while (offset <= raf.length() - nl) {
                raf.seek(offset);
                raf.read(tbuf);
                String cmp = new String(tbuf, "UTF-8");
                if (needle.equals(cmp)) {
                    System.out.println("Found the string in the file");
                    returnValue = true;
                    break;
                }
                offset++;
            }

            return returnValue;
        } catch (IOException e) {
            System.out.println("Issue: Error while reading the file - " + e.getMessage());
            return false;
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    System.out.println("Error closing the file - " + e.getMessage());
                }
            }
        }
    }
   
   
    public static boolean findInString(String needle, String haystack) {
        if (needle == null || needle.isEmpty()) {
            System.out.println("Issue: Needle is null or empty");
            return false;
        }

        int nl = needle.length();
        boolean returnValue = false;

        for (int offset = 0; offset <= haystack.length() - nl; offset++) {
            String cmp = haystack.substring(offset, offset + nl);
            if (needle.equals(cmp)) {
                System.out.println("Found the string in the input string");
                returnValue = true;
                break;
            }
        }
        return returnValue;
    }

    public static boolean findInDirectory(String needle, String haystackDirectory) throws IOException {
        if (needle == null || needle.isEmpty()) {
            System.out.println("Issue: Needle is null or empty");
            return false;
        }

        File dir = new File(haystackDirectory);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Issue: Invalid directory path or directory does not exist");
            return false;
        }

        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Issue: Directory is empty");
            return false;
        }

        boolean returnValue = false;

        for (File file : files) {
            if (file.isFile()) {
                if (findInFile(needle, file.getAbsolutePath())) {
                    System.out.println("Found the string in a file in the directory");
                    returnValue = true;
                    break;
                }
            } else if (file.isDirectory()) {
                if (findInDirectory(needle, file.getAbsolutePath())) {
                    System.out.println("Found the string in a subdirectory");
                    returnValue = true;
                    break;
                }
            }
        }
        return returnValue;
    }

    public static int sieveOfEratosthenes(int n) {
        if (n < 2) {
            System.out.println("Issue: Input value must be 2 or greater");
            return 0;
        }

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int factor = 2; factor * factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor * factor; j <= n; j += factor) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        System.out.println("Number of primes less than or equal to " + n + ": " + count);
        return count;
    }

    public static int levenshteinDistance(CharSequence lhs, CharSequence rhs) {
        if (lhs == null || rhs == null) {
            System.out.println("Issue: Neither lhs nor rhs can be null");
            return -1;
        }

        int len0 = lhs.length() + 1;
        int len1 = rhs.length() + 1;

        int[] cost = new int[len0];
        int[] newCost = new int[len0];

        for (int i = 0; i < len0; i++) {
            cost[i] = i;
        }

        for (int j = 1; j < len1; j++) {
            newCost[0] = j;

            for (int i = 1; i < len0; i++) {
                int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;

                int costReplace = cost[i - 1] + match;
                int costInsert = cost[i] + 1;
                int costDelete = newCost[i - 1] + 1;

                newCost[i] = Math.min(Math.min(costInsert, costDelete), costReplace);
            }

            int[] swap = cost;
            cost = newCost;
            newCost = swap;
        }

        System.out.println("Levenshtein distance: " + cost[len0 - 1]);
        return cost[len0 - 1];
    }
}
