package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 原理：一个大于1的自然数，除了1和它本身外不再有其他的因数。
 * 实现：判断从2到sqrt(n)是否存在其约数，时间复杂度O(sqrt(n))
 * 
 * @author pencejz
 * 2018年7月30日 下午7:51:49
 */
public class PrimeGenerator {
	
	private static boolean[] primeFlags; //素数标志
	private static List<Integer> primes; //素数
	

	public static void main(String[] args) {

//		int[] intArr = generatePrimes_1(100);
//		for (int i : intArr) {
//			System.out.println(i);
//		}
		
		generatePrimes_2(10);
		for (int i : primes) {
			System.out.println(i);
		}
		
		
	}
	//--------------------------------------------version_1.0
	/**
	 * @param maxValue
	 * @version 1.0
	 * @return
	 */
	public static int[] generatePrimes_1(int maxValue){
		
		if(maxValue >= 2) {
			int s = maxValue +1;
			boolean[] f = new boolean[s]; //素数标识数组。值为true，对应下标的数为素数
			
			//初始化标识数组true：默认均为素数
			int i;
			for(i=0; i<s; i++) {
				f[i] = true;
			}
			
			f[0] = f[1] = false; //0 和 1 都不是素数
			
			//从2到sqrt(n)是否存在其约数
			int j;
			for(i=2; i<Math.sqrt(s)+1; i++) {
				for(j=2*i; j<s; j+=i) {
					f[j] = false;
				}
			}
			
			//统计素数个数
			int count = 0;
			for(i=0; i<s; i++) {
				if(f[i]) {
					count ++;
				}
			}
			
			//获取素数
			int[] primes = new int[count];
			for(i=0,j=0; i<s; i++) {
				if(f[i]) {
					primes[j++] = i;
				}
			}
			return primes;
			
		}else{
			//maxValue < 2
			return new int[0];
		}
	}
	
	//--------------------------------------------version_2.0
	/**
	 * 将1.0重构：抽象出全局变量，按功能封装方法
	 * @param maxValue
	 * @version 2.0
	 * @return
	 */
	public static List<Integer> generatePrimes_2(int maxValue) {
		
		//没有素数
		if(maxValue < 2) {
			return new ArrayList<Integer>();
		}else {
			initPrimeFalgs(maxValue); //初始化
			sievePrimes(); //筛选
			generatePrimes(); //生成
			return primes;
		}
	}
	
	/**
	 * 初始化素数标志数组：true
	 * @param maxValue
	 */
	private static void initPrimeFalgs(int maxValue) {
		primeFlags = new boolean[maxValue + 1];
		primeFlags[0] = primeFlags[1] = false;
		for(int i=2; i<primeFlags.length; i++) {
			primeFlags[i] = true;
		}
	}
	
	/**
	 * 筛选素数
	 */
	private static void sievePrimes() {
		//遍历素数标志数组
		for(int i=2; i<Math.sqrt(primeFlags.length)+1; i++) {
			//判断对应下标的数字是否为素数
			for(int j=2*i; j<primeFlags.length; j+=i) {primeFlags[j] = false;}
		}
	}
	
	/**
	 * 生成素数
	 */
	private static void generatePrimes() {
		primes = new ArrayList<Integer>();
		for(int i=2; i<primeFlags.length; i++) {
			if(primeFlags[i]) {primes.add(i);}
		}
	}
	
	
	
}













































