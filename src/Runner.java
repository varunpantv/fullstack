
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		LinkedList list=new LinkedList();
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(0);
		list.add(4,12);
		list.add(0,7);
		System.out.println("List: "+list);*/
	
		LinkedList list=new LinkedList();
		
		list.insert(18);
		list.insert(45);
		list.insert(12);
		
//		list.show();
//		System.out.println("----------------");
		list.insertAtStart(7);
		list.insertAt(0,55);
		list.deleteAt(2);
		list.show();
		
		
		
	}

}
