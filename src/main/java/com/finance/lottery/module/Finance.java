package com.finance.lottery.module;


import java.util.Date;

public class Finance {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	// 主键
	private Long sysNo;

	// 
	private Integer number;

	// 
	private Date createTime;

	// 
	private Date ts;



	/**
	 *
	 * 主键 <br />
	 *
	 * @return 
	 */
	public Long getSysNo() {
		return sysNo;
	}

	/**
	 *
	 * 主键 <br />
	 *
	 * @param sysNo
	 */
	public void setSysNo(Long sysNo) {
		this.sysNo = sysNo;
	}

	/**
	 *
	 *  <br />
	 *
	 * @return 
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 *
	 *  <br />
	 *
	 * @param number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 *
	 *  <br />
	 *
	 * @return 
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 *
	 *  <br />
	 *
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 *
	 *  <br />
	 *
	 * @return 
	 */
	public Date getTs() {
		return ts;
	}

	/**
	 *
	 *  <br />
	 *
	 * @param ts
	 */
	public void setTs(Date ts) {
		this.ts = ts;
	}

}