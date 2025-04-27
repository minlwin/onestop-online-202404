function sumBySide(array, isEven) {
    var result = 0;
    for (var i = 0; i < array.length; i++) {
        if (isEven === undefined) {
            result += array[i];
        }
        else if (isEven && i % 2 === 0) {
            result += array[i];
        }
        else if (!isEven && i % 2 !== 0) {
            result += array[i];
        }
    }
    return result;
}
var ARRAY = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log("sumBySide(ARRAY) is ".concat(sumBySide(ARRAY)));
console.log("sumBySide(ARRAY, true) is ".concat(sumBySide(ARRAY, true)));
console.log("sumBySide(ARRAY, false) is ".concat(sumBySide(ARRAY, false)));
//# sourceMappingURL=body-and-returntype.js.map