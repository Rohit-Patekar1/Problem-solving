
//Construct Tree from given Inorder and Preorder traversals

// // Algorithm: buildTree() 
// 1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call. 
// 2) Create a new tree node tNode with the data as picked element. 
// 3) Find the picked element’s index in Inorder. Let the index be inIndex. 
// 4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode. 
// 5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode. 
// 6) return tNode.


import java.util.HashMap;

class Node
{
    char data;
    Node left,right;
    Node(char item) {
        data = item;
        right = left = null;
    }
}

class Tree
{ int i=0;
    public static Node root;

    static  HashMap<Character,Integer>mp= new HashMap<>();
    static int preIndex=0;

    public static Node buildTree(char[] in, char[] pre, int inStrt, int inEnd)
    {
        if(inStrt>inEnd)
            return null;

        char curr=pre[preIndex++];
        Node tNode;
        tNode=new Node(curr);

        if(inStrt==inEnd)
        {
            return tNode;
        }

        int inIndex = mp.get(curr);

        tNode.left=buildTree(in,pre,inStrt,inIndex-1);
        tNode.right=buildTree(in,pre,inIndex+1,inEnd);
        return tNode;
    }
    public  static  Node buldTreeWrap(char[]in, char[] pre, int len)
    {
        for(int i = 0; i < len; i++)
        {
            mp.put(in[i], i);
        }
        return buildTree(in, pre, 0, len - 1);
    }

    static void printInorder(Node node)
    {
        if(node == null)
        {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
    public static void main (String[] args)
    {
        char[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
        char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;

        Tree.root=buldTreeWrap(in, pre, len);

    /* Let us test the built tree by printing
        Insorder traversal */
        System.out.println("Inorder traversal of the constructed tree is");
        printInorder(root);
    }

}
