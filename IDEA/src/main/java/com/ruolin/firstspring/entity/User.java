package com.ruolin.firstspring.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 
 * </p>
 *
 * @author ruolin
 * @since 2019-01-24
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String uname;
	private String upwd;
	private Integer roleid;


	public Integer getId() {
		return id;
	}

	public User setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getUname() {
		return uname;
	}

	public User setUname(String uname) {
		this.uname = uname;
		return this;
	}

	public String getUpwd() {
		return upwd;
	}

	public User setUpwd(String upwd) {
		this.upwd = upwd;
		return this;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public User setRoleid(Integer roleid) {
		this.roleid = roleid;
		return this;
	}

	public static final String ID = "id";

	public static final String UNAME = "uname";

	public static final String UPWD = "upwd";

	public static final String ROLEID = "roleid";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			", id=" + id +
			", uname=" + uname +
			", upwd=" + upwd +
			", roleid=" + roleid +
			"}";
	}

}
