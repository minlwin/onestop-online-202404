var Controls = /** @class */ (function () {
    function Controls() {
    }
    return Controls;
}());
function useSelectControl(control) {
    console.log(control.selected);
    console.log(control.value);
}
var Select = /** @class */ (function () {
    function Select(value, selected, touch) {
        if (touch === void 0) { touch = false; }
        this.value = value;
        this.selected = selected;
        this.touch = touch;
    }
    return Select;
}());
//# sourceMappingURL=extends-class.js.map