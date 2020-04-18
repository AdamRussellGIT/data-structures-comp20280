package projectCode20280;

import java.util.Comparator;

/**
 * An implementation of a sorted map using an Splay tree.
 * SplayTreeMap extends TreeMap<K, V> to get all of its functionality
 * 		while also adding it's own extra methods to ensure we get the
 * 			type of ordered map that we want.
 * 
 * A BalanceableBinaryTree is used instead of a LinkedBinaryTree.
 * 	This is because the BalanceableBinaryTree has an extended node class, and a few
 * 		extra methods to help with computing a correct re-balance of the tree.
 */

public class SplayTreeMap<K, V> extends TreeMap<K,V> {

	  /** Constructs an empty map using the natural ordering of keys. */
	  public SplayTreeMap() { super(); }

	  /**
	   * Constructs an empty map using the given comparator to order keys.
	   * @param comp comparator defining the order of keys in the map
	   */
	  public SplayTreeMap(Comparator<K> comp) { super(comp); }

	  /** Utility used to rebalance after a map operation. */
	  private void splay(Position<Entry<K,V>> p) {
		  while (!isRoot(p))
		  {
			  Position<Entry<K, V>> parent = parent(p);
			  Position<Entry<K, V>> grandparent = parent(parent);
			  
			  //zig case
			  if (grandparent == null)
			  {
				  tree.rotate(p);
			  }
			  
			  //zig-zig case
			  else if ((parent == left(grandparent)) == (p == left(parent)))
			  {
				  //shift the parent up, and the shift p up
				  tree.rotate(parent);
				  tree.rotate(p);
			  }
			  
			  //zig-zag case
			  else
			  {
				  //move p up twice
				  tree.rotate(p);
				  tree.rotate(p);
			  }
		  }
	  }

	  /** Overrides the TreeMap rebalancing hook that is called after a node access. */
	  @Override
	  protected void rebalanceAccess(Position<Entry<K,V>> p) {
		  if (isExternal(p))
		  {
			  p = parent(p);
		  }
		  
		  if (p != null)
		  {
			  splay(p);
		  }
	  }

	  /** Overrides the TreeMap rebalancing hook that is called after an insertion. */
	  @Override
	  protected void rebalanceInsert(Position<Entry<K,V>> p) {
	  	splay(p);
	  }

	  /** Overrides the TreeMap rebalancing hook that is called after a deletion. */
	  @Override
	  protected void rebalanceDelete(Position<Entry<K,V>> p) {
		  if (!isRoot(p))
		  {
			  splay(parent(p));
		  }
	  }

	  public String toString()
	  {
	  	return super.toString();
	  }
	  
}
