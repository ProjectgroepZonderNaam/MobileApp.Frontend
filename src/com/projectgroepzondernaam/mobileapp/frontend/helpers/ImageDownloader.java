package com.projectgroepzondernaam.mobileapp.frontend.helpers;

import com.projectgroepzondernaam.mobileapp.frontend.tasks.ImagesTask;

import android.content.Context;
import android.widget.ImageView;

public class ImageDownloader {
	
	private Context _context;

	public ImageDownloader(Context context) {
		_context = context;
	}

	public void download(String url, ImageView imageView)
	{
		new ImagesTask(imageView).execute("some_image.jpg", url);
	}
	
}
