package org.senolab.headersearcher.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeaderSearcher {
    public final String TAG = this.getClass().getName();
    List<String> headersToSearch = new ArrayList<String>();
    List<String> cookieToSearch = new ArrayList<String>();
    List<String> listOfHeaders = new ArrayList<String>();
    boolean isSearchingForCookie = false;

    public HeaderSearcher(List<String> inputSearch, List<String> listOfHeaders) {
        for (String header : inputSearch) {
            if(header.toLowerCase().contains("cookie") || header.toLowerCase().contains("set-cookie")) {
                String[] cookieName = header.split("\\.");
                this.cookieToSearch.add(cookieName[1]);
                isSearchingForCookie = true;
            } else {
                this.headersToSearch.add(header);
            }
        }
        this.listOfHeaders = listOfHeaders;

    }

    public void search() {
        if(isSearchingForCookie) {
            for (String header: listOfHeaders) {
                if(header.toLowerCase().contains("cookie") || header.toLowerCase().contains("set-cookie") ) {
                    searchCookie(header, cookieToSearch);
                } else {
                    searchHeader(header, headersToSearch);
                }
            }
        } else {
            for (String header : listOfHeaders) {
                searchHeader(header, headersToSearch);
            }
        }
    }

    private void searchCookie(String header, List<String> cookiesToSearch) {
        List<String> cookies = Arrays.asList(header.split(";"));
        for (String cookie : cookies) {
            for (String cookieToSearch : cookiesToSearch) {
                if(cookie.toLowerCase().contains(cookieToSearch.toLowerCase())) {
                    System.out.println(cookie);
                }
            }
        }
    }

    private void searchHeader(String header, List<String> headersToSearch) {
        for(String headerToSearch : headersToSearch) {
            String[] headerKeyValue = header.split(":");
            if(headerKeyValue[0].toLowerCase().contains(headerToSearch.toLowerCase())) {
                System.out.println(header);
            }
        }
    }
}
