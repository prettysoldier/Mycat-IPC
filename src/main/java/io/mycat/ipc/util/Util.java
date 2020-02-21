package io.mycat.ipc.util;

/**
 * tools
 * 
 * @author wuzhih
 *
 */
public class Util {
	/**
	 * 规整到4096的整数倍：大于i的最小4096整数倍
	 * @param i
	 * @return
	 */
	public static long roundTo4096(long i) {
		return (i + 0xfffL) & ~0xfffL;
	}
	public static void  main(String[] args)
	{
		System.out.println(roundTo4096(4095));
		System.out.println(roundTo4096(4097));
	}
}
