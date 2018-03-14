package com.alibaba.dingtalk.openapi.demo;


/**
 * 企业应用接入时的常量定义
 */
public class Env {

    /**
     * 企业应用接入秘钥相关
     */
    public static final String CORP_ID = "ding1a13187eee6ac35435c2f4657eb6378f";
    public static final String CORP_SECRET = "JiVWjKBgqJC0ywyqEaJgJr287Hg2XrCYFAUPK6m8GafskwTtRz1YTdh9Gi23Uffw";
    public static final String SSO_Secret = "gLOIP0Kfo4OK4cIRbxpwbQDktUHtcc3JZojNLXx2ttuHeqIlStBuYtr_cnhvNGW0";

    /**
     * DING API地址
     */
	public static final String OAPI_HOST = "https://oapi.dingtalk.com";
    /**
     * 企业应用后台地址，用户管理后台免登使用
     */
	public static final String OA_BACKGROUND_URL = "https://oa.dingtalk.com/index.htm#/microApp/microAppList";


    /**
     * 企业通讯回调加密Token，注册事件回调接口时需要传递给钉钉服务器
     */
	public static final String TOKEN = "";
	public static final String ENCODING_AES_KEY = "";
	
}
