package spider;

import java.sql.Timestamp;

import entity.LianJiaNewHouseBean;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author SucreWu
 * @email sucrewu818@gmail.com
 */
public class LianJiaPageProcessor implements PageProcessor {
	
	//DungProxy推荐参数
	private Site site = Site.me()
            .setRetryTimes(3) 
            .setTimeOut(30000)//在使用代理的情况下,这个需要设置,可以考虑调大线程数目
            .setSleepTime(300)//使用代理了之后,代理会通过切换IP来防止反扒。同时,使用代理本身qps降低了,所以这个可以小一些
            .setCycleRetryTimes(3)//这个重试会换IP重试,是setRetryTimes的上一层的重试
            .setUseGzip(true);
	
	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process( Page page) {
		if(page.getUrl().regex("http://sh.fang.lianjia.com/loupan/pg1").match()) {
			//添加列表页
			for(int i=2;i<34;i++) {
				page.addTargetRequest("http://sh.fang.lianjia.com/loupan/pg" + i + "/");
			}
		}
		if(page.getUrl().regex("http://sh.fang.lianjia.com/loupan/\\w++").match()) {
			//添加楼盘详细信息URL
			page.addTargetRequests(page.getHtml().xpath("//div[@class='title-box']/h2/a").links()
					.regex("/detail/\\w+")
					.replace("/detail", "http://sh.fang.lianjia.com/detail")
					.all());
		}else {
			LianJiaNewHouseBean bean = new LianJiaNewHouseBean();
			//id
			bean.setId(page.getUrl().regex("/detail/\\w+").toString().replaceAll("/detail/", ""));
			//楼盘名称
			bean.setName(page.getHtml().xpath("//div[@class='title-row']/h1/text()").toString());
			//楼盘别名
			if(page.getHtml().xpath("//div[@class='alias-row']/span/text()").toString() == null) {
				bean.setAlias("");
			}else {
				bean.setAlias(page.getHtml().xpath("//div[@class='alias-row']/span/text()").toString().replaceAll("别名：", ""));
			}
			//楼盘类型标签
			bean.setType(page.getHtml().xpath("//div[@class='title-row']/span[@class='type label']/text()").toString());
			//销售状态
			bean.setStatus(page.getHtml().xpath("//div[@class='title-row']/span[@class='status label']/text()").toString());
			if("在售".equals(bean.getStatus()) || "尾盘".equals(bean.getStatus())) {
				if("万/套".equals(page.getHtml().xpath("//div[@class='price-row']/div[@class='left']/span[1]/span[@class='unit price']/text()").toString())) {
					bean.setAveragePrice(Integer.valueOf(
							page.getHtml().xpath("//div[@class='price-row']/div[@class='left']/span[2]/span[@class='info']/text()").toString().replaceAll("元/㎡", "")
					));
				}else if ("元/㎡".equals(page.getHtml().xpath("//div[@class='price-row']/div[@class='left']/span[1]/span[@class='unit price']/text()").toString())) {
					bean.setAveragePrice(Integer.valueOf(
							page.getHtml().xpath("//div[@class='price-row']/div[@class='left']/span[1]/span[@class='num price']/text()").toString()
					));
				}
			}else if ("售完".equals(bean.getStatus())) {
				bean.setAveragePrice(-1);
			}else if ("待售".equals(bean.getStatus())) {
				bean.setAveragePrice(0);
			}
			
			//户型面积
			bean.setArea(page.getHtml().xpath("//div[@class='price-row']/div[@class='right']/allText()").toString());
			//经度
			bean.setLongitude(page.getHtml().xpath("//div[@id='zoneMap']/@longitude").toString());
			//纬度
			bean.setLatitude(page.getHtml().xpath("//div[@id='zoneMap']/@latitude").toString());
			//地址
			bean.setAddress(page.getHtml().xpath("//div[@class='box-loupan']/p[2]/span[@class='label-val']/text()").toString().trim());
			//开发商
			bean.setDeveloper(page.getHtml().xpath("//div[@class='box-loupan']/p[3]/span[@class='label-val']/text()").toString().trim());
			//物业公司
			bean.setPropertyCompany(page.getHtml().xpath("//div[@class='box-loupan']/p[4]/span[@class='label-val']/text()").toString().trim());
			//咨询电话
			bean.setTelphone(page.getHtml().xpath("//div[@class='box-loupan']/ul[@class='table-list clear']/li[1]/p/span[@class='label-val']/text()").toString().trim());
			//规划户数
			bean.setPlannedHouseholds(page.getHtml().xpath("//div[@class='box-loupan']/ul[@class='table-list clear']/li[2]/p/span[@class='label-val']/text()").toString().trim());
			//装修状况
			bean.setDecoType(page.getHtml().xpath("//div[@class='box-loupan']/ul[@class='table-list clear']/li[3]/p/span[@class='label-val']/text()").toString().trim());
			//产权年限
			bean.setPropertyTerm(page.getHtml().xpath("//div[@class='box-loupan']/ul[@class='table-list clear']/li[4]/p/span[@class='label-val']/text()").toString().trim().replaceAll("年", ""));
			//最新开盘
			bean.setLatestOpeningTime(page.getHtml().xpath("//div[@class='box-loupan']/ul[@class='table-list clear']/li[5]/p/span[@class='label-val']/text()").toString().trim());
			//容积率
			bean.setVolumetricRate(page.getHtml().xpath("//div[@class='box-loupan']/ul[@class='table-list clear']/li[6]/p/span[@class='label-val']/text()").toString().trim());
			//交房时间
			bean.setSubmitTime(page.getHtml().xpath("//div[@class='box-loupan']/ul[@class='table-list clear']/li[7]/p/span[@class='label-val']/text()").toString().trim());
			//绿化率
			bean.setGreenCoverage(page.getHtml().xpath("//div[@class='box-loupan']/ul[@class='table-list clear']/li[8]/p/span[@class='label-val']/text()").toString().trim());
			//物业费
			bean.setPropertyCosts(page.getHtml().xpath("//div[@class='box-loupan']/ul[@class='table-list clear']/li[9]/p/span[@class='label-val']/text()").toString().trim());
			//车位状况
			bean.setParkingCondition(page.getHtml().xpath("//div[@class='box-loupan']/ul[@class='table-list clear']/li[10]/p/span[@class='label-val']/text()").toString().trim());
			//用水用电
			bean.setWaterAndElectricity(page.getHtml().xpath("//div[@class='box-loupan']/ul[@class='table-list clear']/li[11]/p/span[@class='label-val']/text()").toString().trim());
			//插入时间
			bean.setInsertTime(new Timestamp(System.currentTimeMillis()));
			//修改时间
			bean.setUpdateTime(bean.getInsertTime());
			
			
			page.putField("newHouse", bean);
		}
	}
	
	
}
