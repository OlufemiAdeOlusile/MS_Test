$(document).ready(function() {

	var order = [1,3,5,8,13,21];
	var chaos = [5,21,13,8,1,3];
	var crazy = [1,3,8,5,'O',13];

	var sets = [order, chaos, crazy];

	$('#go').bind("click", function() {
		var sort = sets[(Math.floor(Math.random() * 3))];
		$('#order li').each(function(k) {
			$(this).text(sort[k]).attr('id', order[k]);
		})
	});
});