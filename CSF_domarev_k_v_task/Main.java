package CSF_domarev_k_v_task;

public class Main {

    public static void main(String[] args) {
	Tree<Integer> tree = new Tree<Integer>();
	    tree.add(13);
        tree.add(14);
        tree.add(5);
        tree.add(6);
        tree.add(1);
        tree.add(3);

        tree.printTree();
        System.out.println(tree.getLevel());
    }
}
