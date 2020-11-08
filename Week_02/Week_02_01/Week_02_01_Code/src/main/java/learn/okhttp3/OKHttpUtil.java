package learn.okhttp3;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpUtil {
	public static String getHttp(String url) {
		String responseData = "";
		OkHttpClient client = new OkHttpClient();
		okhttp3.Request request = new okhttp3.Request.Builder().url(url).get().build();
		try {
			Response response = client.newCall(request).execute();
			responseData = response.body().string();
			return responseData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseData;
	}

	public void sync() {
		OkHttpClient okHttpClient = new OkHttpClient();// 1.定义一个client
		Request request = new Request.Builder().url("http://www.baidu.com").build();// 2.定义一个request
		Call call = okHttpClient.newCall(request);// 3.使用client去请求
		try {
			String result = call.execute().body().string();// 4.获得返回结果
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void async() {
		OkHttpClient okHttpClient = new OkHttpClient();// 1.定义一个client
		Request request = new Request.Builder().url("http://www.baidu.com").build();// 2.定义一个request
		Call call = okHttpClient.newCall(request);// 3.使用client去请求
		call.enqueue(new Callback() {// 4.回调方法
			@Override
			public void onFailure(Call call, IOException e) {
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String result = response.body().string();// 5.获得网络数据
				System.out.println(result);
			}
		});
	}
}