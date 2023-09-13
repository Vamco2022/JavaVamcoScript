package scriptLib.system.out;

import scriptLib.global;
import scriptLib.system.values.systemValueType;
import scriptLib.system.values.values;

public class printCon {
    public static String printlnCon(String c,int now){
        String get = null;
        if (now == 0){
            String n = c.replace("$","");
            get = global.valueLib.get(n).date.toString();
        }
        return get;
    }
}
