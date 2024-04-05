import java.io.File;
import java.io.IOException;

import org.bitbucket.kienerj.io.OptimizedRandomAccessFile;
/**
 * Class that implements different Find functions
 *
 */

public class CommonUtils {

    public static boolean findInFile(String needle, String haystack) throws IOException {
        OptimizedRandomAccessFile raf = new OptimizedRandomAccessFile(haystack, "rw");
        long offset = raf.getFilePointer();
        int nl = needle.length();
        byte tbuf[] = new byte[nl];
        boolean returnvalue = false;
        while (true) {
            if (offset >= raf.length()) {
                System.out.println("Potential issue: Offset exceeds file length");
                break;
            }
            raf.read(tbuf);
            String cmp = new String(tbuf, "UTF-8");
            if (needle.equals(cmp)) {
                System.out.println("Found the string in the file");
                returnvalue = true;
                break;
            }
            offset++;
            raf.seek(offset);
        }
        raf.close();
        return returnvalue;
    }

    public static boolean findInString(String needle, String haystack) {
        int offset = 0;
        int nl = needle.length();
        boolean returnvalue = false;
        while (true) {
            if (offset + nl > haystack.length()) {
                System.out.println("Potential issue: Offset exceeds string length");
                break;
            }
            String cmp = haystack.substring(offset, offset + nl);
            if (needle.equals(cmp)) {
                System.out.println("Found the string in the input string");
                returnvalue = true;
                break;
            }
            offset++;
        }
        return returnvalue;
    }

    public static boolean findInDirectory(String needle, String haystackdirectory) throws IOException {
        File dir = new File(haystackdirectory);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Issue: Invalid directory path or directory does not exist");
            return false;
        }

        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Issue: Directory is empty");
            return false;
        }

        boolean returnvalue = false;
        for (File file : files) {
            if (file.isFile()) {
                if (findInFile(needle, file.getAbsolutePath())) {
                    System.out.println("Found the string in a file in the directory");
                    returnvalue = true;
                    return returnvalue;
                }
            }
            if (file.isDirectory()) {
                returnvalue = findInDirectory(needle, file.getAbsolutePath());
                if (returnvalue) {
                    System.out.println("Found the string in a subdirectory");
                    return true;
                }
            }
        }
        return false;
    }

    public static int sieveOfEratosthenes(int n) {
        if (n <= 1) {
            System.out.println("Issue: Input value must be greater than 1");
            return 0;
        }

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int factor = 2; factor * factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor; factor * j <= n; j++) {
                    isPrime[factor * j] = false;
                }
            }
        }

        int primes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes++;
        }

        System.out.println("Number of primes less than or equal to " + n + ": " + primes);
        return primes;
    }

    public static int levenshteinDistance(CharSequence lhs, CharSequence rhs) {
        int len0 = lhs.length() + 1;
        int len1 = rhs.length() + 1;

        int[] cost = new int[len0];
        int[] newcost = new int[len0];

        for (int i = 0; i < len0; i++) cost[i] = i;

        for (int j = 1; j < len1; j++) {
            newcost[0] = j;

            for (int i = 1; i < len0; i++) {
                int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;

                int cost_replace = cost[i - 1] + match;
                int cost_insert = cost[i] + 1;
                int cost_delete = newcost[i - 1] + 1;

                newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
            }

            int[] swap = cost;
            cost = newcost;
            newcost = swap;
        }

        System.out.println("Levenshtein distance: " + cost[len0 - 1]);
        return cost[len0 - 1];
    }

}
