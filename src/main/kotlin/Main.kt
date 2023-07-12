
fun main() {
    var head = createLinkedList()
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
    val node7 = Node("Joyeuese")

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