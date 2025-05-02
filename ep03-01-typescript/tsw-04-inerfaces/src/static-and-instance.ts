interface CameraFeature {
    takePicture():void
}

interface CameraConstructor {
    new (lence: [number, number]):CameraFeature
}

const CameraConstructorInf:CameraConstructor = class Camera implements CameraFeature {
    
    constructor(readonly lences: [number, number]) {}

    takePicture(): void {
        console.log("Taking Picture")
    }
}

function createCamera(cons:CameraConstructor, lens : [number, number]) {
    return new cons(lens)
}

const camera = createCamera(CameraConstructorInf, [100, 50])
