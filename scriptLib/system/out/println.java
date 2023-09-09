package scriptLib.system.out;

import scriptLib.global;
import scriptLib.system.values.values;

public class println {
    public println(String[] c){
        StringBuilder builder = new StringBuilder();
        boolean isString = false;
        boolean hasCon;
        for (int i = 0;i < c.length;i++){
            hasCon = c[i].contains("+");
            if (!hasCon) {
                if (!isString) {
                    if (c[i].startsWith("\"")) {
                        isString = true;
                        builder.append(c[i]);
                    }
                } else {
                    builder.append(c[i]);
                    if (c[i].endsWith("\"")) {
                        isString = false;
                    }
                }
            }else{
                String[] t = c[i].split("\\+");
                builder.append(printCon.printlnCon(t));
            }
        }
        System.out.println(builder);
    }
}
