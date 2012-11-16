package com.ngohung.widget;

public interface ContactItemInterface {

	public String getItemForIndex();   // return the item that we want to categorize under this index. It can be first_name or last_name or display_name
									  //  e.g. "Albert Tan" , "Amy Green" , "Alex Ferguson" will fall under index A
									  // "Ben Alpha", "Ben Beta" will fall under index B 
									 
	
}
