import scriptLib.codeRunning;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @version beta 0.0.1
 * @author vamco2020
 *
 * Now, this script has 3 run mode,
 * 1, straight run it. (Can use)
 * 2, converted the codes to Java, Then run it.(To Jar Will default use it) (Will show in the beta 0.15)
 * 3, converted the codes to C++, Then run it.(Your Computer need gcc or g++!) (Will show in the beta 0.25)
 */

public class debugTime {
    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        File info = new File(".\\file\\program.inf");
        Map<Integer,String> code = new HashMap<>();
        String[] infoGet = new String[64];
        try{
            BufferedReader reader = new BufferedReader(
                    new FileReader(info)
            );
            String s;
            int l = 0;
            while ((s = reader.readLine()) != null){
                infoGet[l] = s;
                l++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error:Cannot found the program.info file!");
        } catch (IOException e) {
            System.out.println("Error:IOException");
        }
        String mainFileName = infoGet[0].split(":")[1];
        File mainCodeFile = new File(".\\file\\codes\\" + mainFileName);
        try{
            BufferedReader reader = new BufferedReader(
                    new FileReader(mainCodeFile)
            );
            String s;
            int l = 0;
            while ((s = reader.readLine()) != null){
                code.put(l,s);
                l++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error:Cannot found the Main file!");
        } catch (IOException e) {
            System.out.println("Error:IOException");
        }
        codeRunning.run(code,0);
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.print("program finish,use " + (endTime - startTimeMillis) + "ms");
    }
}

