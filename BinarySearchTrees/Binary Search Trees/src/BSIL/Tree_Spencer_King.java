// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   5
// IDE:          IntelliJ IDEA

package BSIL;

public interface Tree_Spencer_King <E> extends Iterable <E>
{

    //Return true if the element is in the tree
    public boolean search (E e);

    //Insert element e into the binary search tree
    //Return true if the element is inserted successfully
    public boolean insert (E e);

    //Delete the specified element from the tree
    //Return true if the element is deleted successfully
    public boolean delete (E e);

    //Inorder traversal from the root that prints to user
    public void inorderKeyboard();

    //Inorder traversal from the root that is exported in a text file
    public void inorderText() throws Exception;

    //Postorder traversal from the root
    public void postorder();

    //Preorder traversal from the root
    public void preorder();

    //Get the number of nodes in the tree
    public int getSize();

    //Return true if the tree is empty
    public boolean isEmpty();

}

