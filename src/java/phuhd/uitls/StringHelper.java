/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.uitls;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Duy Phu
 */
public class StringHelper {

    private static CrawHelper crawHelper;

    public StringHelper() {
        crawHelper = new CrawHelper();
    }

    public String getPageSizeOfProduct(String urlString) throws IOException {
        BufferedReader br = crawHelper.crawlHTMl(urlString);
        String line = "";
        String document = "<root>";
        boolean isStart = false;
        while ((line = br.readLine()) != null) {
            line = line.replaceAll("&laquo;", "")
                    .replaceAll("&lsaquo;", "")
                    .replaceAll("&raquo;", "")
                    .replaceAll("&rsaquo;", "");

            if (isStart && line.contains("</div>")) {
                break;
            }
            if (isStart) {
                document += line;
            }
            if (line.contains("<div class=\"div-pagination\">")) {
                isStart = true;
            }
        }
        document += "</root>";
        System.out.println(document);
        return document;
    }

    public String getHTMLCPUByPage(String urlString) throws IOException {
        BufferedReader br = crawHelper.crawlHTMl(urlString);
        String line = "";
        String doc = "<root>";
        boolean isFound = false;
        boolean isStart = false;
        while ((line = br.readLine()) != null) {
            if (isStart && line.contains("<div class=\"div-pagination\">")) {
                break;
            }
            if (isFound) {
                doc += line.trim();
            }
            if (isStart && isFound && line.contains("</a>")) {
                isFound = false;
            }
            if (isStart && line.contains("<a href")) {
                doc += line.trim();
                isFound = true;
            }
            if (line.contains("<div class=\"list-product workstation-product grid-two-on-mobile\">")) {
                isStart = true;
            }

        }
        doc += "</root>";
        System.out.println(doc);
        return doc;
    }

    public String getHTMLOfProduct(String urlString) throws IOException {
        BufferedReader br = crawHelper.crawlHTMl(urlString);
        String line = "";
        String doc = "";
        boolean isFound = false;
        while ((line = br.readLine()) != null) {
            if (isFound && line.contains("</ul>")) {
                doc += line.trim();
                break;
            }
            if (isFound) {
                doc += line.trim();
                System.out.println(line);
            }
            if (line.contains("<ul class=\"ul product-list\">")) {
                doc += line.trim();
                isFound = true;
            }
        }
        return doc;
    }

    public String getHTMLOfDetailProduct(String urlString) throws IOException {
        BufferedReader br = crawHelper.crawlHTMl(urlString);
        String line = "";
        String doc = "";
        boolean isFound = false;
        if (br.ready()) {
            //doc+= "<root>";
            while ((line = br.readLine()) != null) {
                if (isFound) {
                    doc += line.trim();
                    isFound = false;
                }
                if (line.contains("Frequency") || line.contains("CPU Cores:") || line.contains("Turbo (1 Core)")
                        || line.contains("CPU Threads") || line.contains("Overclocking")
                        || line.contains("Memory type:") || line.contains("TDP:") || line.contains("Socket:")) {
                    isFound = true;
                }
            }
        String tmp = doc.substring(5);
        doc = "<root>"+tmp+"</root>";            
        }// while br.readline
        return doc;
    }

    private static String formatHTMLLine(String line, String[] IGNORE_TEXTS) {
        if (IGNORE_TEXTS != null) {
            for (String ignore_text : IGNORE_TEXTS) {
                line = line.replaceAll(ignore_text, "");
            }
        }
        line = line.replaceAll("&ocirc;", "o")
                .replaceAll("&oacute;", "o")
                .replaceAll("&igrave;", "i")
                .replaceAll("&ecirc;", "e")
                .replaceAll("&nbsp;", "")
                .replaceAll("&agrave;", "a")
                .replaceAll("&acirc;", "a");
        return line;
    }

    // cpu-monkey
    public String getHTMLOfCPUMark(String url) throws IOException {
        BufferedReader br = crawHelper.crawlHTMl(url);
        String line = "";
        String doc = "";
        boolean isFound = false;
        doc += "<root>";
        while ((line = br.readLine()) != null) {
            if (line.contains("<div class=\"benchmarkbar\" ")) {
                doc += line.trim();
            }
            if (line.contains("<a class=\"black\"")) {
                doc += line.trim();
            }
        }
        doc += "</root>";
        return doc;
    }
}
