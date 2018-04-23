package com.jjkj.administrator.storecontrollersystem.utils.requset;

import com.jjkj.administrator.storecontrollersystem.bean.ShopInfo;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlElement;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlElementWrapper;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlNameSpace;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlRootElement;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlSoapBody;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlSoapHeader;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlSpaceNameList;

/**
 * @author Administrator
 */
@SuppressWarnings("unused")
@PullXmlRootElement(name = "soap:Envelope")
@PullXmlNameSpace(spaceNameList = {
        @PullXmlSpaceNameList(nameUrl = "http://schemas.xmlsoap.org/soap/envelope/", prefix =
                "soap"),
        @PullXmlSpaceNameList(nameUrl = "http://www.w3.org/2001/XMLSchema-instance", prefix =
                "xsi"),
        @PullXmlSpaceNameList(nameUrl = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),

})
public class WritePosBalanceDate {
    @PullXmlSoapHeader
    @PullXmlElementWrapper(tagName = "CredentialSoapHeader", attributeName = "xmlns",
            attributeValue = "http://www.myregent.cn/")
    @PullXmlElement(tagId = 0, tagName = "UserName")
    private String userName;
    @PullXmlSoapHeader
    @PullXmlElement(tagId = 1, tagName = "Password")
    private String password;

    @PullXmlSoapBody
    @PullXmlElementWrapper(tagName = "WritePosBalanceDate2", attributeName = "xmlns",
            attributeValue = "http://www.myregent.cn/")
    @PullXmlElement(tagId = 0, tagName = "customerId")
    private String customerId;
    @PullXmlSoapBody
    @PullXmlElement(tagId = 1, tagName = "date")
    private String date;
    @PullXmlSoapBody
    @PullXmlElement(tagId = 2, tagName = "reserveMoney")
    private String reserveMoney;
    @PullXmlSoapBody
    @PullXmlElement(tagId = 3, tagName = "returnId")
    private String returnId;
    @PullXmlSoapBody
    @PullXmlElement(tagId = 4, tagName = "returnMessage")
    private String returnMessage;

    public WritePosBalanceDate(String date, String storeNumber) {
        this.userName = ShopInfo.SUPER.username;
        this.password = ShopInfo.SUPER.password;
        this.customerId = storeNumber;
        this.date = date;
        this.reserveMoney = "0";
        this.returnId = "0";
        this.returnMessage = "";
    }
}
