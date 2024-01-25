package tree;

import common.ListNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

import java.util.*;

public class TraversalNTree {
    static class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int levelCount = queue.size();
                for (int i = 0; i < levelCount; i++) {
                    Node node = queue.poll();
                    level.add(node.val);
                    List<Node> children = node.children;
                    queue.addAll(children);
                }
            }

            return result;
        }
    }


    @NoArgsConstructor
    @Data
    static class Node {
        public int val;
        public List<Node> children;

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }
    }

    public static void main(String[] args) {

        List<Node> children = new ArrayList<>();
        Node root = new Node(1, children);
        root.setChildren(children);
        List<Node> children2 = new ArrayList<>();
        children2.add(new Node(5, Collections.emptyList()));
        children2.add(new Node(6, Collections.emptyList()));

        children.add(new Node(3, children2));
        children.add(new Node(2, Collections.emptyList()));
        children.add(new Node(4, Collections.emptyList()));

        Solution solution = new Solution();
        System.out.println(solution.levelOrder(root));

    }
}
