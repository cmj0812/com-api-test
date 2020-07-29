package com.qa.restclient;

import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.*;

import java.io.IOException;

/**
 * @author: cuimengjia
 * @date: 2020/7/29
 * @description:
 */
public class RestClient extends TestBase {

    public String host = prop.getProperty("HOST");


    //定义一个接口
    public interface ApiService{
        @GET
        Call<ResponseBody> get(@Url String url, @QueryMap JSONObject jsonQuery, @HeaderMap JSONObject jsonHeader);

        @POST
        Call<ResponseBody> post(@Url String url, @HeaderMap JSONObject jsonHeader, @Body JSONObject jsonBody);
    }


    public Response get(String url,JSONObject jsonquery,JSONObject jsonHeader) throws IOException {
        //获取retrofit对象
        Retrofit retrofit = new Retrofit.Builder().baseUrl(host).build();
        //通过动态代理获取所定义的接口
        ApiService apiService = retrofit.create(ApiService.class);
        //调用对应的get/post方法可以获取call对象
        Call<ResponseBody> call = apiService.get(url,jsonquery,jsonHeader);
        //执行call.execute/enqueue来完成同步/异步请求
        return call.execute();
    }



}
