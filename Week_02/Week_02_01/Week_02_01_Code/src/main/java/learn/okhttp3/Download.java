package learn.okhttp3;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

@Slf4j
public class Download {

    private void downloadFile3(){
    	
        //下载路径，如果路径无效了，可换成你的下载路径
        final String url = "http://c.qijingonline.com/test.mkv";
        final long startTime = System.currentTimeMillis();
        log.info("DOWNLOAD","startTime="+startTime);

        okhttp3.Request request = new okhttp3.Request.Builder().url(url).build();
        new OkHttpClient().newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 下载失败
                e.printStackTrace();
                log.info("DOWNLOAD","download failed");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Sink sink = null;
                BufferedSink bufferedSink = null;
                try {
                    String mSDCardPath= "";//Environment.getExternalStorageDirectory().getAbsolutePath();
                    File dest = new File(mSDCardPath,   url.substring(url.lastIndexOf("/") + 1));
                    sink = Okio.sink(dest);
                    bufferedSink = Okio.buffer(sink);
                    bufferedSink.writeAll(response.body().source());
                    bufferedSink.close();
                    log.info("DOWNLOAD","download success");
                    log.info("DOWNLOAD","totalTime="+ (System.currentTimeMillis() - startTime));
                } catch (Exception e) {
                    e.printStackTrace();
                    log.info("DOWNLOAD","download failed");
                } finally {
                    if(bufferedSink != null){
                        bufferedSink.close();
                    }
                }
            }
        });
    }

    public void downloadFile(String url,Object closure){
        final long startTime = System.currentTimeMillis();
        log.info("DOWNLOAD","startTime="+startTime);
        OkHttpClient okHttpClient = new OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 下载失败
                e.printStackTrace();
                log.info("DOWNLOAD",e.getMessage(),e);
                log.info("DOWNLOAD","download failed");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                // 储存下载文件的目录
                String savePath = "";//Environment.getExternalStorageDirectory().getAbsolutePath();
                try {
                    is = response.body().byteStream();
                    long total = response.body().contentLength();
                    File file = new File(savePath, url.substring(url.lastIndexOf("/") + 1));
                    fos = new FileOutputStream(file);
                    long sum = 0;
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);
                        //long sum  int progress long total
                        //closure.show(sum ,total, progress);
                        // 下载中
//                        listener.onDownloading(progress);
                    }
                    fos.flush();
                    // 下载完成
//                    listener.onDownloadSuccess();
                    log.info("DOWNLOAD","download success");
                    log.info("DOWNLOAD","totalTime="+ (System.currentTimeMillis() - startTime));
                } catch (Exception e) {
                    e.printStackTrace();
//                    listener.onDownloadFailed();
                    log.info("DOWNLOAD","download failed");
                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (IOException e) {

                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {

                    }
                }
            }
        });
    }
}
