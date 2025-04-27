var Hello = /** @class */ (function () {
    function Hello() {
    }
    return Hello;
}());
var hello = new Hello;
hello.id = 1;
hello.phone = "09181817171";
hello.name = "Aung Aung";
var course = {
    id: 1,
    name: "Type Script"
};
var helloArray = [];
function showWithTurple(input) {
    for (var i = 0; i < input[1]; i++) {
        console.log(input[0]);
    }
}
var arg1 = ["Hello Turple", 3];
var poped = arg1.pop();
console.log(poped);
console.log(arg1);
showWithTurple(arg1);
//# sourceMappingURL=datatypes.js.map