package com.bridegelabz.addressbookcsv;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.bridgelabz.demo.MyUser;
import com.google.gson.Gson;
public class AddressBookJsonReaderWriter {
	String addressBookJson="addressBookJson";
	public void toJsonFormat(List<Contacts> contactsList,String fileName) {
		Gson gg=new Gson();
		try {
			Files.write(Paths.get(addressBookJson+fileName+".txt"),gg.toJson(contactsList).toString().getBytes());
		} catch(IOException e) {
				e.printStackTrace();
		}
	}
	public void fromJsonToObject(String fileName) {
		List<String> contactList=new ArrayList<>();
		String s=null;
		try {
			Files.lines(new File(addressBookJson+fileName+".txt").toPath())
			.map(line->line.trim())
			.forEach(line->contactList.add(line));
		} catch(IOException e) {
			e.printStackTrace();
		}
		s=contactList.get(0);
		Gson gson=new Gson();
		Contacts[] contactArray=gson.fromJson(s,Contacts[].class);
		for(Contacts contact:contactArray) {
			System.out.println(contact);
		}
	}
}
