import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Andy on 23.11.2015.
 */
public class Names
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();

        if (name1.equals(name2)) System.out.println("Имена идентичны");
        else if (name1.length()==name2.length()) System.out.println("Длины имен равны");


    }
}
