// getter of names from REST web service
// example of data: [{name: "Olga", id: 1}, {name: "Vadim", id: 2}]
var get_all_names = function(){
	$('#message').val('');
    $.ajax({
        type: 'GET',
	    url: '/IntroRest/rest',
	    success: function(names) {	        
			$('#list_area').empty();
	        if (names.length > 0){
	        	$.each(names, function (i, name){
	        		$('#list_area').append("<p>Name: {{name}}<br/>Id: {{id}}</p>")
	        	});
	        }else
	        {
	        	$('#message').val('No names in your db :-(');
	        }
	    },
		error: function() {
			$('#message').val('Error getting existing names');
	    }
	 })
}
// listener on page load
if (window.location.pathname == "/IntroRest") {
	$(window).load(get_all_names);
}

// poster of a new name
var post_name = function(){
    var name = $('#input_name').val();
	if (name != ''){
		$.ajax({
			type: 'POST',
			url: '/IntroRest/rest/'+name,
			data: name,
			success: function() {
				$('#input_name').val('');
				get_all_names();
			},
			error: function() {
				$('#message').val('Error inserting new name');
			}
		});}else{
			$('#message').val('Name can not be empty');
		}
		
}
// listener on button click
$('#button_name').click(post_name);