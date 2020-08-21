/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main2
 * Author:   Jianf
 * Date:     2020/8/21 10:33
 * Description: 赏金猎人问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.exam.shunfeng0820;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈赏金猎人问题：赏金猎人时间有限。有n个任务，每个任务有开始时间、结束时间和赏金。求最大收益〉
 *
 * @author Jianf
 * @create 2020/8/21
 * @since 1.0.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskNums = scanner.nextInt();
        //任务
        Task[] tasks = new Task[taskNums];
        for(int i=0;i<taskNums;i++){
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            int mon = scanner.nextInt();
            tasks[i] = new Task(s,e,mon);
        }
        int res = maxIncome(tasks,taskNums);
        System.out.println(res);
    }

    /**
     * 求最大赏金收益，解题方法：动态规划
     * 对于第i个任务来说，有选和不选两个选择
     * @param tasks
     * @param n
     * @return
     */
    public static int maxIncome(Task[] tasks,int n){
        //先排序，按照结束时间来进行升序排序
        Arrays.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.end-o2.end;
            }
        });
        //dp[i]表示做前i个任务时可以获得的最大收益
        int[] dp = new int[n];
        dp[0] = tasks[0].money;

        for(int i=1;i<n;i++){
            Task currentTask = tasks[i];
            int iTemp=-1; //表示做当前任务时，还能接受的前一个任务的编号
            for(int j=i-1;j>=0;j--){
                //找出选择了第i个任务后，前边还能接受的任务（只要接受的任务的结束时间 < 第i个任务的开始时间就可以；
                //因为前边已经将区间按照结束时间来升序排序了
                if(currentTask.start>=tasks[j].end){
                    iTemp = j;
                    break;
                }
            }
            //dp[i-1]表示不选第i个任务，后边表示选择第i个任务
            if(iTemp==-1){
                /*表示选了该任务，前面无任务可做
                    dp转移方程为：max(dp[i-1],currentTask收益）（因为做了该次任务，前面的任务不能做）
                 */
                dp[i]=Math.max(dp[i-1],currentTask.money);
            }else{
                /*
                    即使做了当前i任务，前面也有任务可以做的情况
                    dp[i]=max(dp[i-1],dp[前面一个任务的编号]+currentTask收益)
                 */
                dp[i] = Math.max(dp[i-1],dp[iTemp]+currentTask.money);
            }
        }
        return dp[n-1];
    }

}

//对于任务的一个辅助类
class Task{
    public int start; //开始时间
    public int end; //结束时间
    public int money; //赏金

    public Task(int start, int end, int money) {
        this.start = start;
        this.end = end;
        this.money = money;
    }
}