package com.ngohung.example.models;

import java.util.ArrayList;
import java.util.List;

import com.ngohung.widget.ContactItemInterface;

public class ExampleDataSource {

	public static List<ContactItemInterface> getSampleContactList(){
		 List<ContactItemInterface>  list = new  ArrayList<ContactItemInterface> ();
		
		 list.add(new ExampleContactItem("Lizbeth" , "Lizbeth Crockett" ) );
		 list.add(new ExampleContactItem("Zachery" , "Zachery Loranger" ) );
		 list.add(new ExampleContactItem("Vada" , "Vada Winegar" ) );
		 list.add(new ExampleContactItem("Essie" , "Essie Pass" ) );
		 list.add(new ExampleContactItem("Gracia" , "Gracia Ringdahl" ) );
		 list.add(new ExampleContactItem("Roselia" , "Roselia Benjamin" ) );
		 list.add(new ExampleContactItem("Venice" , "Venice Facey" ) );
		 list.add(new ExampleContactItem("Lanita" , "Lanita Welcher" ) );
		 list.add(new ExampleContactItem("Chana" , "Chana Hollin" ) );
		 list.add(new ExampleContactItem("Stella" , "Stella Ketterer" ) );
		 
		 list.add(new ExampleContactItem("Pete" , "Pete Ibrahim" ) );
		 list.add(new ExampleContactItem("Dwain" , "Dwain Cowher" ) );
		 list.add(new ExampleContactItem("Terisa" , "Terisa Griner" ) );
		 list.add(new ExampleContactItem("Delisa" , "Delisa Deak" ) );
		 list.add(new ExampleContactItem("Zada" , "Zada Buckingham" ) );
		 list.add(new ExampleContactItem("Rosalie" , "Rosalie Rohrer" ) );
		 list.add(new ExampleContactItem("Gladis" , "Gladis Milhorn" ) );
		 list.add(new ExampleContactItem("Branda" , "Branda Respass" ) );
		 list.add(new ExampleContactItem("Tory" , "Tory Stanislawski" ) );
		 
		 
		 list.add(new ExampleContactItem("Gregorio" , "Gregorio Tirrell" ) );
		 list.add(new ExampleContactItem("Jaclyn" , "Jaclyn Justiniano" ) );
		 list.add(new ExampleContactItem("Juana" , "Juana Parisien" ) );
		 list.add(new ExampleContactItem("Demetrius" , "Demetrius Zona" ) );
		 list.add(new ExampleContactItem("Joline" , "Joline Borgmann" ) );
		 list.add(new ExampleContactItem("Neida" , " Neida Su" ) );
		 
		 list.add(new ExampleContactItem("1111" , "1111 xxxx" ) );
		 list.add(new ExampleContactItem("7777" , "7777 xxxx" ) );
		 list.add(new ExampleContactItem("5555" , "5555 xxxx" ) );
		
		 
		 return list;
	}
	
	
}
