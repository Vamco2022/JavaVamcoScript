package scriptLib.system.out;

public class println {
    public println(String[] c) {
        StringBuilder builder = new StringBuilder();
        boolean isString = false;
        for (int i = 1;i < c.length;i++){
            if (!isString && !c[i].contains("+")){
                if (c[i].startsWith("\"")){
                    String t = c[i].replace("\"","");
                    builder.append(t);
                    isString = true;
                }
            }
            else if(!c[i].contains("+")){
                if (c[i].endsWith("\"")){
                    String t = c[i].replace("\"","");
                    builder.append(" ").append(t);
                    isString = false;
                }else {
                    builder.append(" ").append(c[i]);
                }
            }
            else{
                String[] p = printCon.printlnCon(c,i);
                builder.append(p[0]);
                if (p[1].equals("true")){
                    i++;
                }
            }
        }
        System.out.println(builder);
    }
}
