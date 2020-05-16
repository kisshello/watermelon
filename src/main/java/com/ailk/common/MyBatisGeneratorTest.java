package com.ailk.common;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wanghk3
 * @time: 2020/5/16 21:48
 */
public class MyBatisGeneratorTest {

    public void generator() throws Exception {

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String xmlConfig = "generatorConfig.xml";
        InputStream stream = MyBatisGeneratorTest.class.getClassLoader().getResourceAsStream(xmlConfig);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(stream);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        new MyBatisGeneratorTest().generator();
    }

}