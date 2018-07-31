package basic;

/**
 * 斐波拉契数列：当前数的值是前2个数值之和
 * 
 * @author pencejz
 * 2018年7月28日 下午2:22:58
 */
public class FibonacciSequence {

	/*
	 * 题目：
	 * 有一对兔子，从出生后第3个月起每个月都能生一对兔子。
	 * 小兔子长到第3个月后每个月又生一对兔子。
	 * 假设兔子都不死。
	 * 问：每个月个月兔子的总数为多少对？
	 */
	public static void main(String[] args) {
		getNumOfRabbit(1, 8);
		
	}
	
	/**
	 * @param startNumOfRabbit 兔子起始数量
	 * @param cycle 繁殖周期
	 */
	public static void getNumOfRabbit(int startNumOfRabbit, long cycle){
		System.out.println("兔子初始数量："+startNumOfRabbit+"对");
		System.out.println("繁殖周期："+cycle+"个月");
		System.out.println("第1个月的兔子对数：1对");
		
		long total = 0L;
		//第二个月兔子的对数：一个月大的兔子、两个月大的兔子、大于两个月的兔子
		long oneMonthAge = startNumOfRabbit, twoMonthAge = 0L, moreMonthAge = 0L;
		for(int i=2; i<=cycle; i++) {
			/*
			 * 当前月大于两个月大的兔子 = 上月大于两个月大的兔子 + 上月2月大的兔子
			 * 当月两个月大的兔子 = 上月1个月大的兔子
			 * 当月1个月大的兔子 = 当月大于两个月大的兔子
			 */
			moreMonthAge = moreMonthAge + twoMonthAge;
			twoMonthAge = oneMonthAge;
			oneMonthAge = moreMonthAge;
			
			total = moreMonthAge + twoMonthAge + oneMonthAge;
			
			System.out.println("第"+i+"个月的兔子数量："+total+"对");
		}
		
		
		
	}

}
