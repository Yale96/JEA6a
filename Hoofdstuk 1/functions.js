var add = function(a, b){
	return a + b;
};

document.writeln("2 + 2: " + add(2, 2));

var sum = function(){
	var i, sum = 0;
	for (i = 0; i < arguments.length; i += 1){
		sum += arguments[i];
	}
	if(typeof arguments !== "number")
	{
		throw{
			name: "TypeError",
			message: "Arguments must be numbers"
		};
	}
	return sum;
};

var try_sum = function(){
	try{
		document.writeln(sum("f", "f"));
	}
	catch(exception){
		document.writeln(exception.name + ": " + exception.message);
	}
}

try_sum();

document.writeln(sum(2, 4, 8, 16, 32, 64, 128, 256));