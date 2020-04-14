package search;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dionysios Stolis 4/13/2020
 */
public class Container<T> {

    private List<T> list;

    private Container(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    protected static Container init(String... args) {
        try {
            String filename = "";
            for (int i = 0; i < args.length - 1; i++) {
                if (args[i].equalsIgnoreCase("--data"))
                    filename = args[i + 1];
            }
            FileInputStream inputStream = new FileInputStream(filename);
            return new Container(readFile(inputStream));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static List<String> readFile(InputStream inputStream)
            throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add((line));
            }
        }
        return list;
    }
}
