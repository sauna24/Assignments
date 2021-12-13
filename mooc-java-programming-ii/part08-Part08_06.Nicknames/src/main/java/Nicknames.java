
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        HashMap<String, String> nickNameMap = new HashMap<>();
        nickNameMap.put("Matthew", "matt");
        nickNameMap.put("michael", "mix");
        nickNameMap.put("arthur", "artie");
        
        System.out.println(nickNameMap.get("Matthew"));
    }

}
