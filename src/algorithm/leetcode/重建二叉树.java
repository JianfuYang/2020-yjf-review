/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: 重建二叉树
 * Author:   Jianf
 * Date:     2020/9/2 21:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package algorithm.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/2
 * @since 1.0.0
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



public class 重建二叉树 {

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        reConstructBinaryTree(pre,in);
        int n=10;

    }


    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //解题思路：首先找到根节点，再分别递归求解
        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);
        //在中序遍历中找根节点
        int mid = in.length-1;
        for(int i=0;i<in.length;i++){
            if(in[i]==rootVal){
                mid = i;
                break;
            }
        }
        int[] leftIn = Arrays.copyOfRange(in,0,mid);
        int[] rightIn = Arrays.copyOfRange(in,mid+1,in.length);

        //mid大小同时也表示左子树元素的个数
        int[] leftPre = Arrays.copyOfRange(pre,1,mid+1);
        int[] rightPre = Arrays.copyOfRange(pre,mid+1,pre.length);

        TreeNode leftNode = reConstructBinaryTree(leftPre,leftIn);
        TreeNode rightNode = reConstructBinaryTree(rightPre,rightIn);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}