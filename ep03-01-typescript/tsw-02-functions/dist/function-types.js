// Named Function
function sumAll(array) {
    var sum = 0;
    for (var i = 0; i < array.length; i++) {
        sum += array[i];
    }
    return sum;
}
var array = [1, 2, 3, 4, 5];
var result = sumAll(array);
console.log("Sum of ".concat(array, " is ").concat(result));
// Anonymous Function
var isEven = function (input) {
    return input % 2 === 0;
};
for (var _i = 0, array_1 = array; _i < array_1.length; _i++) {
    var element = array_1[_i];
    console.log("".concat(element, " is ").concat(isEven(element) ? 'Even Number' : 'Odd Number'));
}
// Arrow Function
var findIndex = function (array, element) {
    var index = -1;
    for (var i = 0; i < array.length; i++) {
        if (array[i] === element) {
            return i;
        }
    }
    return index;
};
console.log("Index of 3 is ".concat(findIndex(array, 3)));
console.log("Index of 6 is ".concat(findIndex(array, 6)));
//# sourceMappingURL=function-types.js.map