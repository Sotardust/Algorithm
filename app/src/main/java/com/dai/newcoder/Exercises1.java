package com.dai.newcoder;

/**
 * Created by dai on 2017/7/18.
 * <p>
 * 题目描述
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class Exercises1 {


    /**
     * Created by dai on 2017/7/18.
     * <p>
     * 题目描述
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public boolean find(int target, int[][] array) {
        int row = array.length - 1;
        int column = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[row][column] > target) {
                row--;
            } else if (array[row][column] < target) {
                column++;
            }
            if (array[row][column] == target) {
                return true;
            }
        }
        return false;

    }

    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");

    }

    /**
     * Definition for binary tree
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
     */

//    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//
//    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
