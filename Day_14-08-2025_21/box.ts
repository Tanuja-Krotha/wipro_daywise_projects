// box.ts

class Box<T> {
    value: T;

    constructor(value: T) {
        this.value = value;
    }

    getValue(): T {
        return this.value;
    }
}


let numberBox = new Box<number>(123);
console.log(numberBox.getValue()); 

let stringBox = new Box<string>("Hello, TypeScript");
console.log(stringBox.getValue()); 

let booleanBox = new Box<boolean>(true);
console.log(booleanBox.getValue()); 
