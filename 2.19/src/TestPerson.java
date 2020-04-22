import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestPerson {
    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        ObjectOutputStream os = null;
        ObjectInputStream is = null;
        List<Person> list = new ArrayList<>();
        try {
            String len = "";
            int x = 0;
            int y = 0;
            br = new BufferedReader(new InputStreamReader(new FileInputStream("myperson.txt")));
            while ((len = br.readLine()) != null) {
                String[] strings = len.split(",");
                for (int i = 0; i < strings.length; i++) {

                    x = strings[i].indexOf("=");

                    len = strings[i].substring(x + 1);
                    if (i == 0) {

                        y = Integer.parseInt(len);
                    }
                }
                Person p = new Person(y, len);
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        try {

            os = new ObjectOutputStream(new FileOutputStream("Person.txt"));

            os.writeObject(list);

            is = new ObjectInputStream(new FileInputStream("Person.txt"));

            List<Person> list1 = (List<Person>) is.readObject();
            for (Person p : list1) {
                System.out.println(p);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e2) {

                    e2.printStackTrace();
                } finally {
                    if (is != null) {
                    }
                    try {
                        is.close();
                    } catch (Exception e3) {

                        e3.printStackTrace();
                    }
                }
            }

        }

    }
}



