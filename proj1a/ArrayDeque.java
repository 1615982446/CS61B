public class ArrayDeque{

	private T[] items;
	private int left;
	private int right;
	private int capacity = 8;

	public ArrayDeque(){
		items = (T[]) new Object[capacity];
		left = 0;
		right = 0;
	}
	public void addFirst(T item){
		if(size() == capacity-1)
			resize((int)(capacity*1.5));
		left = (left-1+capacity)%capacity;
		item[left] = item;
	}
	public void addLast(T item){
		if(size() == capacity-1)
			resize((int)(capacity*1.5));
		items[right] = item;
		right = (right+1+capacity)%capacity;
	}
	public boolean isEmpty(){
		return left == right;
	}
	public int size(){
		return (right-left+capacity)%capacity;
	}
	public void printDeque(){
		if(left<right){
			for(int i = left ;i<right ;i++){
				if(i == right-1){
					System.out.print(items[i]);
					break;
				}
				System.out.print(items[i]+" ");
			}
		}else if(left>right){
			for(int i = left;i<capacity;i++)
				System.out.print(items[i]);
			for(int i = 0;i<right-1;i++)
				System.out.println(items[i]+" ");
			System.out.println(items[i]);
		}
	}
	public T removeFirst(){
		if(left == right)
			return null;
		T temp = items[left];
		left = (left+1)%capacity;
		if(isLowUsageRate()){
			resize((int)(capacity*0.5));
		}
		return temp;
	}
	public T removeLast(){
		if(left == right)
			return null;
		T temp = items[right];
		right = (right-1)%capacity;
		if(isLowUsageRate()){
			resize((int)(capacity*0.5));
		}
		return temp;
	}
	public T get(int index){
		if(index <0 || index >=size() || isEmpty())
			return null;
		if(left<right)
			return items[index+left];
		else if(left>right){
			if(index+left<capacity)
				return items[index+left];
			else
				return items[(index+left)%capacity];
		}
		return null;
	}
	private boolean isLowUsageRate(){
		return capacity>=16&&size()/(double)capacity<0.25;
	}
	private void resize(int newSize){
		T[] newArray = (T[]) new Object[newSize];
		
        int size = size();
        if (left < right) {
            for (int i = left, j = 0; i < right && j < size; i++, j++) {
                newArray[j] = items[i];
            }
        } else if (left > right) {
            int j = 0;
            for (int i = left; j < capacity - left; i++, j++) {
                newArray[j] = items[i];
            }
            for (int i = 0; j < size; i++, j++) {
                newArray[j] = items[i];
            }
        }
        left = 0;
        right = size;
        items = newArray;
        capacity = newSize;
	}
}