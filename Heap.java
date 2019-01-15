/**
 * A priority queue that supports deletion, insertion and determining
 *   which item has the highest priority.
 * 
 */

public abstract class Heap {
	/** integer array for storage */
	int[] H;
	/** physical size of array storage for heap */
	int arraySize;
	/** number of values stored in the heap (i.e., logical size of array) */
	int heapCount;

	public Heap(int size) {
		this.H = new int[size + 1];
		this.arraySize  = size + 1;
		this.heapCount = 0;
	}
	
	public abstract void initializeHeap(int[] initialContents) throws Exception;
	public abstract int delete() throws Exception;
	public abstract int getHeighestPriority() throws Exception;
	public abstract void insert(int priority) throws Exception;
	
	/**
	 * Checks to see if the contents of the Heap array satisfies the parental
	 * dominance properly.  It checks up to the size of the heap specified through heapCount.
	 *   
	 * @return A boolean value indicating if the current contents of H up to 'heapCount' represents a heap.
	 */
	public boolean isHeap() {
		for(int i = 1; i <= (int)(heapCount/2); i++) {
			if(this.H[i] < this.H[2*i] || ((2*i + 1 < this.heapCount) && this.H[i] < this.H[2*i+1])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Prints out the contents of the heap array.
	 */
	public void printHeap() {
		System.out.print("Heap array:");
		for(int i = 1; i <= heapCount; i++) {
			System.out.print(" " + this.H[i]);
		}
		System.out.println("");
	}
	
	/**
	 * Prints out each parent node in the heap along with index and 
	 * the value and location of its children.
	 */
	public void printParentsWChildren() {
		System.out.print("Parent Value (index): Children (indices)\n======\n");
		for(int i = 1; i <= (int)(heapCount/2); i++) {
			System.out.print(this.H[i] + "(" + i + "): ");
			System.out.print(this.H[2*i] + "(" + 2*i + ")");
			// Check to make sure that the node as two children since
			//  the last parent could have only one child
			if(2*i+1 <= this.heapCount ) {
				System.out.print(" " + this.H[2*i+1] + "(" + (2*i+1) + ")");
			}
			System.out.println("");
		}

	}
	
}
