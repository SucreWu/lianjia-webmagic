package mapper;

import java.util.List;

import entity.LianJiaNewHouseBean;

/**
 * @author SucreWu
 * @email sucrewu818@gmail.com
 */
public interface  LianJiaNewHouseMapper {
	//添加用户信息
    public void insertNewHouse(List<LianJiaNewHouseBean> list) throws Exception;
}
