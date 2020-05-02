package CSF_domarev_k_v_task;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        for (int i = 0; i<10; i++)
            tree.add((int) (Math.random()*10 + 10));

        tree.printTree();
        System.out.println("");
        tree.printChangedTree();

    }
}
