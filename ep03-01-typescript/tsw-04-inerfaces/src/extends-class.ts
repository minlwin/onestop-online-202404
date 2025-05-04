class Controls {
    private state:string
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

class Select extends Controls implements SelectableControls {
    selected: boolean
}