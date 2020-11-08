package learn.okhttp3;

import java.io.FileOutputStream;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;

public class DownUtil {

    private OkHttpClient okHttpClient;

    private boolean canDownLoad = true;

    public boolean downFile(String downUrl, String downPath) {
        try {
            long timeStart = System.currentTimeMillis() / 1000;
            okHttpClient = new OkHttpClient();
            Request request = new Request.Builder().url(downUrl).build();
            Response response = okHttpClient.newCall(request).execute();
            InputStream is;
            is = response.body().byteStream();
            FileOutputStream fos = null;
            fos = new FileOutputStream(downPath);
            int len;
            byte[] bytes = new byte[4096];
            while ((len = is.read(bytes)) != -1 && canDownLoad) {
                fos.write(bytes, 0, len);
            }
            fos.flush();
            is.close();
            fos.close();
            long timeEnd = System.currentTimeMillis() / 1000;
        } catch (Exception ex) {
            return false;
        }
        if (canDownLoad)
            return true;
        return false;
    }

    //超时关闭下载
    public void closeDownLoadStream() {
        canDownLoad = false;
    }

    //http下载数据
    public String getHttp(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", "Mozilla/5.0 AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36 ApiMaxJia/1.0")
                    .addHeader("Referer", "http://api.maxjia.com/")
                    .header("Cookie", "phone_num=0101010101010101010101")
                    .build();
            //client.setConnectTimeout(10, TimeUnit.SECONDS);
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
