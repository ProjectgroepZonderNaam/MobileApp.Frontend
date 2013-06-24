package com.projectgroepzondernaam.mobileapp.frontend.tasks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class ImagesTask extends AsyncTask<String, Void, String> {

	ImageView imageView;

	public ImagesTask(ImageView iv) {

		imageView = iv;

	}

	@Override
	protected String doInBackground(String... params) {

		File file = new File(params[0]); // image name cached on SD

		if (!file.exists()) {

			try {

				Bitmap bmp = BitmapFactory.decodeStream((InputStream) new URL( params[1]).getContent()); // if we have not chached
													// image, then download it

				bmp.compress(CompressFormat.JPEG, 100, new FileOutputStream(

				file));

			} catch (Exception e) {

				Log.d("aray", "exception: " + e.getMessage());

				e.printStackTrace();

			}

		}

		return file.getPath();

	}

	@Override
	protected void onPostExecute(String result) {

		Bitmap bmp = BitmapFactory.decodeFile(result);

		imageView.setImageBitmap(bmp);

	}
}
