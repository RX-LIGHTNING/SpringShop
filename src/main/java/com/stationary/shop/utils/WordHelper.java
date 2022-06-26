package com.stationary.shop.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import com.stationary.shop.entities.Incom;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordHelper {

    public static ByteArrayInputStream generateWord(Incom incom)
            throws FileNotFoundException, IOException, InvalidFormatException {
        try (XWPFDocument doc = new XWPFDocument()) {

            XWPFParagraph p1 = doc.createParagraph();
            p1.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun r1 = p1.createRun();
            r1.setFontSize(22);
            r1.setText("Дата прихода"+incom.getIncomDate().toString()+" Поставщик:" + incom.getProvider().getName()+" Товар:" + incom.getProduct().getName()+" Кол-во" + incom.getQuantity());
            r1.setFontFamily("Courier");
            r1.addBreak();

            ByteArrayOutputStream b = new ByteArrayOutputStream();
            doc.write(b);
            return new ByteArrayInputStream(b.toByteArray());
        }

    }
}

