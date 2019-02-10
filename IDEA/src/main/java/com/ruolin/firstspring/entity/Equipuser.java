package com.ruolin.firstspring.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 
 * </p>
 *
 * @author ruolin
 * @since 2019-01-24
 */
public class Equipuser extends Model<Equipuser> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("user_id")
	private Integer userId;
	@TableField("equip_id")
	private Integer equipId;


	public Integer getId() {
		return id;
	}

	public Equipuser setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public Equipuser setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Integer getEquipId() {
		return equipId;
	}

	public Equipuser setEquipId(Integer equipId) {
		this.equipId = equipId;
		return this;
	}

	public static final String ID = "id";

	public static final String USER_ID = "user_id";

	public static final String EQUIP_ID = "equip_id";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Equipuser{" +
			", id=" + id +
			", userId=" + userId +
			", equipId=" + equipId +
			"}";
	}
}
