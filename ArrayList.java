import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private T[] arr;
	private int size;

	public ArrayList(){
		/* instantiate the array to be a size of 10 */
		arr = (T[]) new Object[10];
		size = 0;
	}

	public void add(T item){
		/* If the size is full, grow the array before adding */
		if (size == arr.length){
			growArray();
		}

		/* add the item to the last spot */
		arr[size] = item;
		size++;
	};

	public void add(int pos, T item){
		/* If the size is full, grow the array before adding */
		if (size == arr.length){
			growArray();
		}

		// move all items down for new item;
		for (int i = size; i > pos; i--){
			arr[i] = arr[i - 1];
		}

		/* add the item at the position */
		arr[pos] = item;
		size++;
	}

	public T get(int pos){
		/* return the item at the position */
		return arr[pos];
	}

	public T remove(int pos){
		T value = arr[pos];

		/* move items back */
		for (int i = pos + 1; i < size; i++){
			arr[i - 1] = arr[i];
		}
		size--;
		return arr[pos];
	}

	public int size(){
		/* return the size of the array */
		return this.size;
	}

	private void growArray(){
		/* create a temp array that's double the size of the current array and copy all values over */
		T[] temp = (T[]) new Object[arr.length * 2];
		temp = Arrays.copyOf(arr, temp.length);
		arr = temp;
	}

}