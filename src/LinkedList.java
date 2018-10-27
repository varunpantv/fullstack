
public class LinkedList {
	Node head;
	
	public void insert(int data)
	{
		Node node=new Node();
		node.data=data;
		node.next=null;
		
		if (null==head)
			head=node;
		else
		{
			Node n=head;
			
			//reach the end node
			while (n.next != null)
			{
				n=n.next;
			}
			
			//insert
			n.next=node;
		}
		
	}
	
	public void insertAtStart(int data)
	{
		Node node = new Node();
		node.data=data;
		node.next=head;
		
		head=node;
	}
	public void insertAt(int index, int data)
	{
		if (index==0)
		{
			insertAtStart(data);
		}
		else
		{	Node node=new Node();
			node.data=data;
			node.next=null;
			
			Node n=head;
			for (int i=0;i<index-1;i++)
			{
				n=n.next;
			}
			node.next=n.next;
			n.next=node;
		}
	}
	public void deleteAt(int index)
	{
		if (0==index)
		{
			head=head.next;
		}
		else
		{
			Node n=head;
			Node n1=null;
			for (int i=0;i<index-1;i++)
			{
				n=n.next;
			}
			n1=n.next;
			n.next=n1.next;
			System.out.println("n1	"+n1.data);
			n1=null;//eligible for garbage collection
		}
	}
	public void show()
	{
		Node node=head;
		
		while (node.next!=null)
		{
			System.out.println(node.data);
			node=node.next;
		}
		System.out.println(node.data);
	}
}
