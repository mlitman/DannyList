
public class DannyList 
{
	private Node head;
	private int count;
	
	public DannyList()
	{
		this.head = null;
		this.count = 0;
	}
	
	public int getCount() {
		return count;
	}

	public int get(int index)
	{
		Node currNode = this.head;
		for(int i = 0; i < index; i++)
		{
			currNode = currNode.getNextNode();
		}
		return currNode.getPayload();
	}
	
	public void addFront(int value)
	{
		Node n = new Node(value);
		if(this.count == 0)
		{
			this.head = n;
		}
		else
		{
			n.setNextNode(this.head);
			this.head = n;
		}
		this.count++;
	}
	
	public int removeFront()
	{
		Node node2Return = this.head;
		this.head = this.head.getNextNode();
		node2Return.setNextNode(null);
		this.count--;
		return node2Return.getPayload();
	}
	
	public void addEnd(int value)
	{
		if(this.count == 0)
		{
			this.addFront(value);
		}
		else
		{
			Node n = new Node(value);
			
			//traverse to the end of the list
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				currNode = currNode.getNextNode();
			}
			//currNode points to the last element in the list
			currNode.setNextNode(n);
		}
		this.count++;
	}
	
	
	public int removeEnd()
	{
		if(this.count == 1)
		{
			return this.removeFront();
		}
		 
		Node node2Return = this.head;
		while(node2Return.getNextNode() != null)
		{
			node2Return = node2Return.getNextNode();
		}
		
		Node newLastGuy = this.head;
		while(newLastGuy.getNextNode() != node2Return)
		{
			newLastGuy = newLastGuy.getNextNode();
		}
		
		newLastGuy.setNextNode(null);
		this.count--;
		return node2Return.getPayload();
	}
	
	public void displayOOP()
	{
		Node currNode = this.head;
		for(int i = 0; i < this.count; i++)
		{
			currNode.display();
			currNode = currNode.getNextNode();
		}
		System.out.println(this.count == 0?"Empty List":"");
	}
	
	public void display()
	{
		//this is too procedural
		if(this.head == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				System.out.print(currNode.getPayload() + " -> ");
				currNode = currNode.getNextNode();
			}
			if(currNode != null)
			{
				System.out.println(currNode.getPayload());
			}
			else
			{
				System.out.println();
			}
		}
	}
}
