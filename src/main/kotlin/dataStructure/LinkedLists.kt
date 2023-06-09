package dataStructure

class LinkedList : Iterable<Int> {  // creating node list, and setting iterable
    private data class Node(var nodeValue: Int, var next: Node? = null)

    private var head: Node? = null

    fun insert(n: Int) {        // it's the same as double linked list but we don't need to add previous and tail functionality
        if (head == null) head = Node(n)
        else {
            var cur = head
            while (cur?.next != null) {
                cur = cur.next
            }
            cur?.next = Node(n)
        }
    }

    fun deleteNode(value: Int) {
        if (head?.nodeValue == value) {
            head = head?.next
            return
        }
        var cur = head
        while (cur?.next != null) {
            if (cur.next?.nodeValue == value) {
                cur.next = cur.next?.next
                return
            }
            cur = cur.next
        }
    }

    fun print() {
        var cur = head
        while (cur != null) {
            print("${cur.nodeValue} ")
            cur = cur.next
        }
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            var current = head
            override fun hasNext(): Boolean {
                return current != null
            }

            override fun next(): Int {
                val result = current?.nodeValue ?: throw NoSuchElementException()
                current = current?.next
                return result
            }
        }
    }
}


// Double linked list

class DoublyLinkedList: Iterable<Int> {
    private data class Node(var nodeValue: Int, var previous: Node? = null, var next: Node? = null)     // setting previous i next node

    private var head: Node? = null  // head is the first node in the list with "index" [0]
    private var tail: Node? = null  // tail is last node in the list with "index" last

    fun insertAtHead(n: Int) {      // we are inserting node at first node
        val newNode = Node(n)       // creating new node
        if (head == null) {        // if there is no node in the list then we are adding first and setting head and tail to it
            head = newNode
            tail = newNode
        } else {
            newNode.next = head    // if not then we are linking newNode to head
            head?.previous = newNode    // and linking backed way from head to newNode
            head = newNode  // placing newNode at head
        }
    }
    fun print() {
        var cur = head
        while (cur != null) {       // every time we are iterating until current node is not equal null
            print("${cur.nodeValue} ")
            cur = cur.next
        }
    }

    fun deleteNode(value: Int) {
        var cur = head
        while (cur != null) {
            if (cur.nodeValue == value) {
                if (cur.previous != null) {
                    cur.previous?.next = cur.next   // if previous node != null then we are changing link from previous node to next node avoiding node we want to delete
                } else {
                    head = cur.next // if it is null then we are setting next node as head
                }
                if (cur.next != null) {     // same thing for tail
                    cur.next?.previous = cur.previous   // checking if next node is null and if != we are linking it with previous node
                } else {
                    tail = cur.previous // if it is null then we are setting tail as previous
                }
                return
            }
            cur = cur.next
        }
    }
    override fun iterator(): Iterator<Int> {    // to iterate we need to add iterator function
        return object : Iterator<Int> {
            var current = head
            override fun hasNext(): Boolean {   //overriding hasNext
                return current != null
            }

            override fun next(): Int {     // overriding next
                val result = current?.nodeValue ?: throw NoSuchElementException()
                current = current?.next
                return result
            }
        }
    }
    fun reverseIterator(): Iterator<Int> {  // creating next custom iterator to iterate in reverse
        return object : Iterator<Int> {
            var current = tail      // main difference is hera to setting current as tail
            override fun hasNext(): Boolean {
                return current != null
            }

            override fun next(): Int {
                val result = current?.nodeValue ?: throw NoSuchElementException()
                current = current?.previous     // and here to set next element as previous
                return result
            }
        }
    }
}

fun main() {
    val n = LinkedList()
    val d = DoublyLinkedList()

    n.insert(5)
    n.insert(3)
    n.insert(7)
    n.insert(9)
    n.print()
    println()
    n.deleteNode(3)
    n.print()
    println()
    for (i in n) {
        println(i)
    }
    println("Double linked list")
    d.insertAtHead(9)
    d.insertAtHead(6)
    d.insertAtHead(2)
    d.insertAtHead(12)
    d.print()
    println()
    d.deleteNode(6)

    val iterator = d.reverseIterator()
    for (i in iterator){
        println(i)
    }
    println("switch")
    for (i in d) {
        println(i)
    }
    d.print()

    /*    5 3 7 9
        5 7 9
        5
        7
        9
        Double linked list
        12 2 6 9
        9
        2
        12
        switch
        12
        2
        9
        12 2 9*/
}