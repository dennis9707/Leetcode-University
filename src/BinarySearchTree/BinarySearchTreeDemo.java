package BinarySearchTree;

import com.sun.tools.internal.xjc.reader.dtd.bindinfo.BIAttribute;

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};
        BinarySearchTree tree = new BinarySearchTree();
        for(int i=0;i<arr.length;i++){
            tree.add(new Node(arr[i]));
        }
        tree.inOrder();
        tree.delete(12);
        System.out.println("delete node");
        tree.inOrder();
    }
}
class BinarySearchTree{
    private Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }
        else{
            root.add(node);
        }
    }
    public void inOrder(){
        if(root != null){
            root.inOrder();
        }
        else{
            System.out.println("Root is empty");
        }
    }
    public Node search(int val){
        if(root == null){
            return null;
        }
        else{
            return root.search(val);
        }

    }
    public Node searchParent(int val){
        if(root == null){
            return null;
        }
        else{
            return root.searchParent(val);
        }
    }
//    return the value of the min node
//    delete the min node
    /**
     *
     * @param node 传入root node
     * @return 返回以root为根节点的最小值
     */
    public int deleteRightTreeMin(Node node){
        while(node.left != null){
            node = node.left;
        }
        int temp = node.value;
        delete(node.value);
        return temp;
    }

    public void delete(int val){
        if(root == null){
            return;
        }
        else{
            Node targetNode = this.root.search(val);
            if(targetNode == null){
                return;
            }

            if(root.left == null && root.right == null){
                root = null;
                return;
            }

            Node parentNode = this.root.searchParent(val);

//            leaf node
            if(targetNode.left == null && targetNode.right == null){
                if(parentNode.left != null && parentNode.left.value == val){
                    parentNode.left = null;
                }
                else if(parentNode.right != null && parentNode.right.value == val){
                    parentNode.right = null;
                }
            }
            else if(targetNode.left != null && targetNode.right != null){
//           两颗子树节点
                int r = deleteRightTreeMin(targetNode.right);
                targetNode.value = r;
            }
            else{
//           一颗子树节点
                if(targetNode.left != null){
                    if(parentNode.left.value == val){
                        parentNode.left = targetNode.left;
                    }
                    else{
                        parentNode.right = targetNode.left;
                    }
                }
                else{
                    if(parentNode.left.value == val){
                        parentNode.left = targetNode.right;
                    }
                    else{
                        parentNode.right = targetNode.right;
                    }
                }
            }
        }
    }

}
class Node{
    Node left;
    Node right;
    int value;
    public Node(int val){
        value = val;
    }

    public Node search(int value){
        if(this.value == value){
            return this;
        }
        else if(this.value < value){
           if(this.left == null){
               return null;
           }
           return this.left.search(value);
        }
        else{
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    public Node searchParent(int value){
        if((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)){
            return this;
        }
        else{
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);
            }
            else if(value > this.value && this.right != null){
                return this.right.searchParent(value);
            }
            else{
                return null;
            }
        }
    }

    public void add(Node node){
        if(node == null){
            return;
        }

        if(node.value < this.value){
            if(this.left == null){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }
        else{
            if(this.right == null){
                this.right = node;
            }
            else{
                this.right.add(node);
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void inOrder(){
        if(this.left != null){
            this.left.inOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.inOrder();
        }
    }
}