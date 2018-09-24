
public class HuffTree implements Comparable {

	private HuffBaseNode root;

	/** Constructors */
	public HuffTree(char el, int wt) {
		root = new HuffLeafNode(el, wt);
	}

	public HuffTree(HuffBaseNode l, HuffBaseNode r, int wt) {
		root = new HuffInternalNode(l, r, wt);
	}

	public HuffBaseNode root() {
		return root;
	}

	public int weight() // Weight of tree is weight of root
	{
		return root.weight();
	}

	public int compareTo(Object t) {
		HuffTree that = (HuffTree) t;
		if (root.weight() < that.weight())
			return -1;
		else if (root.weight() == that.weight()) {

			// check ascii order
			if (((HuffLeafNode) root).value() < ((HuffLeafNode) that.root).value()) {
				return -1;
			} else {
				return 1;
			}
		} else
			return 1;
	}

}// HuffTree

// -----------------------------------------------------------------------------HuffBaseNode
interface HuffBaseNode {
	boolean isLeaf();

	int weight();
}

// -----------------------------------------------------------------------------HuffLeafNode
/** Huffman tree node: Leaf class */
// holds CHAR and WEIGHT
class HuffLeafNode implements HuffBaseNode {
	private char element; // Element for this node
	private int weight; // Weight for this node

	/** Constructor */
	HuffLeafNode(char el, int wt) {
		element = el;
		weight = wt;
	}

	/** @return The element value */
	char value() {
		return element;
	}

	/** @return The weight */
	public int weight() {
		return weight;
	}

	/** Return true */
	public boolean isLeaf() {
		return true;
	}
}

// -----------------------------------------------------------------------------HuffInternalNode
/** Huffman tree node: Internal class */
// holds addition of left and right
class HuffInternalNode implements HuffBaseNode {
	private int weight;
	private HuffBaseNode left;
	private HuffBaseNode right;

	/** Constructor */
	HuffInternalNode(HuffBaseNode l, HuffBaseNode r, int wt) {
		left = l;
		right = r;
		weight = wt;
	}

	/** @return The left child */
	HuffBaseNode left() {
		return left;
	}

	/** @return The right child */
	HuffBaseNode right() {
		return right;
	}

	/** @return The weight */
	public int weight() {
		return weight;
	}

	/** Return false */
	public boolean isLeaf() {
		return false;
	}
}// HuffInternalNode
