package scriptLib.system.out;


public class print {
    public print(String[] c) {
        StringBuilder builder = new StringBuilder();
        boolean isString = false;
        boolean hasCon;
        boolean isNext = false;
        String[] p = new String[0];
        for (int i = 0; i < c.length; i++) {
            if (isNext){
                builder.append(printCon.printlnCon(p));
                isNext = false;
            }
            hasCon = c[i].contains("+");
            if (!hasCon) {
                if (!isString) {
                    if (c[i].startsWith("\"")) {
                        isString = true;
                        builder.append(c[i]);
                    }
                } else {
                    builder.append(" " + c[i]);
                    if (c[i].endsWith("\"")) {
                        isString = false;
                    }
                }
            } else {
                String[] t = c[i].split("\\+");
                if (t[0].endsWith("\"") && isString){
                    isNext = true;
                    isString = false;
                    builder.append(" " + t[0]);
                    p = new String[]{c[i + 1]};
                }
                else{
                    builder.append(c[i]);
                }
            }
        }
        System.out.print(builder);
    }
}
