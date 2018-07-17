package com.gap.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.dao.CustomerDao;
import com.gap.domain.Customer;
import com.gap.service.CustomerService;
import com.gap.utils.MD5Utils;
import com.gap.utils.PageBean;



public class CustomerServiceImpl implements CustomerService {
	private CustomerDao cd;
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	/**获取分页信息*/
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = cd.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中
		pb.setList(list);
		//5 结果返回
		return pb;
	}

	/**系统管理员的新增消费者功能，貌似没啥用了*/
	@Override
	public void save(Customer customer) {
		if (customer.getPhoneNumber_cus()==null) {//新增用户,需要校验用户是否存在
			Customer existC =  cd.getByUserCode(customer.getPhoneNumber_cus());  //1 调用Dao根据注册的登陆名获得用户对象
			if (existC != null) {
				throw new RuntimeException("用户名已经存在!");  //2 如果获得到user对象,用户名已经存在,抛出异常
			}
		}
		//使用MD5对密码进行加密
		//customer.setPassword_cus(MD5Utils.md5(customer.getPassword_cus()));
		cd.saveOrUpdate(customer);
	}

	@Override
	public Customer getById(Long cust_id) {
		return cd.getById(cust_id);
	}

	@Override
	public List<Object[]> getIndustryCount() {
		return cd.getIndustryCount();
	}




	@Override
	public void saveCustomer(Customer customer) {
/*		if (customer.getId_cus()==null) {//新增用户,需要校验用户是否存在
			//1 调用Dao根据注册的登陆名获得用户对象
			Customer existC =  cd.getById(customer.getId_cus());
			if (existC != null) {
				//2 如果获得到user对象,用户名已经存在,抛出异常
				throw new RuntimeException("用户名已经存在!");
			}
		}
*/		//使用MD5对密码进行加密
		customer.setPassword_cus(MD5Utils.md5(customer.getPassword_cus()));
		//3 调用Dao执行保存
		cd.saveOrUpdate(customer);

	}


	@Override
	public void deleteById(Long id_cus) {
		// TODO Auto-generated method stub
		cd.delete(id_cus);
	}

	/** 【系统管理员模块】修改用户权限*/
	@Override
	public void modifyOpenAuthorization(Customer customer) {
		customer.setCondition_cus("1");
		cd.saveOrUpdate(customer);
	}


	//登录
	@Override
	public Customer getCustomerByPhonePassword(Customer cus) {
		Customer getCus = cd.getByUserCode(cus.getPhoneNumber_cus());
		if (getCus==null){
			throw new RuntimeException("您输入的用户名不存在！");
		}
		if (!getCus.getPassword_cus().equals(cus.getPassword_cus())){
			throw new RuntimeException("您输入的密码错误！");
		}
		return getCus;
	}

	@Override
	public boolean getCustomerByPhone(String phoneNumber_cus) {
		Customer checkCus = cd.getByUserCode(phoneNumber_cus);
		if (checkCus != null){
			return true;
		}else{
			return false;
		}
	}


}
