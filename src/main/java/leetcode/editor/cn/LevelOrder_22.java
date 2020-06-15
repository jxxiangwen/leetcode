package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_22 {
    public int[] levelOrder(TreeNode root) {
        if (null == root) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        addElements(root, result);
        int[] returnArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            returnArray[0] = result.get(i);
        }
        return returnArray;
    }

    public void addElements(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
            if (null != current.left) {
                queue.add(current.left);
            }
            if (null != current.right) {
                queue.add(current.right);
            }
        }
    }
}
