package com.geekv.gank.app;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.Volley;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;

public class MyApp extends Application{
	private static RequestQueue queue;
	private static ImageLoader imageLoader;
	
	@Override
	public void onCreate() {
		super.onCreate();
		queue = Volley.newRequestQueue(this);
		imageLoader = new ImageLoader(queue, new ImageCache() {
			LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>((int) (
					Runtime.getRuntime().maxMemory()/8)){
				@Override
				protected int sizeOf(String key, Bitmap value) {
					return value.getHeight()*value.getRowBytes();
				}
			};
			@Override
			public void putBitmap(String arg0, Bitmap arg1) {
				cache.put(arg0, arg1);
			}
			@Override
			public Bitmap getBitmap(String arg0) {
				return cache.get(arg0);
			}
		});
		
	}
	/**
	 * @return
	 */
	public static RequestQueue getQueue(){
		return queue;
	}
	/**
	 * @param iv
	 * @param url
	 */
	/*public static void loadImage(ImageView iv,String url){
		ImageListener imageListener = ImageLoader.getImageListener(
				iv, R.drawable.ic_launcher,R.drawable.ic_launcher);
		imageLoader.get(url, imageListener );
	}*/
	
}
