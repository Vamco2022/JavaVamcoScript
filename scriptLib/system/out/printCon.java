package scriptLib.system.out;

import scriptLib.global;
import scriptLib.system.values.systemValueType;
import scriptLib.system.values.values;

public class printCon {
    public static String[] printlnCon(String[] c,int now){
        String ret;
        boolean needJump= false;
        values v;
        if (c[now].length() == 1){
            String noUseCall = c[now + 1].replace("$","");
            v = global.valueLib.get(noUseCall);
        }else if (c[now].endsWith("+")){
            String noUseCall = c[now + 1].replace("$","");
            v = global.valueLib.get(noUseCall);
            needJump = true;
        }else{
            String noPlus = c[now].replace("+","");
            String noUseCall = noPlus.replace("$","");
            v = global.valueLib.get(noUseCall);
        }
        ret = v.date.toString();
        return new String[]{ret,Boolean.toString(needJump)};
    }
}
