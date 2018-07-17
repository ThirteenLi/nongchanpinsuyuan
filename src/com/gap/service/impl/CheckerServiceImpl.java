package com.gap.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.dao.CheckerDao;
import com.gap.domain.Checker;
import com.gap.service.CheckerService;
import com.gap.service.CustomerService;
import com.gap.utils.MD5Utils;
import com.gap.utils.PageBean;



public class CheckerServiceImpl implements CheckerService {
	private CheckerDao checkerd;
	public void setCheckerd(CheckerDao checkerd) {
		this.checkerd = checkerd;
	}

	/**获取分页信息*/
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount = checkerd.getTotalCount(dc);  //1 调用Dao查询总记录数
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);  //2 创建PageBean对象
		List<Checker> list = checkerd.getPageList(dc,pb.getStart(),pb.getPageSize());  //3 调用Dao查询分页列表数据
		pb.setList(list);//4 列表数据放入pageBean中.并返回
		return pb;
	}

	/**系统管理员的新增消费者功能，貌似没啥用了*/
	@Override
	public void save(Checker checker) {
		if (checker.getUsername_zjy()==null) {//新增用户,需要校验用户是否存在
			Checker existC =  checkerd.getByUserCode(checker.getUsername_zjy());  //1 调用Dao根据注册的登陆名获得用户对象
			if (existC != null) {
				throw new RuntimeException("用户名已经存在!");  //2 如果获得到user对象,用户名已经存在,抛出异常
			}
		}
		//使用MD5对密码进行加密
		//customer.setPassword_cus(MD5Utils.md5(customer.getPassword_cus()));
		checkerd.saveOrUpdate(checker);
	}

	@Override
	public Checker getById(Long id_zjy) {
		return checkerd.getById(id_zjy);
	}

	@Override
	public List<Object[]> getIndustryCount() {
		return checkerd.getIndustryCount();
	}




	@Override
	public void saveCustomer(Checker checker) {
/*		if (customer.getId_cus()==null) {//新增用户,需要校验用户是否存在
			//1 调用Dao根据注册的登陆名获得用户对象
			Customer existC =  cd.getById(customer.getId_cus());
			if (existC != null) {
				//2 如果获得到user对象,用户名已经存在,抛出异常
				throw new RuntimeException("用户名已经存在!");
			} 
		}
*/		//使用MD5对密码进行加密
		checker.setPassword_zjy(MD5Utils.md5(checker.getPassword_zjy()));
		//3 调用Dao执行保存
		checkerd.saveOrUpdate(checker);

	}


	@Override
	public void deleteById(Long id_zjy) {
		// TODO Auto-generated method stub
		checkerd.delete(id_zjy);
	}

	/** 【系统管理员模块】修改用户权限*/
	@Override
	public void modifyOpenAuthorization(Checker checker) {
		checker.setCondition_zjy("1");
		checkerd.saveOrUpdate(checker);
	}


	//登录
	@Override

	public Checker getCheckerByUserNamePassword(Checker checker) {
		Checker getChecker = checkerd.getByUserCode(checker.getUsername_zjy());
		if (getChecker==null){
			throw new RuntimeException("您输入的用户名不存在！");
		}
		if (!getChecker.getPassword_zjy().equals(checker.getPassword_zjy())){
			throw new RuntimeException("您输入的密码错误！");
		}
		return getChecker;
	}




}
