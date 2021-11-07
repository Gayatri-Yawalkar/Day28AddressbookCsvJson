package com.bridegelabz.addressbookcsv;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.bridgelabz.demo.CsvUser;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
public class AddressBookCsvReaderWriter {
	private static final String FILE_NAME="addressBook";
	public void writeData(List<Contacts> contactList,String fileName) throws IOException,CsvDataTypeMismatchException,CsvRequiredFieldEmptyException {
		try (
			Writer writer=Files.newBufferedWriter(Paths.get(FILE_NAME+fileName+".csv"));
		){
			@SuppressWarnings("unchecked")
			StatefulBeanToCsv<Contacts> beanToCsv=new StatefulBeanToCsvBuilder(writer)
							.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
							.build();
			beanToCsv.write(contactList);
		}
	}
	public void readData(String fileName) throws IOException {
		try ( 
			Reader reader=Files.newBufferedReader(Paths.get(FILE_NAME+fileName+".csv"));
		){
			@SuppressWarnings("unchecked")
			CsvToBean<ContactsCsv> csvToBean=new CsvToBeanBuilder(reader)
						              .withType(ContactsCsv.class)
						              .withIgnoreLeadingWhiteSpace(true)
						              .build();
			Iterator<ContactsCsv> i=csvToBean.iterator();
			while(i.hasNext()) {
				ContactsCsv contact=i.next();
				System.out.println(contact);
			}
		}
	}
}
