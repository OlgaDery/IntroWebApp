<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>

<!DOCTYPE html>
<html>
    <head>
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Page</title>
    </head>
    <body>
        <div id="input_area">
	        <input id="input_name" type="text" name="name" value="" required placeholder="Enter a name.."/>
	        <button id="button_name" type="button" name="submit" class="input-t1 btn btn-success btn-sm">Submit</button> 
	    </div>
	    <span id="message"></span>
	    <div id="list_area"></div>
    </body>
    <script type="text/javascript">
    var get_all_names = function(){
    	$('#message').val('');
        $.ajax({
            type: 'GET',
    	    url: '/IntroRest/rest',
    	    dataType:'json',
    	    success: function(names) {	        
				var names = eval(names); 
    			$('#list_area').empty();
    	        if (names.length > 0){
    	        	
  	        	$.each(names, function (i, name){
  	        		//	var json = $.parseJSON(name);
  	        			
    	        		$('#list_area').append('<p>Name entered: ' + (++i) +'</p>') 
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

    </script>
</html>
