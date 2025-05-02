var CameraConstructorInf = /** @class */ (function () {
    function Camera(lences) {
        this.lences = lences;
    }
    Camera.prototype.takePicture = function () {
        console.log("Taking Picture");
    };
    return Camera;
}());
function createCamera(cons, lens) {
    return new cons(lens);
}
var camera = createCamera(CameraConstructorInf, [100, 50]);
//# sourceMappingURL=static-and-instance.js.map