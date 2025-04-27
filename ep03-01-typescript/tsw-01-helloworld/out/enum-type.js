var Level;
(function (Level) {
    Level[Level["Basic"] = 0] = "Basic";
    Level[Level["Intemediate"] = 1] = "Intemediate";
    Level[Level["Advance"] = 2] = "Advance";
})(Level || (Level = {}));
console.log(Level[Level.Basic]);
console.log(Level[Level.Intemediate]);
console.log(Level[Level.Advance]);
console.log(Level["Basic"]);
console.log(Level["Intemediate"]);
console.log(Level["Advance"]);
console.log(Level);
//# sourceMappingURL=enum-type.js.map