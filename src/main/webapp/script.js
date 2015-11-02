

function average(sum, number) {
	var av = sum / number;
	av = av.toFixed(1);
	av = av.replace('.', ',');
	return av;
}

function numsort(a,b) {
	return a - b;
}

function median(values) {
	values.sort(numsort);
	if (values.length % 2 == 1) {
		return values[(values.length - 1)/2];
	}
	else {
		var tmp = values[values.length / 2 - 1] + values[values.length / 2];
		return average(tmp, 2);
	}
	document.write(values);
}

// lies den Text aus dem Artikel aus
var text = document.querySelector('article').innerHTML;

// sammle die einzelnen Wörter aus dem Text in einer Variablen 'words'
var words = text.split(/[.,;«»!?"'\s-]+/);
var longestWord = '';
var wordsLengthTotal = 0;
var wordLengths = [];
var wordUnique = {};

words.forEach(function(word, i) {
	// aktualisiere die gesamte Textlänge
	wordsLengthTotal += word.length;
	// sichere das aktuell längste Word
	if (word.length > longestWord.length) {
		longestWord = word;
	}
	// sichere die Länge des aktuellen Worts
	wordLengths.push(word.length);
	
	//
	var lcWord = word.toLowerCase();
	if (wordUnique[lcWord] == undefined) {
		wordUnique[lcWord]	= 0;
	}
	++wordUnique[lcWord];
})

var wordCount = 0
	usedOnce = [],
	mostPopular = {count:0};
for (var key in wordUnique) {
	++wordCount;
	if (wordUnique[key] === 1) {
		usedOnce.push(key);
	}
	if (wordUnique[key] > mostPopular.count) {
		mostPopular.word = key;
		mostPopular.count = wordUnique[key];
	}
}

Math.

var randoms = [];
while (randoms.length < 5) {
	if (randoms.length === usedOnce.length) {
		break;
	}
	var random = Math.floor(Math.random() * usedOnce.length);
	if (randoms.indexOf(random) === -1) {
		document.write('<li>' + usedOnce[random] + '</li>');
	}
	randoms.push(random);
}


var pubdate = new Date('1915-10-01');
var datediff = Date.now() - pubdate.getTime();
datediff /= 1000 * 60 * 60 * 24;
datediff = Math.floor(datediff);
var years = Math.floor(datediff / 365.2425);
var days = Math.round(datediff % 365.2425);

var months = ['Januar',	'Februar', 'März', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'Oktober', 'November', 'Dezember'];

document.write('<p>Das mit ' + longestWord.length + ' Zeichen längste Wort lautet: <q>' + longestWord + '</q>');
document.write('<p>Durchschnittliche Wortlänge: ' + average(wordsLengthTotal, words.length) + ' Zeichen');
document.write('<p>' + median(wordLengths));
document.write('<p>' + pubdate.getDate() + '.' + months[pubdate.getMonth()] + '.' + pubdate.getFullYear());
document.write('<p>Dieser Text erschien vor ' + (years ? years + ' Jahren und ' : '') + days + ' Tagen.</p>');
