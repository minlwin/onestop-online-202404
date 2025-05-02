function showItem(item) {
    console.log("".concat(item.id, " : ").concat(item.name));
}
var Product = /** @class */ (function () {
    function Product(id, name, price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    return Product;
}());
var SaleItem = /** @class */ (function () {
    function SaleItem(id, name) {
        this.id = id;
        this.name = name;
    }
    return SaleItem;
}());
showItem(new SaleItem(1, "Pepsi"));
showItem(new Product(2, "T Shirt", 15000));
showItem({ id: 10, name: "Truck" });
function defineShape(arg) {
    console.log(arg.name);
    console.log(arg.value);
}
defineShape({ name: "Test" });
defineShape({ name: "Test", value: 10 });
defineShape({ name: "Test", value: 10, order: "Desc", others: true });
//# sourceMappingURL=shape-of-an-object.js.map