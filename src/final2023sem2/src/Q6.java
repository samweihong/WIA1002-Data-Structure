public class Q6 {
    /*
     * (a)
     * Inorder  : 12 18 27 29 31 33 34 36 38 40 56 64 66 99 100
     * Preorder : 34 27 12 18 31 29 33 56 36 40 38 66 64 100 99
     * Postorder: 18 12 29 33 31 27 38 40 36 64 99 100 66 56 34
     *
     * (b)
     * # Deletion of Node 12
     *
     * Original solution:
     *          34
     *        /    \
     *      /        \
     *    27          56
     *   /  \       /    \
     * 18    31    36    66
     *      /  \    \   /  \
     *     29  33   40 64  100
     *              /      /
     *             38     99
     *
     * Reimplemented solution:
     *          34
     *        /    \
     *      /        \
     *    27          56
     *   /  \       /    \
     * 18    31    36    66
     *      /  \    \   /  \
     *     29  33   40 64  100
     *              /      /
     *             38     99
     *
     * Comparison:
     * Both solutions have the same outcome, where the Node 12 is replaced by Node 18.
     *
     * # Deletion of Node 34
     *
     * Original solution:
     *          33
     *        /    \
     *      /        \
     *    27          56
     *   /  \       /    \
     * 12    31    36    66
     *  \    /      \   /  \
     *  18  29      40 64  100
     *              /      /
     *             38     99
     *
     * Reimplemented solution:
     *          36
     *        /    \
     *      /        \
     *    27          56
     *   /  \       /    \
     * 12    31    40    66
     *  \   /  \   /    /  \
     *  18 29  33 38   64  100
     *                     /
     *                    99
     *
     * Comparison:
     * In the original solution, Node 34 is replaced by Node 33.
     * In the reimplemented solution, Node 34 is replaced by Node 36, and Node 40 becomes the root of the left subtree of Node 56.
     *
     * Deletion of Node 66
     *
     * Original solution:
     *          34
     *        /    \
     *      /        \
     *    27          56
     *   /  \       /    \
     * 12    31    36    64
     *  \   /  \    \      \
     *  18 29  33   40     100
     *              /      /
     *             38     99
     *
     * Reimplemented solution:
     *          34
     *        /    \
     *      /        \
     *    27          56
     *   /  \       /    \
     * 12    31    36    99
     *  \   /  \    \   /  \
     *  18 29  33   40 64  100
     *              /
     *             38
     *
     * Comparison:
     * In the original solution, Node 66 is replaced by Node 64.
     * In the reimplemented solution, Node 66 is replaced by Node 99.
     */

    public static void main(String[] args) {
        int[] nums = {34, 27, 12, 18, 31, 29, 33, 56, 36, 40, 38, 66, 64, 100, 99}; // in preorder

        BST<Integer> bst = new BST<>();
        for (int num : nums) {
            bst.insert(num);
        }
        System.out.print("Preorder: ");
        bst.preorder();
        System.out.print("Inorder : ");
        bst.inorder();

        System.out.println();


        int[] numsToRemove = {12, 34, 66};
        for (int numToRemove : numsToRemove) {
            BST<Integer> bstToTestRemove = new BST<>();
            for (int num : nums) {
                bstToTestRemove.insert(num);
            }

            bstToTestRemove.delete(numToRemove);
            System.out.println("Deleted " + numToRemove);

            System.out.print("Preorder: ");
            bstToTestRemove.preorder();
            System.out.print("Inorder : ");
            bstToTestRemove.inorder(); // should be in sorted order

            System.out.println();
        }

        CircularDoublyLinkedList<Integer> list = bst.toCircularDoublyLinkedList();
        System.out.println(list);
    }
}
