// Create an Object without Class
var user1 = {
    name: "Aung Aung",
    phone: "0918171671",
    email: "aung@gmail.com"
};
var User = /** @class */ (function () {
    function User(name, phone, email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    return User;
}());
var user2 = new User("Aung Aung", "0918117111", "aung@gmail.com");
//# sourceMappingURL=create-object.js.map