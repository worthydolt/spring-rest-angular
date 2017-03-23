function getRest() {
    jQuery.ajax({
        url: "test.html",
        context: document.body
    }).done(function() {
        $( this ).addClass( "done" );
    });

}

$(getRest());