public class LinkedListDeque{
	//定义节点
	private class Node{
		private Node pre;
		private T item;
		private Node next;

		public Node(LinkedListDeque<T>.Node pre,T item,LinkedListDeque<T>.Node next){
			this.pre = pre;
			this.item = item;
			this.next = next;
		}
	}

	private Node node;
	private int size;

	public LinkedListDeque(){
		node = new Node(null,(T) new Object(),null);
		node.pre = node;
		node.next = node;
		size = 0;
	}
	public void addFrist(T item){
		Node newNode = new Node(node,item,node.next);
		node.next.pre = newNode;
		node.next = newNode;
		size++;
	}
	public void addList(T item){
		Node newNode = new Node(node.pre,item,node);
		node.pre.next = newNode;
		node.pre = newNode;
		size++;
	}
	public boolean isEmpty(){
		if(size == 0)
			return true;
		return false;
	}
	public int size(){
		return size;
	}
	public void printDeque(){
		for(Node i = node.next;i!=node;i = i.next){
			if(i.next = node){
				System.out.print(i.item);
				break;
			}
			System.out.print(i.item+" ");			
		}
	}
	public T removeFirst(){
		if(size == 0)
			return null;
		T temp = node.next.item;
		node.next = node.next.next;
		node.next.pre = node;
		size--;
		return temp;
	}
	public T removeLast(){
		if(size == 0)
			return null;
		T temp = node.pre.item;
		node.pre = node.pre.pre;
		node.pre.next = node;
		size--;
		return temp;
	}
	public T get(int index){
		if(size<index)
			return null;
		Node p = node.next;
		while(index>0){
			p = p.next;
			index--;
		}
		return p.item;
	}
	public T getRecursive(int index){
		if(size<index)
			return null;
		return getRecursive(node.next,index);
	}
	public T getRecursive（LinkedListDeque<T>.Node node,int i）{
		if(i==0)
			return node.item;
		return getRecursive(node.next,i-1);
	}
}