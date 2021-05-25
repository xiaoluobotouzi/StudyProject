package com.uzi.others;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TestClazz
 * @Description: TODO
 * @Author: kunLing
 * @Date 2021/5/25 14:37
 * ...
 */
public class TestClazz {

    public static void main(String[] args) {
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setAlias("jack");
        projectInfo.setAddress("广州市珠海区");

        Extattr extattr = new Extattr();

        List<Attrs> attrs = new ArrayList<>();

        Attrs attrs1 = new Attrs();
        attrs1.setType(0);
        attrs1.setName("文本名称");
        Text text1 = new Text();
        text1.setValue("文本");
        attrs1.setText(text1);
        attrs.add(attrs1);

        Attrs attrs2 = new Attrs();
        attrs2.setType(1);
        attrs2.setName("网页名称");
        Web web1 = new Web();
        web1.setUrl("http://www.baidu.com");
        web1.setTitle("标题");
        attrs2.setWeb(web1);
        attrs.add(attrs2);

        extattr.setAttrs(attrs);

        projectInfo.setExtattr(extattr);

        String jsonStr = JSON.toJSONString(projectInfo);
        System.out.println(jsonStr);

    }

}
