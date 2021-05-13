// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   5
// IDE:          IntelliJ IDEA

package BSIL;

public class TestBSTDelet_Spencer_King
{


    public static void main (String [] args)
    {

        BST_Spencer_King<String> tree = new BST_Spencer_King<>();

        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        printTree (tree);

        System.out.print("\nAfter delete George:");
        tree.delete("George");
        System.out.println();
        printTree(tree);

        System.out.print("\nAfter delete Adam:");
        tree.delete("Adam");
        System.out.println();
        printTree(tree);

        System.out.print("\nAfter delete Michael:");
        tree.delete("Michael");
        System.out.println();
        printTree(tree);

    }

    public static void printTree(BST_Spencer_King tree)
    {
        //Traverse tree
        System.out.print("Inorder (sorted): ");
        tree.inorderKeyboard();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.print("\nThe number of nodes is " + tree.getSize());
        System.out.println();
    }


}
