package CSF_domarev_k_v_task;

class Tree<T extends Number> {

    private int level = 0;
    private TreeNode branch;

    private void input(T value, TreeNode nd) {
        if (branch == null) {
            branch = new TreeNode(value);
            return;
        }
        if (nd.value.intValue() > value.intValue()) {
            if (nd.left != null) {
                input(value, nd.left);
            } else {
                nd.left = new TreeNode(value);
                if (nd.right == null) {
                    nd.left.nodeLevel = nd.nodeLevel+1;
                    if (level < nd.left.nodeLevel)
                        level++;
                } else {
                    nd.left.nodeLevel = nd.right.nodeLevel;
                }
            }
        } else if (nd.value.intValue() < value.intValue()) {
            if (nd.right != null) {
                input(value, nd.right);
            } else {
                nd.right = new TreeNode(value);
                if (nd.left == null) {
                    nd.right.nodeLevel = nd.nodeLevel+1;
                    if (level < nd.right.nodeLevel)
                        level++;
                } else {
                    nd.right.nodeLevel = nd.left.nodeLevel;
                }
            }

        }
    }

    void add(T value) {
        input(value, branch);
    }

    private void prepareTreeForPrint(TreeNode nd) {
        if (nd == null) return;

        for (int i = 0; i < nd.nodeLevel; i++)
            System.out.print("  ");
        System.out.println(nd.value);

        prepareTreeForPrint(nd.left);
        prepareTreeForPrint(nd.right);
    }

    void printTree() {
        prepareTreeForPrint(branch);
    }

    private void prepareChangedTreeForPrint(TreeNode nd) {
        delete();

        if (nd == null) return;

        for (int i = 0; i < nd.nodeLevel; i++)
            System.out.print("  ");
        System.out.println(nd.value);

        prepareTreeForPrint(nd.left);
        prepareTreeForPrint(nd.right);
    }

    void printChangedTree() {
        prepareChangedTreeForPrint(branch);
    }


    private void searchAndDeleteLeave(TreeNode nd) {
        if (nd == null)
            return;
            if (nd.left != null)
                if (nd.left.nodeLevel != level && nd.left.left == null && nd.left.right == null)
                    nd.left = null;
        searchAndDeleteLeave(nd.right);

            if (nd.right != null)
                if (nd.right.nodeLevel != level && nd.right.left == null && nd.right.right == null)
                    nd.right = null;
        searchAndDeleteLeave(nd.left);
    }

    private void delete() {
        searchAndDeleteLeave(branch);
    }

    public class TreeNode {
        TreeNode left;
        int nodeLevel;
        TreeNode right;
        T value;

        TreeNode(T value) {
            this.value = value;
        }
    }

}
