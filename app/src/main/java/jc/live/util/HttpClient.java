package jc.live.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Http 请求工具类
 * @Author JC
 * @Date 2019-12-17
 * @Since 1.0.0
 */
public class HttpClient extends Thread {

    private String requestUrl = "";
    private Map<String, String> params;
    private HttpCallback httpCallback = null;

    private HttpURLConnection connection = null;
    private PrintWriter pw = null;
    private BufferedReader bufferedReader = null;
    private String line = null;
    private StringBuilder response_cache = new StringBuilder();
    private String response = null;
    private String parameter = null;

    public HttpClient(String requestUrl, HttpCallback httpCallback, Map<String, String> params){
        this.requestUrl = requestUrl;
        this.params = params;
        this.httpCallback = httpCallback;
    }



    @Override
    public void run() {
        try{
            if(requestUrl.equals("") || requestUrl == null){
                //若url为空，结束执行
                return;
            }
            URL url_path = new URL(requestUrl.trim());
            connection = (HttpURLConnection) url_path.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("POST");
            //获取连接
            connection.connect();
            if(!params.isEmpty() && params != null){
                //获取连接输出流，并写入表单参数
                pw = new PrintWriter(connection.getOutputStream());
                parameter = paramsTransfer(params);
                pw.print(parameter);
                pw.flush();
            }
            //获取响应 输入流
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = bufferedReader.readLine()) != null){
                response_cache.append(line);
            }
            response = response_cache.toString().trim();


        }catch (Exception e){


            e.printStackTrace();
        }finally {
            try{
                if(pw != null){
                    pw.close();
                }
                if(bufferedReader != null){
                    bufferedReader.close();
                }
                if(connection != null){
                    connection.disconnect();
                }
            }catch (Exception e){

                e.printStackTrace();
            }
        }
    }

    private String paramsTransfer(Map<String, String> params){
        StringBuilder requestBody = new StringBuilder();
        //遍历map，按照url参数形式拼接
        for(String key:params.keySet()){
            if(requestBody.length() != 0){
                //从第二个参数开始，每个参数key、value前添加 & 符号
                requestBody.append("&");
            }
            requestBody.append(key).append("=").append(params.get(key));
        }
        return requestBody.toString();
    }
    /**
     *  定义回调接口
     */
    public interface HttpCallback {
        void success(String response);
        void error(String error_message);
    }

    /**
     * 线程启动
     * 执行请求
     */
    public static void doPost(String requestUrl, Map<String, String> params, HttpCallback httpCallBack){
        HttpClient hu = new HttpClient(requestUrl,httpCallBack,params);
        hu.start();
    }
}
