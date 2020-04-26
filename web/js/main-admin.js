$(document).ready(function(){
	$('.menu li a.tab:first').addClass('active');
	$('.content').hide();
	$('.content:first').show();

	$('.menu li a.tab').click(function(){
		$('.menu li a.tab').removeClass('active');
		$(this).addClass('active');
		$('.content').hide();

		var activeTab = $(this).attr('href');
		$(activeTab).show();

		return false;
	});
        
       
});


