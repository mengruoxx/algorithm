package tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算每个节点的叶节点的数量
 * @author mengruo
 * @date 2022/7/20 12:25
 */
public class CalculateLeafCount {
    private int getLeafCount(LineNode root) {
        int leafCount = 0;

        for (LineNode child : root.getChildren()) {
            if (child.getChildren().size() == 0) {
                leafCount++;
            } else {
                leafCount = leafCount + getLeafCount(child);
            }
        }
        // 如果是非叶节点，该节点延伸的线的数量就是它的叶子节点的数量
        root.leafCount = leafCount;
        return leafCount;
    }

    @Data
    public static class LineNode {
        /**
         * 值，也等于行index
         */
        private int value;

        private List<LineNode> children = new ArrayList<>();

        private int parentValue;
        private LineNode parent;
        /**
         * 这个节点所延伸出去的线数量
         */
        private int leafCount;
        /**
         * 所在的列index
         */
        private int colIndex;

        public LineNode(int value) {
            this.value = value;
        }
    }
}
