package projectCode20280;

import java.util.ArrayList;

/*
	The LinkedBinaryTree class extends comparable to allow for comparing of
		whatever type of tree needs to be created e.g. Strings, Integers, Doubles etc.
	It also extends AbstractBinaryTree<T> to allow access to abstract traversal methods among others,
		to make accessing and navigating the tree easier.
		
	The LinkedBinaryTree is a binary tree represented using nodes, where each node has a
		parent, a left child and a right child (these can be null).
	Nodes are added based on an order such that the key of a left node is always less than than the
		key of its parent node. Greater than is place on the right node.
*/

/**
 * Concrete implementation of a binary tree using a node-based, linked structure.
 */
public class LinkedBinaryTree<E extends Comparable<E>> extends AbstractBinaryTree<E> {


  /** Nested static class for a binary tree node. */
  protected static class Node<E> implements Position<E> {
	  private E element;
	  
	  private Node<E> parent;
	  
	  private Node<E> left;
	  
	  private Node<E> right;
	  
	  public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild)
	  {
		  this.element = e;
		  this.parent = above;
		  this.left = leftChild;
		  this.right = rightChild;
	  }
	  
	  public void setElement(E e)
	  {
		  element = e;
	  }
	  
	  public void setParent(Node<E> p)
	  {
		  parent = p;
	  }
	  
	  public void setLeft(Node<E> l)
	  {
		  left = l;
	  }
	  
	  public void setRight(Node<E> r)
	  {
		  right = r;
	  }
	  
	  public E getElement() throws IllegalStateException
	  {
		  return this.element;
	  }
	  
	  public Node<E> getParent()
	  {
		  return this.parent;
	  }
	  
	  public Node<E> getLeft()
	  {
		  return this.left;
	  }
	  
	  public Node<E> getRight()
	  {
		  return this.right;
	  }
	  
	  public String toString()
	  {
		  StringBuilder sb = new StringBuilder();
		  sb.append(element);
		  return sb.toString();
	  }
	  
	} 

  /** Factory function to create a new node storing element e. */
  protected Node<E> createNode(E e, Node<E> parent,
                                  Node<E> left, Node<E> right) {
    return new Node<E>(e, parent, left, right);
  }

  // LinkedBinaryTree instance variables
  /** The root of the binary tree */
  protected Node<E> root = null;     // root of the tree

  /** The number of nodes in the binary tree */
  private int size = 0;              // number of nodes in the tree

  // constructor
  /** Construts an empty binary tree. */
  public LinkedBinaryTree() { }      // constructs an empty binary tree

  // nonpublic utility
  /**
   * Verifies that a Position belongs to the appropriate class, and is
   * not one that has been previously removed. Note that our current
   * implementation does not actually verify that the position belongs
   * to this particular list instance.
   *
   * @param p   a Position (that should belong to this tree)
   * @return    the underlying Node instance for the position
   * @throws IllegalArgumentException if an invalid position is detected
   */
  protected Node<E> validate(Position<E> p) throws IllegalArgumentException 
  {
    if (!(p instanceof Node))
      throw new IllegalArgumentException("Not valid position type");
    Node<E> node = (Node<E>) p;       // safe cast
    if (node.getParent() == node)     // our convention for defunct node
      throw new IllegalArgumentException("p is no longer in the tree");
    return node;
  }

  // accessor methods (not already implemented in AbstractBinaryTree)
  /**
   * Returns the number of nodes in the tree.
   * @return number of nodes in the tree
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns the root Position of the tree (or null if tree is empty).
   * @return root Position of the tree (or null if tree is empty)
   */
  @Override
  public Position<E> root() {
    return root;
  }

  /**
   * Returns the Position of p's parent (or null if p is root).
   *
   * @param p    A valid Position within the tree
   * @return Position of p's parent (or null if p is root)
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  @Override
  public Position<E> parent(Position<E> p) throws IllegalArgumentException {
	Node<E> node = validate(p);
	return node.parent;
  }

  /**
   * Returns the Position of p's left child (or null if no child exists).
   *
   * @param p A valid Position within the tree
   * @return the Position of the left child (or null if no child exists)
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   */
  @Override
  public Position<E> left(Position<E> p) throws IllegalArgumentException {
	Node<E> node = validate(p);
	return node.left;
  }

  /**
   * Returns the Position of p's right child (or null if no child exists).
   *
   * @param p A valid Position within the tree
   * @return the Position of the right child (or null if no child exists)
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   */
  @Override
  public Position<E> right(Position<E> p) throws IllegalArgumentException {
	Node<E> node = validate(p);
	return node.right;
  }

  // update methods supported by this class
  /**
   * Places element e at the root of an empty tree and returns its new Position.
   *
   * @param e   the new element
   * @return the Position of the new element
   * @throws IllegalStateException if the tree is not empty
   */
  public Position<E> addRoot(E e) throws IllegalStateException {
	  if (!isEmpty())
	  {
		  throw new IllegalStateException("Tree is not empty, cannot add a root!");
	  }

	  //adding a root means it will be the only node, so parent child and right are null
	  root = createNode(e, null, null, null);
	  size = 1;
	  return root;
  }

  public void insert(E e){
      //recursively add from root
      addRecursive(root, e);
  }
  
  //recursively add Nodes to binary tree in proper position
  private Node<E> addRecursive(Node<E> p, E e){
	if (p == null)
	{
		addRoot(e);
		return root;
	}
	  
	//figure out whether key of node is < or > than parent node
	// continue process until we reach a node with either a null left or null right node, depending
	//create new node with last node in recursive stack as parent, return up the stack
	if (e.compareTo(p.getElement()) < 0)
	{
		if (p.getLeft() != null)
		{
			return addRecursive(p.getLeft(), e);
		}
		
		Node<E> node = createNode(e, p, null, null);
		p.setLeft(node);
		size++;
		return node;
	}
	
	else
	{
		if (p.getRight() != null)
		{
			return addRecursive(p.getRight(), e);
		}
		
		Node<E> node = createNode(e, p, null, null);
		p.setRight(node);
		size++;
		return node;
	}
  }

  
  /**
   * Creates a new left child of Position p storing element e and returns its Position.
   *
   * @param p   the Position to the left of which the new element is inserted
   * @param e   the new element
   * @return the Position of the new element
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   * @throws IllegalArgumentException if p already has a left child
   */
  public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
	Node<E> parent = validate(p);
	
	if (parent.getLeft() != null)
	{
		throw new IllegalArgumentException("This node already has a left child!");
	}
	
	Node<E> child = createNode(e, parent, null, null);
	parent.setLeft(child);
	size++;
	return child;
  }

  /**
   * Creates a new right child of Position p storing element e and returns its Position.
   *
   * @param p   the Position to the right of which the new element is inserted
   * @param e   the new element
   * @return the Position of the new element
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   * @throws IllegalArgumentException if p already has a right child
   */
  public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
	Node<E> parent = validate(p);
	
	if (parent.getRight() != null)
	{
		throw new IllegalArgumentException("This node already has a right child!");
	}
	
	Node<E> child = createNode(e, parent, null, null);
	parent.setRight(child);
	size++;
	return child;
  }

  /**
   * Replaces the element at Position p with element e and returns the replaced element.
   *
   * @param p   the relevant Position
   * @param e   the new element
   * @return the replaced element
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  public E set(Position<E> p, E e) throws IllegalArgumentException {
	  Node<E> node = validate(p);
	  
	  E replaced = node.getElement();
	  node.setElement(e);
	  
	  return replaced;
  }

  /**
   * Attaches trees t1 and t2, respectively, as the left and right subt2ree of the
   * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
   *
   * @param p   a leaf of the tree
   * @param t1  an independent tree whose structure becomes the left child of p
   * @param t2  an independent tree whose structure becomes the right child of p
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   * @throws IllegalArgumentException if p is not a leaf
   */
  public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
	Node<E> node = validate(p);
	
	if (isInternal(p))
	{
		throw new IllegalArgumentException("Node must be a leaf node to attach a tree!");
	}
	
	size += t1.size() + t2.size();
	
	if (!t1.isEmpty())
	{
		//attach tree to node
		t1.root.setParent(node);
		node.setLeft(t1.root);
		//java garbage collector knows to delete this tree now
		t1.root = null;
		t1.size = 0;
	}
	
	if (!t2.isEmpty())
	{
		//attach tree to node
		t2.root.setParent(node);
		node.setRight(t2.root);
		//java garbage collector knows to delete this tree now
		t2.root = null;
		t2.size = 0;
	}
  }

  /**
   * Removes the node at Position p and replaces it with its child, if any.
   *
   * @param p   the relevant Position
   * @return element that was removed
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   * @throws IllegalArgumentException if p has two children.
   */
  public E remove(Position<E> p) throws IllegalArgumentException {
	Node<E> node = validate(p);
	
	if (numChildren(p) == 2)
	{
		throw new IllegalArgumentException("This node has 2 children!");
	}
	
	//check which side child node is on and set it to child
	Node<E> child = (node.getLeft() != null ? node.getLeft(): node.getRight());
	
	if (child != null)
	{
		child.setParent(node.getParent());
	}
	
	if (node == root)
	{
		root = child;
	}
	
	else
	{
		Node<E> parent = node.getParent();
		
		if (node == parent.getLeft())
		{
			parent.setLeft(child);
		}
		
		else
		{
			parent.setRight(child);
		}
	}
	
	size--;
	
	//removing node from memory
	E temp = node.getElement();
	node.setElement(null);
	node.setLeft(null);
	node.setRight(null);
	node.setParent(node);
	
	return temp;
  }
  
  public String toString() {
	  StringBuilder sb = new StringBuilder();
	  sb.append("[");
	  for(Position<E> p : positions()) {
		  sb.append(p.getElement());
		  sb.append(", ");
	  }
	  sb.append("]");
	  return sb.toString();
  }
 
  
  public static void main(String [] args) {
	  LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<Integer>();
	  
	  Position<Integer> root = bt.addRoot(12);
	  Position<Integer> p1 = bt.addLeft(root,  25);
	  Position<Integer> p2 = bt.addRight(root, 31);
	  
	  Position<Integer> p3 = bt.addLeft(p1, 58);
	  bt.addRight(p1, 36);
	  
	  Position<Integer> p5 = bt.addLeft(p2, 42);
	  bt.addRight(p2, 90);
	  
	  Position<Integer> p4 = bt.addLeft(p3, 62);
	  bt.addRight(p3,75);
	  
	  System.out.println("bt inorder " + bt.size() + " " + bt.inorder());
	  System.out.println("bt preorder " + bt.size() + " " + bt.preorder());
	  
	  System.out.println("NumChildren of root: " + bt.numChildren(bt.root));
	  System.out.println("bt2 height: " + bt.height(bt.root));
	  System.out.println("bt2 depth " + bt.depth(bt.root));
	  System.out.println("bt2 depth 62: " + bt.depth(p4));
	  System.out.println("bt2 depth 45: " + bt.depth(p5));
	  
	  System.out.println("--------------------------------------------------------------------------------------");
	  
	  LinkedBinaryTree<Integer> bt2 = new LinkedBinaryTree<Integer>();
	  int [] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
	  for(int i : arr) {
		  bt2.insert(i);
	  }
	  System.out.println("bt2: " + bt2.size() + " " + bt2);
	  
	  System.out.println("Insert 3");
	  bt2.insert(3);
	  System.out.println(bt2);
	  
	  System.out.println("Insert 16");
	  bt2.insert(16);
	  System.out.println(bt2);
	  
	  System.out.println("Insert 2");
	  bt2.insert(2);
	  System.out.println(bt2);
	  
	  System.out.println("Insert 41");
	  bt2.insert(41);
	  System.out.println(bt2);
  }
} 

