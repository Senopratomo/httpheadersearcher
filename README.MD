<h1>Http Header Searcher</h1>
<p>
This is a simple CLI to search for header(s) or cookie(s) from a text file which contain output
of "Copy Request Header" or "Copy Response Header" command from browser dev tool.
It will return the header (or cookie) name with the value.
</p>

<p><h3>How to Use</h3>
To use it: 
<ol>
<li>
simply download the binary relevant to your machine OS in the
"Releases" section of this Github repo
</li>
<li>
unzip the downloaded binary
</li>
<li>
Find the executables name "httpheadersearcher" within "bin" of the extracted directory (from step #2).<br>
For Mac and unix-based-OS user, you may need to provide permission to execute to this script
</li>
</ol>
</p>

<p>
This CLI takes 2 arguments:
<ol>
<li>
Comma-separated list of header(s) to search.<br>
To search for specific cookie name, use the following format "cookie.<name of cookie to search>"<br>
Example:<br>
date,cookie.session,cache-control
</li>
<br>
<li>
Full path to a file containing the output of "Copy Request Header", "Copy Response Header", or "Copy as cURL" from browser dev tool "Network" section.<br>
Example content of the file to process:<br>
   POST /cem HTTP/1.1<br>
   Accept: */*<br>
   Accept-Encoding: gzip, deflate, br<br>
   Accept-Language: en-US,en;q=0.9<br>
   Cache-Control: no-cache<br>
   Connection: keep-alive<br>
   Content-Length: 194<br>
   Content-Type: application/json<br>
   Host: www.example.com<br>
   Pragma: no-cache<br>
   Sec-Fetch-Dest: empty<br>
   Sec-Fetch-Mode: cors<br>
   Sec-Fetch-Site: cross-site<br>
   User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.88 Safari/537.36<br>
   sec-ch-ua: " Not A;Brand";v="99", "Chromium";v="100", "Google Chrome";v="100"<br>
   sec-ch-ua-mobile: ?0<br>
   sec-ch-ua-platform: "Windows"<br>
<br>
OR<br>
<br>
curl "https://www.example.com" ^<br>
-H "authority: www.example.com" ^<br>
-H "accept: */*" ^<br>
-H "accept-language: en-US,en;q=0.9" ^<br>
-H "cache-control: no-cache" ^<br>
--compressed<br>
</li>
</ol>
</p>

<p>
<h3>Sample command:</h3><br>
Scenario #1:<br>
Search and output HTTP response header "Date" and its value and Cookie name sessionid
from file name /home/user/headers.txt<br>
Command:<br>
<code>$./httpheadersearcher date,cookie.sessionid /home/user/headers.txt</code>
<br>
<br>
Scenario #2<br>
Search and output HTTP request header user-agent, host, and accept-encoding from file name
/home/user/request.txt<br>
Command:<br>
<code>$./httpheadersearcher user-agent,host,accept-encoding /home/user/request.txt</code><br>
<br>
any questions or issues, please open "issues" in this Github repository<br>
</p>

