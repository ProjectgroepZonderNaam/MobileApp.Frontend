package com.projectgroepzondernaam.mobileapp.fontend.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.projectgroepzondernaam.mobileapp.frontend.R;
import com.projectgroepzondernaam.mobileapp.frontend.data.App;
import com.projectgroepzondernaam.mobileapp.frontend.helpers.ImageDownloader;

public class ImageListAdapter extends BaseAdapter {

	 
    private Context mContext;

    private LayoutInflater mLayoutInflater;                              

    private ArrayList<App> mEntries = new ArrayList<App>();          

    private final ImageDownloader mImageDownloader;                      

    public ImageListAdapter(Context context) {                           
       mContext = context;
       mLayoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       mImageDownloader = new ImageDownloader(context);
    }

    @Override
    public int getCount() {
       return mEntries.size();
    }

    @Override
    public Object getItem(int position) {
       return mEntries.get(position);
    }

    @Override
    public long getItemId(int position) {
       return position;
    }

    @Override
    public View getView(int position, View convertView,
          ViewGroup parent) {                                           
       RelativeLayout itemView;
       if (convertView == null) {                                        
          itemView = (RelativeLayout) mLayoutInflater.inflate(
                   R.layout.app_item_layout, parent, false);

       } else {
          itemView = (RelativeLayout) convertView;
       }

       ImageView imageView = (ImageView)
          itemView.findViewById(R.id.imageView1);                        
       TextView titleText = (TextView)
          itemView.findViewById(R.id.EditText01);                        
       TextView descriptionText = (TextView)
          itemView.findViewById(R.id.button3);                  

       String imageUrl = mEntries.get(position).getIconUrl();  
       mImageDownloader.download(imageUrl, imageView);                   

       String title = mEntries.get(position).getName();
       titleText.setText(title);
       String description =
          mEntries.get(position).getDescription();
       if (description.trim().length() == 0) {
          description = "Sorry, no description for this image.";
       }
       descriptionText.setText(description);

       return itemView;
    }

    public void updateApps(ArrayList<App> apps) {
       mEntries = apps;
       notifyDataSetChanged();
    }
}

