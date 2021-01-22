package com.zsy.proxy;

/**
 * 经纪公司规定的演员所具备的素质。使用接口来定义规范
 * @author zhy
 *
 */
public interface IActor {

	public void basicAct(float money);

	public void dangerAct(float money);
}
