// box.ts
var Box = /** @class */ (function () {
    function Box(value) {
        this.value = value;
    }
    Box.prototype.getValue = function () {
        return this.value;
    };
    return Box;
}());
var numberBox = new Box(123);
console.log(numberBox.getValue());
var stringBox = new Box("Hello, TypeScript");
console.log(stringBox.getValue());
var booleanBox = new Box(true);
console.log(booleanBox.getValue());
