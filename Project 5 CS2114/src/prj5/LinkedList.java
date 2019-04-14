/**
 * 
 */
package prj5;

/**
 * @author Tom
 *
 */
public class LinkedList<T> 
{
    
    private class Node<S>
    {
        S data;
        Node<S> next;
        
        public Node(S data, Node<S> next)
        {
            this.data = data;
            this.next = next;
        }
        
        public Node<S> getNext()
        {
            return next;
        }
        
        public S getData()
        {
            return data;
        }
        
        public void setData(S data)
        {
            this.data = data;
        }
        
        public void setNext(Node<S> next)
        {
            this.next = next;
        }
    }
    
    Node<T> headNode;
    int size;
    
    public LinkedList()
    {
        headNode = new Node(null, null);
        size = 0;
    }
    
    public T get(int index)
    {
        Node<T> header = headNode;
        
        if (index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        
        for (int i = 0; i < index; i++)
        {
            if (i == index)
            {
                return header.getNext().getData();
            }
            else
            {
                header = header.getNext();
            }
        }
        
        return null;
    }
    
    public void add(T data)
    {
        Node<T> newNode = new Node<T>(data, headNode.getNext());
        headNode.setNext(newNode);
        size++;
    }
    
    public boolean remove(int index)
    {
        Node<T> header = headNode;
        for (int i = 0; i < index; i++)
        {
            if (i == index)
            {
                header.getNext().setNext(header.getNext().getNext());
                size--;
                return true;
            }
        }
        return false;
    }
    
    public boolean remove(T object)
    {
        Node<T> header = headNode;
        while (header.getNext() != null)
        {
            if (header.getNext().getData() == object)
            {
                header.setNext(header.getNext().getNext());
                size--;
                return true;
            }
            header = header.getNext();
        }
        return false;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public void sort()
    {
        
    }
    
    public LinkedList<T> clone()
    {
        LinkedList<T> clone = new LinkedList<T>();
        Node<T> header = headNode;
        
        while (header.next != null)
        {
            clone.add(header.getNext().getData());
            header = header.getNext();
        }
        
        return clone;
    }
}
