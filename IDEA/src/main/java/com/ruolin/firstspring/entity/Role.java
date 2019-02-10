package com.ruolin.firstspring.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author ruolin
 * @since 2019-01-24
 */
public class Role extends Model<User> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String rolename;


	public Integer getId() {
		return id;
	}

	public Role setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getRolename() {
		return rolename;
	}

	public Role setRolename(String rolename) {
		this.rolename = rolename;
		return this;
	}

	public static final String ID = "id";

	public static final String ROLENAME = "rolename";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Role{" +
			", id=" + id +
			", rolename=" + rolename +
			"}";
	}
}
