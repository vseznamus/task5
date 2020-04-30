package CSF_domarev_k_v_task;

import java.util.Stack;

public class Tree<T extends Number> {

    private int level  = 0;
    private TreeNode branch;

    public class TreeNode {
        TreeNode next;
        public String data;
        TreeNode left;
        TreeNode prev;
        int nodeLevel;
        TreeNode right;
        T value;

        public TreeNode(T value) {
            this.value = value;
        }
    }


    public void input(T value, TreeNode nd) {
        if (branch == null) {
            branch = new TreeNode(value);
            return;
        }
        if (nd.value.intValue() > value.intValue()) {
            if (nd.left != null) {
                input(value, nd.left);
                if (nd.left.nodeLevel == nd.right.nodeLevel)
                    nd.left.nodeLevel = level;
                else {
                    level++;
                    nd.left.nodeLevel = level;
                }
            }
            else {
                nd.left = new TreeNode(value);
            }
        }
        else if (nd.value.intValue() < value.intValue()) {
            if (nd.right != null) {
                input(value, nd.right);
                if (nd.right.nodeLevel == nd.left.nodeLevel)
                    nd.right.nodeLevel = level;
                else {
                    level++;
                    nd.right.nodeLevel = level;
                }
            }
            else {
                nd.right = new TreeNode(value);
            }
        }
    }

    public void add(T value)
    {
        input(value , branch);
    }


    public void prepareTreeForPrint(TreeNode nd) {
        if(nd == null) return;
        String left = (nd.left == null ? "нету" : nd.left.value + "");
        String right = (nd.right == null ? "нету" : nd.right.value + "");
        System.out.println("Корень " + nd.value + " левый ребенок: " +left+ " правый ребенок: " + right );
        prepareTreeForPrint(nd.left);
        prepareTreeForPrint(nd.right);
    }

    public void printTree()
    {
        prepareTreeForPrint(branch);
    }

    public int getLevel() {
        return level;
    }

    void contInOrder(TreeNode top){
        Stack<TreeNode> stack = new Stack<> ();
        while (top!=null || !stack.empty()){
            if (!stack.empty()){
                top=stack.pop();
                if (top.right!=null) {
                    top=top.right;
                } else top=null;
            }
            while (top!=null){
                stack.push(top);
                top=top.left;
            }
        }
    }

}
