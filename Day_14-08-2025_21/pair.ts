// pair.ts

// Generic function that returns a tuple of two values
function pair<T, U>(first: T, second: U): [T, U] {
    return [first, second];
}

// Example usages
let numAndString = pair<number, string>(101, "Tanuja");
console.log(numAndString);

let boolAndNumber = pair<boolean, number>(true, 42);
console.log(boolAndNumber);

let stringAndBoolean = pair<string, boolean>("Hello", false);
console.log(stringAndBoolean);
