class Controls {
    value:string
    action:() => void
}

interface SelectableControls extends Controls {
    readonly selected:boolean
}

function useSelectControl(control:SelectableControls) {
    console.log(control.selected)
    console.log(control.value)
}

class Select implements SelectableControls {
    constructor(public value:string, readonly selected:boolean) {}

    action() {
        
    }
}