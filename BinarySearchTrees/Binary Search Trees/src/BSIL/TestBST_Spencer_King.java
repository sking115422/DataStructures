// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   5
// IDE:          IntelliJ IDEA

package BSIL;

public class TestBST_Spencer_King
{


    public static void main (String [] args)
    {

        //Create BST
        BST_Spencer_King<String> tree = new BST_Spencer_King<>();

        tree.insert("George");
        tree.insert("Micheal");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        //Traverse tree
        System.out.print("Inorder (sorted): ");
        tree.inorderKeyboard();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.print("\nThe number of nodes is " + tree.getSize());

        //Search for an element
        System.out.print("\nIs Peter in the tree? " + tree.search("Peter"));

        //Get a path from the root to Peter
        System.out.print("\nA path from the root to Peter is: ");
        java.util.ArrayList<BST_Spencer_King.TreeNode<String>> path = tree.path("Peter");
        for (int i = 0; path != null && i < path.size(); i++)
            System.out.print(path.get(i).element + " ");

        Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};

        BST_Spencer_King<Integer> intTree = new BST_Spencer_King<>(numbers);

        System.out.print("\nInorder (sorted): ");
        intTree.inorderKeyboard();

    }


}
