package com.uzi.others;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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

        /**
         * JSON 一种轻量级的数据交换格式。
         * Java对象和JSON之前转换，市面上有许多的第三方Jar：fastJson、jackson、gson、jsonLib
         *
         * Java里面只能操作对象，故需要把JSON转成Java对象才能在做一些操作，比如保存数据库
         *
         * 若要提供数据，采用JSON这种数据格式的话，从数据库查询到Java那只能是Java对象，转成JSON，才符合规则。
         *
         */

        // =============================================JSON字符串 转 Java对象
        String jsonStr1 = "{\n" +
                "    \"errcode\": 0,\n" +
                "    \"errmsg\": \"ok\",\n" +
                "    \"userid\": \"zhangsan\",\n" +
                "    \"name\": \"张三\",\n" +
                "    \"department\": [1, 2],\n" +
                "    \"order\": [1, 2],\n" +
                "    \"position\": \"后台工程师\",\n" +
                "    \"mobile\": \"13800000000\",\n" +
                "    \"gender\": \"1\",\n" +
                "    \"email\": \"zhangsan@gzdev.com\",\n" +
                "    \"is_leader_in_dept\": [1, 0],\n" +
                "    \"avatar\": \"http://wx.qlogo.cn/mmopen/ajNVdqHZLLA3WJ6DSZUfiakYe37PKnQhBIeOQBO4czqrnZDS79FH5Wm5m4X69TBicnHFlhiafvDwklOpZeXYQQ2icg/0\",\n" +
                "    \"thumb_avatar\": \"http://wx.qlogo.cn/mmopen/ajNVdqHZLLA3WJ6DSZUfiakYe37PKnQhBIeOQBO4czqrnZDS79FH5Wm5m4X69TBicnHFlhiafvDwklOpZeXYQQ2icg/100\",\n" +
                "    \"telephone\": \"020-123456\",\n" +
                "    \"alias\": \"jackzhang\",\n" +
                "    \"address\": \"广州市海珠区新港中路\",\n" +
                "    \"open_userid\": \"xxxxxx\",\n" +
                "    \"main_department\": 1,\n" +
                "    \"extattr\": {\n" +
                "        \"attrs\": [\n" +
                "            {\n" +
                "                \"type\": 0,\n" +
                "                \"name\": \"文本名称\",\n" +
                "                \"text\": {\n" +
                "                    \"value\": \"文本\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"type\": 1,\n" +
                "                \"name\": \"网页名称\",\n" +
                "                \"web\": {\n" +
                "                    \"url\": \"http://www.test.com\",\n" +
                "                    \"title\": \"标题\"\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"status\": 1,\n" +
                "    \"qr_code\": \"https://open.work.weixin.qq.com/wwopen/userQRCode?vcode=xxx\",\n" +
                "    \"external_position\": \"产品经理\",\n" +
                "    \"external_profile\": {\n" +
                "        \"external_corp_name\": \"企业简称\",\n" +
                "        \"external_attr\": [{\n" +
                "                \"type\": 0,\n" +
                "                \"name\": \"文本名称\",\n" +
                "                \"text\": {\n" +
                "                    \"value\": \"文本\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"type\": 1,\n" +
                "                \"name\": \"网页名称\",\n" +
                "                \"web\": {\n" +
                "                    \"url\": \"http://www.test.com\",\n" +
                "                    \"title\": \"标题\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"type\": 2,\n" +
                "                \"name\": \"测试app\",\n" +
                "                \"miniprogram\": {\n" +
                "                    \"appid\": \"wx8bd80126147dFAKE\",\n" +
                "                    \"pagepath\": \"/index\",\n" +
                "                    \"title\": \"my miniprogram\"\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}\n";

        ProjectInfo projectInfo1 = JSONObject.parseObject(jsonStr1, ProjectInfo.class);
        System.out.println(projectInfo1.getAlias());


        // =============================================Java对象 转 JSON字符串
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
