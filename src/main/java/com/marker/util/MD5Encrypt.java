package com.marker.util;

import java.security.MessageDigest;

public class MD5Encrypt {
	
	public static void main(String[] args) {
		System.out.println(encrypt("123456"));
	}
	
	public static String encrypt(String string) {
        String md5str = "";
        string += "salt"; // ����
        try {
            // 1 ����һ���ṩ��ϢժҪ�㷨�Ķ��󣬳�ʼ��Ϊmd5�㷨����
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 2 ����Ϣ���byte����
            byte[] input = string.getBytes();
            // 3 ��������ֽ�����,�������128λ��
            byte[] buff = md.digest(input);
            // 4 ������ÿһ�ֽڣ�һ���ֽ�ռ��λ������16��������md5�ַ���
            md5str = HexUtil.bytes2Hex(buff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }

}
