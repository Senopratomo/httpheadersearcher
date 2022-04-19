package org.senolab.headersearcher;

import org.senolab.headersearcher.Utils.InstructionsUtil;
import org.senolab.headersearcher.Utils.TextUtil;
import org.senolab.headersearcher.model.HeaderSearcher;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        if(args.length == 2) {
            TextUtil.checkInput(args[0], args[1]);
            List<String> listOfHeaders = new ArrayList<String>();
            var inputSearch = Arrays.asList(args[0].split(","));
            try {
                listOfHeaders = Files.readAllLines(Path.of(args[1]), StandardCharsets.UTF_8);
            } catch (IOException ioe) {
                System.out.println(MethodHandles.lookup().lookupClass().getName() + ioe.getMessage());
                ioe.printStackTrace();
            }
            if(listOfHeaders.get(0).contains("curl")) {
                HeaderSearcher curlHeaderSearcher = new HeaderSearcher(inputSearch, TextUtil.sanitizeCurlHeaderInput(listOfHeaders));
                curlHeaderSearcher.search();
            } else {
                HeaderSearcher headerSearcher = new HeaderSearcher(inputSearch, listOfHeaders);
                headerSearcher.search();
            }

        } else {
            System.out.println("You did not specify the correct number of parameters. Please" +
                    " refer to instruction below\n");
            System.out.println(InstructionsUtil.printInstruction());
        }
    }


}
