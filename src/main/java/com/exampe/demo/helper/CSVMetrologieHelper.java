package com.exampe.demo.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import com.example.demo.model.Métrologie;


public class CSVMetrologieHelper {
//
//	public static String TYPE = "text/csv";
//	  static String[] HEADERs = { "Id", "Inventaire", "DateMetrologie","DateProchaineMetrologie","Description", "Published" };
//
//	  public static boolean hasCSVFormat(MultipartFile file) {
//
//	    if (!TYPE.equals(file.getContentType())) {
//	      return false;
//	    }
//
//	    return true;
//	  }

	 
	  public static ByteArrayInputStream tutorialsToCSV(List<Métrologie> metrologies) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	      for (Métrologie metrologie : metrologies) {
	        List<Object> data = Arrays.asList(
	              String.valueOf(metrologie.getId()),
	              metrologie.getInventaire(),
	              metrologie.getDateMetrologie(),
	              metrologie.getDateProchaineMetrologie(),
                  metrologie.getDescription(),
	              String.valueOf(metrologie.isPublished())
	            );

	        csvPrinter.printRecord(data);
	      }

	      csvPrinter.flush();
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	  }
}
