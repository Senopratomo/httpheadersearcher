package org.senolab.headersearcher.Utils;

public class InstructionsUtil {
    public static String printInstruction() {
        return  """
                HttpHeaderSearcher v1.1
                                
                This is a simple CLI to search for header(s) or cookie(s) from a text file which contain output
                of "Copy Request Header" or "Copy Response Header" command from browser dev tool.
                It will return the header (or cookie) name with the value.
                                
                It takes 2 arguments:
                1) list of header(s) or cookie(s) to search
                comma-separated list of header(s) to search. 
                To search for specific cookie name, use the following format "cookie.<name of cookie to search>" 
                Example:
                date,cookie.session,cache-control
                                
                2) Full path to a file containing the output of "Copy Request Header", "Copy Response Header", or "Copy as cURL" from 
                browser dev tool "Network" section.  
                Example content of the file to process:
                POST /cem HTTP/1.1
                Accept: */*
                Accept-Encoding: gzip, deflate, br
                Accept-Language: en-US,en;q=0.9
                Cache-Control: no-cache
                Connection: keep-alive
                Content-Length: 194
                Content-Type: application/json
                Host: www.example.com
                Pragma: no-cache
                Sec-Fetch-Dest: empty
                Sec-Fetch-Mode: cors
                Sec-Fetch-Site: cross-site
                User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.88 Safari/537.36
                sec-ch-ua: " Not A;Brand";v="99", "Chromium";v="100", "Google Chrome";v="100"
                sec-ch-ua-mobile: ?0
                sec-ch-ua-platform: "Windows"
                                
                OR
                                
                curl "https://www.example.com" ^
                  -H "authority: www.example.com" ^
                  -H "accept: */*" ^
                  -H "accept-language: en-US,en;q=0.9" ^
                  -H "cache-control: no-cache" ^
                  --compressed              
                                
                Sample command:
                Scenario #1:
                Search and output HTTP response header "Date" and its value and Cookie name sessionid
                from file name /home/user/headers.txt
                Command:
                $./httpheadersearcher date,cookie.sessionid /home/user/headers.txt
                                
                Scenario #2
                Search and output HTTP request header user-agent, host, and accept-encoding from file name
                /home/user/request.txt
                Command:
                $./httpheadersearcher user-agent,host,accept-encoding /home/user/request.txt
                              
                any questions or issues, please open "issues" in this Github repository
                """;
    }
}
