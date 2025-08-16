// pair.ts
// Generic function that returns a tuple of two values
function pair(first, second) {
    return [first, second];
}
// Example usages
var numAndString = pair(101, "Tanuja");
console.log(numAndString);
var boolAndNumber = pair(true, 42);
console.log(boolAndNumber);
var stringAndBoolean = pair("Hello", false);
console.log(stringAndBoolean);
