
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sandbox {

    public static void main(String[] args) {
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");
        
        memberNames
            .stream()
            .sorted()
            .filter((s) -> s
            .contains("h"))
            .map(String::toUpperCase)   
            .forEach(System.out::println);
    }

}
