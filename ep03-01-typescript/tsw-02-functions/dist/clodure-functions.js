function sayHello(name) {
    return function (time) {
        for (var i = 0; i < time; i++) {
            console.log("Hello ".concat(name));
        }
    };
}
var helloWorker = sayHello("TypeScript");
helloWorker(3);
helloWorker(1);
//# sourceMappingURL=clodure-functions.js.map