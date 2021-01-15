package com.uzi.jxls;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 动态表头
 */
public class JxlsDemo2 {

    public static void main(String[] args) {
        // ok
//        List<List<Object>> cells = getCells(searchResult.getHits(), columnNames);
//        if (cells != null && cells.size() > 0) {
//            File file = new File(gridTemplate);
//            InputStream in = new FileInputStream(file);
//            FileOutputStream out = new FileOutputStream(gridOutput);
//            Context context = new Context();
//            context.putVar("headers", getHeaders(columnNames));
//            context.putVar("cells", cells);
//            context.putVar("devStatusTable", getCells2(searchResult.getHits()));
//            JxlsHelper.getInstance().processTemplate(in, out, context);
//            File outPutFile = new File(gridOutput);
//            FileInputStream fileInputStream = new FileInputStream(outPutFile);
//            String fileName = URLEncoder.encode("exportResult.xlsx", "UTF-8");
//            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//            HttpServletResponse response = servletRequestAttributes.getResponse();
//            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//            response.setContentLengthLong(outPutFile.length());
//            ServletOutputStream outputStream = response.getOutputStream();
//            IOUtils.copy(fileInputStream, outputStream);
//            IOUtils.closeQuietly(fileInputStream);
//            IOUtils.closeQuietly(outputStream);
//        }
    }

}
