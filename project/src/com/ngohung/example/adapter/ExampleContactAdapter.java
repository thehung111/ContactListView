package com.ngohung.example.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.ngohung.example.models.ExampleContactItem;
import com.ngohung.view.R;
import com.ngohung.widget.ContactItemInterface;
import com.ngohung.widget.ContactListAdapter;

public class ExampleContactAdapter extends ContactListAdapter{

	public ExampleContactAdapter(Context _context, int _resource,
			List<ContactItemInterface> _items) {
		super(_context, _resource, _items);
		
	}
	
	// override this for custom drawing
	public void populateDataForRow(View parentView, ContactItemInterface item , int position){
		// default just draw the item only
		View infoView = parentView.findViewById(R.id.infoRowContainer);
		TextView fullNameView = (TextView)infoView.findViewById(R.id.fullNameView);
		TextView nicknameView = (TextView)infoView.findViewById(R.id.nickNameView);
		
		nicknameView.setText(item.getItemForIndex());
		
		if(item instanceof ExampleContactItem){
			ExampleContactItem contactItem = (ExampleContactItem)item;
			fullNameView.setText("Full name: " + contactItem.getFullName());
		}
		
	}

}
