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
public class Equipment extends Model<Equipment> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String egroup;
	private String num;
	private String ename;
	private String type;
	private String address;


	public Integer getId() {
		return id;
	}

	public Equipment setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getEgroup() {
		return egroup;
	}

	public Equipment setEgroup(String egroup) {
		this.egroup = egroup;
		return this;
	}

	public String getNum() {
		return num;
	}

	public Equipment setNum(String num) {
		this.num = num;
		return this;
	}

	public String getEname() {
		return ename;
	}

	public Equipment setEname(String ename) {
		this.ename = ename;
		return this;
	}

	public String getType() {
		return type;
	}

	public Equipment setType(String type) {
		this.type = type;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Equipment setAddress(String address) {
		this.address = address;
		return this;
	}

	public static final String ID = "id";

	public static final String EGROUP = "egroup";

	public static final String NUM = "num";

	public static final String ENAME = "ename";

	public static final String TYPE = "type";

	public static final String ADDRESS = "address";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Equipment{" +
			", id=" + id +
			", egroup=" + egroup +
			", num=" + num +
			", ename=" + ename +
			", type=" + type +
			", address=" + address +
			"}";
	}
}
