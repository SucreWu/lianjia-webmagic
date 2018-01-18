package main;

import downloader.WebMagicCustomOfflineProxyDownloader;
import pipeline.LianJiaNewHousePipeline;
import spider.LianJiaPageProcessor;
import us.codecraft.webmagic.Spider;


/**
 * @author SucreWu
 * @email sucrewu818@gmail.com
 */
public class LianJiaSpiderLoader {
	public static void main(String[] args) {
		LianJiaNewHousePipeline pipeline = new LianJiaNewHousePipeline();
		long startTime, endTime;
		startTime = System.currentTimeMillis();
		Spider.create(new LianJiaPageProcessor()).addUrl("http://sh.fang.lianjia.com/loupan/pg1")
			.setDownloader(new WebMagicCustomOfflineProxyDownloader())
			.addPipeline(pipeline)
			.thread(5)
			.run();
		endTime = System.currentTimeMillis();
		pipeline.insert();
		System.out.println("爬虫共耗时" + ((endTime - startTime) / 1000) + "秒");
	}
}
	