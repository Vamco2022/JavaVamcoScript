package scriptLib.system.out;

public class println {
    public println(String[] c) {
        StringBuilder init = new StringBuilder();
        for (int i = 1;i < c.length;i++){
            init.append(c[i]).append(" ");
        }
        String p = init.toString();
        String pe = p.replace("+"," ");
        String[] n = pe.split(" ");
        StringBuilder builder = new StringBuilder();
        boolean isString = false;
        for (int i = 0;i < n.length;i++){
            if (isString){
                if (n[i].endsWith("\"")){
                    builder.append(n[i].replace("\"",""));
                    isString = false;
                }else{
                    builder.append(n[i]).append(" ");
                }
            }else{
                if (n[i].startsWith("\"")  && !n[i].endsWith("\"")){
                    builder.append(n[i].replace("\"","")).append(" ");
                    isString = true;
                }else if (n[i].startsWith("\"") && n[i].endsWith("\"")){
                    builder.append(n[i].replace("\"",""));
                }
                else if (n[i].startsWith("$")){
                    builder.append(printCon.printlnCon(n[i],0));
                }
            }
        }
        System.out.println(builder);
    }
}
