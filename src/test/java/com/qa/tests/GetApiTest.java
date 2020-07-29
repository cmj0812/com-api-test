package com.qa.tests;

import com.alibaba.fastjson.JSONObject;
import com.qa.restclient.RestClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

/**
 * @author: cuimengjia
 * @date: 2020/7/29
 * @description: get请求测试
 */
public class GetApiTest  {
    public RestClient api;

    @BeforeClass
    public void setUp(){
        api = new RestClient();
    }

    @Test
    public void geyApiTest() throws IOException {
        String path = "ajax/json/review/reviewDraftAction";
        JSONObject jsonQuery = JSONObject.parseObject("{\"run\":\"d\",\"mode\":\"pro\",\"shopId\":\"k4zckQHRV1liJHRn\"}");
        JSONObject jsonHeader=JSONObject.parseObject(
                "{\"User-Agent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36\"}");
        Response response = api.get(path,jsonQuery,jsonHeader);
        Assert.assertNotNull(response);
    }

}
