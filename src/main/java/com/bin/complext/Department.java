package com.bin.complext;

/**
 * 1.Department是模型,实际录入的是Department.deptName可以直接写到
 * 	s:textfield的name属性中,那么mgr属性如何处理?
 * 	> struts表单标签的name属性可以被赋值为属性的属性:name=department.mgr.name
 * 2.mgr中有一个Date类型的birth属性,Struts2可以自动完成类型的转换吗?
 * 	> 转换器还可以正常工作.
 */
public class Department {
	private Integer id ;
	private String deptName ;
	
	private Manager mgr ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public Manager getMgr() {
		return mgr;
	}

	public void setMgr(Manager mgr) {
		this.mgr = mgr;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", manager=" + mgr + "]";
	}

	public Department(Integer id, String deptName, Manager manager) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.mgr = manager;
	}
	
	public Department() {
	}
}
