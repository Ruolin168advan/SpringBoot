package com.ruolin.firstspring.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author ruolin
 * @since 2019-01-28
 */
public class Permission extends Model<User> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String pername;
	private Integer roleid;


	public Integer getId() {
		return id;
	}

	public Permission setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getPername() {
		return pername;
	}

	public Permission setPername(String pername) {
		this.pername = pername;
		return this;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public Permission setRoleid(Integer roleid) {
		this.roleid = roleid;
		return this;
	}

	public static final String ID = "id";

	public static final String PERNAME = "pername";

	public static final String ROLEID = "roleid";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Permission{" +
			", id=" + id +
			", pername=" + pername +
			", roleid=" + roleid +
			"}";
	}
}
