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
public class BuisnessManSelectByID {
    @PullXmlSoapHeader
    @PullXmlElementWrapper(tagName = "CredentialSoapHeader", attributeName = "xmlns",
            attributeValue = "http://tempuri.org/")
    @PullXmlElement(tagId = 0, tagName = "UserName")
    private String userName;
    @PullXmlSoapHeader
    @PullXmlElement(tagId = 1, tagName = "Password")
    private String password;

    @PullXmlSoapBody
    @PullXmlElementWrapper(tagName = "BuisnessManSelectByID", attributeName = "xmlns",
            attributeValue = "http://tempuri.org/")
    @PullXmlElement(tagId = 0, tagName = "buisnessManID")
    private String buisnessManID;

    public BuisnessManSelectByID() {
        this.userName = ShopInfo.SUPER.username;
        this.password = ShopInfo.SUPER.password;
        this.buisnessManID = "77504";
    }
}
