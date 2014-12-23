package com.bin.crud;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction implements RequestAware,ModelDriven<Employee>,Preparable{
	private Dao dao= new Dao() ;
	private Employee employee ;
	// 需要在当前的EmployeeActin中定义Employee属性.以接收页面请求参数.
	private Integer employeeId ;
	
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String list() {
		request.put("emps", dao.getEmployees()) ;
		
		return "list" ;
	}
	
	public String edit() {
		// 1.获取传入的EmployeeId:employee.getEmployeeId()
		
		// 2.根据EmployeeId获取Employee对象.
//		Employee emp = dao.get(employee.getEmployeeId()) ;
		// 3.把栈顶对象的属性装配好.
		// 目前的Employee对象只有employeeId属性,其它属性为null;
		/*
		 * Struts2表单回显时:从值栈栈顶开始查找匹配的属性,若找到就添加到value属性中.
		 */
		// ① 太麻烦
//		employee.setEmail(emp.getEmail());
//		employee.setFirstName(emp.getFirstName());
//		employee.setLastName(emp.getLastName());
		
		
		// ② 不能实现回显.栈顶Employee对象根本就没有被改变属性.
		//employee = dao.get(employee.getEmployeeId()) ;
		
		// ③ 手工压入栈顶,可以实现回显,但是值栈中有两个Employee对象.
		//ActionContext.getContext().getValueStack().push(dao.get(employee.getEmployeeId()));
		
		// ④ 修改getModel()方法实现.
		
		return "edit" ;
	}
	
	public void prepareEdit() {
		employee = dao.get(employeeId) ;
	}
	
	public String delete() {
		dao.delete(employeeId);
		// 返回结果的类型:redirectAction.也可以是chain.实际上chain是没有必要的.因为不需要在下一个Action中保留当前Action的状态.
		// 还有,若使用chain,则到达目标页面后地址栏显示的依然 删除 那个连接,刷新时会有重复提交.
		
		return "success" ;
	}
	
	public String save(){
		// 1.获取请求参数:通过定义对应属性的方式.
		
		// 2.调用Dao的save方法
		dao.save(employee);
		// 3.通过redirectAction的方式返回到emp-list页面
		
		return "success" ;
	}
	public void prepareSave() {
		employee = new Employee() ;
	}
	
	public String update(){
		dao.update(employee);
		return "success" ;
	}
	public void prepareUpdate() {
		// employee这个属性是要被压入栈顶的.
		employee = new Employee() ;
	}

	private Map<String,Object> request ;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request ;
	}

	@Override
	public Employee getModel() {
		// 判断是Create还是Edit.
		// 若为Create,则employee employee = new Employee() ;
		// 若为Edit,则employee = dao.get(employeeId)
		// 判断标准为:是否有employeeId..若通过employeeId来判断,则需要在modelDriven拦截器之前先执行一个params拦截器,这样才会有值!
		// 这个可以使用,paramsPrepareParams拦截器栈实现.
		// 需要在Struts.xml文件中配置使用paramsPrepareParams作为拦截器栈.
		
//		employee = new Employee() ;
		return employee;
		
		//TODO 发现这个方法,每次请求,调用了两次到三次 ;这里有数据库访问,也就是至少两次数据库访问,这种方案是否真的最好?
	}

	/** 
	 * prepare方法的主要作用:为getModel()准备model的.这个拦截器先于ModelDriven拦截器执行.
	 */
	@Override
	public void prepare() throws Exception {
		System.out.println("prepare....方法执行!");
		/*
		 * 这个方法可以关掉不执行, 默认情况是会执行.如过不想执行,方法体空着就行了.
		 * 这个方法可以用来准备一些各个方法(是所有方法)共用类的数据..
		 */
		// 以下代码用不着了.
//		if (employeeId == null) {
//			employee= new Employee() ;
//		} else {
//			employee = dao.get(employeeId) ;
//		}
	}
	

}
