package com.ngohung.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.markupartist.android.widget.ActionBar;
import com.ngohung.example.adapter.ExampleContactAdapter;
import com.ngohung.example.models.ExampleContactItem;
import com.ngohung.example.models.ExampleDataSource;
import com.ngohung.widget.ContactItemComparator;
import com.ngohung.widget.ContactItemInterface;
import com.ngohung.widget.ContactListView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ContactListActivity extends Activity implements TextWatcher {

	private ExampleContactListView listview;
	
	private EditText searchBox;
	private String searchString;
	
	private Object searchLock = new Object();
	
	private final static String TAG = "com.ngohung.view.ContactListActivity";
	
	List<ContactItemInterface> contactList;
	List<ContactItemInterface> filterList;
	private SearchListTask curSearchTask = null;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);
        
        final ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);

		actionBar.setTitle("All Contacts");
		actionBar.setHomeLogo(R.drawable.ic_launcher);
        
		
		filterList = new ArrayList<ContactItemInterface>();
		contactList = ExampleDataSource.getSampleContactList();
		
		ExampleContactAdapter adapter = new ExampleContactAdapter(this, R.layout.example_contact_item, contactList);
		
		listview = (ExampleContactListView) this.findViewById(R.id.listview);
		listview.setFastScrollEnabled(true);
		listview.setAdapter(adapter);
		
		// use this to process individual clicks
		// cannot use OnClickListener as the touch event is overrided by IndexScroller
		// use last touch X and Y if want to handle click for an individual item within the row
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView parent, View v, int position,
					long id) {
				
				Toast.makeText(ContactListActivity.this, "Nickname: " + contactList.get(position).getItemForIndex() , Toast.LENGTH_SHORT).show();
			}
		});
		
		
		searchBox = (EditText) findViewById(R.id.input_search_query);
		searchBox.addTextChangedListener(this);
    }

    @Override
	public void afterTextChanged(Editable s) {
		

		searchString = searchBox.getText().toString().trim().toUpperCase();

		if(curSearchTask!=null && curSearchTask.getStatus() != AsyncTask.Status.FINISHED)
		{
			try{
				curSearchTask.cancel(true);
			}
			catch(Exception e){
				Log.i(TAG, "Fail to cancel running search task");
			}
			
		}
		curSearchTask = new SearchListTask();
		curSearchTask.execute(searchString); // put it in a task so that ui is not freeze
    }
    
    
    @Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
    	// do nothing
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// do nothing
	}
    
	private class SearchListTask extends AsyncTask<String, Void, String> {

		boolean inSearchMode = false;
		
		@Override
		protected String doInBackground(String... params) {
			filterList.clear();
			
			String keyword = params[0];
			
			inSearchMode = (keyword.length() > 0);

			if (inSearchMode) {
				// get all the items matching this
				for (ContactItemInterface item : contactList) {
					ExampleContactItem contact = (ExampleContactItem)item;
					
					if ((contact.getFullName().toUpperCase().indexOf(keyword) > -1) ) {
						filterList.add(item);
					}

				}


			} 
			return null;
		}
		
		protected void onPostExecute(String result) {
			
			synchronized(searchLock)
			{
			
				if(inSearchMode){
					
					ExampleContactAdapter adapter = new ExampleContactAdapter(ContactListActivity.this, R.layout.example_contact_item, filterList);
					adapter.setInSearchMode(true);
					listview.setInSearchMode(true);
					listview.setAdapter(adapter);
				}
				else{
					ExampleContactAdapter adapter = new ExampleContactAdapter(ContactListActivity.this, R.layout.example_contact_item, contactList);
					adapter.setInSearchMode(false);
					listview.setInSearchMode(false);
					listview.setAdapter(adapter);
				}
			}
			
		}
	}
	
    
}
