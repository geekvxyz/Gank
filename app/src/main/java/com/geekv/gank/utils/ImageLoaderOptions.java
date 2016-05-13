package com.geekv.gank.utils;

import android.graphics.Bitmap;

import com.geekv.gank.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
/**
 * ImagerLoader������
 * �ṩImageLoader�ڼ���ͼƬʱʹ�õ���ʾ����DisplayImageOptions
 * @author acer_pc
 *
 */
public class ImageLoaderOptions {
	public static DisplayImageOptions getOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
		// // ����ͼƬ�������ڼ���ʾ��ͼƬ
		//.showImageOnLoading(R.drawable.pic_imageloader_loading)
		// // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
		// .showImageForEmptyUri(R.drawable.small_image_holder_listpage)
		// // ����ͼƬ����/��������д���ʱ����ʾ��ͼƬ
		//.showImageOnFail(R.drawable.pic_imageloader_loading)
		// �������ص�ͼƬ�Ƿ񻺴����ڴ���
		.cacheInMemory(true)
		// �������ص�ͼƬ�Ƿ񻺴���SD����
		.cacheOnDisc(true)
		.considerExifParams(true)////�Ƿ���JPEGͼ��EXIF��������ת����ת��
		.imageScaleType(ImageScaleType.EXACTLY)// ����ͼƬ����εı��뷽ʽ��ʾ
		.bitmapConfig(Bitmap.Config.RGB_565)// ����ͼƬ�Ľ�������
		// .decodingOptions(android.graphics.BitmapFactory.Options
		// decodingOptions)//����ͼƬ�Ľ�������
		.considerExifParams(true)
		// ����ͼƬ����ǰ���ӳ�
		// .delayBeforeLoading(int delayInMillis)//int
		// delayInMillisΪ�����õ��ӳ�ʱ��
		// ����ͼƬ���뻺��ǰ����bitmap��������
		// ��preProcessor(BitmapProcessor preProcessor)
		.resetViewBeforeLoading(true)// ����ͼƬ������ǰ�Ƿ����ã���λ
		// .displayer(new RoundedBitmapDisplayer(20))//�Ƿ�����ΪԲ�ǣ�����Ϊ����
		.displayer(new FadeInBitmapDisplayer(100))// ����
		.build();

		return options;
	}
	public static DisplayImageOptions getChatAdapterOptions(){
		return new DisplayImageOptions.Builder()
		.showImageForEmptyUri(R.drawable.zhanwei)
		.showImageOnFail(R.drawable.zhanwei)
		.resetViewBeforeLoading(true)
		.cacheOnDisc(true)
		.cacheInMemory(true)
		.imageScaleType(ImageScaleType.EXACTLY)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.considerExifParams(true)
		.displayer(new FadeInBitmapDisplayer(300))
		.build();
	}
}
