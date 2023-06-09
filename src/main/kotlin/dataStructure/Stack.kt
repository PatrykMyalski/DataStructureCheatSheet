package dataStructure


/*Stack is data structure that is all around top of the stack. FIFO - first in first out

Complexity:
pushing = 0(1)
popping = 0(1)
peeking = 0(1)
searching = 0(n)
size = 0(1)

Example:
We have brackets: "[]{{()}}"
0,25.checking if stack is empty when current bracket is rightSided, if it is then return false
0,5. check if current bracket is pairing first bracket in the stack, if it is then pop it.
1.we are pushing first leftSided bracket to the stack "["
2,75. we are popping bracket because it is matching "]".
3. push next bracket "{"
4. push next bracket "{"
5.push next bracket "("
6,75. we are popping "(" because it is matching with ")"
7,75 we are popping "{" because it is matching with "}"
8,75 we are popping "{" because it is matching with "}"
9. if brackets we are adding ended we need to check if some left sided bracket are in the stack, if true then return false
10. if list of bracket ended and our stack is empty return true



Stack is commonly used in:
 undo mechanism in text editors
 go back to the last page
used in compiler syntax checking for matching brackets and braces
 used to support recursion by keeping track of previous function calls

 Usage:
 We can import stack library from java or just Deque which mean double ended queue and can work as queue and stack
 You can use a stack data structure in Kotlin by importing the `Stack` library from Java or by using `Deque` which means a double-ended queue and can work both as a queue and a stack.
 One way to use `Deque` is by using the `ArrayDeque` class introduced in Kotlin 1.3.70, which functions as both a queue and a stack, like Java's `java.util.Deque`
val stack = ArrayDeque(listOf(1, 2, 3)) // stack: [1, 2, 3]
stack.addLast(0) // stack: [1, 2, 3, 0] (push)
val value = stack.removeLast() // value: 0, stack: [1, 2, 3] (pop)
Note that if an `ArrayDeque` is empty when you call `removeFirst` or `removeLast`, it will throw a `kotlin.NoSuchElementException`. If you don't want to check the size of your deque every time you need to access it,
then you should use the `removeFirstOrNull` and `removeLastOrNull` functions.
 */
fun main(){
    val stack = ArrayDeque(listOf(1, 2, 3)) // stack: [1, 2, 3]
    stack.addLast(2) // stack: [1, 2, 3, 2] (push)
    val value = stack.removeLast() // value: 2, stack: [1, 2, 3] (pop)
    print("$stack $value")
    //[1, 2, 3] 2
}