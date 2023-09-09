package scriptLib.system.out;

import scriptLib.global;
import scriptLib.system.values.values;

public class printCon {
    public static String printlnCon(String[] c){
        String ret;
        values v;
        if (c.length == 1 && !c[0].startsWith("$")){
            ret = c[0];
        }else{
            String[] p = c[0].split("\\$");
            v = global.valueLib.get(p[1]);
            ret = (String) v.date;
        }
        return ret;
    }
}
