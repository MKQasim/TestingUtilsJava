import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

import org.junit.After;
import org.junit.Before;



public class CommonUtilsTestNew {

    private String tempDirectoryPath;

    @Before
    public void setUp() throws IOException {
        // Create a temporary directory for testing
        Path tempDir = Files.createTempDirectory("testdir");
        tempDirectoryPath = tempDir.toString();
    }

    @After
    public void tearDown() throws IOException {
        // Delete the temporary directory and its contents after each test
        Files.walk(Paths.get(tempDirectoryPath))
                .map(Path::toFile)
                .forEach(File::delete);
        Files.deleteIfExists(Paths.get(tempDirectoryPath));
    }

    @Test
    public void testFindInFile_ExistingNeedleInFile() throws IOException {
        String fileContent = "This is a test file with some content.";
        File file = createTempFileWithContent(fileContent);

        assertTrue(CommonUtilsSolutions.findInFile("test", file.getAbsolutePath()));
    }

    @Test
    public void testFindInFile_NonExistingNeedleInFile() throws IOException {
        String fileContent = "This is a test file with some content.";
        File file = createTempFileWithContent(fileContent);

        assertFalse(CommonUtilsSolutions.findInFile("needle", file.getAbsolutePath()));
    }

    @Test
    public void testFindInFile_EmptyFile() throws IOException {
        File file = createTempFileWithContent("");

        assertFalse(CommonUtilsSolutions.findInFile("test", file.getAbsolutePath()));
    }

    @Test
    public void testFindInFile_FileNotFound() throws IOException {
        assertFalse(CommonUtilsSolutions.findInFile("test", "invalid_path/file.txt"));
    }

    @Test
    public void testFindInString_ExistingNeedleInString() {
        assertTrue(CommonUtilsSolutions.findInString("Hello", "Hello, world!"));
    }

    @Test
    public void testFindInString_NonExistingNeedleInString() {
        assertFalse(CommonUtilsSolutions.findInString("Swift", "Hello, world!"));
    }

    @Test
    public void testFindInString_EmptyHaystack() {
        assertFalse(CommonUtilsSolutions.findInString("needle", ""));
    }

    @Test
    public void testFindInDirectory_ExistingNeedleInDirectory() throws IOException {
        File file = createTempFileWithContent("This is a test file with some content.");

        assertTrue(CommonUtilsSolutions.findInDirectory("test", tempDirectoryPath));
    }

    @Test
    public void testFindInDirectory_NonExistingNeedleInDirectory() throws IOException {
        assertFalse(CommonUtilsSolutions.findInDirectory("needle", tempDirectoryPath));
    }

    @Test
    public void testFindInDirectory_EmptyDirectory() throws IOException {
        assertFalse(CommonUtilsSolutions.findInDirectory("test", tempDirectoryPath));
    }

    @Test
    public void testFindInDirectory_DirectoryNotFound() throws IOException {
        assertFalse(CommonUtilsSolutions.findInDirectory("test", "invalid_path"));
    }

    @Test
    public void testSieveOfEratosthenes_Negative() {
        assertEquals(0, CommonUtilsSolutions.sieveOfEratosthenes(-1));
    }

    @Test
    public void testSieveOfEratosthenes_Zero() {
        assertEquals(0, CommonUtilsSolutions.sieveOfEratosthenes(0));
    }

    @Test
    public void testSieveOfEratosthenes_10() {
        assertEquals(4, CommonUtilsSolutions.sieveOfEratosthenes(10));
    }

    @Test
    public void testSieveOfEratosthenes_100() {
        assertEquals(25, CommonUtilsSolutions.sieveOfEratosthenes(100));
    }

    @Test
    public void testSieveOfEratosthenes_1000() {
        assertEquals(168, CommonUtilsSolutions.sieveOfEratosthenes(1000));
    }

    @Test
    public void testLevenshteinDistance_CalcDistance0() {
        assertEquals(0, CommonUtilsSolutions.levenshteinDistance("", ""));
    }

    @Test
    public void testLevenshteinDistance_CalcDistance1() {
        assertEquals(1, CommonUtilsSolutions.levenshteinDistance("AA", "AB"));
    }

    @Test
    public void testLevenshteinDistance_CalcDistance2() {
        assertEquals(2, CommonUtilsSolutions.levenshteinDistance("AAA", "ABC"));
    }

    @Test
    public void testLevenshteinDistance_CalcDistanceN() {
        assertTrue(CommonUtilsSolutions.levenshteinDistance("dsfgdfhdfer", "fgjtykfgnsd") > 5);
    }

    private File createTempFileWithContent(String content) throws IOException {
        File file = new File(tempDirectoryPath, "testfile.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
        return file;
    }
}

