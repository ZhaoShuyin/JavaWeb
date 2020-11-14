package mybatis.demo.mapper;

import java.util.List;

import mybatis.demo.po.Orders;
import mybatis.demo.po.OrdersCustom;
import mybatis.demo.po.User;


/**
 * 订单接口
 * @author JD
 *
 */
public interface OrdersMapper {

	/**
	 * 查询订单细信息并关联查询用户用信息   resultType实现
	 * @return
	 * @throws Exception
	 */
	public List<OrdersCustom> queryOrdersAndUserByResultType() throws Exception;
	
	/**
	 * 查询订单细信息并关联查询用户用信息   resultMap实现
	 * @return
	 * @throws Exception
	 */
	public List<Orders> queryOrdersAndUserByResultMap() throws Exception;
	
	/**
	 * 查询订单细信息并关联查询明细信息
	 * @return
	 * @throws Exception
	 */
	public List<Orders> queryOrdersAndDetailByResultMap() throws Exception;
	
	/**
	 * 查询用户信息并关联查询商品信息
	 * @return
	 * @throws Exception
	 */
	public List<User> queryAll() throws Exception;
	
	/**
	 * 查询订单信息，延迟加载用户
	 * @return
	 * @throws Exception
	 */
	public List<Orders> queryOrdersLazyLoadingByUser() throws Exception;
	
	/**
	 * mybatis的一级缓存
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User queryUserById(int id) throws Exception;
	public void updateUserById(User user) throws Exception;
}
