package com.anyconnect.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HelloHttpClient {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet httpget=new HttpGet("http://www.baidu.com");
		System.out.println("执行请求："+httpget.getRequestLine());
		CloseableHttpResponse response=httpClient.execute(httpget);
		System.out.println("=====================");
		System.out.println("请求状态："+response.getStatusLine());
		System.out.println();
		HttpEntity entity=response.getEntity();
		
		System.out.println(EntityUtils.toString(entity, "utf-8"));
		response.close();
		httpClient.close();
	}
}
