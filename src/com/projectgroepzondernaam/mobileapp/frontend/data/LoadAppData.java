package com.projectgroepzondernaam.mobileapp.frontend.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.DropBoxManager.Entry;

import com.google.gson.Gson;
import com.projectgroepzondernaam.mobileapp.fontend.adapters.ImageListAdapter;

public class LoadAppData extends AsyncTask<Void, Void, ArrayList<App>> {

	private final String mUrl = "http://localhost";

	private final ImageListAdapter mAdapter;

	public LoadAppData(ImageListAdapter adapter) {
		mAdapter = adapter;
	}

	private InputStream retrieveStream(String url) {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = null;
		httpGet = new HttpGet(url);

		HttpResponse httpResponse = null;
		try {
			httpResponse = client.execute(httpGet);
			HttpEntity getResponseEntity = httpResponse.getEntity();
			return getResponseEntity.getContent();
		} catch (IOException e) {
			httpGet.abort();
		}
		return null;
	}

	@Override
	protected ArrayList<App> doInBackground(Void... params) {
		InputStream source = retrieveStream(mUrl);
		Reader reader = null;
		try {
			reader = new InputStreamReader(source);
		} catch (Exception e) {
			return null;
		}
		Gson gson = new Gson();
		ArrayList<App> result = gson.fromJson(reader, ArrayList.class);

		return result;

	}

	protected void onPostExecute(ArrayList<App> apps) {
		mAdapter.updateApps(apps);
	}
}
