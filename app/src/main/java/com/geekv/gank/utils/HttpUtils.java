package com.geekv.gank.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.geekv.gank.app.MyApp;
import com.geekv.gank.constant.Constant;

public class HttpUtils {
	/**
	 * 获取分类
	 * @param listener
	 */
	public static void getTodayArticles(Listener<String> listener) {
		String url=Constant.TODAY_ART_LIST_URL_STRING+getToday();
		StringRequest request = new StringRequest(url, listener,null);
		MyApp.getQueue().add(request);
	}

	/**
	 * 获取type分类文章
	 * @param type
	 * @param listener
	 */
	public static void getTypeArticles(String type,Listener<String> listener) {
		String url= Constant.ART_LIST_URL_STRING2+type+"/20/1";
		StringRequest request = new StringRequest(url, listener,null);
		MyApp.getQueue().add(request);
	}

	/**
	 * 获取安卓相关文章
	 * @param listener
	 */
	public static void getAndroidArticles(int page,Listener<String> listener) {
		String url= Constant.ART_LIST_URL_STRING2+Constant.ANDROID+"/20/"+page;
		StringRequest request = new StringRequest(url, listener,null);
		MyApp.getQueue().add(request);
	}

	/**
	 * 获取福利
	 * @param listener
	 */
	public static void getFULIArticles(int page,Listener<String> listener) {
		String url= Constant.ART_LIST_URL_STRING2+Constant.FULI+"/20/"+page;
		StringRequest request = new StringRequest(url, listener,null);
		MyApp.getQueue().add(request);
	}

	/**
	 * 获取Ios相关文章
	 * @param listener
	 */
	public static void getiosArticles(int page,Listener<String> listener) {
		String url= Constant.ART_LIST_URL_STRING2+Constant.IOS+"/20/1";
		StringRequest request = new StringRequest(url, listener,null);
		MyApp.getQueue().add(request);
	}


	/**
	 * 获取前端相关文章
	 * @param listener
	 */
	public static void getqdArticles(int page,Listener<String> listener) {
		String url= Constant.ART_LIST_URL_STRING2+Constant.QIANDUAN+"/20/1";
		StringRequest request = new StringRequest(url, listener,null);
		MyApp.getQueue().add(request);
	}

	/**
	 * 获得所有文章
	 * @param listener
	 */
	public static void getallArticles(int page,Listener<String> listener) {
		String url= Constant.ART_LIST_URL_STRING2+Constant.ALL+"/20/1";
		StringRequest request = new StringRequest(url, listener,null);
		MyApp.getQueue().add(request);
	}
	public static void getVDArticles(int page,Listener<String> listener) {
		String url= Constant.ART_LIST_URL_STRING2+Constant.VIDEO+"/20/1";
		StringRequest request = new StringRequest(url, listener,null);
		MyApp.getQueue().add(request);
	}
	public static String getToday() {
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy/MM/dd");       
		Date curDate =new Date(System.currentTimeMillis());
		String today = formatter.format(curDate);       
		return today;
	}
}
