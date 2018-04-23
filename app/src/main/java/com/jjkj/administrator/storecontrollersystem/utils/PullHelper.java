package com.jjkj.administrator.storecontrollersystem.utils;

import android.util.SparseArray;
import android.util.Xml;

import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlElement;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlElementBean;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlElementWrapper;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlNameSpace;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlRootElement;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlSoapBody;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlSoapHeader;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlSpaceNameList;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;

/**
 * PullHelper
 *
 * @author Administrator
 * @date 2018/3/16
 */

public interface PullHelper {
    String DEF = "##default";


    /**
     * 转化对象为XML的方法
     *
     * @param value 转化的对象
     * @param type  转化的对象的类
     * @return 返回转化好的Xml
     * @throws IOException 抛出的异常
     */
    default String obj2xml(Object value, Class<?> type) throws IOException {
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        serializer.setOutput(writer);
        serializer.startDocument("utf-8", null);
        Field[] fields = type.getDeclaredFields();
        PullXmlRootElement rootElement = type.getAnnotation(PullXmlRootElement.class);
        PullXmlNameSpace nameSpace = type.getAnnotation(PullXmlNameSpace.class);
        //类开始标签以及命名空间
        if (rootElement != null && !rootElement.name().equals(DEF)) {
            if (nameSpace != null && nameSpace.spaceNameList().length > 0) {
                PullXmlSpaceNameList[] nameList = nameSpace.spaceNameList();
                for (PullXmlSpaceNameList spaceNameList : nameList) {
                    serializer.setPrefix(spaceNameList.prefix(), spaceNameList.nameUrl());
                }
            }
            serializer.startTag(null, rootElement.name());
        }
        //把字段上面注解的值取出来
        SparseArray<PullXmlElementBean> header = new SparseArray<>();
        SparseArray<PullXmlElementBean> body = new SparseArray<>();
        for (Field field : fields) {
            field.setAccessible(true);
            PullXmlElement element = field.getAnnotation(PullXmlElement.class);
            PullXmlSoapHeader soapHeader = field.getAnnotation(PullXmlSoapHeader.class);
            PullXmlSoapBody soapBody = field.getAnnotation(PullXmlSoapBody.class);
            if (element != null) {
                PullXmlElementBean elementBean = new PullXmlElementBean();
                if (element.isNeed()) {
                    elementBean.setTagName(element.tagName());
                    try {
                        elementBean.setText((String) field.get(value));
                    } catch (IllegalAccessException e) {
                        throw new IOException("获取字段值失败", e);
                    }
                }
                PullXmlElementWrapper wrapper = field.getAnnotation(PullXmlElementWrapper
                        .class);
                if (wrapper != null) {
                    elementBean.setWrapperName(wrapper.tagName());
                    elementBean.setAttributeName(wrapper.attributeName());
                    elementBean.setAttributeValue(wrapper.attributeValue());
                }
                if (soapHeader != null) {
                    header.put(element.tagId(), elementBean);
                } else if (soapBody != null) {
                    body.put(element.tagId(), elementBean);
                }

            }
        }

        //处理请求头
        serializer.startTag(null, "soap:Header");
        for (int i = 0; i < header.size(); i++) {
            PullXmlElementBean elementBean = header.get(i);
            if (elementBean.getWrapperName() == null) {
                continue;
            }
            serializer.startTag(null, elementBean.getWrapperName());
            serializer.attribute(null, elementBean.getAttributeName(), elementBean
                    .getAttributeValue());
        }
        for (int i = 0; i < header.size(); i++) {
            PullXmlElementBean elementBean = header.get(i);
            serializer.startTag(null, elementBean.getTagName());
            serializer.text(elementBean.getText());
            serializer.endTag(null, elementBean.getTagName());
        }
        for (int i = header.size() - 1; i >= 0; i--) {
            PullXmlElementBean elementBean = header.get(i);
            if (elementBean.getWrapperName() == null) {
                continue;
            }
            serializer.endTag(null, elementBean.getWrapperName());
        }
        serializer.endTag(null, "soap:Header");
        //处理请求体
        serializer.startTag(null, "soap:Body");
        for (int i = 0; i < body.size(); i++) {
            PullXmlElementBean elementBean = body.get(i);
            if (elementBean.getWrapperName() == null) {
                continue;
            }
            serializer.startTag(null, elementBean.getWrapperName());
            if (!elementBean.getAttributeName().equals(DEF)) {
                serializer.attribute(null, elementBean.getAttributeName(), elementBean
                        .getAttributeValue());
            }
        }
        for (int i = 0; i < body.size(); i++) {
            PullXmlElementBean elementBean = body.get(i);
            if (elementBean.getTagName() == null) {
                continue;
            }
            serializer.startTag(null, elementBean.getTagName());
            serializer.text(elementBean.getText());
            serializer.endTag(null, elementBean.getTagName());
        }
        for (int i = body.size() - 1; i >= 0; i--) {
            PullXmlElementBean elementBean = body.get(i);
            if (elementBean.getWrapperName() == null) {
                continue;
            }
            serializer.endTag(null, elementBean.getWrapperName());
        }
        serializer.endTag(null, "soap:Body");
        //类结束标签
        if (rootElement != null && !rootElement.name().equals(DEF)) {
            serializer.endTag(null, rootElement.name());
        }
        serializer.endDocument();
        return writer.toString();
    }
}
