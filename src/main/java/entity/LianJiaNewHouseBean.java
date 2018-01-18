package entity;

import java.sql.Timestamp;

/**
 * @author SucreWu
 * @email sucrewu818@gmail.com
 */
public class LianJiaNewHouseBean {
	
	//主键
	private String id;
	//名称
	private String name ;
	//别名
	private String alias ;
	//均价（单位：元/㎡）
	private int averagePrice;
	//地址
	private String address;
	//开发商
	private String developer;
	//物业公司
	private String propertyCompany;
	//咨询电话
	private String telphone;
	//装修情况
	private String decoType;
	//最新开盘
	private String latestOpeningTime;
	//交房时间
	private String submitTime;
	//用水用电
	private String waterAndElectricity;
	//物业费
	private String propertyCosts;
	//规划户数
	private String plannedHouseholds;
	//产权年限
	private String propertyTerm;
	//容积率
	private String volumetricRate;
	//绿化率
	private String greenCoverage;
	//车位状况
	private String parkingCondition;
	//房产标签
	private String type;
	//销售状态
	private String status;
	//户型面积
	private String area;
	//经度
	private String longitude;
	//纬度
	private String latitude;
	//区县
	private String region;
	//插入时间
	private Timestamp insertTime;
	//更新时间
	private Timestamp updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public int getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(int averagePrice) {
		this.averagePrice = averagePrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getPropertyCompany() {
		return propertyCompany;
	}
	public void setPropertyCompany(String propertyCompany) {
		this.propertyCompany = propertyCompany;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getDecoType() {
		return decoType;
	}
	public void setDecoType(String decoType) {
		this.decoType = decoType;
	}
	public String getLatestOpeningTime() {
		return latestOpeningTime;
	}
	public void setLatestOpeningTime(String latestOpeningTime) {
		this.latestOpeningTime = latestOpeningTime;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getWaterAndElectricity() {
		return waterAndElectricity;
	}
	public void setWaterAndElectricity(String waterAndElectricity) {
		this.waterAndElectricity = waterAndElectricity;
	}
	public String getPropertyCosts() {
		return propertyCosts;
	}
	public void setPropertyCosts(String propertyCosts) {
		this.propertyCosts = propertyCosts;
	}
	public String getPlannedHouseholds() {
		return plannedHouseholds;
	}
	public void setPlannedHouseholds(String plannedHouseholds) {
		this.plannedHouseholds = plannedHouseholds;
	}
	public String getPropertyTerm() {
		return propertyTerm;
	}
	public void setPropertyTerm(String propertyTerm) {
		this.propertyTerm = propertyTerm;
	}
	public String getVolumetricRate() {
		return volumetricRate;
	}
	public void setVolumetricRate(String volumetricRate) {
		this.volumetricRate = volumetricRate;
	}
	public String getGreenCoverage() {
		return greenCoverage;
	}
	public void setGreenCoverage(String greenCoverage) {
		this.greenCoverage = greenCoverage;
	}
	public String getParkingCondition() {
		return parkingCondition;
	}
	public void setParkingCondition(String parkingCondition) {
		this.parkingCondition = parkingCondition;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Timestamp getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "LianJiaNewHouseBean [id=" + id + ", name=" + name + ", alias=" + alias + ", averagePrice="
				+ averagePrice + ", address=" + address + ", developer=" + developer + ", propertyCompany="
				+ propertyCompany + ", telphone=" + telphone + ", decoType=" + decoType + ", latestOpeningTime="
				+ latestOpeningTime + ", submitTime=" + submitTime + ", waterAndElectricity=" + waterAndElectricity
				+ ", propertyCosts=" + propertyCosts + ", plannedHouseholds=" + plannedHouseholds + ", propertyTerm="
				+ propertyTerm + ", volumetricRate=" + volumetricRate + ", greenCoverage=" + greenCoverage
				+ ", parkingCondition=" + parkingCondition + ", type=" + type + ", status=" + status + ", area=" + area
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", region=" + region + ", insertTime="
				+ insertTime + ", updateTime=" + updateTime + "]";
	}
	
}
