package org.senolab.headersearcher.Utils;

import java.util.List;

public class TextUtil {
    public static void checkInput(String arg1, String arg2) {
        if(arg1.isBlank() && arg2.isBlank()) {
            System.out.println("You pass on an empty value in one of the parameter. Please specify the correct values. See below for instructions and examples\n");
            InstructionsUtil.printInstruction();
            System.exit(0);
        }
    }

    public static List<String> sanitizeCurlHeaderInput(List<String> curlHeaderInput) {
        for (int i=0; i < curlHeaderInput.size(); i++) {
            if(curlHeaderInput.get(i).toLowerCase().contains("curl")) {
                curlHeaderInput.remove(i);
                i=i-1;
                continue;
            }
            String result = curlHeaderInput.get(i).replace("-H","")
                    .replace("^","")
                    .replace("\\", "")
                    .trim();
            result = result.substring(1, result.length() - 1);
            curlHeaderInput.set(i, result);
        }
        return curlHeaderInput;
    }
}
