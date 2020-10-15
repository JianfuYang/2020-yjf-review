/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main2
 * Author:   Jianf
 * Date:     2020/9/25 17:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package interview.bigo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Jianf
 * @create 2020/9/25
 * @since 1.0.0
 */
public class Main2 {

    public static void main(String[] args) {

    }


    //二叉树转单向链表的形式
    public static TreeNode treeNode2ListNode(TreeNode root){

        if(root==null||(root.left==null&&root.right==null)){
            return root;
        }
        TreeNode parent = root;
        TreeNode res = parent;
        //对左右子树递归操作
        TreeNode left =root.left;
        TreeNode right = root.right;
        //递归操作
        TreeNode leftNode = treeNode2ListNode(left);
        TreeNode rightNode = treeNode2ListNode(right);
        //将左子树作为根节点的右子树，左子树的的最终右节点是原来树的右子节点
        parent.right = leftNode;
        //遍历，直到左子树的最右
        while(parent.right!=null){
            parent = parent.right;
        }
        //右子节点接上原树的右子树
        parent.right = rightNode;
        return res;
    }


}



class TreeNode{
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}