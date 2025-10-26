import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if(args.length < 1){
            System.out.println("Please provide the class name to run (e.g., Solution, Week8Solution1, Week8Solution2).");
            return;
        }

        //실행할 클래스 이름
        String className = args[0];
        Class<?> cls = Class.forName(className);

        Method mainMethod = cls.getMethod("main", String[].class);

        String[] mainArgs = Arrays.copyOfRange(args, 1, args.length);
        mainMethod.invoke(null, (Object) mainArgs);

    }
}
