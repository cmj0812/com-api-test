package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author: cuimengjia
 * @date: 2020/7/29
 * @description: test基类，增加配置文件读取、数据文件读取等
 */
public class TestBase {
    public Properties prop;

    //构造函数
    public TestBase(){
        try{
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
                    "/src/main/java/com/qa/config/config.properties");
            prop.load(fis);

        }catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
