package scriptLib;

import scriptLib.debugClass.haveNews;
import scriptLib.system.out.print;
import scriptLib.system.out.println;
import scriptLib.system.values.userValueType;
import scriptLib.system.values.systemValueType;
import scriptLib.system.values.values;

import java.util.Map;

public class codeRunning {
    public static void run(Map<Integer,String> codes,int type){
        String ct;
        String[] ctl;
        if (type == 0) {
            for (int i = 0; i < codes.size(); i++) {
                ct = codes.get(i);
                ctl = ct.split(" ");
                if (ctl[0].startsWith("System")){
                    String[] p = ctl[0].split("\\.");
                    switch (p[1]){
                        case "print" :
                            new print(ctl);
                            break;
                        case "println":
                            new println(ctl);
                            break;
                    }
                }
                else if (ctl[0].equals("int") || ctl[0].equals("double") || ctl[0].equals("string") || ctl[0].equals("bool")){
                    valueSet.vs(ctl);
                }
            }
        }
    }
}

@haveNews(what = "update the value set more fast and more easy and clean (Not fix over)")
class valueSet{
    public static void vs(String[] c){
        userValueType ut;
        systemValueType st;
        String valueName;
        String valueDate;
        if (c[2].equals("=") && c.length == 4){
            valueName = c[1];
            valueDate = c[3];
        }else if (c[2].startsWith("=")){
            String[] t = c[2].split("=");
            valueDate = t[0];
            valueName = c[1];
        }else{
            String[] t = c[1].split("=");
            valueName = t[0];
            valueDate = c[2];
        }

        switch(c[0]){
            case "int":
                ut = userValueType.Int;
                st = systemValueType.Integer;
                values<Integer> iv = new values<>(st,ut,Integer.parseInt(valueDate));
                global.valueLib.put(valueName,iv);
                break;

            case "double":
                ut = userValueType.Double;
                st = systemValueType.Double;
                values<Double> dv = new values<>(st,ut,Double.parseDouble(valueDate));
                global.valueLib.put(valueName,dv);
                break;

            case "string":
                ut = userValueType.String;
                st = systemValueType.String;
                values<String> sv = new values<>(st,ut,valueDate);
                global.valueLib.put(valueName,sv);
                break;

            case "bool":
                ut = userValueType.Bool;
                st = systemValueType.Boolean;
                boolean b;
                b = valueDate.equals("true");
                values<Boolean> bv = new values<>(st,ut,b);
                global.valueLib.put(valueName,bv);
                break;
        }
    }
}