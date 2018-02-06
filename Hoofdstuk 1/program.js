var person = {
	"first-name": 'Yannick',
	"second-name": "Leeuwen",
	"age": 21
};

document.writeln(person["first-name"] + ", " + person["second-name"] + ", " + person["age"]);

person['middle-name'] = "van";
var yan = person["middle-name"];

document.writeln("Added middle name: " + yan);
document.writeln(person["first-name"] + ", " + person["second-name"] + " " + person["middle-name"] + ", " + person["age"]);

document.writeln(typeof person.age);

var i;
var properties = [
	"first-name",
	"middle-name",
	"second-name",
	"age"
];
for (i=0; i < properties.length; i += 1){
	document.writeln(properties[i] + ' (in for loop): ' + person[properties[i]]);
}

