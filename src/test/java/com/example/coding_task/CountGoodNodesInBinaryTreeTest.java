package com.example.coding_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

class CountGoodNodesInBinaryTreeTest
{
//    static Stream<Map<TreeNode, Integer>> input()
//    {
//        return Stream.of(
//                Collections.singletonMap(convert(new Integer[] {3,1,4,3,null,1,5}), 4),
//                Collections.singletonMap(convert(new Integer[] {3,3,null,4,2}), 3)
//        );
//    }
//
//    private static TreeNode convert(Integer[] ints)
//    {
//        return convert(ints, 0);
//    }
//
//    private static TreeNode convert(Integer[] ints, int index)
//    {
//        if (index >= ints.length)
//        {
//            return null;
//        }
//        if (ints[index] == null)
//        {
//            return null;
//        }
//        return new TreeNode(ints[index], convert(ints, index * 2 + 1), convert(ints, index * 2 + 2));
//    }
//
//
//    @ParameterizedTest
//    @MethodSource("input")
//    void test(Map<TreeNode, Integer> input)
//    {
//        input.forEach((k, v) -> Assertions.assertEquals(v, testImpl(k)));
//    }
//
//    private Integer testImpl(TreeNode head)
//    {
//        List<Integer> goodNodes = new ArrayList<>();
//        List<TreeNode> roots = new LinkedList<>();
//        checkNode(head, roots, goodNodes);
//        return goodNodes.size();
//    }
//
//    private TreeNode checkNode(TreeNode node, List<TreeNode> roots, List<Integer> goodNodes)
//    {
//        if(node.val > roots.)
//        if(!Optional.ofNullable(roots).isPresent())
//        {
//            roots.add(node);
//        }
//
//
//        if(Optional.ofNullable(node.left).isPresent())
//        {
//
//        }
//
//    }
//
//    private static class TreeNode
//    {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right)
//      {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//    }

}
