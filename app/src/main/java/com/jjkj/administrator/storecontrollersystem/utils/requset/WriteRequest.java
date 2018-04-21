package com.jjkj.administrator.storecontrollersystem.utils.requset;

import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlElement;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlElementWrapper;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlNameSpace;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlRootElement;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlSpaceNameList;

/**
 * @author Administrator
 */
@SuppressWarnings("all")
@PullXmlRootElement(name = "soap:Envelope")
@PullXmlNameSpace(spaceNameList = {
        @PullXmlSpaceNameList(nameUrl = "http://schemas.xmlsoap.org/soap/envelope/", prefix =
                "soap"),
        @PullXmlSpaceNameList(nameUrl = "http://www.w3.org/2001/XMLSchema-instance", prefix =
                "xsi"),
        @PullXmlSpaceNameList(nameUrl = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),

})
public class WriteRequest {
    @PullXmlElementWrapper(attributeName = "xmlns",
            attributeValue = "http://service.mobile.com/"
            ,  tagName = "writeObjectOut")
    private String xmlns;
    @PullXmlElementWrapper(tagName = "soap:Body")
    private String soapBody;
    @PullXmlElement(tagName = "QueryXmlDoc", tagId = 3)
    private String xmlDoc;
    @PullXmlElement(tagName = "jkid", tagId = 2)
    private String interfaceId;
    @PullXmlElement(tagName = "jkxlh", tagId = 1)
    private String serialNumber;
    @PullXmlElement(tagName = "xtlb", tagId = 0)
    private String xtlb;

    public WriteRequest() {
        this.soapBody = "";
        this.xmlns = "";
        this.serialNumber = "";
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getSoapBody() {
        return soapBody;
    }

    public void setSoapBody(String soapBody) {
        this.soapBody = soapBody;
    }

    public String getXmlDoc() {
        return xmlDoc;
    }

    public void setXmlDoc(String xmlDoc) {
        this.xmlDoc = xmlDoc;
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getXtlb() {
        return xtlb;
    }

    public void setXtlb(String xtlb) {
        this.xtlb = xtlb;
    }
}
