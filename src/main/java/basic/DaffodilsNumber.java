package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 水仙花数
 * 形如 153 = 1^3 + 5^3 + 3^3
 * 
 * double Math.pow(a, b)   计算a的b次方
 * 
 * @author pencejz
 * 2018年7月31日 下午11:42:42
 */
public class DaffodilsNumber {

	public static void main(String[] args) {

//		boolean a = isDaffodilsNumber(153);
//		System.out.println(a);
		
		List<Integer> list = getDaffodils(100, 1000);
		for (Integer i : list) {
			System.out.print(i+" ");
		}
		
		
		
	}
	
	/**
	 * 判断一个数是否为水仙花数
	 * @param number
	 * @return
	 */
	public static boolean isDaffodilsNumber(int number) {
		
		int len = String.valueOf(number).length(); //number长度
		
		int total = 0; //水仙花数规则计算和
		int temp = number; //代替number，用于计算
		int digital; //number的每一位上的数字
		int index = len-1;
		while(index >= 0){
			int weight = (int)Math.pow(10, index);
			digital = temp / weight; //每一位上的数字
			total= total + (int)Math.pow(digital, len);
			temp = temp -digital*weight;
			index--;
		}
		
		return number==total?true:false;
	}
	
	/**
	 * 找出[minNum, maxNum] 中的水仙花数
	 * @param minNumb
	 * @param maxNum
	 * @return
	 */
	public static List<Integer> getDaffodils(int minNum, int maxNum) {
		
		List<Integer> daffodils = new ArrayList<>();
		for(int i=minNum;i<=maxNum; i++) {
			if(isDaffodilsNumber(i)){
				daffodils.add(i);
			}
		}
		return daffodils;
	}

}
