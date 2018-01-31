package pipeline;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import entity.LianJiaNewHouseBean;
import mapper.LianJiaNewHouseMapper;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author SucreWu
 * @email sucrewu818@gmail.com
 */
public class LianJiaNewHousePipeline implements Pipeline{
	
	private Logger logger = Logger.getLogger(LianJiaNewHousePipeline.class);
	//会话工厂
	private SqlSessionFactory sqlSessionFactory; 
	//实体类集合
	private List<LianJiaNewHouseBean> list = new ArrayList<LianJiaNewHouseBean>();
	
	public LianJiaNewHousePipeline() {
		super();
	}
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		LianJiaNewHouseBean bean = resultItems.get("newHouse");
		//因为不是所有页面都需要抽取信息，所以需要进行空判断
		if(bean!=null) {
			list.add(bean);
		}
	}
	
	
	/**
	 * 数据库连接初始化
	 * @throws Exception
	 */
	public void setup() throws Exception{  
        //创建SqlSessionFactory  
        String resource="SqlMapConfig.xml";  
        //将配置文件加载成流  
        InputStream inputStream = Resources.getResourceAsStream(resource);  
        //创建会话工厂，传入mybatis配置文件的信息  
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);  
    } 
	
	/**
	 * 持久化到数据库
	 */
	public void insert() {
		try {
			setup();
			SqlSession sqlSession=sqlSessionFactory.openSession();  
	        //创建Mapper代理对象  
			LianJiaNewHouseMapper mapper=sqlSession.getMapper(LianJiaNewHouseMapper.class);  
	        //调用Mapper的方法  
			mapper.insertNewHouse(list);
			//事务提交
			sqlSession.commit();
			//释放资源
			sqlSession.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
		}

	}
}
