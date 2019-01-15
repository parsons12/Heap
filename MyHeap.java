/**
 * Initialize a heap using the bottom up method. Also implements delete and
 * insert methods while maintaining the conditions of a heap
 * 
 * @author Blake Parsons
 * @since 11/15/2018
 */
public class MyHeap extends Heap {
	public MyHeap(int size) {
		super(size);
	}

	/**
	 * Initializes a heap using the bottom up method.
	 * 
	 * @param: array with contents to populate heap
	 * 
	 */
	public void initializeHeap(int[] initialContents) throws Exception {
		H[0] = 0;
		for (int i = 0; i < initialContents.length; i++) {
			H[i + 1] = initialContents[i];
		}
		heapCount = initialContents.length;// set the heap count to length of array
		boolean isHeap = false;
		if (initialContents.length > arraySize - 1) {
			throw new Exception();
		}
		for (int i = Math.floorDiv(heapCount, 2); i > 0; i--) {
			int k = i;
			int temp = this.H[k];
			isHeap = false;// set heap to false initially
			while (!isHeap && 2 * k <= heapCount) {
				int j = 2 * k;
				if (j < heapCount) {
					if (H[j] < H[j + 1]) {
						j = j + 1;
					}
				}
				if (temp >= this.H[j]) {
					isHeap = true;
				} else {
					this.H[k] = this.H[j];
					k = j;
				}
				this.H[k] = temp;// swap
			}
		}
	}

	/**
	 * Method to delete the element with the highest priority
	 * 
	 * @return: the deleted value
	 */
	public int delete() throws Exception {
		if (heapCount <= 0) {
			throw new Exception();
		}
		int k = H[1];// set k to deleted value
		swap(H, 1, heapCount);
		heapCount--;
		sift(H, 1);// heapify the array
		return k;
	}

	/**
	 * Method to find the highest priority of the heap. Which will be the first
	 * element in the array since it is "heapified"
	 * 
	 * @return integer value of highest priority
	 */
	@Override
	public int getHeighestPriority() throws Exception {
		if (heapCount == 0) {// if empty
			throw new Exception();
		}
		return this.H[1];
	}

	/**
	 * insert a value into the heap into the correct position to maintain the
	 * conditions necessary to be a heap
	 * 
	 * @param priority value to insert
	 * 
	 */
	public void insert(int priority) throws Exception {
		Integer i = new Integer(priority);
		if (heapCount == H.length - 1) {// if full
			throw new Exception();
		}
		heapCount++;
		H[heapCount] = priority;
		if (heapCount > 1) {
			int temp;
			int child = heapCount;
			while (child != 1 && i.compareTo(H[child / 2]) > 0) {
				temp = H[child];
				H[child] = H[child / 2];
				H[child / 2] = temp;
				child = child / 2;
			}
		}
	}

	/**
	 * 
	 * @param arr array to act as heap
	 * @param     i: integer for index Description: method to heapify the new
	 *            contents of array
	 */
	public void sift(int arr[], int i) {
		int leftChild = 2 * i;// set children
		int rightChild = 2 * i + 1;
		int j = i;
		if (leftChild <= (heapCount) && arr[leftChild] > arr[i])
			j = leftChild;
		if (rightChild <= (heapCount) && arr[rightChild] > arr[j])
			j = rightChild;
		if (j != i) {
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			sift(arr, j); // called until dominance condition
		}
	}

	/**
	 * 
	 * Method to swap two elements in an array
	 * 
	 * @param a integer array representing heap
	 * @param i integer representing index of first element
	 * @param j integer representing index of second element Description: Performs
	 *          swap upon two given values within an array.
	 */
	public void swap(int a[], int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
