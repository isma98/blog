function changeIconMenu(){
    if($("#btn-menu").hasClass('fa-bars')){
        $("#btn-menu").removeClass('fa-bars');
        $("#btn-menu").addClass('fa-times');
    }else{
            $("#btn-menu").removeClass('fa-times');
            $("#btn-menu").addClass('fa-bars');
    }
};