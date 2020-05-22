package cn.zsy;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title ${PACKAGE_NAME}
 * @date 2020/4/10
 * @autor Zsy
 */
@WebServlet(name = "AgencyServlet")
public class AgencyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        System.out.println("转发: "+url);
        request.getRequestDispatcher("http://www.baidu.com").forward(request,response);
//        response.getWriter().
    }



    private void get() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuffer stringBuffer=new StringBuffer();
                try {
                    URL url = new URL("url");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setConnectTimeout(5*1000);//链接超时
                    urlConnection.setReadTimeout(5*1000);//返回数据超时
                    //getResponseCode (1.200请求成功 2.404请求失败)
                    if(urlConnection.getResponseCode()==200){
                        //获得读取流写入
                        InputStream inputStream = urlConnection.getInputStream();
                        byte[] bytes=new byte[1024];
                        int len=0;
                        while ((len=inputStream.read(bytes))!=-1){
                            stringBuffer.append(new String(bytes,0,len));
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void post() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuffer stringBuffer=new StringBuffer();
                try {
                    URL url = new URL("url");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setConnectTimeout(5*1000);
                    urlConnection.setReadTimeout(5*1000);
                    //设置请求方式，默认是get
                    urlConnection.setRequestMethod("POST");//大写的POST
                    //设置允许输出
                    urlConnection.setDoOutput(true);//允许向服务器提交数据、
                    //获得输出流写数据 "&page=1"
                    urlConnection.getOutputStream().write("?stage_id=1&limit=10&page=1".getBytes());//请求参数放到请求体
                    if(urlConnection.getResponseCode()==200){
                        InputStream inputStream = urlConnection.getInputStream();
                        byte[] bytes=new byte[1024];
                        int len=0;
                        while ((len=inputStream.read(bytes))!=-1){
                            stringBuffer.append(new String(bytes,0,len));
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
