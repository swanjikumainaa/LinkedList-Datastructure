import kotlin.math.ceil

fun main() {
//    step11
    var head2 =newCreateLinkedList()
    var cycle = detectCycle(head2)
    println(cycle?.name)
    println("----------")

//    step 12 Floyd hare and tortoise algo to detect cycle
    var cyc = floydsCycle(head2)
    println(cyc?.name)
    println("-----------")

//step1
    var head = createLinkedList()
//  step10
    var kth = findKthElementFromEnd(6,head)
    println(kth.name)
    println("---------------")
//step8
    var middle = findMiddleNode(head)
    println(middle.name)

    println("-------------")
//step9
    val mid = findMiddle(head)
    println(mid.name)

    println("--------------")
//step2
    traverseList(head)
    println("---------")

//step3
    insertAtPosition(4,Node("Mary"),head)
    traverseList(head)
    println("---------")
//step4
     head = insertAtHead(Node("Joan"),head)
    traverseList(head)
    println("---------")

//step5
    removeAtPosition(7,head)
    traverseList(head)
    println("---------")

//step6
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
fun newCreateLinkedList(): Node {
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
    node7.next=node3

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

fun findMiddleNode(head: Node): Node {
    var current:Node? =head
    var counter = 1

    while (current!=null){
        current =current.next
        counter++
    }
    var mid = ceil(counter/2.0).toInt()

    counter = 1
    current = head
    while (counter<mid){
        current = current?.next
        counter ++

    }
    return current!!
}

fun findMiddle(head: Node):Node{
    var fast:Node?=head
    var slow:Node?=  head

    while(fast?.next!=null){
        fast = fast.next?.next
        slow =slow?.next
    }
    return slow!!
}

fun findKthElementFromEnd(k:Int,head: Node):Node{
    var fast:Node? = head
    var slow:Node? = head
    var counter = 1

    while(counter<k){
        fast= fast?.next
        counter++
    }
    while(fast?.next!=null){
        fast = fast.next
        slow = slow?.next
    }
    return slow!!
}
fun detectCycle(head2:Node): Node? {
    var visited = mutableListOf<Node>()
    var current:Node? = head2
    while (current!=null){
        if(visited.contains(current)){
            return current
        }
        else {
            visited.add(current)
            current = current.next
        }
    }
    return null
}

fun floydsCycle(head2: Node):Node?{
    var fast:Node? = head2
    var slow:Node? = head2

    while(fast?.next!=null){
        fast =fast.next?.next
        slow = slow?.next
        if (fast==slow){
            break
        }
    }
    fast =head2
    while (fast?.next!=null){
        fast =fast.next
        slow=slow?.next
        if(fast==slow){
            return fast
        }
    }
    return null

}


