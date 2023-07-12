
fun main() {
    var head = createLinkedList()
    insertAtPosition(4,Node("Mary"),head)
    traverseList(head)
    println("---------")
     head = insertAtHead(Node("Joan"),head)
    traverseList(head)
    println("---------")
    removeAtPosition(7,head)
    traverseList(head)
    println("---------")
    insertAfterNode("Joy",Node("Mercy"),head)
    traverseList(head)



}
class Node (var name:String){
    var next:Node?=null
}
fun createLinkedList(): Node {
    val node1 = Node("Susan")
    val node2 = Node("Eunice")
    val node3 = Node("Juliet")
    val node4 = Node("Joy")
    val node5 = Node("Valary")
    val node6 = Node("Elizabeth")
    val node7 = Node("Joyuese")

    node1.next=node2
    node2.next=node3
    node3.next =node4
    node4.next=node5
    node5.next=node6
    node6.next=node7

    return node1
}

fun traverseList(head:Node){
    var current:Node? = head
    while (current!=null){
        println(current.name)
        current=current.next
    }

}

fun insertAtPosition(pos:Int,nodeToInsert:Node,head:Node){
    var counter = 1
    var current:Node? = head
    while (counter<pos-1){
        current = current?.next
        counter++
    }
    nodeToInsert.next =current?.next
    current?.next = nodeToInsert
}

fun insertAfterNode(name: String,nodeToInsert: Node,head: Node){
    var current:Node?= head
    while (current!!.name!=name){
        current = current.next!!
    }
    nodeToInsert.next= current.next
    current.next = nodeToInsert


}

fun insertAtHead(nodeToInsert: Node,head: Node):Node{
    nodeToInsert.next=head

    return nodeToInsert
}

fun removeAtPosition(pos:Int,head:Node){
    var counter = 1
    var current:Node? = head

    while (counter<pos-1){
        current = current?.next
        counter ++
    }
    current?.next = current?.next?.next
}

