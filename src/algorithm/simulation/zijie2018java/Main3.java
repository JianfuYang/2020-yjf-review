/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: algorithm.exam.xiaomi0908.algorithm.exam.didi0913.Main
 * Author:   Jianf
 * Date:     2020/8/20 9:20
 * Description: 往年真题：字节2018后端-Java
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.simulation.zijie2018java;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈往年真题：字节2018后端-Java〉
 *
 * @author Jianf
 * @create 2020/8/20
 * @since 1.0.0
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String string = input.split(" ")[0];
        int m = Integer.parseInt(input.split(" ")[1]);

        int len = string.length();
        //记录字符串s的每个位置和26个字母的关系
        int[][] record = new int[len][26];
        //记录每个字母在规定交换次数内最长的相同字母数量
        int[] length = new int[26];
        for(int i=0;i<len;i++){
            record[i][string.charAt(i)-'a']=1;
        }

        for(int i=0;i<26;i++){
            //对于每个字母，记录字符串s中出现该字母的位置
            int[] position = new int[len];
            int k=0; //字符串s中出现该字母k次
            for(int j=0;j<len;j++) {
                if (record[j][i] == 1) {
                    position[k] = j;
                    k++;
                }
            }
            if(k==0){
                length[i]=0;
            }else if(k==1){
                length[i]=1;
            }else {
                int answer = Integer.MIN_VALUE;
                for (int p = 0; p < k; p++) {
                    for (int q = p + 1; q < k; q++) {
                        int res = dfsSwichCharacter(p, q, position);
                        if (res <= m) {
                            //在规定交换次数内，更新连续的某个相同字母数量
                            answer = Math.max(answer, q - p + 1);
                        }
                    }
                }
                length[i] = answer;
            }
        }
        int result = Integer.MIN_VALUE;
        for(int cur:length){
            result = Math.max(result,cur);
        }
        System.out.println(result);
    }

    public static int dfsSwichCharacter(int i,int j,int[] position){
        if(i==j){
            return 0;
        }else if(i+1 == j){
            //说明字符串s中position[i]和position[j]之前不可能再有该字母，所有移动次数就是坐标之差-1
            return position[j]-position[i]-1;
        }else{
            //移动次数相当于把position[j]的字母移到position[i]隔壁的次数减去这两个位置之间该字母的个数
            return dfsSwichCharacter(i+1,j-1,position)+position[j]-position[i]-1-(j-i-1);
        }
    }

}