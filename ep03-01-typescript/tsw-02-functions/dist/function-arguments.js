// Argument With Types
function showFullName(firstName, lastName) {
    return "".concat(firstName, " ").concat(lastName);
}
var fullName = showFullName("Zaw Min", "Lwin");
console.log(fullName);
// Optional Arguments
function getFullName(firstName, lastName) {
    if (firstName && lastName) {
        return "".concat(firstName, " ").concat(lastName);
    }
    if (firstName && !lastName) {
        return firstName;
    }
    if (!firstName && lastName) {
        return lastName;
    }
    return "No Name";
}
var result1 = getFullName();
var result2 = getFullName("Min Lwin");
var result3 = getFullName("Zaw", "Min Lwin");
var result4 = getFullName(undefined, "Lwin");
console.log("getFullName() is ".concat(result1));
console.log("getFullName(\"Min Lwin\") is ".concat(result2));
console.log("getFullName(\"Zaw\", \"Min Lwin\") is ".concat(result3));
console.log("getFullName(undefined, \"Lwin\") is ".concat(result4));
// Default Arguments
function greet(user, count) {
    if (user === void 0) { user = "User"; }
    if (count === void 0) { count = 1; }
    for (var i = 0; i < count; i++) {
        console.log("Hello ".concat(user));
    }
}
greet();
greet("Aung Aung");
greet("Thidar", 3);
greet(undefined, 5);
//# sourceMappingURL=function-arguments.js.map