package com.ssafy.k_xml_ui.parse.parser;

import java.io.InputStream;
import java.util.List;

import com.ssafy.k_xml_ui.parse.dto.BoxOffice;

public interface BoxOfficeParser {

    public abstract List<BoxOffice> getBoxOffice(InputStream resource);
}
