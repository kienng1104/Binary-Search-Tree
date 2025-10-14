package cs1501_p1;
public class BST<T extends Comparable<T>> implements BST_Inter<T>{
    private BTNode<T> root;
    @Override
    public void put(T key){
        root=put(root,key);
    }
    private BTNode<T> put (BTNode<T> node, T key){
        if (node==null) return new BTNode<>(key);
        int cmp = key.compareTo(node.getKey());
        //add to left if smaller
        if (cmp<0){
            node.setLeft(put(node.getLeft(),key));
        } else if(cmp>0){
            //add to right if bigger
            node.setRight(put(node.getRight(),key));
        } /*else {
            node.setKey(key);
        }*/
        return node;
    }
    @Override
    public boolean contains(T key){
        return contains(root,key);
    }
    private boolean contains(BTNode<T> node, T key){
        if (node==null) return false;
        int cmp = key.compareTo(node.getKey());
        if (cmp<0){
            return contains(node.getLeft(),key);
        } else if(cmp>0){
            return contains(node.getRight(),key);
        } else {
            return true;
        }
    }
   @Override
    public void delete(T key){
        root = delete(root,key);
    }
    
    private BTNode<T> delete(BTNode<T> node, T key){
        //Base case
        if(node==null) return null;
        int cmp = key.compareTo(node.getKey());
        if(cmp<0) node.setLeft(delete(node.getLeft(),key));
        else if(cmp>0) node.setRight(delete(node.getRight(),key));
        else{
            if(node.getLeft()==null) return node.getRight();
            if(node.getRight()==null) return node.getLeft();

            BTNode<T> temp = min(node.getRight());
            node.setRight(deleteMin(node.getRight()));
            temp.setLeft(node.getLeft());
            temp.setRight(node.getRight());
            return temp;
        }
        return node;
    }
    //helper method for delete
    //find the minimum of the tree
    private BTNode<T> min(BTNode<T> node){
        if(node.getLeft()==null) return node;
        return min(node.getLeft());
    }
    //helper method for delete
    //delete the minimum
    private BTNode<T> deleteMin(BTNode<T> node){
        if(node.getLeft()==null) return node.getRight();
        node.setLeft(deleteMin(node.getLeft()));
        return node;
    }

    @Override 
    public int height(){
        return height(root);
    }
    private int height(BTNode<T> node){
        //Base case
        if (node==null) return 0;
        return 1+Math.max(height(node.getLeft()),height(node.getRight())); //Recursively count the height of the left and right subtrees
    }

    @Override
    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(BTNode<T> node){
        //Base case
        if (node==null) return true;
        int leftHeight = height(node.getLeft()); //get the height of the left subtree
        int rightHeight = height(node.getRight()); //get the height of the right subtree
        if (Math.abs(leftHeight-rightHeight)>1) return false; //if the difference between the two is greater than 1, return false
        if (isBalanced(node.getLeft())&&isBalanced(node.getRight())) return true; //if the left and right subtrees are balanced, return true
        else return false;
    }

    @Override
    public String inOrderTraversal(){
        StringBuilder sb = new StringBuilder(); //create a stringbuilder to store the traversal
        inOrderTraversal(root,sb);
        return sb.toString(); //return the string
    }
    private void inOrderTraversal(BTNode<T> node, StringBuilder sb){
        if(node==null) return; //base case
        inOrderTraversal(node.getLeft(),sb); //traverse the left subtree
        if(sb.length()>0) sb.append(":");
        sb.append(node.getKey()); //append the key
        inOrderTraversal(node.getRight(),sb); //traverse the right subtree
    }  

    @Override
    public String serialize(){
        if(root==null) return "";
        StringBuilder sb = new StringBuilder(); //create a stringbuilder to store the traversal
        seriHelper(root, true, sb);
        return sb.toString();
    }
    //serialize helper method
    private void seriHelper(BTNode<T> node, boolean isRoot, StringBuilder sb){
        if(node==null) return; //base case
        String type;
        if(isRoot){
            type="R"; //R if node is the root
        } else if (node.getLeft()==null&&node.getRight()==null){
            type="L"; //L if node is a leaf
        } else{
            type="I"; //I if interior node
        }
        if(sb.length()>0)sb.append(",");
        sb.append(type).append("(").append(node.getKey()).append(")");
        if(type.equals("L")) return; //return nothing is the type is L because leafs have no child
        //traverse the left subtree
        if(node.getLeft()!=null){ 
            seriHelper(node.getLeft(),false,sb); //if the left child is not null, traverse the left subtree
        } else{
            //only add X(NULL) if there is a right child
            if (node.getRight() != null) {
            sb.append(",X(NULL)");
            }
        }    
        //traverse the right subtree
        if(node.getRight()!=null){
            seriHelper(node.getRight(),false,sb); //if the right child is not null, traverse the right subtree
        } else{
            //only add X(NULL) if there is a left child
            if (node.getLeft() != null) {
            sb.append(",X(NULL)");
            }
        }
    }

    @Override
    public BST_Inter<T> reverse(){
        BST<T> reversed = new BST<>();
        if (root != null) {
            reversed.root = reverseCopy(root);
        }
        return reversed;
    }
    
    private BTNode<T> reverseCopy(BTNode<T> node){
        //Base case
        if (node==null) return null;
        BTNode<T>temp=new BTNode<>(node.getKey()); //create a new node with the same key
        temp.setLeft(reverseCopy(node.getRight())); //set the left child to the right child of the original node
        temp.setRight(reverseCopy(node.getLeft())); //set the right child to the left child of the original node
        return temp;
    }
    

}