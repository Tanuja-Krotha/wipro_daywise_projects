// stack.ts

class Stack<T> {
    private items: T[] = [];

    push(item: T): void {
        this.items.push(item);
    }

    pop(): T | undefined {
        return this.items.pop();
    }

    peek(): T | undefined {
        return this.items[this.items.length - 1];
    }
}


let numberStack = new Stack<number>();
numberStack.push(10);
numberStack.push(20);
console.log(numberStack.peek()); 
console.log(numberStack.pop());  
console.log(numberStack.peek()); 

let stringStack = new Stack<string>();
stringStack.push("A");
stringStack.push("B");
console.log(stringStack.peek()); 
console.log(stringStack.pop());  
