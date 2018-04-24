package com.jjkj.administrator.storecontrollersystem.utils.requset;

import com.jjkj.administrator.storecontrollersystem.bean.ShopInfo;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlElement;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlElementWrapper;
import com.jjkj.administrator.storecontrollersystem.utils.pull.PullXmlListElement;
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
public class GetCustomerVipListByFilter {
    @PullXmlSoapHeader
    @PullXmlElementWrapper(tagName = "CredentialSoapHeader", attributeName = "xmlns",
            attributeValue = "http://tempuri.org/")
    @PullXmlElement(tagId = 0, tagName = "UserName")
    private String userName;
    @PullXmlSoapHeader
    @PullXmlElement(tagId = 1, tagName = "Password")
    private String password;


    @PullXmlSoapBody
    @PullXmlElementWrapper(tagName = "GetCustomerVipListByFilter", attributeName = "xmlns",
            attributeValue = "http://www.myregent.cn/")
    @PullXmlElement(tagId = 0, tagName = "userNo")
    private String userNo;
    @PullXmlSoapBody
    @PullXmlListElement(tagId = 1, tagName = "filter")
    private String filter;
    @PullXmlSoapBody
    @PullXmlElement(tagId = 2, tagName = "userNo")
    private String returnId;
    @PullXmlSoapBody
    @PullXmlElement(tagId = 3, tagName = "userNo")
    private String returnMessage;
    @PullXmlSoapBody
    @PullXmlElement(tagId = 4, tagName = "userNo")
    private String PageIndex;
    @PullXmlSoapBody
    @PullXmlElement(tagId = 5, tagName = "userNo")
    private String PageSize;
    @PullXmlSoapBody
    @PullXmlElement(tagId = 6, tagName = "userNo")
    private String TotalRecord;


    public GetCustomerVipListByFilter(String userNo) {
        this.userName = ShopInfo.SUPER.username;
        this.password = ShopInfo.SUPER.password;
        this.userNo = userNo;
        this.filter = "";
        this.returnId = "0";
        this.returnMessage = "";
        this.PageIndex = "1";
        this.PageSize = "500";
        this.TotalRecord = "0";
    }
}
