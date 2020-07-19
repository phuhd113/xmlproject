/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.parser;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import phuhd.entity.TblProduct;
import phuhd.entity.TblProductDetail;
import phuhd.entity.TblProductMark;
import phuhd.jaxb.Product;
import phuhd.main.AppConstant;
import phuhd.uitls.CrawHelper;
import phuhd.uitls.FormatStringHelper;
import phuhd.uitls.StringHelper;

/**
 *
 * @author Duy Phu
 */
public class StAXParser {

    private static CrawHelper crawHelper;
    private static FormatStringHelper formatStringHelper;

    public StAXParser() {
        crawHelper = new CrawHelper();
        formatStringHelper = new FormatStringHelper();
    }

    public ArrayList<TblProduct> stAXParserCPUsByPage(String document) throws UnsupportedEncodingException, XMLStreamException {
        XMLEventReader eventReader = crawHelper.parseStringToXMLEventReader(document);
        ArrayList<TblProduct> listProduct = null;
        if (eventReader.hasNext()) {
            listProduct = new ArrayList<TblProduct>();
            TblProduct product = new TblProduct();
            FormatStringHelper formatStringHelper = new FormatStringHelper();
            String name = "";
            String img = "";
            String price = "";
            String linkDetail = "";
            while (eventReader.hasNext()) {

                //System.out.println(eventReader.getElementText());
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    QName tagName = startElement.getName();
                    //System.out.println(tagName);

//                if ("a".equals(tagName.toString())) {
//                    Attribute attURL = startElement.getAttributeByName(new QName("href"));
//                    link = attURL.getValue();
//                    System.out.println(link);
//                }// end if <a> url
                    if ("img".equals(tagName.toString())) {
                        Attribute attURL = startElement.getAttributeByName(new QName("src"));
                        img = attURL.getValue();
                        product.setImage(img);
                        //System.out.println(img);
                    }
                    // get name
                    if ("span".equals(tagName.toString())) {
                        Attribute att = startElement.getAttributeByName(new QName("class"));
                        String valueAtt = att.getValue();
                        if (valueAtt.equals("name")) {
                            event = eventReader.nextEvent();
                            if (event.isCharacters()) {
                                name = event.asCharacters().getData();
                                formatStringHelper.formatNameCPU(name, product);
                                //System.out.println(product.getBranch());
                            }
                        }
                        if (valueAtt.equals("new-price")) {
                            event = eventReader.nextEvent();
                            if (event.isCharacters()) {
                                price = event.asCharacters().getData();
                                product.setPrice(formatStringHelper.formatPrice(price));

                                //listProduct.add(product);
                                //System.out.println(price);
                            }
                        }
                    }// end if span
                }// end if isStartElement
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();

                    if (endElement.getName().toString().equals("a")) {
                        listProduct.add(product);
                        product = new TblProduct();
                    }
                }
            }// end while reader.hasnetxt
        }//end if reader.hashnext

        return listProduct;
    }

    public int stAXParserPageSize(String document) throws UnsupportedEncodingException, XMLStreamException {
        document = document.trim();
        String link = "";
        if (document != null) {
            XMLEventReader eventReader = crawHelper.parseStringToXMLEventReader(document);
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    QName name = startElement.getName();
                    //System.out.println(name);
                    if ("a".equals(name.toString())) {
                        Attribute attribute = startElement.getAttributeByName(new QName("rel"));
                        if (attribute == null) {
                            attribute = startElement.getAttributeByName(new QName("href"));
                            link = attribute.getValue();
                            //System.out.println(link);
                        }
                    }
                }
            }
            if (link != null && !link.isEmpty()) {
                String regex = "[0-9]+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(link);
                if (matcher.find()) {
                    String result = matcher.group();
                    try {
                        int number = Integer.parseInt(result);
                        //System.out.println(number);
                        return number;
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }// end if doc is null
        return 1;
    }

//    public void stAXParserProductDetail(String document) throws UnsupportedEncodingException, XMLStreamException {
//        document = document.trim();
//        if (document != null) {
//            XMLEventReader eventReader = crawHelper.parseStringToXMLEventReader(document);
//
//            while (eventReader.hasNext()) {
//                XMLEvent event = eventReader.nextEvent();
//                if (event.isStartElement()) {
//                    StartElement startElement = event.asStartElement();
//                    QName name = startElement.getName();
//                    System.out.println(name);
//                    //get link Image
//                    if ("a".equals(name.toString())) {
//                        Attribute attribute = startElement.getAttributeByName(new QName("href"));
//                        System.out.println(attribute.getValue());
//                    }
//                    //get detail of product
//                    if ("span".equals(name.toString())) {
//                        event = eventReader.nextEvent();
//                        if (event.isCharacters()) {
//                            Characters value = event.asCharacters();
//                            System.out.println(value.getData());
//                        }
//                    }
//                }// if isStartElement
//            }// end while eventReader.hasNext
//        }
//    }
    public List<TblProductMark> stAXParserCpuBenchMark(String doc) throws UnsupportedEncodingException, XMLStreamException {
        XMLEventReader eventReader = crawHelper.parseStringToXMLEventReader(doc);
        List<TblProductMark> productMarks = null;
        if (eventReader.hasNext()) {
            productMarks = new ArrayList<>();
            String url = "";
            String name = "";
            String mark = "";
            TblProductMark productMark = new TblProductMark();
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    QName qName = startElement.getName();
                    if (qName.toString().equals("a")) {
                        Attribute a = startElement.getAttributeByName(new QName("href"));
                        if (a != null) {
                            // set URL
                            url = AppConstant.URL_CPU_MARK + a.getValue();
                            productMark.setUrl(url);
                            event = eventReader.nextEvent();
                            if (event.isCharacters()) {
                                //Set Name
                                name = event.asCharacters().getData();
                                productMark.setName(name);
                            }
                        }
                    }
                    if (qName.toString().equals("div")) {
                        Attribute a = startElement.getAttributeByName(new QName("class"));
                        if (a != null) {
                            event = eventReader.nextEvent();
                            if (event.isCharacters()) {
                                mark = event.asCharacters().getData();
                                productMark.setSingleCore(Integer.parseInt(mark));
                                productMarks.add(productMark);
                                productMark = new TblProductMark();
                            }
                        }
                    }// end if div
                }//end if isStartElement
            }//while event.hasNext
        }// if event.hastNext
        return productMarks;
    }

    public TblProductDetail stAXParserProductDetail(String doc) throws UnsupportedEncodingException, XMLStreamException {
        XMLEventReader eventReader = crawHelper.parseStringToXMLEventReader(doc);
        TblProductDetail detail = null;
        if (eventReader.hasNext()) {
            detail = new TblProductDetail();
            int core = 0;
            int thread = 0;
            double frequency = 0;
            double turbo = 0;
            String memoryType = "";
            String socket = "";
            boolean overClocking = false;
            int tdp = 0;
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    QName qName = startElement.getName();

                    if (qName.toString().equals("td")) {
                        FormatStringHelper stringHelper = new FormatStringHelper();
                        for (int i = 0; i < 8; i++) {
                            switch (i) {
                                case 0: { // get frequency 
                                    event = eventReader.nextEvent();
                                    frequency = Double.parseDouble(stringHelper.formatProductDetail(event.asCharacters().getData()));
                                    detail.setFrequency(frequency);
                                    System.out.println("Frequency : " + frequency);
                                    eventReader.next();
                                    eventReader.next();
                                    break;
                                }
                                case 1: {
                                    event = eventReader.nextEvent();
                                    core = Integer.valueOf(event.asCharacters().getData());
                                    detail.setCore(core);
                                    System.out.println("Core : " + core);
                                    eventReader.next();
                                    eventReader.next();
                                    break;
                                }
                                case 2: {
                                    event = eventReader.nextEvent();
                                    if (event.asCharacters().getData().contains("No turbo")) {
                                        turbo = 0;
                                    } else {
                                        turbo = Double.parseDouble(stringHelper.formatProductDetail(event.asCharacters().getData()));
                                    }
                                    detail.setTurbo(turbo);
                                    System.out.println("Turbo : " + turbo);
                                    eventReader.next();
                                    eventReader.next();
                                    break;
                                }
                                case 3: {
                                    event = eventReader.nextEvent();
                                    thread = Integer.valueOf(event.asCharacters().getData());
                                    detail.setThread(thread);
                                    System.out.println("Thread : " + thread);
                                    eventReader.next();
                                    eventReader.next();
                                    break;
                                }
                                case 4: {
                                    event = eventReader.nextEvent();
                                    if (event.asCharacters().getData().equals("Yes")) {
                                        overClocking = true;
                                    }
                                    detail.setOverClocking(overClocking);
                                    System.out.println("OverClocking : " + overClocking);
                                    eventReader.next();
                                    eventReader.next();
                                    break;
                                }
                                case 5: {
                                    event = eventReader.nextEvent();
                                    memoryType = event.asCharacters().getData();
                                    detail.setMemoryType(memoryType);
                                    System.out.println("Memory Type : " + memoryType);
                                    eventReader.next();
                                    eventReader.next();
                                    break;
                                }
                                case 6: {
                                    event = eventReader.nextEvent();
                                    tdp = Integer.parseInt(stringHelper.formatProductDetail(event.asCharacters().getData()));
                                    detail.setTdp(tdp);
                                    System.out.println("TDP : " + tdp);
                                    eventReader.next();
                                    eventReader.next();
                                    break;
                                }
                                case 7: {
                                    event = eventReader.nextEvent();
                                    socket = event.asCharacters().getData();
                                    detail.setSocket(socket);
                                    System.out.println("Socket : " + socket);
                                    break;
                                }

                            }// end switch
                        }//end for i of switch
                    }// end qName = td
                }// end event isStartElement
            }//end While event.hasNext            
        }//end if event.hasNext
        return detail;
    }
}
