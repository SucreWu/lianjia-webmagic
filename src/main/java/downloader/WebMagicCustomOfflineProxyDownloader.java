package downloader;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.virjar.dungproxy.webmagic7.DungProxyDownloader;

import us.codecraft.webmagic.Page;

public class WebMagicCustomOfflineProxyDownloader extends DungProxyDownloader {
	@Override
    protected boolean needOfflineProxy(Page page) {
        if( super.needOfflineProxy(page)){//父类默认下线 401和403,你也可以不调用
            return true;
        }else{
            return StringUtils.containsIgnoreCase(page.getRawText(), "包含这个关键字,代表IP被封禁");
        }
    }
    @Override
    protected boolean needOfflineProxy(IOException e) {
        //return e instanceof SSLException;//如果异常类型是SSL,代表IP被封禁,你也可以不实现
        return false;
    }
}
