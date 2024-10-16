class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /*
	   pre-order traversal
	   Prints the value of every node preorder
      @param Root the root node of given tree
	   */
	   public void preOrderTraversal(Node root){
		//implement in here
		   if (root == null)
            return;
         
         //Print tree
         System.out.print(root.value + " ");
         
         //Move to the left
         preOrderTraversal(root.left);
         
         //Move to the right
         preOrderTraversal(root.right);
	   }

	   
	   
	   /*
	   * in-order traversal
      * Prints the value of every node in order
      * @param Root the root node of given tree
	   */
	   public void inOrderTraversal(Node root){
	      //implement in here
         if (root == null)
            return;
         
         inOrderTraversal(root.left);
         
         System.out.print(root.value + " ");
         
         inOrderTraversal(root.right);
	   }
	   
	   
	   
	   /*
	   * post-order traversal
      * Prints the value of every node post order
      * @param Root the root node of given tree
	   */
	  
	   public void postOrderTraversal(Node root){
         //implement in here
		   if (root == null)
            return;
         
         postOrderTraversal(root.left);
         
         postOrderTraversal(root.right);
         
         System.out.print(root.value + " ");
	   }
	   
	   
	   
	   /*
	   * a method to find the node in the tree
	   * with a specific value
      * @param Root the root node of given tree. Key the value given to find
      * @return Boolean of whether the node is found or not
	   */
	   public boolean find(Node root, int key){
		 //implement in here
         if (root == null)
            return false;
         if (root.value == key)
            return true;
         
         if (root.value < key)
            return find(root.right, key);
        
		   return find(root.left, key);
	   }
	   
	   
	   
	   /*
	   * a method to find the node in the tree
	   * with a smallest key
      * @param Root the root node of given tree
      * @return Value of the min node
	   */
	   public int getMin(Node root){
         //implement in here
         if (root == null || root.left == null)
            return root.value;
         //Move left until getting smallest value
         return getMin(root.left);
	   }
	  
	  
	  
	   /*
	   * a method to find the node in the tree
	   * with a largest key
      * @param Root the root node of given tree
      * @return Value of the max node
	   */
	   public int getMax(Node root){
         //implement in here
         if (root == null || root.right == null)
            return root.value;
         return getMax(root.right);
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("pre-order :   ");
	      t1.preOrderTraversal(t1.root);
         System.out.println();
	      System.out.print("in-order :   ");
         t1.inOrderTraversal(t1.root);
	      System.out.println();
         System.out.print("post-order :   ");
         t1.postOrderTraversal(t1.root);
         System.out.println();
         System.out.println("Find 80 : " + t1.find(t1.root, 80));
         System.out.println("Find 10 : " + t1.find(t1.root, 10));
	      System.out.println("Min value : " + t1.getMin(t1.root));
         System.out.println("Max value : " + t1.getMax(t1.root));
	   }  
	}
