import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Challenge7 {


    public static void main(String[] args) throws IOException {
        var tree = new Tree();
        var reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(Challenge7.class.getResourceAsStream("challenge7.txt"))));

        Directory currentDir = null;
        var line = "";
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("$ cd ")) {
                var folderName = line.replace("$ cd ", "");

                if (tree.getRootDir() == null) {
                    var dir = new Directory(null, folderName);
                    tree.setRootDir(dir);
                    currentDir = tree.getRootDir();
                    continue;
                }
                currentDir = currentDir.getSubDirectory(folderName);

            } else if (line.equals("$ cd ..")) {
                assert currentDir != null;
                currentDir = currentDir.getHeadDirectory();
            } else if (!line.equals("$ ls")) {
                if (!line.startsWith("dir")) {
                    var fileInfo = line.split(" ");
                    var fileName = fileInfo[1];
                    var fileSize = Integer.parseInt(fileInfo[0]);
                    var file = new File(fileSize, fileName);
                    assert currentDir != null;
                    currentDir.getFiles().add(file);
                } else {
                    var dir = new Directory(currentDir, line.replace("dir ", ""));
                    currentDir.getSubdirectories().add(dir);
                }
            }
        }
    }

    static class File {
        private final int size;
        private final String name;

        public File(int size, String name) {
            this.size = size;
            this.name = name;
        }
    }

    static class Directory {
        private final Directory headDirectory;
        private final String name;
        private final ArrayList<Directory> subdirectories = new ArrayList<>();
        private final ArrayList<File> files = new ArrayList<>();

        public Directory(Directory headDirectory, String name) {
            this.headDirectory = headDirectory;
            this.name = name;
        }

        public Directory getHeadDirectory() {
            return headDirectory;
        }

        public String getName() {
            return name;
        }

        public ArrayList<Directory> getSubdirectories() {
            return subdirectories;
        }

        public Directory getSubDirectory(String directoryName) {
            for (var directory : getSubdirectories()) {
                if (directory.name.equalsIgnoreCase(directoryName))
                    return directory;
            }
            return null;
        }

        public ArrayList<File> getFiles() {
            return files;
        }
    }

    static class Tree {

        private Directory rootDir = null;

        public Directory getRootDir() {
            return rootDir;
        }

        public void setRootDir(Directory rootDir) {
            this.rootDir = rootDir;
        }
    }

}
