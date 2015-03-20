package com.platform.shiro.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
* @ClassName: Organization 
* @Description: 组织
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午1:59:05 
*
 */
public class Organization implements Serializable {
    private Long id;

    private String orgName;

    private String orgCode;

    private String orgWebsite;

    private String orgPic;

    private String orgAddress;

    private Short regionId;

    private BigDecimal orgLng;

    private BigDecimal orgLat;

    private String city;

    private String province;

    private String keywords;

    private String message;

    private String busline;

    private String orgRule;

    private String orgContact;

    private String orgTel;

    private String vipPhone;

    private String orgEmail;

    private String backAddress;

    private String backContact;

    private String backTel;

    private String openTime;

    private String orgGrade;

    private Short orgRank;

    private Short orgProinfo;

    private Short isMi;

    private Short isDelete;

    private String orgLnk;

    private Date createtime;

    private Date updatetime;

    private Long parentId;

    private String parentIds;

    private String mallId;
    
    private String storeId;

    private String orgDesc;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgWebsite() {
        return orgWebsite;
    }

    public void setOrgWebsite(String orgWebsite) {
        this.orgWebsite = orgWebsite == null ? null : orgWebsite.trim();
    }

    public String getOrgPic() {
        return orgPic;
    }

    public void setOrgPic(String orgPic) {
        this.orgPic = orgPic == null ? null : orgPic.trim();
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
    }

    public Short getRegionId() {
        return regionId;
    }

    public void setRegionId(Short regionId) {
        this.regionId = regionId;
    }

    public BigDecimal getOrgLng() {
        return orgLng;
    }

    public void setOrgLng(BigDecimal orgLng) {
        this.orgLng = orgLng;
    }

    public BigDecimal getOrgLat() {
        return orgLat;
    }

    public void setOrgLat(BigDecimal orgLat) {
        this.orgLat = orgLat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getBusline() {
        return busline;
    }

    public void setBusline(String busline) {
        this.busline = busline == null ? null : busline.trim();
    }

    public String getOrgRule() {
        return orgRule;
    }

    public void setOrgRule(String orgRule) {
        this.orgRule = orgRule == null ? null : orgRule.trim();
    }

    public String getOrgContact() {
        return orgContact;
    }

    public void setOrgContact(String orgContact) {
        this.orgContact = orgContact == null ? null : orgContact.trim();
    }

    public String getOrgTel() {
        return orgTel;
    }

    public void setOrgTel(String orgTel) {
        this.orgTel = orgTel == null ? null : orgTel.trim();
    }

    public String getVipPhone() {
        return vipPhone;
    }

    public void setVipPhone(String vipPhone) {
        this.vipPhone = vipPhone == null ? null : vipPhone.trim();
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail == null ? null : orgEmail.trim();
    }

    public String getBackAddress() {
        return backAddress;
    }

    public void setBackAddress(String backAddress) {
        this.backAddress = backAddress == null ? null : backAddress.trim();
    }

    public String getBackContact() {
        return backContact;
    }

    public void setBackContact(String backContact) {
        this.backContact = backContact == null ? null : backContact.trim();
    }

    public String getBackTel() {
        return backTel;
    }

    public void setBackTel(String backTel) {
        this.backTel = backTel == null ? null : backTel.trim();
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime == null ? null : openTime.trim();
    }

    public String getOrgGrade() {
        return orgGrade;
    }

    public void setOrgGrade(String orgGrade) {
        this.orgGrade = orgGrade == null ? null : orgGrade.trim();
    }

    public Short getOrgRank() {
        return orgRank;
    }

    public void setOrgRank(Short orgRank) {
        this.orgRank = orgRank;
    }

    public Short getOrgProinfo() {
        return orgProinfo;
    }

    public void setOrgProinfo(Short orgProinfo) {
        this.orgProinfo = orgProinfo;
    }

    public Short getIsMi() {
        return isMi;
    }

    public void setIsMi(Short isMi) {
        this.isMi = isMi;
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    public String getOrgLnk() {
        return orgLnk;
    }

    public void setOrgLnk(String orgLnk) {
        this.orgLnk = orgLnk == null ? null : orgLnk.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId == null ? null : parentId;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    public String getMallId() {
        return mallId;
    }

    public void setMallId(String mallId) {
        this.mallId = mallId == null ? null : mallId.trim();
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc == null ? null : orgDesc.trim();
    }
	
	
	
	
	
	
	
	
    //private Long id; //编号
    //private String name; //组织机构名称
    //private Long parentId; //父编�?
    //private String parentIds; //父编号列表，�?1/2/
    //private Boolean available = Boolean.FALSE;



    public boolean isRootNode() {
        return parentId == 0;
    }

    public String makeSelfAsParentIds() {
        return getParentIds() + id + "/";
    }


    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", orgName='" + orgName + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", orgCode=" + orgCode +
                '}';
    }

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
}
