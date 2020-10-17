/**
 * Copyright (C), 2018-2020, GDUT_YJF
 * FileName: Main3
 * Author:   Jianf
 * Date:     2020/10/15 14:58
 * Description: 二叉查找树
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package interview.bigo;

import java.util.Stack;

/**
 * 〈一句话功能简述〉<br> 
 * 〈二叉查找树〉
 *
 * @author Jianf
 * @create 2020/10/15
 * @since 1.0.0
*/



public class Main3 {

    private TreeNode treeNode2ListNode(TreeNode root){
        //思路：判空，先最左，右，依次
        if((root == null) || (root.left == null && root.right==null)){
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        //先走到最左
        while(root.left!=null){
            stack.add(root.left);
            root = root.left;
        }
        //用于返回的头结点
        TreeNode res = root;
        while(!stack.isEmpty()){
            TreeNode pRoot = stack.pop();
            root.right = pRoot;
            pRoot.left = root;

            //迭代，将当前节点的父节点置为当前节点
            root = pRoot;
            //处理父节点的右子节点
            TreeNode temp = root.right;
            while(temp!=null){
                stack.add(temp);
                temp = temp.left;
            }
        }
        return res;
    }
}

class TreeNode{

     int val;
     TreeNode left;
     TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}