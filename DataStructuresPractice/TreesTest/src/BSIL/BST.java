package BSIL;

public class BST <E extends Comparable <E>>
{
    private int size = 0;
    private TreeNode <E> root;
    private TreeNode <E> currentSearch;
    private TreeNode <E> parentSearch;

    public TreeNode<E> getRoot()
    {
        return root;
    }

    public static class TreeNode < E extends Comparable <E>>
    {
        private E element;
        private TreeNode <E> left;
        private TreeNode <E> right;

        public TreeNode (E e)
        {
            element = e;
            TreeNode <E> left;
            TreeNode <E> right;
        }

        public TreeNode()
        {
        }
    }

    public TreeNode <E> createNewNode (E e)
    {
        return new TreeNode <> (e);
    }

    public void insert (E e)
    {
        if (root == null)
            root = createNewNode(e);
        else
        {
            TreeNode <E> parent = null;
            TreeNode <E> current = root;

            while (current != null)
            {
                if (e.compareTo(current.element) < 0)
                {
                    parent = current;
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0)
                {
                    parent = current;
                    current = current.right;
                }
                else
                    return;
            }

            if(e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
    }


    public void inorder ()
    {
        inorder(root);
    }

    public void inorder (TreeNode <E> root)
    {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    public void preorder ()
    {
        preorder(root);
    }

    public void preorder (TreeNode <E> root)
    {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder ()
    {
        postorder(root);
    }

    public void postorder (TreeNode <E> root)
    {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    public void breadthFirst ()
    {
        breadthFirst(root);
    }

    public void breadthFirst (TreeNode <E> tree)
    {
        for (int i = 0; i < size; i++)
            printCurrentLevel(tree, i);

    }

    public void printCurrentLevel(TreeNode <E> tree, int level)
    {
        if (tree == null) return;
        if (level == 0)
            System.out.print(tree.element + " ");
        else
        {
            printCurrentLevel(tree.left, level - 1);
            printCurrentLevel(tree.right, level - 1);
        }
    }

    public void printTree ()
    {
        printTree(root);
    }

    public void printTree (TreeNode <E> tree)
    {
        for (int i = 0; i < size; i++)
        {
            System.out.print("\t\t\t\t\t");
            int count = 0;
            while (count != (size - i))
            {
                if ((i == 0) && (count == 0))
                {
                    System.out.print("   ");
                }
                else
                {
                    System.out.print("      ");
                }
                count++;
            }


            printCurrentLevelVisual(tree, i);
            System.out.println();
            System.out.println();

        }

    }

    public void printCurrentLevelVisual(TreeNode <E> tree, int level)
    {
        if (tree == null) return;
        if (level == 0)
            System.out.printf("%-6s", tree.element);
        else
        {
            printCurrentLevelVisual(tree.left, level - 1);
            printCurrentLevelVisual(tree.right, level - 1);
        }
    }

    public boolean search (E e)
    {
        currentSearch = root;   //Start from the root
        parentSearch = root;

        if (currentSearch.right == null && currentSearch.left == null && e.compareTo(currentSearch.element) == 0)
            return true;

        else
        {
            while (currentSearch != null)
            {
                if (e.compareTo(currentSearch.element) < 0)
                {
                    parentSearch = currentSearch;
                    currentSearch = currentSearch.left;
                } else if (e.compareTo(currentSearch.element) > 0)
                {
                    parentSearch = currentSearch;
                    currentSearch = currentSearch.right;
                } else                    //Element matches current.element
                    return true;                  //Element is found
            }
            return false;
        }
    }

    public String delete (E e)
    {
        boolean nodeExists = search(e);
        boolean deleted = false;
        boolean right = false;
        TreeNode <E> parentLargestInLeftSubTree;
        TreeNode <E> largestInLeftSubTree;
        TreeNode <E> child;


        if (nodeExists)
        {
            if (currentSearch.element == root.element)
                root = null;
            else if (currentSearch.left == null && currentSearch.right == null)
            {
                if (parentSearch != null)
                {
                    if (parentSearch.element.compareTo(currentSearch.element) < 0)
                        parentSearch.right = null;
                    else
                        parentSearch.left = null;
                }
                currentSearch.element = null;
            }
            else if (currentSearch.left != null && currentSearch.right == null)
            {
                child = currentSearch.left;

                if (parentSearch.element.compareTo(currentSearch.element) < 0)
                    parentSearch.right = child;
                else
                    parentSearch.left = child;

                currentSearch.element = null;
            }
            else if (currentSearch.left == null && currentSearch.right != null)
            {
                child = currentSearch.right;

                if (parentSearch.element.compareTo(currentSearch.element) < 0)
                    parentSearch.right = child;
                else
                    parentSearch.left = child;

                currentSearch.element = null;
            }
            else
            {
                parentLargestInLeftSubTree = currentSearch;
                largestInLeftSubTree = currentSearch;

                largestInLeftSubTree = largestInLeftSubTree.left;

                while (largestInLeftSubTree.right != null)
                {
                        parentLargestInLeftSubTree = largestInLeftSubTree;
                        largestInLeftSubTree = largestInLeftSubTree.right;
                        right = true;
                }

                currentSearch.element = largestInLeftSubTree.element;

                if (right)
                    parentLargestInLeftSubTree.right = null;
                else
                    parentLargestInLeftSubTree.left = null;

                largestInLeftSubTree.element = null;


            }
            deleted = true;
            size--;
        }

        if (deleted)
            return "The node has been deleted!";
        else
            return "The node does not exist";
    }

    public void deleteAll ()
    {
        deleteAll(root);
    }

    public void deleteAll (TreeNode <E> tree)
    {
        for (int i = size; i >= 0; i--)
            CurrentLevel(tree, i);

    }

    public void CurrentLevel(TreeNode <E> tree, int level)
    {
        if (tree == null) return;
        if (level == 0)
        {
            delete(tree.element);
        }
        else
        {
            CurrentLevel(tree.right, level - 1);
            CurrentLevel(tree.left, level - 1);
        }

    }

    public int findMax (int left, int right)
    {
        if (left > right)
            return left;
        else
            return right;
    }

    public int getHeight (TreeNode <E> tree)
    {
        if ( tree == null)
            return 0;
        else if (tree.left == null && tree.right == null )
            return 1;
        else
        {
            return findMax(getHeight(tree.left), getHeight(tree.right)) + 1;
        }
    }

}
