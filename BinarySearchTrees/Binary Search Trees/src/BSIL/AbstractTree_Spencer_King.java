// Class:        CS5040
// Term:         Fall 2020
// Name:         Spencer King
// Instructor:   Dr. Haddad
// Assignment:   5
// IDE:          IntelliJ IDEA

package BSIL;

public abstract class AbstractTree_Spencer_King <E> implements Tree_Spencer_King <E>
{

    //Inorder traversal from the root that prints to user
    @Override
    public void inorderKeyboard()
    {
    }

    //Inorder traversal from the root that is exported in a text file
    @Override
    public void inorderText() throws Exception
    {
    }

    //Postorder traversal from the root
    @Override
    public void postorder ()
    {
    }

    //Preorder traversal from the root
    @Override
    public void preorder ()
    {
    }

    //Return true if the tree is empty
    @Override
    public boolean isEmpty()
    {
        return getSize() == 0;
    }

}

