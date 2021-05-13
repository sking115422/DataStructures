package BSIL;

import java.lang.*;

public class AVLT
{

    public static class avlTreeNodes
    {
        avlTreeNodes left;
        avlTreeNodes right;
        int element;
        int height;
        int balanceFactor;

        public avlTreeNodes (int element, int nodeHeight, int balanceFactor)
        {
            this.element = element;
            this.height = nodeHeight;
            this.balanceFactor = balanceFactor;
            avlTreeNodes left;
            avlTreeNodes right;

        }

        public avlTreeNodes ()
        {

        }

    }

    private avlTreeNodes root;
    private int treeHeight;
    private int size;

    private avlTreeNodes current;
    private avlTreeNodes parent;

    public AVLT ()
    {
        root = null;
        treeHeight = 0;
        size = 0;
    }

    public avlTreeNodes createNewNode (int element)
    {
        return new avlTreeNodes(element, getNodeHeight(current), getBalanceFactor());
    }

    public void insert (int element)
    {
        if (root == null)
        {
            root = createNewNode(element);
        }
        else
        {
            current = root;
            parent = null;

            while (current != null)
            {
                if (element < current.element)
                {
                    parent = current;
                    current = current.left;
                }
                else
                {
                    parent = current;
                    current = current.right;
                }
            }

            if (element < parent.element)
                parent.left = createNewNode(element);
            else
                parent.right = createNewNode(element);

        }

    }

    public int getNodeHeight (avlTreeNodes node)
    {
        if (root != null && root.right == null & root.left == null)
            return 1;
        else
            return Math.max(getNodeHeight(current.left), getNodeHeight(current.right) + 1);
    }

    public int getBalanceFactor ()
    {
        return 1;
    }


    public void printTree ()
    {
        printTree(root);
    }

    public void printTree (avlTreeNodes tree)
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

    public void printCurrentLevelVisual(avlTreeNodes tree, int level)
    {
        if (tree == null) return;
        if (level == 0)
            System.out.printf("| %-6d, %-6d, %-6d |", root.element, root.height, root.balanceFactor);
        else
        {
            printCurrentLevelVisual(tree.left, level - 1);
            printCurrentLevelVisual(tree.right, level - 1);
        }
    }

    public void inorder ()
    {
        inorder(root);
    }

    public void inorder (avlTreeNodes node)
    {
        if (root == null) return;
        inorder(node.left);
        System.out.println("| " + root.element + ", " + root.height + ", " + root.balanceFactor + " |");
        inorder(node.right);
    }

    public void breadthFirst ()
    {
        breadthFirst(root);
    }

    public void breadthFirst (avlTreeNodes node)
    {
        for (int i = 0; i < size; i++)
            printCurrentLevel(node, i);

    }

    public void printCurrentLevel(avlTreeNodes node, int level)
    {
        if (node == null) return;
        if (level == 0)
            System.out.println("| " + root.element + ", " + root.height + ", " + root.balanceFactor + " |");
        else
        {
            printCurrentLevel(node.left, level - 1);
            printCurrentLevel(node.right, level - 1);
        }
    }



}
