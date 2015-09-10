package com.xgtongcheng.xgexpress.common;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class GUID
{
	private static String		valueBeforeMD5	= "";

	private static String		valueAfterMD5	= "";

	private static Random		myRand;

	private static SecureRandom	mySecureRand;

	private static String		s_id;

	private static final int	PAD_BELOW		= 0x10;

	private static final int	TWO_BYTES		= 0xFF;

	static
	{
		mySecureRand = new SecureRandom();
		long secureInitializer = mySecureRand.nextLong();
		myRand = new Random(secureInitializer);

		try
		{
			s_id = InetAddress.getLocalHost().toString();

		}
		catch (UnknownHostException e)
		{
			//
			e.printStackTrace();
		}
	}

	public GUID()
	{
	}

	private static void getRandomGUID(boolean secure)
	{

		MessageDigest md5 = null;
		StringBuffer sbValueBeforeMD5 = new StringBuffer(128);

		try
		{
			md5 = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e)
		{
			//
			e.printStackTrace();
		}

		try
		{
			long time = System.currentTimeMillis();
			long rand = 0;
			if (secure)
				rand = mySecureRand.nextLong();
			else
				rand = myRand.nextLong();

			sbValueBeforeMD5.append(s_id);
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(time));
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(rand));

			valueBeforeMD5 = sbValueBeforeMD5.toString();
			md5.update(valueBeforeMD5.getBytes());

			byte[] array = md5.digest();
			StringBuffer sb = new StringBuffer(32);

			for (int j = 0; j < array.length; ++j)
			{
				int b = array[j] & TWO_BYTES;
				if (b < PAD_BELOW)
					sb.append('0');
				sb.append(Integer.toHexString(b));
			}
			valueAfterMD5 = sb.toString();
		}
		catch (Exception e)
		{
			//
			e.printStackTrace();
		}

	}

	public static String newGUID()
	{
		getRandomGUID(true);

		String raw = valueAfterMD5.toUpperCase();
		StringBuffer sb = new StringBuffer(64);
		sb.append(raw.substring(0, 8));
		sb.append(raw.substring(8, 12));
		sb.append(raw.substring(12, 16));
		sb.append(raw.substring(16, 20));
		sb.append(raw.substring(20));

		return sb.toString();
	}

	// For testing only
	public static void main(String[] args)
	{
		System.out.println("Generating begin :");

		long a = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++)
		{
			System.out.println(GUID.newGUID());
		}

		long b = System.currentTimeMillis();

		// about consumes 71s for 100,0000 GUID
		System.out.println("Generating end, time consumption :" + (b - a) + " ms");
	}
}