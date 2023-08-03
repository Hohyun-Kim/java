package com.ssafy.k_xml_ui.parse.parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ssafy.k_xml_ui.parse.dto.BoxOffice;

public class BoxOfficeDomParser implements BoxOfficeParser {

    private static BoxOfficeDomParser parser = new BoxOfficeDomParser();

    public static BoxOfficeDomParser getParser() {
        return parser;
    }

    private BoxOfficeDomParser() {
        System.out.println("DOM parser");
    }

    private List<BoxOffice> list = new ArrayList<>();

    @Override
    public List<BoxOffice> getBoxOffice(InputStream resource) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 문서 로딩 완료 --> 원하는 요소들 골라내기
            Document doc = builder.parse(resource);
            // 최 상위 element
            Element root = doc.getDocumentElement();
            parse(root);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void parse(Element root) {
        // TODO: root에서 dailyBoxOffice를 추출한 후 BoxOffice를 생성해 list에 저장하시오.
    	NodeList list = root.getElementsByTagName("dailyBoxOffice");
        for(int i = 0; i < list.getLength(); i++) {
        	Node node = list.item(i);
        	this.list.add(getBoxOffice(node));
        }
        // END
    }

    private static BoxOffice getBoxOffice(Node node) {
        BoxOffice boxOffice = new BoxOffice();
        // TODO: node 정보를 이용해서 BoxOffice를 구성하고 반환하시오.
        NodeList list = node.getChildNodes();
        for(int i = 0; i < list.getLength(); i++) {
        	Node child = list.item(i);
        	String name = child.getNodeName();
        	if(name.equals("rank")) {
        		child.getTextContent();
        		boxOffice.setRank(Integer.parseInt(child.getTextContent()));
        	} else if (name.equals("movieNm")) {
        		boxOffice.setMovieNm(child.getTextContent());
        	} else if (name.equals("openDt")) {
        		boxOffice.setOpenDt(boxOffice.toDate(child.getTextContent()));
        	} else if (name.equals("audiAcc")) {
        		boxOffice.setAudiAcc(Integer.parseInt(child.getTextContent()));
        	}
        }
        // END
        return boxOffice;
    }
}
